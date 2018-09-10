package edu.nd.se2018.homework.hwk2;

public class Main {
	public static void main(String[] args) {	
		Race race = new Race();
		race.enrollHorse("Sam", 0, 22, new EarlySprintStrategy());
		race.enrollHorse("Molly", 1, 24, new SlowStartStrategy());
		race.enrollHorse("Joe", 2, 25, new EarlySprintStrategy());
		race.enrollHorse("Blizzard", 3, 25, new SlowStartStrategy());
		race.enrollHorse("Flicker", 4, 25, new SteadyRunStrategy());
		
		race.startRace();
	}
}
