package edu.nd.se2018.homework.hwk6.model;

import java.util.Observable;

import edu.nd.se2018.homework.hwk6.view.ChipView;

public class ChipModel extends Observable {
	int keys;
	int x;
	int y;
	int[] position = new int[2];
	int[][] gameMap;
	
	public ChipModel(int xPos, int yPos, int[][] map) {
		x = xPos;
		y = yPos;
		keys = 0;
		gameMap = map;
	}
	
	public int[] getPosition() {
		position[0] = this.x;
		position[1] = this.y;
		return(position);
	}
	
	public int getKeys() {
		return(this.keys);
	}
	
	public void setPosition(int xPos, int yPos) {
		if (gameMap[xPos][yPos] == 0) {
			this.x = xPos;
			this.y = yPos;
		}
		setChanged();
		notifyObservers();
	}
	
	public void addKey() {
		this.keys++;
	}
	
	public void attachView(ChipView view) {
		addObserver(view);
	}

}
