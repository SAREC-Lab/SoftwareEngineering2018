package raceTests;
import org.junit.Test;

import hwk2.EarlySprintStrategy;
import hwk2.Horse;
import hwk2.SlowStartStrategy;
import hwk2.SteadyRunStrategy;

public class RaceTest1 {
	@Test
	public void test() throws InterruptedException {
		Horse test1 = new SteadyRunStrategy(null, 0);
		test1.run();
		Horse test2 = new SlowStartStrategy(null, 0);
		test2.run();
		Horse test3 = new EarlySprintStrategy(null, 0);
		test3.run();
	}	
}
