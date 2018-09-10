package edu.nd.se2018.homework.hwk2;

public class SteadyRunStrategy implements HorseBehavior {

	@Override
	public void performRace(Horse horse) {
		horse.mins++;
		horse.currMiles = ((horse.initSpeed * 0.80) / 60) * horse.mins;
	}

}
