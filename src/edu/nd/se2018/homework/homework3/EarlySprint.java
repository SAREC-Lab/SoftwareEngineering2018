package edu.nd.se2018.homework.homework3;

public class EarlySprint implements Strategy {
	
	public double move(double maxSpeed, double distanceTraveled) {
		if (distanceTraveled < 2) {
			return maxSpeed / 3600;
		}
		return (maxSpeed * .75) / 3600;
	}
	
}
