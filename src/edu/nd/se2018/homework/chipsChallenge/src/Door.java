package edu.nd.se2018.homework.chipsChallenge.src;

import java.awt.Point;

import javafx.scene.image.ImageView;

public interface Door {
	// methods for doors
	Point getDoorLocation();
	void lockDoor();
	int getDoorId();
	void unlockDoor();
	ImageView getDoorImageView();
}
