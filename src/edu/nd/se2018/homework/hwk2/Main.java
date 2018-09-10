package edu.nd.se2018.homework.hwk2;
import edu.nd.se2018.homework.hwk2.types.*;
// All races 10 miles long
public class Main {

	public static void main(String[] args) {
		 Race race = new Race();
		 float min = (float) 0.5;
		 //RaceBehavior steady = new Steady();
		 /*race.enrollHorse("Wolf Blitzer", 0, 20, steady);
		 race.enrollHorse("Toby", 1, 70, steady);
		 race.enrollHorse("WWW", 2, 70, steady);
		 String winner = race.startRace(min);*/

		 /*race.enrollHorse("Sam",0,22,new EarlySprint());
		 race.enrollHorse("Molly",1,24,new SlowStart());
		 race.enrollHorse("Joe",2,25,new EarlySprint());
		 race.enrollHorse("Blizzard",3,25,new SlowStart());
		 race.enrollHorse("Flicker",4,25,new Steady());
		*/
		 race.enrollHorse("Sam",0,100,new EarlySprint());
		 race.enrollHorse("Molly",1,100,new SlowStart());
		 String winner = race.startRace(min);
		 System.out.println(winner);
	}

}
