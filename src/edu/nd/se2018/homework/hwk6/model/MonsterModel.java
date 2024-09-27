package edu.nd.se2018.homework.hwk6.model;

import java.util.Observable;

import edu.nd.se2018.homework.hwk6.view.MonsterView;

public class MonsterModel extends Observable {
	
	int[] position = new int[2];
	int[][] gameMap;
	int x, y;
	
	
	public MonsterModel(int xPos, int yPos) {
		x = xPos;
		y = yPos;
		position[0] = x;
		position[1] = y;
		
	}
	
	public void setPosition(int xPos, int yPos) {
		position[0] = xPos;
		position[1] = yPos;
		setChanged();
		notifyObservers();
		
	}
	
	public int[] getPosition() {
		return(this.position);
	}
	
	public void attachView(MonsterView view) {
		addObserver(view);
	}

}
