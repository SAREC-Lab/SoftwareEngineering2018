package design_patterns.horses;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Race race1 = new Race();
		race1.enrollHorse("Joe", 43, "steady");
		race1.enrollHorse("Kendall", 46, "slow");
		race1.enrollHorse("Fisher", 45, "early");
		race1.enrollHorse("Sharley", 42, "slow");
		race1.enrollHorse("Julius", 41, "steady");
		race1.startRace();
	}

}
