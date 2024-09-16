package hwk4;

// Cameron Pickard

import java.awt.Point;


import java.util.Observable;

public class Ship extends Observable {
	int xCell;
	int yCell;
	int unitSize;  // Scaling factor
	OceanMap oceanMap;

	public Ship(int x, int y, int unitSize, OceanMap map){
		xCell = x;
		yCell = y;
		this.unitSize = unitSize;
		this.oceanMap = map; // We need a reference to it so we can access the grids!
	}

	// Return point coordinate of ship
	public Point getLocation(){
		Point position = new Point(this.xCell, this.yCell);
		return position;
	}
	// Movement functions
	public void goEast() {
		if(this.xCell < 24 && oceanMap.seeSpace(this.xCell + 1, this.yCell) != 1 ) {
			this.xCell++;
			setChanged();
			notifyObservers();
		}

	}
	public void goWest() {
		if(this.xCell>0 && oceanMap.seeSpace(this.xCell - 1, this.yCell)!= 1 ) {
			this.xCell--;
			setChanged();
			notifyObservers();
		}
	}
	public void goSouth() {
		if(this.yCell < 24 && oceanMap.seeSpace(this.xCell, this.yCell+1) != 1) {
			this.yCell++;
			setChanged();
			notifyObservers();
		}
	}
	public void goNorth() {
		if(this.yCell > 0 && oceanMap.seeSpace(this.xCell, this.yCell-1) != 1) {
			this.yCell--;
			setChanged();
			notifyObservers();
		}
	}
}
