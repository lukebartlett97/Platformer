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
    	int[] playerPos = game.player.getWholePos();
    	int offsetX = -600 - playerPos[2] + playerPos[0];
    	int offsetY = -332 - playerPos[3] + playerPos[1];
	    g.setColor(Color.BLACK);
	    for(Platform platform : game.platforms){
	    	int[] objectPos = platform.getWholePos();
	    	g.fillRect(objectPos[0]-offsetX,objectPos[1]-offsetY,objectPos[2],objectPos[3]);
	    }
	    for(Coin coin : game.coins){
	    	int[] objectPos = coin.getWholePos();
		    g.setColor(Color.BLACK);
	    	g.fillRect(objectPos[0]-offsetX,objectPos[1]-offsetY,objectPos[2],objectPos[3]);
		    g.setColor(Color.YELLOW);
	    	g.fillRect(objectPos[0]-offsetX+1,objectPos[1]-offsetY+1,objectPos[2]-2,objectPos[3]-2);
	    }
	    g.setColor(Color.BLACK);
	    g.fillRect(playerPos[0]-offsetX,playerPos[1]-offsetY,playerPos[2],playerPos[3]);
	    g.drawString(Integer.toString(game.player.coins) + "/" + Integer.toString(game.totalCoins), 10, 20);
	    if(game.player.hasWon()){
	    	g.drawString("You Win!", 110, 20);
	    }
	}
	        
}
