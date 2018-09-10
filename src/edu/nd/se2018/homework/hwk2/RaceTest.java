package edu.nd.se2018.homework.hwk2;
import org.junit.Test;

public class RaceTest {
	@Test
	// Test which strat works with same speed
	public void test1() { 
		Race race = new Race();
		race.enrollHorse("Abaccus", 0, 20, new SteadyRunStrategy());
		race.enrollHorse("Abdullah", 1, 20, new SlowStartStrategy());
		race.enrollHorse("Above", 2, 20, new EarlySprintStrategy());
		assert(race.startRace().equals("Winner is Abdullah"));
	}
	
	@Test
	// Test when Slow works
	public void test2() { 
		Race race = new Race();
		race.enrollHorse("Nabisco", 0, 35, new SteadyRunStrategy());
		race.enrollHorse("Nadia", 1, 40, new SlowStartStrategy());
		race.enrollHorse("Nafa", 2, 30, new EarlySprintStrategy());
		assert(race.startRace().equals("Winner is Nadia"));
	}
	
	@Test
	// Tortoise vs hare
	public void test3() { 
		Race race = new Race();
		race.enrollHorse("Z", 0, 23, new SteadyRunStrategy());
		race.enrollHorse("Zack", 1, 21, new SlowStartStrategy());
		race.enrollHorse("Zane", 2, 25, new EarlySprintStrategy());
		race.enrollHorse("Zara", 3, 19, new SlowStartStrategy());
		race.enrollHorse("Zeek", 4, 18, new EarlySprintStrategy());
		assert(race.startRace().equals("Winner is Zack"));
	}
	
	@Test
	public void test4() {
		Race race = new Race();
		race.enrollHorse("Sam", 0, 22, new SteadyRunStrategy());
		race.enrollHorse("Molly", 1, 22, new SteadyRunStrategy());
		assert(race.startRace().equals("Winner is Sam"));	
	}
	
	@Test
	public void test5() {
		Race race = new Race();
		race.enrollHorse("Sam", 0, 100, new EarlySprintStrategy());
		race.enrollHorse("Molly", 1, 100, new SlowStartStrategy());
		assert(race.startRace().equals("Winner is Molly"));
	}
}
