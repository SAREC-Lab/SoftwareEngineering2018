package edu.nd.se2018.homework.chipsChallenge.src;

import java.awt.Point;

import javafx.scene.image.ImageView;

public interface Key {
	Point getKeyLocation();
	ImageView getKeyImageView();
	int getDoorId();

}
