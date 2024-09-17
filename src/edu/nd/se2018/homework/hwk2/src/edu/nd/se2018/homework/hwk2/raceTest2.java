package src.edu.nd.se2018.homework.hwk2;


import org.junit.jupiter.api.Test;

class raceTest2 {

	@Test
	// basic tie test
	void test() {
		race Test1 = new race();
		Test1.addHorse("Mike",25,"EarlySprinter");
		Test1.addHorse("Sam",25,"EarlySprinter");
		Test1.addHorse("Molly",25,"EarlySprinter");
		
		Test1.runRace();
	}
}

