package edu.nd.se2018.homework.hwk2;

public class SteadyRun implements RaceStrategy {
	public double runStrategy(double position, double maxSpeed) {
		double p;
		if (position < 10) {
			p = position + (0.8 * maxSpeed);
		}
		else {
			p = 10;
		}
		return p;		
	}

}
