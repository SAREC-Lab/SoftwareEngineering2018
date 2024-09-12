package edu.nd.se2018.homework.hwk2;
import java.util.HashMap;
import java.lang.*;
import java.text.DecimalFormat;

public class Race
{
	public Race(){}
	private int totalHorses = 0;
	private HashMap<String, Double> distanceRan = new HashMap<String, Double>();
	private HashMap<String, Horse> Horses = new HashMap<String, Horse>();
	
	
	public void addHorse(String name, int maxSpeed, String Strategy)
	{
		if (this.totalHorses < 5)
		{
			if (maxSpeed == 0)
			{
				System.out.println(name + " doesn\'t want to run!");
				return;
			}
			else if (maxSpeed <= 0)
			{
				System.out.println(name + " is running backwards off the track!");
				return;
			}
			Horse newHorse = new Horse(name, maxSpeed);
			if (Strategy.equals("EarlySprinter"))
			{
				EarlySprinter horseStrategy = new EarlySprinter();
				newHorse.setStrategy(horseStrategy);
			}
			else if (Strategy.equals("SteadyRunner"))
			{
				SteadyRunner horseStrategy = new SteadyRunner();
				newHorse.setStrategy(horseStrategy);
			}
			else if (Strategy.equals("SlowStarter"))
			{
				SlowStarter horseStrategy = new SlowStarter();
				newHorse.setStrategy(horseStrategy);
			}
			this.totalHorses += 1;
			distanceRan.put(newHorse.getName(), 0.0);
			Horses.put(newHorse.getName(), newHorse);
		}
	}
	
	public void runRace()
	{
		int seconds = 1;
		boolean finished = false;
		boolean tie = false;
		String winner = "";
		
		
		while (!finished)
		{
			for (String horse: Horses.keySet())
			{
				int lapCounter = (int)Math.floor(distanceRan.get(horse));
				double newDistance = distanceRan.get(horse) + Horses.get(horse).run(lapCounter);
				distanceRan.put(horse, newDistance);
				
				if (newDistance >= 10)
				{
					if (finished || tie)
					{
						winner = winner + " and " + Horses.get(horse).getName();
						tie = true;
					}
					else
						winner = Horses.get(horse).getName();
					finished = true;
				}	
			}
			
			if ((seconds % 150) == 0)
			{
				for (String horse: Horses.keySet())
				{
					String output = new DecimalFormat("#.##").format(distanceRan.get(horse));
					System.out.println(horse + " has run " + output + " miles");
				}
					
			}
			seconds += 1;
		}
		
		if (tie)
			System.out.println("It's a tie! " + winner + " are the winners!");
		else
			System.out.println(winner + " is the winner!");
	}
}