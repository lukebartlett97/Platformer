import java.awt.Color;

public class Killer extends GameObject{
	public Killer(int xPos, int yPos, int width, int height, Game game){
		super(xPos,yPos,width,height, game,Color.RED);
		this.xPos += 10;
		this.yPos += 10;
		this.width = this.width / 2;
		this.height = this.height / 2;
	}
	public void update(){
		;
	}
}
