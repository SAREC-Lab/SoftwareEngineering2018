package edu.nd.se2018.homework.ChipsChallenge;

import javafx.scene.Node;

public interface Key {
	public Node getImageView();
	public int getKeyX();
	public int getKeyY();
	public String getColor();
	public void delete();
}
