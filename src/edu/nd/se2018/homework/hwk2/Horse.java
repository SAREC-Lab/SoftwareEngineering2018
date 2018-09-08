package edu.nd.se2018.homework.hwk2;

import edu.nd.se2018.homework.hwk2.HorseBehavior;

public class Horse {
	HorseBehavior horseBehavior;
	
	public Horse(String[] horseName, int horseIndex, int horseInitSpeed){
		String[] name = horseName;
		int index = horseIndex;
		int initSpeed = horseInitSpeed;
		
		//HorseBehavior horseBehavior;
		//horseBehavior = new FlyWithWings();
	}
	
	public void race() {
		horseBehavior.performRace();
	}
	
	public void setHorseBehavior(HorseBehavior horseBehavior) {
		this.horseBehavior = horseBehavior;
	}
}
