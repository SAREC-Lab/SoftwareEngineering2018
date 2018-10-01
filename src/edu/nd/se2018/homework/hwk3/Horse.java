package edu.nd.se2018.homework.hwk3;

public class Horse {

	private String name;
	private float maxSpeed; // miles per iteration
	private float distanceTravelled; // miles
	private RaceStrategy strategy;
	
	public Horse(String name, float maxSpeed, RaceStrategy rs)
	{
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.distanceTravelled = 0f;
		this.strategy = rs;
	}
	
	public void race()
	{
		float percentOfMaxSpeed = strategy.setMaxSpeedPercentage(distanceTravelled);
		float currentSpeed = maxSpeed*percentOfMaxSpeed;
		distanceTravelled += currentSpeed;
	}
	
	public boolean finishedRace()
	{
		return (distanceTravelled >= RaceSimulator.RACE_LENGTH_MILES) ? true : false;
	}
	
	public float getDistanceTravelled()
	{
		return distanceTravelled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
}
