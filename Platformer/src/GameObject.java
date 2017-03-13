import java.awt.Color;

public abstract class GameObject {
	protected int xPos, yPos, xVel, yVel, width, height;
	protected Game game;
	public Color color;
	public GameObject(int xPos, int yPos, int width, int height, Game game, Color color){
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.xVel = 0;
		this.yVel = 0;
		this.game = game;
		this.color = color;
	}
	
	public int[] getWholePos(){
		int[] wholePos = {xPos,yPos,width,height};
		return wholePos;
	}
	
	public void accelerate(int x, int y){
		xVel += x;
		yVel += y;
	}
	public abstract void update();
	
	
	public boolean clearBelow(){
		for(GameObject otherObject : game.platforms){
			if(otherObject.yPos == yPos + height){
				if((otherObject.xPos < xPos + width) && otherObject.xPos + otherObject.width > xPos){
					return false;
				}
			}
		}
		return true;
	}
	public boolean clearAbove(){
		for(GameObject otherObject : game.platforms){
			if(otherObject.yPos + otherObject.height == yPos){
				if((otherObject.xPos < xPos + width) && otherObject.xPos + otherObject.width > xPos){
					return false;
				}
			}
		}
		return true;
	}
	public boolean clearLeft(){
		for(GameObject otherObject : game.platforms){
			if(otherObject.xPos + otherObject.width == xPos){
				if((otherObject.yPos < yPos + height) && otherObject.yPos + otherObject.height > yPos){
					return false;
				}
			}
		}
		return true;
	}
	public boolean clearRight(){
		for(GameObject otherObject : game.platforms){
			if(otherObject.xPos == xPos + width){
				if((otherObject.yPos < yPos + height) && otherObject.yPos + otherObject.height > yPos){
					return false;
				}
			}
		}
		return true;
	}
}
