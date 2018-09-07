package edu.nd.se2018.homework.hwk2;
import edu.nd.se2018.homework.hwk2.RaceStrategy;

public class Horse {
	RaceStrategy raceStrategy;
	public static String name;
	public static int number;
	public static double position;
	public static double maxSpeed;
	
	public Horse(RaceStrategy strategy, String n, int num, double p, double s) {
		raceStrategy = strategy;
		name = n;
		number = num;
		position = p;
		maxSpeed = s;
	}
	
	public void run() {
		double p = raceStrategy.runStrategy(position, maxSpeed);
		position = p;
	}
	
	public void setStrategy(RaceStrategy strategy) {
		raceStrategy = strategy;
		
	}
	
	public void display() {
		System.out.println(name + " is at position: " + position);
	}

}
