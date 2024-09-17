package application;

import java.util.Observable;

public class Ship extends Observable{
// seeker
	

	int xLocal = 240;
	int yLocal = 240;
	
	public int getX() {
		return xLocal;
	}
	public int getY() {
		return yLocal;
	}
	public void goWest(int [][] oceanGrid) {
		if(xLocal - 24 >= 0 && goodMove(xLocal-24,yLocal,oceanGrid)) {
			xLocal = xLocal - 24;
			setChanged();
			notifyObservers();
		}
	}
	public void goEast(int [][] oceanGrid) {
		if(xLocal + 24 < 600 && goodMove(xLocal+24,yLocal,oceanGrid)) {
			xLocal = xLocal + 24;
			setChanged();
			notifyObservers();
		}
	}
	public void goNorth(int [][] oceanGrid) {
		if(yLocal - 24 >= 0 && goodMove(xLocal,yLocal-24,oceanGrid)) {
			yLocal = yLocal - 24;
			setChanged();
			notifyObservers();
		}
	}
	public void goSouth(int [][] oceanGrid) {
		if(yLocal + 24 < 600 && goodMove(xLocal,yLocal+24,oceanGrid)) { // bound check + logic
			yLocal = yLocal + 24;
			setChanged(); // update the pirate class
			notifyObservers();
		}
	}
	public boolean goodMove(int x, int y, int[][] oceanGrid) {
		if (oceanGrid[y/24][x/24] == 0) { // check oceanGrid to see if the move is vallid
			return true;
		}else {
			return false;
		}
	}
}
