package edu.nd.se2018.homework.ColumbusGame;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.concurrent.ThreadLocalRandom;

public class OceanMap {
	
	int[][] oceanGrid = new int[10][10];
	final int dimensions = 10;
	Image island;
	ImageView islandImageView;
	Image ocean;
	ImageView oceanImageView;
	
	public void drawMap(ObservableList<Node> root, int scale) {
		Image ocean = new Image("images\\oceanSprite.png",scale, scale, false, true);
		for(int x = 0; x < dimensions; x++) {
			for(int y = 0; y < dimensions; y++) {
				oceanImageView = new ImageView(ocean);
				oceanImageView.setX(x*scale);
				oceanImageView.setY(y*scale);
				root.add(oceanImageView);
				oceanGrid[x][y] = 0;
			}
		}
	}
	
	public void placeIslands(ObservableList<Node> root, int scale) {
		int randomNum;
		int randomNum2;
		for(int i = 0; i <= 9; i++) {
			randomNum = ThreadLocalRandom.current().nextInt(0, 10);
			randomNum2 = ThreadLocalRandom.current().nextInt(0, 10);
			if (oceanGrid[randomNum][randomNum2] == 0) {
				oceanGrid[randomNum][randomNum2] = 1;
				island = new Image("images\\islandSprite.png",scale, scale, false, true);
				islandImageView = new ImageView(island);
				islandImageView.setX(randomNum*scale);
				islandImageView.setY(randomNum2*scale);
				root.add(islandImageView);
			}else {
				i -= 1;
			}
		}
	}
	
}