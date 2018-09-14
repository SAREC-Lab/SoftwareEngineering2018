package edu.nd.se2018.homework.hwk3;

import java.util.Observable;
import java.util.Observer;

public class PirateShip implements Observer {
	public int x = 5;
	public int y = 7;
	int[][] oceanMap;
	int[] shipPosition = new int[2];

	public PirateShip(int[][] map) {
		oceanMap = map;

	}

	public int[] getLocation() {
		int[] location = new int[2];
		location[0] = x;
		location[1] = y;
		return (location);
	}

	public void goEast() {
		int[] l = getLocation();
		if (l[0] <= 8) {
			if (oceanMap[l[0] + 1][l[1]] == 0) {
				x += 1;
			}
		}

	}

	public void goWest() {
		int[] l = getLocation();
		if (l[0] >= 1) {
			if (oceanMap[l[0] - 1][l[1]] == 0) {
				x -= 1;
			}
		}
	}

	public void goSouth() {
		int[] l = getLocation();
		if (l[1] <= 8) {
			if (oceanMap[l[0]][l[1] + 1] == 0) {
				y += 1;
			}
		}
	}

	public void goNorth() {
		int[] l = getLocation();
		if (l[1] >= 1) {
			if (oceanMap[l[0]][l[1] - 1] == 0) {
				y -= 1;
			}
		}
	}
	
	public void movePirate() {
		if (x - shipPosition[0] <= 0) {
			this.goEast();
		}
		else {
			this.goWest();
		}
		if (shipPosition[1] - y < 0) {
			this.goNorth();
		}
		else {
			this.goSouth();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Ship) {
			shipPosition = ((Ship) o).getLocation();
			this.movePirate();
		}
		
	}
}
