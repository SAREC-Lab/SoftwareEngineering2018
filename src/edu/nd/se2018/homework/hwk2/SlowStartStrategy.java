package edu.nd.se2018.homework.hwk2;

public class SlowStartStrategy implements HorseBehavior {

	@Override
	public void performRace(Horse horse) {
		horse.mins++;
		if (horse.currMiles <= 6) { 
			horse.currMiles = ((horse.initSpeed * 0.75) / 60) * horse.mins;
		} else if (horse.currMiles > 6 && horse.currMiles <= 9) {
			horse.currMiles = ((horse.initSpeed * 0.90) / 60) * horse.mins;
		} else {
			horse.currMiles = (horse.initSpeed / 60) * horse.mins;
		}
	}

}
