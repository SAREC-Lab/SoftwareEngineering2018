package edu.nd.se2018.homework.hwk3;

import java.util.Observable;

public class Ship extends Observable {
	public int x = 0;
	public int y = 0;
	int[][] oceanMap;
	
	public Ship(int[][] map) {
		oceanMap = map;
		
	}
	
	public int[] getLocation() {
		int[] location = new int[2];
		location[0] = x;
		location[1] = y;
		return(location);
	}
	
	public void goEast() {
		int[] l = getLocation();
		if (l[0] <= 8) {
			if (oceanMap[l[0] + 1][l[1]] == 0) {
				x += 1;
			}
		}
		setChanged();
		notifyObservers(); 
	}
	
	public void goWest() {
		int[] l = getLocation();
		if (l[0] >= 1) {
			if (oceanMap[l[0] - 1][l[1]] == 0) {
				x -= 1;
			}
		}
		setChanged();
		notifyObservers(); 
	}
	
	public void goSouth() {
		int[] l = getLocation();
		if (l[1] <= 8) {
			if (oceanMap[l[0]][l[1] + 1] == 0) {
				y += 1;
			}
		}
		setChanged();
		notifyObservers(); 
	}
	
	public void goNorth() {
		int[] l = getLocation();
		if (l[1] >= 1) {
			if (oceanMap[l[0]][l[1] - 1] == 0) {
				y -= 1;
			}
		}
		setChanged();
		notifyObservers(); 
	}

}
