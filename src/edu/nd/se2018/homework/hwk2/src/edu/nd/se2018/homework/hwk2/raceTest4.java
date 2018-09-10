package src.edu.nd.se2018.homework.hwk2;

import org.junit.jupiter.api.Test;

class raceTest4 {

	@Test
	// Size controls test, race should continue, but only with 5 horses.
	void test() {
		race Test1 = new race();
		Test1.addHorse("Mike1",20,"EarlySprinter");
		Test1.addHorse("Sam1",25,"EarlySprinter");
		Test1.addHorse("Molly1",30,"EarlySprinter");
		Test1.addHorse("Mike2",20,"EarlySprinter");
		Test1.addHorse("Sam2",25,"EarlySprinter");
		Test1.addHorse("Molly2",30,"EarlySprinter");
		
		Test1.runRace();
	}
}
