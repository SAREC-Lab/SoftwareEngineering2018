package edu.nd.se2018.homework.hwk2;

public class Race {
	public static Horse[] horseArray = new Horse[5];
	public static int count = 0;
	int miles = 10;
	boolean done = false;
	String winner = "";
	
	public void enrollHorse(RaceStrategy rs, String n, int num, double p, double ms) {
		horseArray[count] = new Horse(rs, n, num, p, ms);
		count = count + 1;
		
	}
	
	public Race() {}
	
	public void run() {
		while (!done) {
			for (int i = 0; i < count; i++ ) {
				horseArray[i].run();
				horseArray[i].display();
				if (horseArray[i].done()) {
					winner = horseArray[i].name;
					done = true;
				}
			}
		}
		System.out.println("The winner is: " + winner);
	}
	

}
