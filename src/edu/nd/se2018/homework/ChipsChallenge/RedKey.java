package edu.nd.se2018.homework.ChipsChallenge;

import java.awt.Point;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RedKey implements Key {
	Image keyImage;
	ImageView keyImageView;
	Point location = new Point();
	String color;
	
	public RedKey(int x, int y, int scalingFactor) {
		location.x = x;
		location.y = y;
		color = "Red";
		Image keyImage = new Image("images\\redKey.png",scalingFactor, scalingFactor, false, true);
		keyImageView = new ImageView(keyImage);
		keyImageView.setX(x*scalingFactor);
		keyImageView.setY(y*scalingFactor);
	}
	
	@Override
	public Node getImageView() {
		return keyImageView;
	}

	@Override
	public int getKeyX() {
		return location.x;
	}

	@Override
	public int getKeyY() {
		return location.y;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
