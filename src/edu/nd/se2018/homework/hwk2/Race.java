package edu.nd.se2018.homework.hwk2;

import edu.nd.se2018.homework.hwk2.types.*;
import java.util.ArrayList;
//import java.util.List;

/**
 * Creates the pond and adds ducks to it.
 * @author Janeh
 *
 */
public class Race {

	ArrayList<Horse> list = new ArrayList<Horse>();
	String winner = null;
	public void enrollHorse(String name, int num, float speed, RaceBehavior raceBehavior) {
		Horse newHorse = new Horse();
		newHorse.setName(name);
		newHorse.setNo(num);
		newHorse.setSpeed(speed);
		newHorse.setBehavior(raceBehavior);

		//System.out.println(newHorse.getName());

		this.list.add(newHorse);
		//Horse tempHorse = list.get(0);
		//System.out.println(tempHorse.getSpeed());
	}

	public String startRace(float min) {
		int numRacers = this.list.size();
		//float currMiles;
		String winner = null;
		float totalTime = 0;
		float currMaxMiles = -1;
		while(numRacers > 0) {
			for(int i = 0; i < this.list.size(); i++) {
				Horse tempHorse = list.get(i);
				if(tempHorse.getTimeFinished() >=0 ) {
					continue;
				}
				tempHorse.update(min);
				if(tempHorse.getTimeFinished() >=0 ) {
					if(currMaxMiles < tempHorse.getMiles()) {
						currMaxMiles = tempHorse.getMiles();
						winner = tempHorse.getName();
					}
					continue;
				}
				list.set(i, tempHorse);
				totalTime += min;
			}
			if(currMaxMiles > -1) {
				return winner;
			}
		}
		return winner;
	}

	public void announceWinner() {
		String message = "This race's winner is " + winner + "!";
		System.out.println(message);
	}
	/*public Pond(){
		Duck mallard = new Mallard();
		mallard.swim();
		mallard.fly();
		mallard.quack();

		Duck yellowDucky = new YellowDucky();
		yellowDucky.swim();
		yellowDucky.fly();
		yellowDucky.quack();
	}*/

}
