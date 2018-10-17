package edu.nd.se2018.homework.hwk2.src.homework2;

public class EarlySprintStrategy extends Horse{
	
	public double slowSpeed;
	public double intspeed;
	
	public EarlySprintStrategy(String n, double s) {
		intspeed = s;
		slowSpeed = s*.75;
	}
	
	@Override
	public void run() {
		if (position < 10) {
			if (position >= 2) {
				intspeed = slowSpeed;
			}
			position = position + intspeed*timeIncr;
		}else {
			finished = true;
		}
	}
	
	public void display() {
		if (!finished) {
			System.out.println(name + " ran " + position + " miles.");
		}else {
			System.out.println(name + " finished.");
		}
		
	}
}
