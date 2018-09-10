package edu.nd.se2018.homework.homework3;

public class Horse {
	
	public String name;
	public Strategy strategy;
	public double maxSpeed;
	
	public Horse(String name, Strategy strategy, double maxSpeed) {
		this.name = name;
		this.strategy = strategy;
		this.maxSpeed = maxSpeed;
	}
	
	// Resets horse strategy
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
}
