package edu.nd.se2018.homework.hwk2;

public class Horse {
	HorseBehavior horseBehavior;
	String name;
	int index;
	double initSpeed;
	double currMiles = 0;
	int mins = 0;
	
	public Horse(String name, int index, double initSpeed, HorseBehavior horseBehavior){
		this.name = name;
		this.index = index;
		this.initSpeed = initSpeed;
		this.horseBehavior = horseBehavior;
	}
	
	public void setHorseBehavior(HorseBehavior horseBehavior) {
		this.horseBehavior = horseBehavior;
	}
	
	public void updateRace() {
		horseBehavior.performRace(this);
	}

	public double printCurrLoc() {
		System.out.println(name + " has run " + currMiles);
		return currMiles;
	}
}
