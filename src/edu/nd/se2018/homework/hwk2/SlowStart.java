package edu.nd.se2018.homework.hwk2;

public class SlowStart implements Strategy {
	
	public double move(double maxSpeed, double distanceTraveled) {
		if (distanceTraveled < 6) {
			return (maxSpeed * .75) / 3600;
		}
		else if (distanceTraveled < 9) {
			return (maxSpeed * .9) / 3600;
		}
		return maxSpeed / 3600;
	}
	
}
