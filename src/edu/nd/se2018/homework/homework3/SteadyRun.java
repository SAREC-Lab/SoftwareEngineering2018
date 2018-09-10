package edu.nd.se2018.homework.homework3;

public class SteadyRun implements Strategy {
	
	public double move(double maxSpeed, double distanceTraveled) {
		return (maxSpeed * .8) / 3600;
	}
	
}
