package edu.nd.se2018.homework.hwk2.src.homework2;

public class SteadyRunStrategy extends Horse {
	public double intspeed;

	public SteadyRunStrategy(String n, double s) {
		name = n;
		intspeed = s*.8;
	}

	
	@Override
	public void run() {
		if (position < 10) {
			position = position + intspeed*timeIncr;
		}else {
			finished = true;
		}
	}
	
	public void display() {
		if (!finished) {
			System.out.println(name + " tran " + position + " miles.");
		}else {
			System.out.println(name + " finished.");
		}
	}
}
