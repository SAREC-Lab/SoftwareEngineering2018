package edu.nd.se2018.homework.hwk2;

public class EarlySprintStrategy implements HorseBehavior {

	@Override
	public void performRace(Horse horse) {
		horse.mins++;
		if (horse.currMiles > 2) { 
			horse.currMiles = (horse.initSpeed * 0.75 / 60) * horse.mins;

		} else {
			horse.currMiles = (horse.initSpeed / 60) * horse.mins;
		}
	}

}
