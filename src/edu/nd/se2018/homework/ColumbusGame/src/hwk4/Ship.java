package hwk4;

import java.awt.Point;

//import com.sun.javafx.scene.paint.GradientUtils.Point;

import javafx.scene.shape.Circle;
//import src.edu.nd.se2018.examples.mazeCode.Maze;
import java.util.Observable;

public class Ship extends Observable {
	Circle circle;
	int xCell;
	int yCell;
	int unitSize;  // Scaling factor
	OceanMap oceanMap;

	public Ship(int x, int y, int unitSize, OceanMap map){
		xCell = x;
		yCell = y;
		this.unitSize = unitSize;
		//circle = new Circle(unitSize/2);
		//circle.setCenterX(x*unitSize+unitSize/2);
		//circle.setCenterY(y*unitSize+unitSize/2);
		//circle = new Circle(x*unitSize+unitSize/2, y*unitSize+unitSize/2, unitSize/2);
		this.oceanMap = map; // We need a reference to it so we can access the grids!
	}

	public Point getLocation(){
		Point position = new Point(this.xCell, this.yCell);
		return position;
	}

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
