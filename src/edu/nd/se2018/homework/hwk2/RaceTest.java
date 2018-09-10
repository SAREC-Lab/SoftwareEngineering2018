package edu.nd.se2018.homework.hwk2;

import edu.nd.se2018.homework.hwk2.types.*;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.nd.se2018.homework.hwk2.types.EarlySprint;
import edu.nd.se2018.homework.hwk2.types.SlowStart;
import edu.nd.se2018.homework.hwk2.types.Steady;

public class RaceTest {

	@Test
	public void test() {
		 Race race = new Race();
		 Race race2 = new Race();
		 Race race3 = new Race();
		 float min = (float) 0.5;
		 String winner;
		 //RaceBehavior steady = new Steady();
		 race.enrollHorse("Wolf Blitzer", 0, 20, new Steady());
		 race.enrollHorse("Do we have a picture of Paul McCartney?", 1, 22, new SlowStart());
		 race.enrollHorse("WW, my star, my perfect silence", 2, 25, new SlowStart());
		 winner = race.startRace(min);
		 System.out.println(winner);
		 assert(winner == "WW, my star, my perfect silence");

		 race2.enrollHorse("Darmani",0,20,new EarlySprint());
		 race2.enrollHorse("Majora",1,32,new SlowStart());
		 race2.enrollHorse("Anju",2,28,new EarlySprint());
		 race2.enrollHorse("Mikau",3,28,new EarlySprint());
		 race2.enrollHorse("Kafei",4,25,new Steady());
		 winner = race2.startRace(min);
		 assert(winner == "Majora");

		 System.out.println(winner);
		 race3.enrollHorse("Alyssa",0,50,new Steady());
		 race3.enrollHorse("James",1, (float) 50.7, new EarlySprint());
		 winner = race3.startRace(min);
		 assert(winner == "James");

		 System.out.println(winner);
	}

}
