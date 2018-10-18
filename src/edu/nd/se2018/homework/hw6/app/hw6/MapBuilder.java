package hw6;

import javafx.collections.ObservableList;
import javafx.scene.Node;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import hw6.blocks.*;

public class MapBuilder {
	int[][] gameGrid = new int[25][25];
	final int dimensions = 25;
	ImageView block;
	
	public int[][] buildLevel( int level) {
		if(level == 1) {
			buildlevel1();
			System.out.println("level 1");
		}
		else if(level == 2) {
			buildlevel2();
			System.out.println("level 2");
		}
		return gameGrid;
	}
	private  void buildlevel1(){
		 for(int i = 0; i < 25 ; i++) {
			 gameGrid[0][i] = gameGrid[i][24] = gameGrid[i][0] = gameGrid[24][i] = 1; // build in border walls
		 }
		 gameGrid[20][20] = 3; // place a door to the next level
	}
	private  void buildlevel2(){
		for(int i = 0; i < 25 ; i++) {
			 gameGrid[0][i] = gameGrid[i][24] = gameGrid[i][0] = gameGrid[24][i] = 1; // build in border walls
		 }
		 gameGrid[23][10] = 2; // place a key
		 gameGrid[2][2] = 3; // place a door to the next level
		 gameGrid[4][2] = 4; // locked until you have the key
		 gameGrid[4][1] = gameGrid[4][3] = gameGrid[3][3] = gameGrid[2][3] = gameGrid[1][3]  = 1;
	}
	public void drawLevel(ObservableList<Node> root, int scale, AnchorPane base) {
		wall _wall = new wall();
		portal _portal = new portal();
		walkable _walkable = new walkable();
		key _key = new key();
		greenKeyBlock _keyBlock = new greenKeyBlock();
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions;y++) {
				ImageView block = block = new ImageView(_walkable.getImageView());
				if(gameGrid[x][y]==1) {
						System.out.println("This is a 1");
						// borders 
						block = new ImageView(_wall.getImageView());
				}else if(gameGrid[x][y] == 2){
					System.out.println("This is a 2");
						// key
						block = new ImageView(_key.getImageView());
				}else if(gameGrid[x][y] == 3){
						block = new ImageView(_portal.getImageView());
						//portal placement
				}else if(gameGrid[x][y] == 4){
						block = new ImageView(_keyBlock.getImageView());	
				}else {
					//rect.setFill(Color.GREY);
					gameGrid[x][y] = 0;
				}
			block.setX(scale*x);
			block.setY(scale*y);;
			base.getChildren().add(block);
			}
		}
	}
}
