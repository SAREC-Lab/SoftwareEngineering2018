package edu.nd.se2018.homework.ChipsChallenge;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MoveableBlock{
	ChipsMap map;
	Point location = new Point();
	final int scalingFactor = 26; 
	Image blockImage;
	ImageView blockImageView;
	
	public MoveableBlock(ChipsMap chipMap, int x, int y) {
		map = chipMap;
		location.x = x;
		location.y = y;
		blockImage = new Image("images\\moveableBlock.png",scalingFactor, scalingFactor, false, true);
		blockImageView = new ImageView(blockImage);
	}
	
	public void setImageView() {
		blockImageView.setX(location.x*scalingFactor);
		blockImageView.setY(location.y*scalingFactor);
	}
	
	public ImageView getImageView(){
		return blockImageView;
	}
	
	public Point getBlockLocation() {
		return location;
	}

	public void goEast() {
		if(location.x < 24 && map.chipsGrid[location.x +1][location.y] != 1) {
			location.x += 1;
		}
	}

	public void goWest() {
		if(location.x > 0 && map.chipsGrid[location.x -1][location.y] != 1) {
			location.x -= 1;
		}
	}

	public void goNorth() {
		if(location.y > 0 && map.chipsGrid[location.x][location.y-1] != 1) {
			location.y -= 1;
		}
	}

	public void goSouth() {
		if(location.y < 24 && map.chipsGrid[location.x][location.y +1] != 1) {
			location.y += 1;
		}
	}

}
