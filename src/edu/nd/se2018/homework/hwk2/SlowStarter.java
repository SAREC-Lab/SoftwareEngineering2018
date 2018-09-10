package edu.nd.se2018.homework.hwk2;

public class SlowStarter implements Strategy
{
	@Override
	public double runLap(double maxSpeed, int lapsRun)
	{
		if (lapsRun < 5)
			return (double)maxSpeed*.6;
		else if (lapsRun < 9)
			return (double)maxSpeed*.9;
		else
			return (double)maxSpeed*1;
	}
}