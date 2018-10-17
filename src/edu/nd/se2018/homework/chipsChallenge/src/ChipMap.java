package edu.nd.se2018.homework.chipsChallenge.src;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChipMap {
	int[][] chipsGrid = new int[25][25];
	final int dimensions = 25;
	ImageView tileImageView;
	ImageView wallImageView;
	ImageView waterImageView;
	ImageView fireImageView;
	int vert1, vert2, vert3, vert4, vert5, vert6, vert7, vert8, vert9, vert10, vert11;
	int horiz1, horiz2, horiz3, horiz4, horiz5, horiz6, horiz7, horiz8, horiz9, horiz10, horiz11, horiz12;
	BlueDoor blueDoor;
	
	
	public void drawMap(ObservableList<Node> root, int scale) {
		Image tile = new Image("images\\BlankTile.png", scale, scale, false, true);
		for(int x = 0; x < dimensions; x++) {
			for(int y = 0; y < dimensions; y++) {
				tileImageView = new ImageView(tile);
				tileImageView.setX(x*scale);
				tileImageView.setY(y*scale);
				root.add(tileImageView);
				chipsGrid[x][y] = 0;
			}
		}
	}
	
	public void resetFloor(ObservableList<Node> root, int scale, int x, int y) {
		Image tile = new Image("images\\BlankTile.png", scale, scale, false, true);
		tileImageView = new ImageView(tile);
		tileImageView.setX(x*scale);
		tileImageView.setY(y*scale);
		root.add(tileImageView);
		chipsGrid[x][y] = 0;
	}
	
	public void drawObsticles2(ObservableList<Node> root, int scale) {
		// draw fire
		for(int y = 2; y < 25; y++) {
			for(int x = 0; x < 1; x++) {
				Image fire = new Image("images\\fire.PNG", scale, scale, false, true);
				fireImageView = new ImageView(fire);
				fireImageView.setX(x*scale);
				fireImageView.setY(y*scale);
				root.add(fireImageView);
				chipsGrid[x][y] = 3;
			}
		}
		
		for(int x = 1; x < 24; x++) {
			for(int y = 24; y < 25; y++) {
				Image fire = new Image("images\\fire.PNG", scale, scale, false, true);
				fireImageView = new ImageView(fire);
				fireImageView.setX(x*scale);
				fireImageView.setY(y*scale);
				root.add(fireImageView);
				chipsGrid[x][y] = 3;
			}
		}
	}
	
	public void drawObsticles(ObservableList<Node> root, int scale) {
		// draw water
		for(int y = 9; y < 12; y++) {
			for(int x = 0; x < dimensions - 1; x++) {
				Image water = new Image("images\\water.PNG", scale, scale, false, true);
				waterImageView = new ImageView(water);
				waterImageView.setX(x*scale);
				waterImageView.setY(y*scale);
				root.add(waterImageView);
				chipsGrid[x][y] = 1;
			}
		}
		
		// draw fire
		for(int y = 5; y < 8; y++) {
			for(int x = 3; x < 12; x++) {
				Image fire = new Image("images\\fire.PNG", scale, scale, false, true);
				fireImageView = new ImageView(fire);
				fireImageView.setX(x*scale);
				fireImageView.setY(y*scale);
				root.add(fireImageView);
				chipsGrid[x][y] = 2;
			}
		}
		for(int x = 3; x < 6; x++) {
			for(int y = 0; y < 5; y++) {
				Image fire = new Image("images\\fire.PNG", scale, scale, false, true);
				fireImageView = new ImageView(fire);
				fireImageView.setX(x*scale);
				fireImageView.setY(y*scale);
				root.add(fireImageView);
				chipsGrid[x][y] = 2;
			}
		}
	}
	
	public int killChip(int x, int y) {
		return chipsGrid[x][y];
	}
	
	public void walkOnFire(ObservableList<Node> root) {
		for(int y = 5; y < 8; y++) {
			for(int x = 3; x < 12; x++) {
				chipsGrid[x][y] = 0;
			}
		}
		for(int x = 3; x < 6; x++) {
			for(int y = 0; y < 5; y++) {
					chipsGrid[x][y] = 0;
			}
		}
	}
	public void walkOnFire2(ObservableList<Node> root) {
		for(int y = 2; y < 25; y++) {
			for(int x = 0; x < 1; x++) {
				chipsGrid[x][y] = 0;
			}
		}
		
		for(int x = 1; x < 24; x++) {
			for(int y = 24; y < 25; y++) {
				chipsGrid[x][y] = 0;
			}
		}
	}
	
	
	public void drawWalls2(ObservableList<Node> root, int scale) {
		
		// vertical walls
		vert6 = 1;
		vert7 = 5;
		vert8 = 4;
		vert9 = 6;
		vert10 = 18;
		vert11 = 16;
		for(int y = 0; y < dimensions; y++) {
			if(y < 24) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vert6*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vert6][y] = 1;
			}
			if(y > 1 && y < 8) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vert7*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vert7][y] = 1;
			}
			if(y > 11 && y < 22) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vert8*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vert8][y] = 1;
			}
			if(y > 13 && y < 22) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vert9*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vert9][y] = 1;
			}
			if(y > 3 && y < 14) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vert10*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vert10][y] = 1;
			}
			if(y > 3 && y < 12) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vert11*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vert11][y] = 1;
			}
		}
		
		// horizontal walls
		horiz5 = 2;
		horiz6 = 7;
		horiz7 = 11;
		horiz8 = 13;
		horiz9 = 23;
		horiz10 = 21;
		horiz11 = 14;
		horiz12 = 16;
		for(int x = 0; x < dimensions; x++) {
			if(x > 4 && x < 21) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(horiz5*scale);
				root.add(wallImageView);
				chipsGrid[x][horiz5] = 1;
			}
			if(x > 1 && x < 5) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(horiz6*scale);
				root.add(wallImageView);
				chipsGrid[x][horiz6] = 1;
			}
			if(x > 3 && x < 16) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(horiz7*scale);
				root.add(wallImageView);
				chipsGrid[x][horiz7] = 1;
			}
			if(x > 5 && x < 18) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(horiz8*scale);
				root.add(wallImageView);
				chipsGrid[x][horiz8] = 1;
			}
			if(x > 1 && x < 24) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(horiz9*scale);
				root.add(wallImageView);
				chipsGrid[x][horiz9] = 1;
			}
			if(x > 6 && x < 24) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(horiz10*scale);
				root.add(wallImageView);
				chipsGrid[x][horiz10] = 1;
			}
			if(x > 22) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(horiz11*scale);
				root.add(wallImageView);
				chipsGrid[x][horiz11] = 1;
			}
			if(x > 22) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(horiz12*scale);
				root.add(wallImageView);
				chipsGrid[x][horiz12] = 1;
			}
		}
	}
	
	public void drawWalls(ObservableList<Node> root, int scale) {
		
		// vertical walls
		vert1 = 2;
		vert2 = 14;
		vert3 = 16;
		vert4 = 6;
		vert5 = 23;
		for(int y = 0; y < dimensions; y++) {
			if((y > 11 && y < 16) || y > 16) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vert1*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vert1][y] = 1;
			}
			if(y > 19) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vert2*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vert2][y] = 1;
			}
			if(y < 19 && y > 16) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vert5*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vert5][y] = 1;
			}
			if(y > 3 && y < 9) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vert3*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vert3][y] = 1;
			}
			if(y >= 0 && y < 5) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vert4*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vert4][y] = 1;
			}
		
		
		
		}
		
		
		// horizontal walls
		horiz1 = 20;
		horiz2 = 4;
		horiz3 = 17;
		horiz4 = 16;
		for(int x = 0; x < dimensions; x++) {
			if(x > 13 && x != 24) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(horiz1*scale);
				root.add(wallImageView);
				chipsGrid[x][horiz1] = 1;
			}
			if(x > 3 && x < 23) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(horiz3*scale);
				root.add(wallImageView);
				chipsGrid[x][horiz3] = 1;
			}
			if(x == 4) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(horiz4*scale);
				root.add(wallImageView);
				chipsGrid[x][horiz4] = 1;
			}
			if((x > 12 && x < 24) || (x > 6 && x < 12)) {
				Image wall = new Image("images\\wall.PNG", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(horiz2*scale);
				root.add(wallImageView);
				chipsGrid[x][horiz2] = 1;
			}
		}
	}
}
