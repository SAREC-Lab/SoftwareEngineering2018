package edu.nd.se2018.homework.hwk6.model;

import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.hwk6.view.ChipView;

public class ChipModel extends Observable implements Observer {
	int keys;
	int x;
	int y;
	int[] position = new int[2];
	int[][] gameMap;
	boolean allKeys = false;
	int [] monsterPos = new int[2];
	
	private GameState gameRunning;
	private GameState chipsCollected;
	private GameState gameWon;
	private GameState currentState;
	
	public ChipModel(int xPos, int yPos, int[][] map, int k) {
		x = xPos;
		y = yPos;
		this.keys = k;
		gameMap = map;
		
		gameRunning = new GameRunning(this);
		chipsCollected = new AllChips(this);
		gameWon = new GameWon(this);
		
		currentState = gameRunning;
		currentState.running();
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
		this.keys--;
		if (keys == 0) {
			this.allKeys = true;
			currentState.allChipsCollected();
		}
	}
	
	public void attachView(ChipView view) {
		addObserver(view);
	}
	
	public boolean allKeysCollected() {
		return(allKeys);
	}
	
	public void setGameState(GameState newState){
		currentState = newState;
	}
	
	public GameState getAllChipsState() {
		return chipsCollected;
	}
	
	public GameState getRunningState() {
		return gameRunning;
	}
	
	public GameState getGameWonState() {
		return gameWon;
	}
	
	public void levelWon() {
		currentState.levelWon();
	}

	@Override
	public void update(Observable o, Object arg) {
		monsterPos = ((MonsterModel)o).getPosition();
		if ((monsterPos[0] == x) && (monsterPos[1] == y)) {
			setPosition(0,0);
		}
		
		
	}

}
