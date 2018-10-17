package edu.nd.se2018.homework.chipsChallenge.src;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BlueKey implements Key{
	
	Point location = new Point();
	ChipMap map;
	ImageView imageView;
	int scale = 20;
	int ID = 1;
	
	public BlueKey(ChipMap chipMap, int x, int y) {
		map = chipMap;
		location.x = x;
		location.y = y;
		Image blueKeyImage = new Image("images\\blueKey.png", scale, scale, false, true);
		imageView = new ImageView(blueKeyImage);
		imageView.setX(location.x*scale);
		imageView.setY(location.y*scale);
	}

	@Override
	public Point getKeyLocation() {
		return location;
	}

	@Override
	public ImageView getKeyImageView() {
		return imageView;
	}

	@Override
	public int getDoorId() {
		return ID;
	}

}
