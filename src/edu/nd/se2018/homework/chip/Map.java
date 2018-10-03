package edu.nd.se2018.homework.chip;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Map {
	
	final int dimensions = 25;
	public int[][] mapGrid = new int[dimensions][dimensions];
	
	public void drawMap(ObservableList<Node> root, int scale) {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				mapGrid[x][y] = 0;
			}
		}
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				if (mapGrid[x][y] == 0) {
					rect.setFill(Color.GREY);
				}
				root.add(rect);
			}
		}
	}
}
