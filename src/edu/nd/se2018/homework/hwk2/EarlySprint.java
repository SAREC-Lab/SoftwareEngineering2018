package edu.nd.se2018.homework.hwk2;

public class EarlySprint implements Strategy {
	
	public double move(double maxSpeed, double distanceTraveled) {
		if (distanceTraveled < 2) {
			return maxSpeed / 3600;
		}
		return (maxSpeed * .75) / 3600;
	}
	
}
