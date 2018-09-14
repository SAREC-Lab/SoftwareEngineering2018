package edu.nd.se2018.homework.hwk3;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import edu.nd.se2018.homework.hwk3.Ship;

public class OceanMap {
	public int[][] oceanGrid = new int[25][25];
	final int dimensions = 25;
	Ship ship = new Ship();
	
	public void drawMap(ObservableList<Node> root, int scale) {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				root.add(rect);
				oceanGrid[x][y] = 0;
				
			}
		}
	}
	
	public int[] getShipLocation() {
		int[] location = new int[2];
		location = ship.getLocation();
		return(location);
	}
}
