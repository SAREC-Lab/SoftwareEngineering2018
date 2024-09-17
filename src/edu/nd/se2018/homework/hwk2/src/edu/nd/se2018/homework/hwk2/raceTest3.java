package src.edu.nd.se2018.homework.hwk2;


import org.junit.jupiter.api.Test;

class raceTest3 {

	@Test
	// Speed controls test, race should continue, but not with the horse thats too slow in it
	void test() {
		race Test1 = new race();
		Test1.addHorse("Mike",20,"EarlySprinter");
		Test1.addHorse("Sam",25,"EarlySprinter");
		Test1.addHorse("Molly",1,"EarlySprinter");
		
		Test1.runRace();
	}
}
