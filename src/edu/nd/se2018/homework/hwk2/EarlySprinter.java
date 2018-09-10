package edu.nd.se2018.homework.hwk2;

public class EarlySprinter implements Strategy
{
	@Override
	public double runLap(double maxSpeed, int lapsRun)
	{
		if (lapsRun < 2)
			return (double)maxSpeed;
		else
			return (double)maxSpeed*.75;
	}
}