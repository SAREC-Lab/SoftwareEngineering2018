package raceTests;
import org.junit.Test;

public class RaceTest3 {
	@Test
	public void test() throws InterruptedException {
		Race race = new Race();
		race.enrollHorse("Lily", 41, "steady");
		race.enrollHorse("Argo", 42, "slow");
		race.enrollHorse("Jackie", 45, "early");
		race.enrollHorse("Stone", 46, "slow");
		race.enrollHorse("Caleb", 41, "steady");
	}	
}

