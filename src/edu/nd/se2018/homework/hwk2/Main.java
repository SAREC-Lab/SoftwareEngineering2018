package edu.nd.se2018.homework.hwk2;

public class Main 
{
	
	public static void main(String args[])
	{
		Race race = new Race();
		
		race.addHorse("Equestrian 1", 20, "EarlySprinter");
		race.addHorse("Equestrian 2", 20, "SteadyRunner");
		race.addHorse("Equestrian 3", 22, "SlowStarter");
		
		race.runRace();
	}
}