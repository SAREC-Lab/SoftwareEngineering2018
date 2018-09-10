package src.edu.nd.se2018.homework.hwk2;

public class horse {
	private String name;
	private int distanceTravelled;
	private int topSpeed;
	private strategy strat;
	
	
	public horse(String Name, int speed, strategy str) {
		this.name = Name;
		this.topSpeed = speed;
		this.strat = str;
	}
	public String getName() {
		return this.name;
	}
	public int run(int pos) {
		return this.strat.moveForward(this.distanceTravelled, topSpeed);
	}
	
}
