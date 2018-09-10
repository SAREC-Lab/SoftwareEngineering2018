package src.edu.nd.se2018.homework.hwk2;

public class horse {
	private String name;
	private int distanceTravelled;
	private int topSpeed;
	private strategy strat;
	
	
	public horse(String Name, int speed, String str) {
		this.name = Name;
		this.topSpeed = speed;
		setStrategy(str);
	}
	public void setStrategy(String str1) {  //switch statement to change strategy
		switch(str1) {
		case "slowStarter":
			System.out.println("1");
			strat = new slowStarter();
			break;
		case "EarlySprinter":
			System.out.println("2");
			strat = new EarlySprinter();
			break;
		case "steadyRunner":
			System.out.println("3");
			strat = new steadyRunner();
			break;
		default:
			System.out.println("4");
			strat = new steadyRunner();
			break;
		}
	}
	public String getName() {
		return this.name;
	}
	public int getD() {
		return this.distanceTravelled;
	}
	public int run() {
		int jump = this.strat.moveForward(this.distanceTravelled, topSpeed);
		System.out.println(jump + "this the the jump up");
		distanceTravelled += jump;
		return distanceTravelled;
	}
	
}
