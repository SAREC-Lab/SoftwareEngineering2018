package edu.nd.se2018.homework.hwk2;

public class EarlySprint implements RaceStrategy {
	@Override
	public double runStrategy(double position, double maxSpeed) {
		double p;
		if (position <= 2) {
			p = position + maxSpeed;
		}
		else if (position < 10) {
			p = position + (0.75 * maxSpeed);
		}
		else {
			p = 10;
		}
		return p;
		
	}

}
