package edu.nd.se2018.homework.hwk3;

public class RaceStrategy {
	
	public static int EARLY_SPRINT = 0;
	public static int STEADY_RUN = 1;
	public static int SLOW_START = 2;

	private int strategy;
	
	public RaceStrategy(int s)
	{
		this.strategy = s;
	}
	
	public float setMaxSpeedPercentage(float distanceTravelled)
	{
		float percentOfMaxSpeed = 0f;
		if(strategy == EARLY_SPRINT)
		{
			if(distanceTravelled <= (0.2f*RaceSimulator.RACE_LENGTH_MILES))
			{
				percentOfMaxSpeed = 1;
			}
			else
			{
				percentOfMaxSpeed = 0.75f;
			}
		}
		else if(strategy == STEADY_RUN)
		{
			percentOfMaxSpeed = 0.8f;
		}
		else if(strategy == SLOW_START)
		{
			if(distanceTravelled <= (0.6f*RaceSimulator.RACE_LENGTH_MILES))
			{
				percentOfMaxSpeed = 0.75f;
			}
			else if(distanceTravelled <= (0.9f*RaceSimulator.RACE_LENGTH_MILES))
			{
				percentOfMaxSpeed = 0.9f;
			}
			else
			{
				percentOfMaxSpeed = 0.1f;
			}
		}
		else
		{
			percentOfMaxSpeed = 1;
		}
		
		return percentOfMaxSpeed;
	}
}
