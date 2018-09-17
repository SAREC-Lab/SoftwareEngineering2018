package edu.nd.se2018.homework.ColumbusGame;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class PirateShip implements Observer{
	Random rand = new Random();
	OceanMap oceanMap;
	Point currentLocation;
	Point shipLocation;
	
	public PirateShip(OceanMap map) {
		oceanMap = map;
		boolean piratesInit = false;		
		
		while (piratesInit == false) {
			int n1 = rand.nextInt(24);
			int n2 = rand.nextInt(24);
			
			if (!oceanMap.getMap(n1,n2)) {
				currentLocation = new Point(n1,n2);
				piratesInit = true;
			}
		}
	}
	
	public Point getPirateShipLocation() {
		return currentLocation;
	}
	
	public void movePirateShip() {
		// x
		if (currentLocation.x - shipLocation.x < 0) {
			boolean island = oceanMap.getMap(currentLocation.x+1,currentLocation.y);
			if (!island) {
				currentLocation.x++;
			}
		}
		else if (currentLocation.x - shipLocation.x != 0) {
			boolean island = oceanMap.getMap(currentLocation.x-1,currentLocation.y);
			if (!island) {
				currentLocation.x--;
			}
		}
		
		// y
		if (currentLocation.y - shipLocation.y < 0) {
			boolean island = oceanMap.getMap(currentLocation.x,currentLocation.y+1);
			if (!island) {
				currentLocation.y++;
			}
		}
		else if (currentLocation.y - shipLocation.y != 0) {
			boolean island = oceanMap.getMap(currentLocation.x,currentLocation.y-1);
			if (!island) {
				currentLocation.y--;
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Ship){
			shipLocation = ((Ship)o).getShipLocation();
			movePirateShip();
		}
	}
}
