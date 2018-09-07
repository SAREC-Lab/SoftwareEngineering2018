package edu.nd.se2018.homework.hwk2;

public class Main {

	public static void main(String[] args) {
		Race race = new Race();
		race.enrollHorse(new SteadyRun(), "Joe", 1, 0, 1);
		race.enrollHorse(new EarlySprint(), "Mary", 2, 0, 1);
		race.enrollHorse(new SlowStart(), "Spirit", 3, 0, 1);
		race.enrollHorse(new EarlySprint(), "DingDing", 4, 0, 1);
		race.enrollHorse(new SlowStart(), "Kelly", 5, 0, 1);
		race.run();

	}
}
