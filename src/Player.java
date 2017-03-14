import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import javax.swing.JPanel;

public class Player extends GameObject{
	Set<Integer> keysPressed;
    int fallingCount = 0;
	int coins = 0;
    static void attach(Player player, JPanel panel) {
        class PlayerKeyboardListener implements KeyListener {
            Player player;
            PlayerKeyboardListener(Player newPlayer) { player = newPlayer; }
            
            // When a key is pressed, add the event to the solver's queue
            public void keyPressed(KeyEvent e) {player.keysPressed.add(e.getKeyCode()); }
            
            // These are needed to implement the KeyListener interface,
            // but they don't need to do anything
            public void keyReleased(KeyEvent e) {player.keysPressed.remove(e.getKeyCode()); }
            public void keyTyped(KeyEvent e) { }
        }
        
        // Add one of these listeners to the panel
        panel.addKeyListener(new PlayerKeyboardListener(player));
        // The panel needs to be focusable so that it can receive KeyEvents
        panel.setFocusable(true);
    }
    
	public Player(int xPos, int yPos, int width, int height, Game game){
		super(xPos,yPos,width,height, game, Color.BLACK);
		keysPressed = new HashSet<Integer>();
	}
	public boolean falling(){
		return clearBelow();
	}
	public void update(){
		if(falling()){
			if(fallingCount++ == 3){
				accelerate(0,1);
				fallingCount = 0;
			}
		}
		if(keysPressed.contains(KeyEvent.VK_UP)){
			if(!falling()){
				yVel = -8;
			}
		}
		int direction = 0;
		if(keysPressed.contains(KeyEvent.VK_LEFT)){
			direction += 1;
		}
		if(keysPressed.contains(KeyEvent.VK_RIGHT)){
			direction += 2;
		}
		switch(direction){
		case 1:
			if(xVel>-6){xVel += -1;}
			break;
		case 2:
			if(xVel<6){xVel += 1;}
			break;
		default:
			if(xVel>0){xVel += -1;}
			else if(xVel<0){xVel += 1;}
		}
		move();
		collectCoins();
		if(isDead()){
			game.playing = false;
		}
		if(hasWon()){
			//game.playing = false;
		}
	}
	public void moveBy(int x, int y){
		xPos += x;
		yPos += y;
	}
	public void move(){
		if(yVel>0){
			for(int i = 0; i<yVel; i++){
				if(clearBelow()){yPos += 1;}
				else{yVel = 0;}
			}
		}
		else if(yVel<0){
			for(int i = 0; i<-yVel; i++){
				if(clearAbove()){yPos += -1;}	
				else{yVel = 0;}		
			}			
		}
		if(xVel<0){
			for(int i = 0; i<-xVel; i++){
				if(clearLeft()){xPos += -1;}	
				else{xVel = 0;}	
			}
		}
		else if(xVel>0){
			for(int i = 0; i<xVel; i++){
				if(clearRight()){xPos += 1;}	
				else{
					xVel = 0;
				}	
			}
		}
	}
	
	public void collectCoins(){
		Iterator<Coin> iterator = game.coins.iterator();
		while(iterator.hasNext()){
			GameObject coin = iterator.next();
			int[] coinPos = coin.getWholePos();
			if((coinPos[0]<xPos+width) && (coinPos[0]+coinPos[2] > xPos) && (coinPos[1]<yPos+height) && (coinPos[1]+coinPos[3] > yPos)){
				coins++;
				iterator.remove();
			}
		}
	}
	
	public boolean isDead(){
		if(!clearBelow() && !clearAbove()){
			return true;
		}
		int biggestY = 0;
		for(Platform platform : game.platforms){
			if(platform.yPos>biggestY){biggestY = platform.yPos;}
		}
		if(yPos>biggestY+600){return true;}
		return false;
	}
	
	public boolean hasWon(){
		if(game.totalCoins == coins){
			return true;
		}
		return false;
	}
}
