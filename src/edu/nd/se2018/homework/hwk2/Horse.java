package edu.nd.se2018.homework.hwk2;
import java.text.DecimalFormat;

import edu.nd.se2018.homework.hwk2.RaceStrategy;

public class Horse {
	private static DecimalFormat df2 = new DecimalFormat(".##");
	
	RaceStrategy raceStrategy;
	public String name;
	public int number;
	public double position;
	public double maxSpeed;
	
	public Horse(RaceStrategy strategy, String n, int num, double p, double s) {
		this.raceStrategy = strategy;
		this.name = n;
		this.number = num;
		this.position = p;
		this.maxSpeed = s;
	}
	
	public void run() {
		double p = raceStrategy.runStrategy(this.position, this.maxSpeed);
		this.position = p;
	}
	
	public void setStrategy(RaceStrategy strategy) {
		this.raceStrategy = strategy;
		
	}
	
	public boolean done() {
		if (position >= 10) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void display() {
		System.out.println(name + " is at position: " + df2.format(position));
	}

}
