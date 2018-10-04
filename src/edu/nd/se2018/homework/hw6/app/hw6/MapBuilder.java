package hw6;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MapBuilder {
	int[][] gameGrid = new int[25][25];
	final int dimensions = 25;
	
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
		 gameGrid[10][12] = 2; // place a key
		 gameGrid[20][20] = 3; // place a door to the next level
		 gameGrid[15][10] = 5; // place chip
	}
	private  void buildlevel2(){
		for(int i = 0; i < 25 ; i++) {
			 gameGrid[0][i] = gameGrid[i][24] = gameGrid[i][0] = gameGrid[24][i] = 1; // build in border walls
		 }
		 gameGrid[23][10] = 2; // place a key
		 gameGrid[2][2] = 3; // place a door to the next level
		 gameGrid[4][2] = 4; // locked until you have the key
		 gameGrid[15][10] = 5; // place chip
		 gameGrid[4][1] = gameGrid[4][3] = gameGrid[3][3] = gameGrid[2][3] = gameGrid[1][3]  = 1;
	}
	public void drawLevel(ObservableList<Node> root, int scale) {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions;y++) {
				Rectangle rect = new Rectangle(y*scale, x*scale,scale,scale);
				rect.setStroke(Color.BLACK);
				if(gameGrid[x][y]==1) {
					rect.setFill(Color.BLACK);
				}else if(gameGrid[x][y] == 2){
					rect.setFill(Color.GOLD);
				}else if(gameGrid[x][y] == 3){
					rect.setFill(Color.BLUE);
				}else if(gameGrid[x][y] == 4){
					rect.setFill(Color.RED);
				}else if(gameGrid[x][y] == 5){
					rect.setFill(Color.GREEN);
				}else {
					rect.setFill(Color.GREY);
					gameGrid[x][y] = 0;
				}
				root.add(rect);
			}
		}
	}
}
