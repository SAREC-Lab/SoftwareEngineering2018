package src.edu.nd.se2018.homework.hwk2;

import org.junit.jupiter.api.Test;

class raceTest {

	@Test
	// basic unit test
	void test() {
		race Test1 = new race();
		Test1.addHorse("Mike",25,"slowStarter");
		Test1.addHorse("Sam",22,"EarlySprinter");
		Test1.addHorse("Molly",30,"EarlySprinter");
		Test1.addHorse("Joe",25,"EarlySprinter");
		Test1.addHorse("Blizzard",20,"EarlySprinter");
		Test1.runRace();
	}
	

}
