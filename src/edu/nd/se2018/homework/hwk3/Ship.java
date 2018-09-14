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

}
