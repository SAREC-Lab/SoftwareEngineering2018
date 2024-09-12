package edu.nd.se2018.homework.hwk2;

public class Horse
{
	private Strategy strategy;
	private String name;
	private double maxSpeed;
	
	public Horse(String Name, int speed)
	{
		this.maxSpeed = (double)speed/3600;
		this.name = Name;
	}
	
	public void setStrategy(Strategy Strategy)
	{
		this.strategy = Strategy;
	}
	
	public double run(int lapsRun)
	{
		return strategy.runLap(this.maxSpeed, lapsRun);
	}
	
	public String getName()
	{
		return this.name;
	}
}