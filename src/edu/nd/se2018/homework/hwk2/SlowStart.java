package edu.nd.se2018.homework.hwk2;

public class SlowStart implements RaceStrategy {
	public double runStrategy(double position, double maxSpeed) {
		double p = position;
		if (position <= 6) {
			p = position + (0.75 * maxSpeed);
		}
		else if (position <= 1) {
			p = position + (0.9 * maxSpeed);
		}
		else if (position < 10){
			p = position + maxSpeed;
		}
		else {
			position = 10;
		}
		return p;	
	}

}
