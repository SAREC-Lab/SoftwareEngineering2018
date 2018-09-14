package edu.nd.se2018.homework.hwk3;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

import edu.nd.se2018.homework.hwk3.Ship;

public class OceanMap {
	public int[][] oceanGrid = new int[25][25];
	final int dimensions = 25;
	public Ship ship = new Ship(oceanGrid);
	
	
	public void setIslands( ) {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int xIsland = random.ints(0, 10).findFirst().getAsInt();
			int yIsland =  random.ints(0, 10).findFirst().getAsInt();
			while ((xIsland == 0) && (yIsland == 0)) {
				xIsland = random.ints(0, 10).findFirst().getAsInt();
				yIsland =  random.ints(0, 10).findFirst().getAsInt();
			}
			oceanGrid[xIsland][yIsland]= 1;
		}
	}
	public void drawMap(ObservableList<Node> root, int scale) {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				if (oceanGrid[x][y] == 1) {
					rect.setFill(Color.GREEN);
				}
				else {
					rect.setFill(Color.PALETURQUOISE);
					oceanGrid[x][y] = 0;
				}
				root.add(rect);
			}
		}
	}
	
	public int[] getShipLocation() {
		int[] location = new int[2];
		location = ship.getLocation();
		return(location);
	}
}
