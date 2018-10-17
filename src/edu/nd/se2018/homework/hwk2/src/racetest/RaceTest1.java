package edu.nd.se2018.homework.hwk2.src.racetest;
import org.junit.Test;

import edu.nd.se2018.homework.hwk2.src.homework2.EarlySprintStrategy;
import edu.nd.se2018.homework.hwk2.src.homework2.Horse;
import edu.nd.se2018.homework.hwk2.src.homework2.SlowStartStrategy;
import edu.nd.se2018.homework.hwk2.src.homework2.SteadyRunStrategy;

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
