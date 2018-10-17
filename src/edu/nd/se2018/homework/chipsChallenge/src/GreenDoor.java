package edu.nd.se2018.homework.chipsChallenge.src;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GreenDoor implements Door{
	
	ChipMap map;
	Point location = new Point();
	ImageView imageView;
	int scale = 20;
	int ID = 2;

	public GreenDoor(ChipMap chipMap, int x, int y) {
		map = chipMap;
		location.x = x;
		location.y = y;
		Image blueDoorImage = new Image("images\\greenKeyWall.png", scale, scale, false, true);
		imageView = new ImageView(blueDoorImage);
		imageView.setX(location.x*scale);
		imageView.setY(location.y*scale);
		map.chipsGrid[location.x][location.y] = 1;
	}
	@Override
	public Point getDoorLocation() {
		return location;
	}

	@Override
	public void lockDoor() {
		map.chipsGrid[location.x][location.y] = 1;
		
	}
	@Override
	public ImageView getDoorImageView() {
		return imageView;
	}
	@Override
	public int getDoorId() {
		return ID;
	}
	@Override
	public void unlockDoor() {
		map.chipsGrid[location.x][location.y] = 0;
		
	}

}
