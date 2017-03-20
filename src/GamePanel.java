import java.awt.*;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Game game;
	Font font;
	
	public GamePanel(Game game){
		this.game = game;
		font = new Font("Serif",Font.BOLD,24);
	}
	
	public void paintComponent(Graphics g) {
		// Redraw the background
	    super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(font);
	    setBackground(Color.WHITE);
    	int offsetX = (int) (-600 - game.player.getWidth()*Game.sizeMultiplier + game.player.getXPos()*Game.sizeMultiplier);
    	int offsetY = (int) (-332 - game.player.getHeight()*Game.sizeMultiplier + game.player.getYPos()*Game.sizeMultiplier);
	    g.setColor(Color.BLACK);
	    for(Platform platform : game.platforms){
	    	g.fillRect((int) (platform.getXPos()*Game.sizeMultiplier-offsetX),(int) (platform.getYPos()*Game.sizeMultiplier-offsetY),(int) (platform.getWidth()*Game.sizeMultiplier),(int) (platform.getHeight()*Game.sizeMultiplier));
	    }
	    for(Coin coin : game.coins){
		    g.setColor(Color.BLACK);
	    	g.fillRect((int) (coin.getXPos()*Game.sizeMultiplier-offsetX),(int) (coin.getYPos()*Game.sizeMultiplier-offsetY),(int) (coin.getWidth()*Game.sizeMultiplier),(int) (coin.getHeight()*Game.sizeMultiplier));
		    g.setColor(Color.YELLOW);
	    	g.fillRect((int) (coin.getXPos()*Game.sizeMultiplier-offsetX+1),(int) (coin.getYPos()*Game.sizeMultiplier-offsetY+1),(int) (coin.getWidth()*Game.sizeMultiplier-2),(int) (coin.getHeight()*Game.sizeMultiplier-2));
	    }
	    g.setColor(Color.BLACK);
	    g.fillRect((int) (game.player.getXPos()*Game.sizeMultiplier-offsetX),(int) (game.player.getYPos()*Game.sizeMultiplier-offsetY),(int) (game.player.getWidth()*Game.sizeMultiplier),(int) (game.player.getHeight()*Game.sizeMultiplier));
	    g.drawString(Integer.toString(game.player.coins) + "/" + Integer.toString(game.totalCoins), 10, 20);
	    g.drawString(Integer.toString(game.maxTime - game.clock.seconds), 110, 20);
	    if(game.player.hasWon()){
	    	g.drawString("You Win!", 160, 20);
	    }
	}
	        
}
