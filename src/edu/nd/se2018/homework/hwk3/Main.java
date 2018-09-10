package edu.nd.se2018.homework.hwk3;

public class Main {
	
	public static void main(String[] args)
	{
		Horse[] horses = {
				new Horse("Brad", 0.1f, new RaceStrategy(RaceStrategy.EARLY_SPRINT)),
				new Horse("Chad", 0.1f, new RaceStrategy(RaceStrategy.SLOW_START)),
				new Horse("Jimmy", 0.1f, new RaceStrategy(RaceStrategy.STEADY_RUN)),
				new Horse("Daniel", 0.05f, new RaceStrategy(RaceStrategy.STEADY_RUN)),
				new Horse("Grant", 0.12f, new RaceStrategy(RaceStrategy.STEADY_RUN))};
		RaceSimulator sim = new RaceSimulator(horses);
	}

}
