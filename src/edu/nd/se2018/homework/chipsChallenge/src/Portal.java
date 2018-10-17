package edu.nd.se2018.homework.chipsChallenge.src;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Portal {
	
	Point location = new Point();
	ChipMap map;
	ImageView imageView;
	int scale = 20;

	public Portal(ChipMap chipMap, int x, int y) {
		map = chipMap;
		location.x = x;
		location.y = y;
		Image portalImage = new Image("images\\portal.png", scale, scale, false, true);
		imageView = new ImageView(portalImage);
		imageView.setX(location.x*scale);
		imageView.setY(location.y*scale);
	}
	
	public Point getLocation() {
		return location;
	}
	
	public void setLocation2() {
		location.x = 0;
		location.y = 0;
	}
	
	public ImageView getImageView() {
		return imageView;
	}

}
