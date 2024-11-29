package edu.nd.se2018.homework.ColumbusGame;
import java.awt.Point;
import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

public class Ship extends Observable{
	
	Point location = new Point();
	OceanMap map;
	
	public Ship(OceanMap oceanMap){
		map = oceanMap;
		do {
			location.x = ThreadLocalRandom.current().nextInt(0, 10);
			location.y = ThreadLocalRandom.current().nextInt(0, 10);
		} while (map.oceanGrid[location.x][location.y] != 0);
	}
	
	public Point getShipLocation() {
		return location;
	}

	public void goEast() {
		if(location.x < 9 && map.oceanGrid[location.x +1][location.y] != 1) {
			location.x += 1;
		}
		setChanged();
		notifyObservers();
	}

	public void goWest() {
		if(location.x > 0 && map.oceanGrid[location.x -1][location.y] != 1) {
			location.x -= 1;
		}
		setChanged();
		notifyObservers();
	}

	public void goNorth() {
		if(location.y > 0 && map.oceanGrid[location.x][location.y-1] != 1) {
			location.y -= 1;
		}
		setChanged();
		notifyObservers();
	}

	public void goSouth() {
		if(location.y < 9 && map.oceanGrid[location.x][location.y +1] != 1) {
			location.y += 1;
		}
		setChanged();
		notifyObservers();
	}

	
}