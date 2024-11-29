package design_patterns.horses;



public class SlowStarter extends Horse{

	public double speed;
	public double nonReducedSpeed;
	public double reducedSpeed;
	public double reducedSpeed_2;

	public SlowStarter(String n, double s) {
		name = n;
		nonReducedSpeed = s;
		reducedSpeed = s*.90;
		reducedSpeed_2 = s*.75;
	}
	
	@Override
	public void run() {
		if (position < 10) {
			if (position <= 6) {
				speed = reducedSpeed_2;
			}else if (position > 6 && position < 9) {
				speed = reducedSpeed;
			}else {
				speed = nonReducedSpeed;
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
