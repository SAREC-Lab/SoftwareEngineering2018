package edu.nd.se2018.homework.ChipsChallenge;

import java.util.concurrent.ThreadLocalRandom;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChipsMap {
	
	int[][] chipsGrid = new int[25][25];
	final int dimensions = 25;
	Image wall;
	ImageView wallImageView;
	Image ground;
	ImageView groundImageView;
	
	public void drawMap(ObservableList<Node> root, int scale) {
		Image ground = new Image("images\\Brick.png",scale, scale, false, true);
		for(int x = 0; x < dimensions; x++) {
			for(int y = 0; y < dimensions; y++) {
				groundImageView = new ImageView(ground);
				groundImageView.setX(x*scale);
				groundImageView.setY(y*scale);
				root.add(groundImageView);
				chipsGrid[x][y] = 0;
			}
		}
	}
	
	public void placeWalls(ObservableList<Node> root, int scale) {
		int randomNum;
		int randomNum2;
		for(int i = 0; i <= 24; i++) {
			randomNum = ThreadLocalRandom.current().nextInt(0, 25);
			randomNum2 = ThreadLocalRandom.current().nextInt(0, 25);
			if (chipsGrid[randomNum][randomNum2] == 0) {
				chipsGrid[randomNum][randomNum2] = 1;
				wall = new Image("images\\BlankTile.png",scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(randomNum*scale);
				wallImageView.setY(randomNum2*scale);
				root.add(wallImageView);
			}else {
				i -= 1;
			}
		}
	}
	
}
