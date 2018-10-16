package edu.nd.se2018.homework.ChipsChallenge;

import java.awt.Point;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RedDoor implements Door{
	Image doorImage;
	ImageView doorImageView;
	Point location = new Point();
	String color;
	
	public RedDoor(int x, int y, int scalingFactor) {
		location.x = x;
		location.y = y;
		color = "Red";
		Image doorImage = new Image("images\\redKeyWall.png",scalingFactor, scalingFactor, false, true);
		doorImageView = new ImageView(doorImage);
		doorImageView.setX(x*scalingFactor);
		doorImageView.setY(y*scalingFactor);
	}
	
	@Override
	public Node getImageView() {
		return doorImageView;
	}

	@Override
	public int getDoorX() {
		return location.x;
	}

	@Override
	public int getDoorY() {
		return location.y;
	}

	@Override
	public void delete() {

	}

	@Override
	public String getColor() {
		return color;
	}

}
