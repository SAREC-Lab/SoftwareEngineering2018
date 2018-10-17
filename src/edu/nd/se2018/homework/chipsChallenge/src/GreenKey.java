package edu.nd.se2018.homework.chipsChallenge.src;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GreenKey implements Key{

	Point location = new Point();
	ChipMap map;
	ImageView imageView;
	int scale = 20;
	int ID = 2;
	
	public GreenKey(ChipMap chipMap, int x, int y) {
		map = chipMap;
		location.x = x;
		location.y = y;
		Image greenKeyImage = new Image("images\\greenKey.png", scale, scale, false, true);
		imageView = new ImageView(greenKeyImage);
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
