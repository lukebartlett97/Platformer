import java.awt.Color;

public class Coin extends GameObject{
	public Coin(int xPos, int yPos, int width, int height, Game game){
		super(xPos,yPos,width,height, game,Color.YELLOW);
		this.xPos += 10;
		this.yPos += 10;
		this.width = this.width / 2;
		this.height = this.height / 2;
	}
	public void update(){
		;
	}
}