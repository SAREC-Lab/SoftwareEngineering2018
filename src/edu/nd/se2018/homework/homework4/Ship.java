package edu.nd.se2018.homework.homework4;
import java.awt.Point;
import java.util.Observable;

import javafx.scene.image.Image;

@SuppressWarnings("deprecation")
public class Ship extends Observable {
	
	// Data members
	public Point currentLocation = new Point(0, 0);
	

	// Getter for currentLocation
	public Point getShipLocation() { return currentLocation; }
	
	// Movements
	public void goEast() {
		if (currentLocation.x < 23) {
			currentLocation.x = currentLocation.x + 1;
			setChanged();
			notifyObservers();
		}
	}
	public void goWest() {
		if (currentLocation.x > 0) {
			currentLocation.x = currentLocation.x - 1;
			setChanged();
			notifyObservers();
		}
	}
	public void goNorth() {
		if (currentLocation.y > 0) {
			currentLocation.y = currentLocation.y - 1;
			setChanged();
			notifyObservers();
		}
	}
	public void goSouth() {
		if (currentLocation.y < 23) {
			currentLocation.y = currentLocation.y + 1;
			setChanged();
			notifyObservers();
		}
	}
	
}
