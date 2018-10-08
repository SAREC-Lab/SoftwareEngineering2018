package edu.nd.se2018.homework.hwk6.controller;

import edu.nd.se2018.homework.hwk6.model.ChipModel;
import edu.nd.se2018.homework.hwk6.view.ChipView;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class ChipController {
	public ChipModel chip;
	public ChipView chipView;
	public int[] pos;
	public int [][] gameMap;
	
	public ChipController(int[][] map) {
		chip = new ChipModel(0, 0, map);
		chipView = new ChipView(chip);
		chip.attachView(chipView);
		pos = chip.getPosition();
		gameMap = map;
		
	}
	
	public void moveEvent(KeyEvent ke) {
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
	
	public void moveRight() {
		int[] pos = new int[2];
		pos = chip.getPosition();
		int x = pos[0];
		int y = pos[1];
		if (x + 1 < 25) {
			if (gameMap[x + 1][y] != 1) {
				x++;
			}
		}
		this.chip.setPosition(x, y);
	}
	
	public void moveLeft() {
		int[] pos = new int[2];
		pos = chip.getPosition();
		int x = pos[0];
		int y = pos[1];
		if (x - 1 >= 0) {
			if (gameMap[x - 1][y] != 1) {
				x--;
			}
		}
		this.chip.setPosition(x, y);
	}
	
	public void moveUp() {
		int[] pos = new int[2];
		pos = chip.getPosition();
		int x = pos[0];
		int y = pos[1];
		if (y - 1 >= 0) {
			if (gameMap[x][y - 1] != 1) {
				y--;
			}
		}
		this.chip.setPosition(x, y);
	}
	
	public void moveDown() {
		int[] pos = new int[2];
		pos = chip.getPosition();
		int x = pos[0];
		int y = pos[1];
		if (y + 1 < 25) {
			if (gameMap[x][y + 1] != 1) {
				y++;
			}
		}
		this.chip.setPosition(x, y);
	}

}
