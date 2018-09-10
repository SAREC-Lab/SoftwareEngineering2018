package edu.nd.se2018.homework.hwk2;
import org.junit.Test;

public class TestRace 
{
	@Test
	public void Test()
	{
		Race case1 = new Race();						// Standard test case to assess functionality
		
		case1.addHorse("Divine Providence", 25, "EarlySprinter");
		case1.addHorse("Speed Demon", 25, "SteadyRunner");
		case1.addHorse("American Pharoah", 28, "SlowStarter");
		case1.addHorse("Sea Biscuit", 25, "SlowStarter");
		case1.addHorse("Rear Gunner", 25, "EarlySprinter");
		
		case1.runRace();
		System.out.println("");
		
		Race case2 = new Race();						// Test case for tie event
		
		case2.addHorse("War Admiral", 25, "EarlySprinter");
		case2.addHorse("Circus Act", 24, "SlowStarter");
		case2.addHorse("American Pharoah", 25, "EarlySprinter");
		case2.addHorse("Sea Biscuit", 23, "SlowStarter");
		case2.addHorse("Secretariat", 25, "EarlySprinter");
		
		case2.runRace();
		
		System.out.println("");
		Race case3 = new Race();						// Test case for "null rider", or 0/negative initial speed
		
		case3.addHorse("2Sigma", 25, "EarlySprinter");
		case3.addHorse("Pariveda", 25, "SteadyRunner");
		case3.addHorse("Jane Street", 0, "SlowStarter");
		case3.addHorse("Deloitte", -25, "SlowStarter");
		
		case3.runRace();
	}
}