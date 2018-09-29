package edu.nd.se2018.homework.hwk6.controller;

import edu.nd.se2018.homework.hwk6.model.ChipModel;
import edu.nd.se2018.homework.hwk6.view.ChipView;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class ChipController {
	ChipModel chip;
	ChipView chipView;
	
	public ChipController(int[][] map) {
		chip = new ChipModel(0, 0, map);
		chipView = new ChipView(chip);
		chip.attachView(chipView);
		
	}
	
	public void moveEvent(KeyEvent ke) {
		switch(ke.getCode()){
			case RIGHT:
				System.out.println("right");
				break;
			case LEFT:
				System.out.println("left");
				break;
			case UP:
				System.out.println("up");
				break;
			case DOWN:
				System.out.println("down");
				break;
			default:
				break;
		}
		
	}
	
	public Node getImageView() {
		return chipView.view;
	}

}
