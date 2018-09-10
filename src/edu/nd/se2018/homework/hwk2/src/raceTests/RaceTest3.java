package raceTests;
import org.junit.Test;

public class RaceTest3 {
	@Test
	public void test() throws InterruptedException {
		Race race1 = new Race();
		race1.enrollHorse("Jimmy", 43, "steady");
		race1.enrollHorse("klien", 46, "slow");
		race1.enrollHorse("Dabo", 45, "early");
		race1.enrollHorse("Sheen", 42, "slow");
		race1.enrollHorse("Biscuit", 41, "steady");
	}	
}

