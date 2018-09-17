package hwk4;

// Cameron Pickard

import java.awt.Point;

import java.util.Observer;
import java.util.Observable;

import javafx.scene.shape.Circle;

public class PirateShip implements Observer {
	int xCell;
	int yCell;
	int unitSize;  // Scaling factor
	OceanMap oceanMap;

	Ship columbusShip;

	public PirateShip(int x, int y, int unitSize, OceanMap map){
		xCell = x;
		yCell = y;
		this.unitSize = unitSize;
		this.oceanMap = map; // We need a reference to it so we can access the grids!
	}

	// Function runs when Ship notifies observers
	public void update(Observable observable, Object arg) {
		columbusShip = (Ship) observable;
		int cx = columbusShip.getLocation().x;
		int cy = columbusShip.getLocation().y;
		if(cx > this.xCell) {
			if(goEast()) {
				return;
			}
			else {
				if(cy < this.yCell) {
					goNorth();
					return;
				}
				else if(cy>this.yCell) {
					goSouth();
					return;
				}
				else
					return;
			}
		}
		else if(cx < this.xCell) {
			if(goWest()) {
				return;
			}
			else {
				if(cy < this.yCell) {
					goNorth();
					return;
				}
				else if(cy>this.yCell) {
					goSouth();
					return;
				}
				else
					return;
			}
		}
		else {
			if(cy < this.yCell) {
				goNorth();
				return;
			}
			else if(cy>this.yCell) {
				goSouth();
				return;
			}
			else
				return;
		}
	}
	public Point getLocation(){
		Point position = new Point(this.xCell, this.yCell);
		return position;
	}

	// Movement functions
	public boolean goEast() {
		if(this.xCell < 24 && oceanMap.seeSpace(this.xCell + 1, this.yCell) != 1 ) {
			this.xCell++;
			return true;
		}
		return false;
	}
	public boolean goWest() {
		if(this.xCell>0 && oceanMap.seeSpace(this.xCell - 1, this.yCell)!= 1 ) {
			this.xCell--;
			return true;
		}
		return false;
	}
	public boolean goSouth() {
		if(this.yCell < 24 && oceanMap.seeSpace(this.xCell, this.yCell+1) != 1) {
			this.yCell++;
			return true;
		}
		return false;
	}
	public boolean goNorth() {
		if(this.yCell > 0 && oceanMap.seeSpace(this.xCell, this.yCell-1) != 1) {
			this.yCell--;
			return true;
		}
		return false;
	}
}

