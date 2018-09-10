package edu.nd.se2018.homework.hwk2;

public class Main {

	public static void main(String[] args) {
		
		// Instantiate Race class
		Race race = new Race();
		
		// Create horses
		Horse horse1 = new Horse("Horsey", new EarlySprint(), 20);
		Horse horse2 = new Horse("Cool Guy", new SteadyRun(), 20);
		Horse horse3 = new Horse("Lag", new SlowStart(), 20);
		Horse horse4 = new Horse("Steady Dude", new SteadyRun(), 20);
		Horse horse5 = new Horse("Hyper Man", new EarlySprint(), 20);
		
		// Add horses to race
		race.addHorse(horse1);
		race.addHorse(horse2);
		race.addHorse(horse3);
		race.addHorse(horse4);
		race.addHorse(horse5);

		
		// Start race
		race.startRace();
	}

}
