package edu.nd.se2018.homework.ChipsChallenge;

import javafx.scene.Node;

public interface Door {
	public Node getImageView();
	public int getDoorX();
	public int getDoorY();
	public String getColor();
	public void delete();
}
