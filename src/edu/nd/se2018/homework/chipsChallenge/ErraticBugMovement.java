package edu.nd.se2018.homework.chipsChallenge;

import java.lang.Math;

public class ErraticBugMovement implements BugMovement{

	public int getNewX(int currentX, int currentY, Level level) {
		int randomX = currentX + (int)Math.ceil(Math.random() - 0.5);
		if(level.canMoveChipTo(randomX, currentY))
			return randomX;
		
		return currentX;
	}

	@Override
	public int getNewY(int currentX, int currentY, Level level) {
		int randomY = currentY + (int)Math.ceil(Math.random() - 0.5);
		if(level.canMoveChipTo(randomY, currentY))
			return randomY;
		
		return currentX;
	}

}
