package edu.nd.se2018.homework.chipsChallenge.src;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class YellowKey implements Key{
	// locals
	Point location = new Point();
	ChipMap map;
	ImageView imageView;
	int scale = 20;
	int ID = 4;

	public YellowKey(ChipMap chipMap, int x, int y) {
		map = chipMap;
		location.x = x;
		location.y = y;
		Image blueKeyImage = new Image("images\\yellowKey.png", scale, scale, false, true);
		imageView = new ImageView(blueKeyImage);
		imageView.setX(location.x*scale);
		imageView.setY(location.y*scale);
	}

	@Override
	public Point getKeyLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	@Override
	public ImageView getKeyImageView() {
		// TODO Auto-generated method stub
		return imageView;
	}

	@Override
	public int getDoorId() {
		// TODO Auto-generated method stub
		return ID;
	}

}
