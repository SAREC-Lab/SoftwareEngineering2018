package edu.nd.se2018.homework.hwk6.controller;

import edu.nd.se2018.homework.hwk6.model.ChipModel;
import edu.nd.se2018.homework.hwk6.view.ChipView;
import edu.nd.se2018.homework.hwk6.view.MapDisplay;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;

public class ChipController {
	public ChipModel chip;
	public ChipView chipView;
	public MapDisplay gameMap;
	public int[] pos;
	public int [][] map;
	public int keys;
	boolean update = false;
	int x;
	int y;
	boolean allChips = false;
	
	public ChipController(MapDisplay gMap) {
		gameMap = gMap;
		map = gameMap.getMap();
		keys = gameMap.getLevel()*5;
		
		chip = new ChipModel(0, 0, map, keys);
		chipView = new ChipView(chip);
		chip.attachView(chipView);
		pos = chip.getPosition();
	}
	
	public void moveEvent(KeyEvent ke) {
		
		if (update == true) {
			gameMap.removeKey(x, y);
			allChips = chip.allKeysCollected();
		}
		
		switch(ke.getCode()){
			case RIGHT:
				moveRight();
				break;
			case LEFT:
				moveLeft();
				break;
			case UP:
				moveUp();
				break;
			case DOWN:
				moveDown();
				break;
			default:
				break;
		}
		
	}
	
	public Node getImageView() {
		return chipView.view;
	}
	
	public ChipModel getModel() {
		return chip;
	}
	
	public void moveRight() {
		int[] pos = new int[2];
		pos = chip.getPosition();
		x = pos[0];
		y = pos[1];
		if (x + 1 < 25) {
			if (map[x + 1][y] != 1) {
				x++;
				if (map[x][y] == 2) {
					gameMap.setMap(x, y, 0);
					chip.addKey();
					update = true;
				}
				else {
					update = false;
				}
			}
			if (allChips == true) {
				if (map[x][y] == 4) {
					gameMap.setMap(x, y, 0);
					levelWon();
					
				}
			}
		}
		this.chip.setPosition(x, y);
	}
	
	public void moveLeft() {
		int[] pos = new int[2];
		pos = chip.getPosition();
		x = pos[0];
		y = pos[1];
		if (x - 1 >= 0) {
			if (map[x - 1][y] != 1) {
				x--;
				if (map[x][y] == 2) {
					gameMap.setMap(x, y, 0);
					chip.addKey();
					update = true;
				}
				else {
					update = false;
				}
			}
			if (allChips == true) {
				if (map[x][y] == 4) {
					gameMap.setMap(x, y, 0);
					levelWon();;
				}
			}
		}
		this.chip.setPosition(x, y);
	}
	
	public void moveUp() {
		int[] pos = new int[2];
		pos = chip.getPosition();
		x = pos[0];
		y = pos[1];
		if (y - 1 >= 0) {
			if (map[x][y - 1] != 1) {
				y--;
				if (map[x][y] == 2) {
					gameMap.setMap(x, y, 0);
					chip.addKey();
					update = true;
				}
				else {
					update = false;
				}
			}
			if (allChips == true) {
				if (map[x][y] == 4) {
					gameMap.setMap(x, y, 0);
					levelWon();
				}
			}
		}
		this.chip.setPosition(x, y);
	}
	
	public void moveDown() {
		int[] pos = new int[2];
		pos = chip.getPosition();
		x = pos[0];
		y = pos[1];
		if (y + 1 < 25) {
			if (map[x][y + 1] != 1)  {
				y++;
				if (map[x][y] == 2 ) {
					gameMap.setMap(x, y, 0);
					chip.addKey();
					update = true;
				}
				else {
					update = false;
				}
			}
			if (allChips == true) {
				if (map[x][y] == 4) {
					gameMap.setMap(x, y, 0);
					levelWon();
	
				}
			}
		}
		this.chip.setPosition(x, y);
	}
	
	public void levelWon() {
		System.out.println("level won");
		gameMap.reset();
		//chip.setPosition(0, 0);
		//chip = new ChipModel(0, 0, map, keys);
		chipView = new ChipView(chip);
		chip.attachView(chipView);
		chip.setPosition(0, 0);
		pos = chip.getPosition();
	}

}
