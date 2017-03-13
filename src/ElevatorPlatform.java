
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
		this.low = low;
		this.high = high;
		this.moveX = moveX;
	}
	@Override
	public void update(){
		boolean posChanged = false;
		int[] playerPos = game.player.getWholePos();
		if(moveX){
			if(xVel>0){
				if((playerPos[0] == xPos + width) && (playerPos[1] <= yPos + height) && playerPos[1] + playerPos[3] >= yPos){
					yPos += yVel;
					xPos += xVel;
					posChanged = true;
					if(game.player.clearRight()){
						game.player.moveBy(xVel,yVel);
					}
				}
				else if((playerPos[1] + playerPos[3] == yPos) && (playerPos[0] <= xPos + width) && playerPos[0] + playerPos[2] >= xPos){
					xPos += xVel;
					yPos += yVel;
					posChanged = true;
					if(game.player.clearAbove()){
						game.player.moveBy(xVel,yVel);
					}
				}
			}
			else{
				if((playerPos[0] + playerPos[2] == xPos) && (playerPos[1] <= yPos + height) && playerPos[1] + playerPos[3] >= yPos){
					xPos += xVel;
					yPos += yVel;
					posChanged = true;
					if(game.player.clearRight()){
						game.player.moveBy(xVel,yVel);
					}
				}
				else if((playerPos[1] + playerPos[3] == yPos) && (playerPos[0] <= xPos + width) && playerPos[0] + playerPos[2] >= xPos){
					xPos += xVel;
					yPos += yVel;
					posChanged = true;
					if(game.player.clearAbove()){
						game.player.moveBy(xVel,yVel);
					}
				}
			}
		}
		else{
			if(yVel>0){
				if((playerPos[1] == yPos + height ||(playerPos[1] + playerPos[3] == yPos)) && (playerPos[0] <= xPos + width) && playerPos[0] + playerPos[2] >= xPos){
					xPos += xVel;
					yPos += yVel;
					posChanged = true;
					if(game.player.clearBelow()){
						game.player.moveBy(xVel,yVel);
					}
				}
			}
			else{
				if((playerPos[1] + playerPos[3] == yPos) && (playerPos[0] <= xPos + width) && playerPos[0] + playerPos[2] >= xPos){
					xPos += xVel;
					yPos += yVel;
					posChanged = true;
					if(game.player.clearAbove()){
						game.player.moveBy(xVel,yVel);
					}
				}
			}
		}
		if(!posChanged){
			xPos += xVel;
			yPos += yVel;
		}
		checkTurn();
	}
	/*
	@Override
	public void update(){
		boolean posChanged = false;
		int[] playerPos = game.player.getWholePos();
		if(playerPos[1] + playerPos[3] == yPos){
			if((playerPos[0] < xPos + width) && playerPos[0] + playerPos[2] > xPos){
				xPos += xVel;
				yPos += yVel;
				posChanged = true;
				if(yVel>0 && game.player.clearBelow()){
					game.player.moveBy(xVel,yVel);
				}
				else if(yVel<0 && game.player.clearAbove()){
					game.player.moveBy(xVel,yVel);
				}
				else if(xVel>0 && game.player.clearRight()){
					game.player.moveBy(xVel,yVel);
				}
				else if(xVel<0 && game.player.clearLeft()){
					game.player.moveBy(xVel,yVel);
				}
			}
		}
		if(!posChanged){
			xPos += xVel;
			yPos += yVel;
		}
		checkTurn();
	}
	*/
	public void checkTurn(){
		if(moveX){
			if(xVel > 0 && xPos>high){
				xVel = -xVel;
			}
			else if (xVel < 0 && xPos<low){
				xVel = -xVel;
			}
		}
		else{
			if(yVel > 0 && yPos>high){
				yVel = -yVel;
			}
			else if (yVel < 0 && yPos<low){
				yVel = -yVel;
			}
		}
	}
}
