package edu.nd.se2018.homework.homework4;
import javafx.collections.ObservableList;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class OceanMap {
	
	public int[][] oceanGrid = new int[25][25];
	final int dimensions = 25;
	int islandNum = 0;
	
	public void drawMap(ObservableList<Node> root, int scale) {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				oceanGrid[x][y] = 0;
			}
		}
		while (islandNum < 10) {
			Random rand = new Random();
			int islandXPos = rand.nextInt(25);
			int islandYPos = rand.nextInt(25);
			while (oceanGrid[islandXPos][islandYPos] != 0) {
				islandXPos = rand.nextInt(25);
				islandYPos = rand.nextInt(25);
			}
			oceanGrid[islandXPos][islandYPos] = 1;
			islandNum++;
		}
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				if (oceanGrid[x][y] == 0) {
					rect.setFill(Color.PALETURQUOISE);
				}
				else if (oceanGrid[x][y] == 1) {
					rect.setFill(Color.GREEN);
				}
				root.add(rect);
			}
		}
	}
	
}