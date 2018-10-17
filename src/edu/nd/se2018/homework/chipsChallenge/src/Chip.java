package edu.nd.se2018.homework.chipsChallenge.src;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

public class Chip extends Observable{

	Point location = new Point();
	ChipMap map;
	List<Key> bag;
	int doorId = 1;
	
	public Chip(ChipMap chipMap) {
		map = chipMap;
		location.x = 14;
		location.y = 14;
		bag = new LinkedList<Key>();
	}
	
	public Point getChipLocation() {
		return location;
	}
	
	public int getDoorId() {
		return doorId;
	}
	
	// set starting location of chip for level 2
	public void resetChip() {
		location.x = 14;
		location.y = 14;
	}
	
	// set starting location of chip for level 2
	public void resetChip2() {
		location.x = 20;
		location.y = 1;
	}
	
	public void goEast() {
		if(location.x < 24 && map.chipsGrid[location.x +1][location.y] != 1) {
			location.x += 1;
			setChanged();
			notifyObservers();
		}
	}
	
	public void goWest() {
		if(location.x > 0 && map.chipsGrid[location.x -1][location.y] != 1) {
			location.x -= 1;
			setChanged();
			notifyObservers();
		}
	}
	
	public void goNorth() {
		if(location.y > 0 && map.chipsGrid[location.x][location.y-1] != 1) {
			location.y -= 1;
			setChanged();
			notifyObservers();
		}
	}

	public void goSouth() {
		if(location.y < 24 && map.chipsGrid[location.x][location.y +1] != 1) {
			location.y += 1;
			setChanged();
			notifyObservers();
		}
	}

}
