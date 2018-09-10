package edu.nd.se2018.homework.hwk2;
import java.util.*;

public class Race {
	//ArrayList<Horse> horses = new ArrayList<Horse> ();
	ArrayList<Horse> horses;
	public Race() {
		//ArrayList<Horse> horses = new ArrayList<Horse> (); 
		// race.enrollHorse("Sam",0,22,new EarlySprintStrategy());
		//System.out.println(horses);
		horses = new ArrayList<Horse>();
	}
	
	public void enrollHorse(String name, int index, int maxSpeed, HorseBehavior horseBehavior) {
		horses.add(new Horse(name, index, maxSpeed, horseBehavior));
	}
	
	public String startRace() {
		String winMsg = "";
		double maxDistance = 0;
		double tempDistance;
		
		while (true) {
			
			for (Horse horse : horses) {
				horse.updateRace();
				horse.printCurrLoc();
			}

			String winHorse = "";
			for (Horse horse: horses) {
				tempDistance = horse.currMiles;
				if (tempDistance > maxDistance) {
					maxDistance = tempDistance;
					winHorse = horse.name;
				}
			}
			
			if (maxDistance >= 10.0) {
				winMsg = "Winner is " + winHorse;
				break;
			}
			
		}
		
		System.out.println(winMsg);
		return winMsg;
		
	}
}
