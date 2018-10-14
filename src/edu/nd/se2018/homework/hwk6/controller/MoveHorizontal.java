package edu.nd.se2018.homework.hwk6.controller;

public class MoveHorizontal implements MoveStrategy {
	public int direction = 1;
	
	public int[] move(int xPos, int yPos) {
		int x = xPos;
		int y = yPos;
		int[] pos = new int[2];
		
		if ((x < 15) && (x > 5)) {
			x = x + direction;
		}
		else {
			direction = direction * -1;
			x = x + direction;
		}
		
		pos[0] = x;
		pos[1] = y;
		
		return(pos);
		
	}
}
