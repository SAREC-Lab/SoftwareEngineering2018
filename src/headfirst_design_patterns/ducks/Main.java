package headfirst_design_patterns.ducks;

import horse_race_hwk2.Race;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Race race1 = new Race();
		race1.enrollHorse("Jimmy", 43, "steady");
		race1.enrollHorse("Klien", 46, "slow");
		race1.enrollHorse("Dabo", 45, "early");
		race1.enrollHorse("Sheen", 42, "slow");
		race1.enrollHorse("Biscuit", 41, "steady");
		race1.startRace();
	}

}
