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
    	int offsetX = -600 - game.player.getWidth() + game.player.getXPos();
    	int offsetY = -332 - game.player.getHeight() + game.player.getYPos();
	    g.setColor(Color.BLACK);
	    for(Platform platform : game.platforms){
	    	g.fillRect(platform.getXPos()-offsetX,platform.getYPos()-offsetY,platform.getWidth(),platform.getHeight());
	    }
	    for(Coin coin : game.coins){
		    g.setColor(Color.BLACK);
	    	g.fillRect(coin.getXPos()-offsetX,coin.getYPos()-offsetY,coin.getWidth(),coin.getHeight());
		    g.setColor(Color.YELLOW);
	    	g.fillRect(coin.getXPos()-offsetX+1,coin.getYPos()-offsetY+1,coin.getWidth()-2,coin.getHeight()-2);
	    }
	    g.setColor(Color.BLACK);
	    g.fillRect(game.player.getXPos()-offsetX,game.player.getYPos()-offsetY,game.player.getWidth(),game.player.getHeight());
	    g.drawString(Integer.toString(game.player.coins) + "/" + Integer.toString(game.totalCoins), 10, 20);
	    g.drawString(Integer.toString(game.maxTime - game.clock.seconds), 110, 20);
	    if(game.player.hasWon()){
	    	g.drawString("You Win!", 160, 20);
	    }
	}
	        
}
