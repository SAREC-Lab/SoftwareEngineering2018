package edu.nd.se2018.homework.chipsChallenge;

public class StraightLineBugMovement implements BugMovement{
	
	boolean horizontal; // track if bug moves horizontally or vertically
	boolean goingPositive; // track if bug has been moving in the positive x/y direction
	
	public StraightLineBugMovement(boolean horizontal) {
		this.horizontal = horizontal;
		this.goingPositive = true;
	}

	@Override
	public int getNewX(int currentX, int currentY, Level level) {
		if(horizontal){
			if(goingPositive){
				if(level.canMoveTo(currentX+1, currentY)){
					return currentX+1;
				}else{
					goingPositive = false;
					return currentX-1;
				}
			}
			else{
				if(level.canMoveTo(currentX-1, currentY)){
					return currentX-1;
				}else{
					goingPositive = true;
					return currentX+1;
				}
			}
		}
		
		// if going vertical, return the same X
		return currentX;
	}

	@Override
	public int getNewY(int currentX, int currentY, Level level) {
		if(horizontal == false){
			if(goingPositive){
				if(level.canMoveTo(currentX, currentY+1)){
					return currentY+1;
				}else{
					goingPositive = false;
					return currentY-1;
				}
			}
			else{
				if(level.canMoveTo(currentX, currentY-1)){
					return currentY-1;
				}else{
					goingPositive = true;
					return currentY+1;
				}
			}
		}
		
		// if going horizontal, return the same Y
		return currentY;
	}

}
