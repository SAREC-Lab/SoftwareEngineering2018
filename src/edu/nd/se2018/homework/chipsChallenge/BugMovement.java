package edu.nd.se2018.homework.chipsChallenge;

public interface BugMovement {
	
	public int getNewX(int x, boolean hittingWall);
	public int getNewY(int y, boolean hittingWall);

}
