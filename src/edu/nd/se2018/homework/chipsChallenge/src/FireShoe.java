package edu.nd.se2018.homework.chipsChallenge.src;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FireShoe {
	// locals
	Point location = new Point();
	ChipMap map;
	ImageView imageView;
	int scale = 20;
	int ID = 1;

	public FireShoe(ChipMap chipMap, int x, int y) {
		map = chipMap;
		location.x = x;
		location.y = y;
		Image blueKeyImage = new Image("images\\fireShoe.PNG", scale, scale, false, true);
		imageView = new ImageView(blueKeyImage);
		imageView.setX(location.x*scale);
		imageView.setY(location.y*scale);
	}

	public Point getLocation() {
		return location;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
