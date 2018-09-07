package edu.nd.se2018.homework.hwk2;

public class Race {
	/*public static Horse[] horseArray = new Horse[5];
	public static int count = 0;
	
	public void enrollHorse(RaceStrategy rs, String n, int num, double p, double ms) {
		horseArray[count] = new Horse(rs, n, num, p, ms);
		count = count + 1;
		
	}*/
	
	
	public Race() {
		Horse joe = new Horse(new SteadyRun(), "JoeTheHorse", 1, 0, 1);
		Horse mary = new Horse(new EarlySprint(), "MaryTheHorse", 2, 0, 1);
		for (int i = 0; i < 3; i++) {
			
			joe.run();
			joe.display();
		
			
			mary.run();
			mary.display();
		}
	}
	

}
