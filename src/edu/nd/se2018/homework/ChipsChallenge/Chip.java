package edu.nd.se2018.homework.ChipsChallenge;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;


import edu.nd.se2018.homework.ChipsChallenge.ChipsMap;

public class Chip extends Observable{
	Point location = new Point();
	ChipsMap map;
	List<Key> chipsKeys = new LinkedList<Key>();
	int chipLives;
	int startX;
	int startY;
	
	public Chip(ChipsMap chipMap, int x, int y){
		map = chipMap;
		location.x = x;
		location.y = y;
		startX = x;
		startY = y;
		chipLives = 3;
	}
	
	public Point getChipLocation() {
		return location;
	}
	
	public void setChipLocation(int x, int y) {
		startX = x;
		startY = y;
		location.x = x;
		location.y = y;
	}
	
	public void killChip() {
		chipLives -= 1;
		resetChip();
	}
	
	public void resetChip() {
		location.x = startX;
		location.y = startY;
	}
	
	public int getChipLives() {
		return chipLives;
	}
	
	public void clearPockets() {
		for (int i = chipsKeys.size()-1; i >= 0; i--)
			chipsKeys.remove(i);
	}
	public boolean unlockDoor(Door door) {
		ArrayList<Key> toDelete = new ArrayList<Key>();
		boolean unlocked = false;
		
		for(Key key: chipsKeys) {
			if(key.getColor() == door.getColor()) {
				unlocked = true;
				toDelete.add(key);
			}
		}
		
		for(Key key: toDelete) {
			chipsKeys.remove(key);
		}
		
		return unlocked;
	}
	
	public void grabKey(Key key) {
		chipsKeys.add(key);
	}
	
	public void useKey(Key key) {
		chipsKeys.remove(key);
	}
	
	public void goEast() {
		if(location.x < 24 && map.chipsGrid[location.x +1][location.y] < 1) {
			location.x += 1;
		}
		setChanged();
		notifyObservers();
	}

	public void goWest() {
		if(location.x > 0 && map.chipsGrid[location.x -1][location.y] < 1) {
			location.x -= 1;
		}
		setChanged();
		notifyObservers();
	}

	public void goNorth() {
		if(location.y > 0 && map.chipsGrid[location.x][location.y-1] < 1) {
			location.y -= 1;
		}
		setChanged();
		notifyObservers();
	}

	public void goSouth() {
		if(location.y < 24 && map.chipsGrid[location.x][location.y +1] < 1) {
			location.y += 1;
		}
		setChanged();
		notifyObservers();
	}
}
