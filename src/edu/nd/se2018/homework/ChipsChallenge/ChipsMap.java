package edu.nd.se2018.homework.ChipsChallenge;

import java.util.LinkedList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChipsMap {

	int[][] chipsGrid = new int[25][25];
	final int dimensions = 25;
	Image wall;
	Image lava;
	ImageView lavaImageView;
	ImageView wallImageView;
	Image ground;
	Image heart;
	Image portal;
	ImageView portalImageView;
	ImageView groundImageView;
	int scale;
	
	List<ImageView> lives = new LinkedList<ImageView>(); 
	
	public void drawMap(ObservableList<Node> root, int scale) {
		this.scale = scale;
		ground = new Image("images\\BlankTile.png",scale, scale, false, true);
		lava = new Image("images\\lava_tile.png",scale, scale, false, true);
		wall = new Image("images\\wall.png",scale, scale, false, true);
		for(int x = 0; x < dimensions; x++) {
			for(int y = 0; y < dimensions; y++) {
				groundImageView = new ImageView(ground);
				groundImageView.setX(x*scale);
				groundImageView.setY(y*scale);
				root.add(groundImageView);
				chipsGrid[x][y] = 0;
			}
		}
		//Heart images in top left corner
		heart = new Image("images\\Heart.png",scale, scale, false, true);
		ImageView heart1 = new ImageView(heart);
		ImageView heart2 = new ImageView(heart);
		ImageView heart3 = new ImageView(heart);
		lives.add(heart1);
		lives.add(heart2);
		lives.add(heart3);
		int x = 0;
		int y = 0;
		for (ImageView life: lives) {
			life.setX(x*scale);
			life.setY(y*scale);
			root.add(life);
			x += 1;
		}
		
		// Portal image
		portal = new Image("images\\portal.png",scale, scale, false, true);
		portalImageView = new ImageView(portal);
		portalImageView.setX(12*scale);
		portalImageView.setY(1*scale);
		root.add(portalImageView);
		chipsGrid[12][1] = -1;
	}
	//// SECOND MAP
	public void drawMap2(ObservableList<Node> root) {
		Image ground = new Image("images\\BlankTile.png",scale, scale, false, true);
		for(int x = 0; x < dimensions; x++) {
			for(int y = 0; y < dimensions; y++) {
				groundImageView = new ImageView(ground);
				groundImageView.setX(x*scale);
				groundImageView.setY(y*scale);
				root.add(groundImageView);
				chipsGrid[x][y] = 0;
			}
		}
		//Heart images in top left corner
		int x = 0;
		int y = 24;
		for (ImageView life: lives) {
			life.setX(x*scale);
			life.setY(y*scale);
			root.add(life);
			x += 1;
		}
		
		// Portal image
		portalImageView = new ImageView(portal);
		portalImageView.setX(1*scale);
		portalImageView.setY(1*scale);
		root.add(portalImageView);
		chipsGrid[1][1] = -2;
	}
	
	
	public void killLife(ObservableList<Node> root) {
		root.remove(lives.get(lives.size()-1));
		lives.remove(lives.size()-1);
	}
	public void setToGround(ObservableList<Node> root, int scale, int x, int y) {
		Image ground = new Image("images\\BlankTile.png",scale, scale, false, true);
		groundImageView = new ImageView(ground);
		groundImageView.setX(x*scale);
		groundImageView.setY(y*scale);
		root.add(groundImageView);
		chipsGrid[x][y] = 0;
	}
	
	public void setGrid(int x, int y, int val) {
		chipsGrid[x][y] = val;
	}
	
	public void setDoor(Door door) {
		setGrid(door.getDoorX(),door.getDoorY(), 1);
	}
	
	public void placeHazards(ObservableList<Node> root, int scale) {
		int row1 = 4;
		int row2 = 5;
		
		for(int i = 7; i < 18; i++) {
			chipsGrid[i][row1] = 2;
			chipsGrid[i][row2] = 2;
			//lava = new Image("images\\lava_tile.png",scale, scale, false, true);
			lavaImageView = new ImageView(lava);
			lavaImageView.setX(i*scale);
			lavaImageView.setY(row1*scale);
			root.add(lavaImageView);
			lavaImageView = new ImageView(lava);
			lavaImageView.setX(i*scale);
			lavaImageView.setY(row2*scale);
			root.add(lavaImageView);
		}
	}
	
	public void placeHazards2(ObservableList<Node> root) {
		//Horizontal lava
		int row = 3;
		for(int i = 0; i < 4; i++) {
			chipsGrid[i][row] = 2;
			lavaImageView = new ImageView(lava);
			lavaImageView.setX(i*scale);
			lavaImageView.setY(row*scale);
			root.add(lavaImageView);
		}
		
		row = 6;
		for(int i = 14; i < 20; i++) {
			chipsGrid[i][row] = 2;
			lavaImageView = new ImageView(lava);
			lavaImageView.setX(i*scale);
			lavaImageView.setY(row*scale);
			root.add(lavaImageView);
		}
		
		row = 12;
		for(int i = 14; i < 20; i++) {
			chipsGrid[i][row] = 2;
			lavaImageView = new ImageView(lava);
			lavaImageView.setX(i*scale);
			lavaImageView.setY(row*scale);
			root.add(lavaImageView);
		}
		
		// Hard coding in 10 lava blocks placed in weird order
		chipsGrid[24][12] = 2;
		chipsGrid[21][13] = 2;
		chipsGrid[22][14] = 2;
		chipsGrid[23][14] = 2;
		chipsGrid[21][16] = 2;
		chipsGrid[23][16] = 2;
		chipsGrid[24][17] = 2;
		chipsGrid[22][18] = 2;
		chipsGrid[23][19] = 2;
		chipsGrid[21][20] = 2;
		for (int x = 21; x < 25; x++) {
			for(int y = 12; y < 21; y++) {
				if (chipsGrid[x][y] == 2) {
					lavaImageView = new ImageView(lava);
					lavaImageView.setX(x*scale);
					lavaImageView.setY(y*scale);
					root.add(lavaImageView);
				}
			}
		}
		
		// Vertical lava strips
		int col = 3;
		for(int i = 0; i < 4; i++) {
			chipsGrid[col][i] = 2;
			lavaImageView = new ImageView(lava);
			lavaImageView.setX(col*scale);
			lavaImageView.setY(i*scale);
			root.add(lavaImageView);
		}
		
	}
	
	public void placeWalls(ObservableList<Node> root, int scale) {
		int vert1 = 6;
		int vert2 = 18;
		int horz1 = 10;
		int horz2 = 15;
		// Vertical walls
		for(int j = 0; j <= 24; j++) {
				if (j < 6 || (j > 9 && j < 19) || j > 20) {
					chipsGrid[vert1][j] = 1;
					wallImageView = new ImageView(wall);
					wallImageView.setX(vert1*scale);
					wallImageView.setY(j*scale);
					root.add(wallImageView);
					// Second column of walls
					if (j != 12) {
						chipsGrid[vert2][j] = 1;
						wallImageView = new ImageView(wall);
						wallImageView.setX(vert2*scale);
						wallImageView.setY(j*scale);
						root.add(wallImageView);
					}
				}
		}
		// horizontal walls
		for(int i = 0; i <= 24; i++) {
			if (i < 7 || i > 17) {
				chipsGrid[i][horz1] = 1;
				wallImageView = new ImageView(wall);
				wallImageView.setX(i*scale);
				wallImageView.setY(horz1*scale);
				root.add(wallImageView);
			}
			// second row
			if (i < 18 && i > 6) {
				chipsGrid[i][horz2] = 1;
				wallImageView = new ImageView(wall);
				wallImageView.setX(i*scale);
				wallImageView.setY(horz2*scale);
				root.add(wallImageView);
			}
		}
		
	}
	
	public void placeWalls2(ObservableList<Node> root) {
		int col1 = 20;
		int col2 = 13;
		int col3 = 6;
		int row1 = 13;
		// Vertical walls
		for(int j = 0; j < 25; j++) {
				if (j != 1) {
					chipsGrid[col1][j] = 1;
					wallImageView = new ImageView(wall);
					wallImageView.setX(col1*scale);
					wallImageView.setY(j*scale);
					root.add(wallImageView);
				}
		}
		for(int j = 0; j < 22; j++) {
			chipsGrid[col2][j] = 1;
			wallImageView = new ImageView(wall);
			wallImageView.setX(col2*scale);
			wallImageView.setY(j*scale);
			root.add(wallImageView);
		}
		for(int j = 0; j < 23; j++) {
			if (j != 1) {
				chipsGrid[col3][j] = 1;
				wallImageView = new ImageView(wall);
				wallImageView.setX(col3*scale);
				wallImageView.setY(j*scale);
				root.add(wallImageView);
			}
		}
		// horizontal walls
		for(int i = 0; i < 6; i++) {
			chipsGrid[i][row1] = 1;
			wallImageView = new ImageView(wall);
			wallImageView.setX(i*scale);
			wallImageView.setY(row1*scale);
			root.add(wallImageView);
		}
		
	}
	
	public void resetMap(ObservableList<Node> root) {
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
	
}
