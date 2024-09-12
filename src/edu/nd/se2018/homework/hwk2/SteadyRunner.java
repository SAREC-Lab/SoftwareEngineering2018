package edu.nd.se2018.homework.hwk2;

public class SteadyRunner implements Strategy
{
	@Override
	public double runLap(double maxSpeed, int lapsRun)
	{
		return (double)maxSpeed*.8;
	}
}