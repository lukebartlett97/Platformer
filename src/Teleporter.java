import java.awt.Color;

public class Teleporter extends GameObject{
	int targetX, targetY;
	public Teleporter(int xPos, int yPos, int width, int height, Game game, int targetX, int targetY){
		super(xPos,yPos,width,height, game,Color.BLUE);
		this.xPos += 10;
		this.yPos += 10;
		this.width = this.width / 2;
		this.height = this.height / 2;
		this.targetX = targetX;
		this.targetY = targetY;
	}
	public void update(){
		;
	}
}
