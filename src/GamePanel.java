import java.awt.*;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Game game;
	Font font;
	boolean zoomIn = false;
	
	public GamePanel(Game game){
		this.game = game;
		font = new Font("Serif",Font.BOLD,24);
	}
	
	public void paintComponent(Graphics g) {
		// Redraw the background
		/*
		if(zoomIn){
			Game.sizeMultiplier += 0.01;
			if(Game.sizeMultiplier >= 1.5){
				zoomIn = false;
			}
		}
		else{
			Game.sizeMultiplier -= 0.01;
			if(Game.sizeMultiplier <= 0.5){
				zoomIn = true;
			}
		}
		*/
	    super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(font);
	    setBackground(Color.WHITE);
    	int offsetX = (int) (-600 - game.player.getWidth()*Game.sizeMultiplier + game.player.getXPos()*Game.sizeMultiplier);
    	int offsetY = (int) (-332 - game.player.getHeight()*Game.sizeMultiplier + game.player.getYPos()*Game.sizeMultiplier);
    	//g.setColor(Color.WHITE);
    	//g.fillOval((int) ((game.player.getXPos()-150)*Game.sizeMultiplier-offsetX),(int) ((game.player.getYPos()-150)*Game.sizeMultiplier-offsetY), (int) (300*Game.sizeMultiplier), (int) (300*Game.sizeMultiplier));
	    
	    for(Coin coin : game.coins){
		    g.setColor(Color.BLACK);
	    	g.fillRect((int) (coin.getXPos()*Game.sizeMultiplier-offsetX),(int) (coin.getYPos()*Game.sizeMultiplier-offsetY),(int) (coin.getWidth()*Game.sizeMultiplier),(int) (coin.getHeight()*Game.sizeMultiplier));
		    g.setColor(Color.YELLOW);
	    	g.fillRect((int) (coin.getXPos()*Game.sizeMultiplier-offsetX+1),(int) (coin.getYPos()*Game.sizeMultiplier-offsetY+1),(int) (coin.getWidth()*Game.sizeMultiplier-2),(int) (coin.getHeight()*Game.sizeMultiplier-2));
	    }
	    for(Teleporter teleporter : game.teleporters){
		    g.setColor(Color.BLACK);
	    	g.fillRect((int) (teleporter.getXPos()*Game.sizeMultiplier-offsetX),(int) (teleporter.getYPos()*Game.sizeMultiplier-offsetY),(int) (teleporter.getWidth()*Game.sizeMultiplier),(int) (teleporter.getHeight()*Game.sizeMultiplier));
		    g.setColor(Color.BLUE);
	    	g.fillRect((int) (teleporter.getXPos()*Game.sizeMultiplier-offsetX+1),(int) (teleporter.getYPos()*Game.sizeMultiplier-offsetY+1),(int) (teleporter.getWidth()*Game.sizeMultiplier-2),(int) (teleporter.getHeight()*Game.sizeMultiplier-2));
	    	g.drawRect((int) (teleporter.targetX*40*Game.sizeMultiplier-offsetX+10),(int) (teleporter.targetY*40*Game.sizeMultiplier-offsetY+10),(int) (teleporter.getWidth()*Game.sizeMultiplier-2),(int) (teleporter.getHeight()*Game.sizeMultiplier-2));
	    }
	    for(Killer killer : game.killers){
		    g.setColor(Color.BLACK);
	    	g.fillRect((int) (killer.getXPos()*Game.sizeMultiplier-offsetX),(int) (killer.getYPos()*Game.sizeMultiplier-offsetY),(int) (killer.getWidth()*Game.sizeMultiplier),(int) (killer.getHeight()*Game.sizeMultiplier));
		    g.setColor(Color.RED);
	    	g.fillRect((int) (killer.getXPos()*Game.sizeMultiplier-offsetX+1),(int) (killer.getYPos()*Game.sizeMultiplier-offsetY+1),(int) (killer.getWidth()*Game.sizeMultiplier-2),(int) (killer.getHeight()*Game.sizeMultiplier-2));
	    }
	    g.setColor(Color.BLACK);
	    for(Platform platform : game.platforms){
	    	g.fillRect((int) (platform.getXPos()*Game.sizeMultiplier-offsetX),(int) (platform.getYPos()*Game.sizeMultiplier-offsetY),(int) (platform.getWidth()*Game.sizeMultiplier),(int) (platform.getHeight()*Game.sizeMultiplier));
	    }
	    g.setColor(Color.BLACK);
	    g.fillRect((int) (game.player.getXPos()*Game.sizeMultiplier-offsetX),(int) (game.player.getYPos()*Game.sizeMultiplier-offsetY),(int) (game.player.getWidth()*Game.sizeMultiplier),(int) (game.player.getHeight()*Game.sizeMultiplier));

	    g.setColor(Color.GRAY);
	    g.drawString(Integer.toString(game.player.coins) + "/" + Integer.toString(game.totalCoins), 10, 20);
	    g.drawString(Integer.toString(game.maxTime - game.clock.seconds), 110, 20);
	    if(game.player.hasWon()){
	    	g.drawString("You Win!", 160, 20);
	    }
	}
	        
}
