package edu.nd.se2018.homework.hwk2;
import org.junit.Test;

public class RaceTest {
	@Test
	public void test() { 	// Same strategies, different max speeds
		Race race = new Race();
		race.enrollHorse(new SteadyRun(), "A1", 1, 0, 1);
		race.enrollHorse(new SteadyRun(), "B1", 2, 0, 1.2);
		race.enrollHorse(new SteadyRun(), "C1", 3, 0, 1.4);
		race.run();
		assert(race.winner == "C1");
	}
	
	@Test
	public void test2() { 	// Same strategies, different max speeds
		Race race2 = new Race();
		race2.enrollHorse(new SteadyRun(), "A2", 1, 0, 1);
		race2.enrollHorse(new EarlySprint(), "B2", 1, 0, 1);
		race2.enrollHorse(new SlowStart(), "C2", 3, 0, 1);
		race2.run();
		assert(race2.winner == "C2");
	}
	
	@Test
	public void test3() {
		Race race3 = new Race();
		race3.enrollHorse(new SteadyRun(), "A3", 1, 0, 2);
		race3.enrollHorse(new SlowStart(), "B3", 2, 0, 1);
		race3.enrollHorse(new EarlySprint(), "C3", 3, 0, 1.1);
		race3.enrollHorse(new SlowStart(), "D3", 4, 0, 0.8);
		race3.enrollHorse(new SteadyRun(), "E3", 5, 0, 0.9);
		race3.run();
		assert(race3.winner == "A3");
	}
}
