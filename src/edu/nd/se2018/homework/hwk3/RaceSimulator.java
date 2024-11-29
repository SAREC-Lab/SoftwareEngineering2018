package edu.nd.se2018.homework.hwk3;

public class RaceSimulator {

	public static int RACE_LENGTH_MILES = 10; // miles
	public static int NUM_HORSES = 5;
	Horse[] horses;
	
	public RaceSimulator(Horse[] horses)
	{
		this.horses = horses;
		simulateRace();	
	}
	
	public void simulateRace()
	{
		boolean raceFinished = false;
		String winningHorse = null;
		
		while(raceFinished == false)
		{
			raceFinished = true;
			for(int i=0; i<NUM_HORSES; i++)
			{
				Horse horse = horses[i];
				horse.race();
				if(horse.finishedRace())
				{
					if(winningHorse == null)
						winningHorse = horse.getName();
				}
				else
				{
					System.out.print(horse.getName()+": ");
					System.out.printf("%.1f", horse.getDistanceTravelled());
					System.out.print(" miles  |  ");
				}
				
				raceFinished = raceFinished && horse.finishedRace();
			}
			System.out.println();
		}
		
		System.out.println(winningHorse+" won the race");
	}
}
