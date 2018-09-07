package edu.nd.se2018.homework.hwk2;

public class Race {
	public  Horse[] horseArray = new Horse[5];
	public int count = 0;
	int miles = 10;
	boolean done = false;
	String winner = "";
	
	public void enrollHorse(RaceStrategy rs, String n, int num, double p, double ms) {
		this.horseArray[this.count] = new Horse(rs, n, num, p, ms);
		this.count = this.count + 1;
		
	}
	
	public Race() {}
	
	public void run() {
		while (!done) {
			for (int i = 0; i < this.count; i++ ) {
				this.horseArray[i].run();
				this.horseArray[i].display();
				if (this.horseArray[i].done()) {
					winner = this.horseArray[i].name;
					done = true;
				}
			}
		}
		System.out.println("The winner is: " + winner);
	}
	

}
