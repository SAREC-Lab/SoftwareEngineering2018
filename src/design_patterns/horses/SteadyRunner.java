package design_patterns.horses;

public class SteadyRunner extends Horse{

	public double speed;

	public SteadyRunner(String n, double s) {
		name = n;
		speed = s*.8;
	}

	@Override
	public void run() {
		if (position < 10) {
			position = position + speed*timeIncr;
		}else {
			finished = true;
		}
	}
	
	public void display() {
		if (!finished) {
			System.out.println(name + " has run " + position + " miles.");
		}else {
			System.out.println(name + " has finished.");
		}
	}

}
