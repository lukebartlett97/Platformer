
public class ElevatorPlatform extends Platform{
	boolean moveX;
	int low, high;
	public ElevatorPlatform(int xPos, int yPos, int width, int height, Game game, boolean moveX, int low, int high, int speed){
		super(xPos, yPos, width, height, game);
		if(moveX){
			yVel = 0;
			xVel = speed;
		}
		else{
			xVel = 0;
			yVel = speed;
		}
		this.low = low * 40;
		this.high = high * 40;
		this.moveX = moveX;
	}
	@Override
	public void update(){
		if(moveX){
			if(xVel>0){
				for(int i = 0; i<xVel; i++){
					if(((game.player.getXPos() == xPos + width) && (game.player.getYPos() <= yPos + height) && game.player.getYPos() + game.player.getHeight() >= yPos) ||
					((game.player.getYPos() + game.player.getHeight() == yPos) && (game.player.getXPos() <= xPos + width) && game.player.getXPos() + game.player.getWidth() >= xPos)){
						xPos += 1;
						if(game.player.clearRight()){
							game.player.moveBy(1,0);
						}
					}
					else {xPos += 1;}
				}
				
			}
			else{
				for(int i = 0; i<-xVel; i++){
					if(((game.player.getXPos() + game.player.getWidth() == xPos) && (game.player.getYPos() <= yPos + height) && game.player.getYPos() + game.player.getHeight() >= yPos) ||
					((game.player.getYPos() + game.player.getHeight() == yPos) && (game.player.getXPos() <= xPos + width) && game.player.getXPos() + game.player.getWidth() >= xPos)){
						xPos -= 1;
						if(game.player.clearLeft()){
							game.player.moveBy(-1,0);
						}
					}
					else {xPos -= 1;}
				}
			}
		}
		else{
			if(yVel>0){
				for(int i = 0; i<yVel; i++){
					if((game.player.getYPos() == yPos + height ||(game.player.getYPos() + game.player.getHeight() == yPos)) && (game.player.getXPos() <= xPos + width) && game.player.getXPos() + game.player.getWidth() >= xPos){
						yPos += 1;
						if(game.player.clearBelow()){
							game.player.moveBy(0,1);
						}
					}
					else {yPos += 1;}
					
				}
			}
			else{
				for(int i = 0; i<(-yVel); i++){
					if((game.player.getYPos() + game.player.getHeight() == yPos) && (game.player.getXPos() <= xPos + width) && game.player.getXPos() + game.player.getWidth() >= xPos){
						yPos -= 1;
						if(game.player.clearAbove()){
							game.player.moveBy(0,-1);
						}
					}
					else {yPos -= 1;}
				}
			}
		}
		checkTurn();
	}
	
	public void checkTurn(){
		if(moveX){
			if(xVel > 0 && xPos>=high){
				xVel = -xVel;
			}
			else if (xVel < 0 && xPos<=low){
				xVel = -xVel;
			}
		}
		else{
			if(yVel > 0 && yPos>=high){
				yVel = -yVel;
			}
			else if (yVel < 0 && yPos<=low){
				yVel = -yVel;
			}
		}
	}
}
