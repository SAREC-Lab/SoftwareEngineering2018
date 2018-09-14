package edu.nd.se2018.homework.hwk3;

public class Ship {
	public int x = 0;
	public int y = 0;
	
	public class OceanMap {}
	
	public int[] getLocation() {
		int[] location = new int[2];
		location[0] = x;
		location[1] = y;
		return(location);
	}
	
	public void goEast() {
		if (getLocation()[0] <= 8) {
			x += 1;
		}
		
	}
	
	public void goWest() {
		if (getLocation()[0] >= 1) {
			x -= 1;
		}
	}
	
	public void goSouth() {
		if (getLocation()[1] <= 8) {
			y += 1;
		}
	}
	
	public void goNorth() {
		if (getLocation()[1] >= 1) {
			y -= 1;
		}
	}

}
