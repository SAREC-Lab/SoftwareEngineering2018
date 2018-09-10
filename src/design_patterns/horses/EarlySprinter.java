package design_patterns.horses;


public class EarlySprinter extends Horse{
	
	public double speed;
	public double reducedSpeed;

	public EarlySprinter(String n, double s) {
		name = n;
		speed = s;
		reducedSpeed = s*.75;
	}
	
	@Override
	public void run() {
		if (position < 10) {
			if (position >= 2) {
				speed = reducedSpeed;
			}
			
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
