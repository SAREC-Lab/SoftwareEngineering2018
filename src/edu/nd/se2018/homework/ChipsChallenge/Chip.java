package edu.nd.se2018.homework.ChipsChallenge;
import java.awt.Point;
import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

import edu.nd.se2018.homework.ChipsChallenge.ChipsMap;

public class Chip extends Observable{
	Point location = new Point();
	ChipsMap map;
	
	public Chip(ChipsMap chipMap){
		map = chipMap;
		do {
			location.x = ThreadLocalRandom.current().nextInt(0, 25);
			location.y = ThreadLocalRandom.current().nextInt(0, 25);
		} while (map.chipsGrid[location.x][location.y] != 0);
	}
	
	public Point getChipLocation() {
		return location;
	}

	public void goEast() {
		if(location.x < 24 && map.chipsGrid[location.x +1][location.y] != 1) {
			location.x += 1;
		}
		setChanged();
		notifyObservers();
	}

	public void goWest() {
		if(location.x > 0 && map.chipsGrid[location.x -1][location.y] != 1) {
			location.x -= 1;
		}
		setChanged();
		notifyObservers();
	}

	public void goNorth() {
		if(location.y > 0 && map.chipsGrid[location.x][location.y-1] != 1) {
			location.y -= 1;
		}
		setChanged();
		notifyObservers();
	}

	public void goSouth() {
		if(location.y < 24 && map.chipsGrid[location.x][location.y +1] != 1) {
			location.y += 1;
		}
		setChanged();
		notifyObservers();
	}
}
