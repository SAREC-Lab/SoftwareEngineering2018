package application;

import javafx.scene.shape.*;
import javafx.scene.Node;
import java.util.Random;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

public class OceanMap {
//Maze
	int[][] oceanGrid = new int[25][25];
	final int dimensions = 25;
	
	public int [][] drawMap(ObservableList<Node> root, int scale) {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions;y++) {
				Rectangle rect = new Rectangle(y*scale, x*scale,scale,scale);
				rect.setStroke(Color.BLACK);
				if(oceanGrid[x][y]==1) {
					rect.setFill(Color.GREEN);
				}else {
					rect.setFill(Color.TURQUOISE);
					oceanGrid[x][y] = 0;
				}
				root.add(rect);
			}
		}
		return oceanGrid;
	}
	public void placeIslands() {
		Random random = new Random();
		int numIslands = 10;
		for (int i = 0; i < numIslands; i++) {
			int xAxis = random.nextInt(23)+1;// keep it out of the way of the pirates entering the water
			int yAxis = random.nextInt(24);
			if(oceanGrid[xAxis][yAxis]==1 || (xAxis == 10 && yAxis ==10)) {
				i--; //iterate down in count if it wants to make the boat an island or double paste an island
			} else {
			oceanGrid[xAxis][yAxis] = 1; // flag as an island
			
		}
	}
}
}
