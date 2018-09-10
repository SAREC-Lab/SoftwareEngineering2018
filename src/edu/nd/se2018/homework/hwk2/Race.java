package edu.nd.se2018.homework.hwk2;

import java.util.HashMap;

public class Race {
	
	// Data members
	public Horse[] horses = new Horse[5];
	public HashMap<String, Double> distances = new HashMap<String, Double>();
	public double raceDistance = 10.0;
	public int horsesInRace = 0;
	
	// Constructor
	public Race() {};
	
	// Methods
	public void addHorse(Horse horse) {
		horses[horsesInRace] = horse;
		horsesInRace++;
		distances.put(horse.name, 0.0);
	}
	
	public void announceLeader(Horse horse) {
		System.out.println("In the lead: " + horse.name);
	}
	
	public void announceWinner(Horse horse) {
		System.out.println("The winner is: " + horse.name + "!!");
	}
	
	public String runRace() {
		
		boolean raceContinue = true;
		double maxDistance = 0;
		Horse winningHorse = horses[0];
		
		while (raceContinue) {
				
			for (Horse horse : horses) {
				distances.put(horse.name, distances.get(horse.name) +
						horse.strategy.move(horse.maxSpeed, distances.get(horse.name)));
			}
									
			for (Horse horse : horses) {
				if (distances.get(horse.name) > maxDistance) {
					winningHorse = horse;
					maxDistance = distances.get(horse.name);
				}
			}
			
			if (maxDistance >= raceDistance) {
				announceWinner(winningHorse);
				raceContinue = false;
				
			}
			else {
				announceLeader(winningHorse);
			}
			
		}
		
		return winningHorse.name;
		
	}
	
	public String startRace() {
		return runRace();
	}
	
}
