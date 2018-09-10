package edu.nd.se2018.homework.hwk2;
import org.junit.Test;

public class RaceTest {

	// Test when all horses have the same max speeds and varied strategies
	@Test
	public void testCase1() {
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

		
		// Test with ASSERT
		assert(race.startRace()=="Lag");
	}
	
	// Test when all horses have different max speeds and same strategies
	@Test
	public void testCase2() {
		// Instantiate Race class
		Race race = new Race();
		
		// Create horses
		Horse horse1 = new Horse("Horsey", new SteadyRun(), 20);
		Horse horse2 = new Horse("Cool Guy", new SteadyRun(), 30);
		Horse horse3 = new Horse("Lag", new SteadyRun(), 40);
		Horse horse4 = new Horse("Steady Dude", new SteadyRun(), 42);
		Horse horse5 = new Horse("Hyper Man", new SteadyRun(), 45);
		
		// Add horses to race
		race.addHorse(horse1);
		race.addHorse(horse2);
		race.addHorse(horse3);
		race.addHorse(horse4);
		race.addHorse(horse5);

		
		// Test with ASSERT
		assert(race.startRace()=="Hyper Man");
	}
	
	// Test when all horses have different max speeds and varied strategies
	@Test
	public void testCase3() {
		// Instantiate Race class
		Race race = new Race();
		
		// Create horses
		Horse horse1 = new Horse("Horsey", new EarlySprint(), 22);
		Horse horse2 = new Horse("Cool Guy", new SteadyRun(), 20);
		Horse horse3 = new Horse("Lag", new SlowStart(), 18);
		Horse horse4 = new Horse("Steady Dude", new SteadyRun(), 25);
		Horse horse5 = new Horse("Hyper Man", new EarlySprint(), 28);
		
		// Add horses to race
		race.addHorse(horse1);
		race.addHorse(horse2);
		race.addHorse(horse3);
		race.addHorse(horse4);
		race.addHorse(horse5);

		
		// Test with ASSERT
		assert(race.startRace()=="Hyper Man");
	}
	
}
