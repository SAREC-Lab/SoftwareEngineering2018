package edu.nd.se2018.examples.shapepopper;

import java.util.Random;

import javafx.scene.paint.Color;

public class RandomColorPicker {
	Color[] colorPick = new Color[10];
	Random rand = new Random();
	
	public RandomColorPicker(){
		colorPick[0] = Color.RED;
		colorPick[1] = Color.BLUE;
		colorPick[2] = Color.GREEN;
		colorPick[3] = Color.ORANGE;
		colorPick[4] = Color.YELLOW;
		colorPick[5] = Color.DARKGOLDENROD;
		colorPick[6] = Color.GRAY;
		colorPick[7] = Color.ALICEBLUE;
		colorPick[8] = Color.HOTPINK;
		colorPick[9] = Color.PLUM;		
	}
	
	public Color pickRandomColor(){
		int picker = rand.nextInt(10);
		return colorPick[picker];
	}
}
