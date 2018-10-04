package hw6;

import java.util.Observable;

public class chip extends Observable{
	
	int xLocal = 312;
	int yLocal = 312;
	int scale = 24; // if time find a way to keep this throughout structure 
	int keys = 0;
	int brickX = xLocal/24;
	int brickY = yLocal/24;
	
	public int getX() {
		return xLocal;
	}
	public int getY() {
		return yLocal;
	}
	public int getKey() {
		return keys;
	}
	public void goUp(int [][] grid) {
		checkMove(grid,brickX,brickY-1);
	}
	public void goDown(int [][] grid) {
		checkMove(grid,brickX,brickY+1);
	}
	public void goLeft(int [][] grid) {
		checkMove(grid,brickX-1,brickY);
	}
	public void goRight(int [][] grid) {
		checkMove(grid,brickX+1,brickY);
	}
	public boolean checkMove(int [][] grid, int x, int y) {
		if(grid[x][y] == 0) {
			return true;
		}else {
			return false;
		}
	}

}
