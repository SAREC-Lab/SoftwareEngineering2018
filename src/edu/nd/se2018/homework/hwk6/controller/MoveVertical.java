package edu.nd.se2018.homework.hwk6.controller;

public class MoveVertical implements MoveStrategy {
	public int direction = 1;
	
	public int[] move(int xPos, int yPos) {
		int x = xPos;
		int y = yPos;
		int[] pos = new int[2];
		
		if ((y < 15) && (y > 5)) {
			y = y + direction;
		}
		else {
			direction = direction * -1;
			y = y + direction;
		}
		
		pos[0] = x;
		pos[1] = y;
		
		return(pos);
		
	}

}
