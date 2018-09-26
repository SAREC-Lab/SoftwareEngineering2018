package hwk2;

public class SlowStartStrategy extends Horse{
	public double intspeed;
	public double nonslowSpeed;
	public double slowSpeed;
	public double slowerSpeed;

	public SlowStartStrategy(String n, double s) {
		name = n;
		nonslowSpeed = s;
		slowerSpeed = s*.75;
		slowSpeed = s*.90;
	}
	
	@Override
	public void run() {
		if (position < 10) {
			if (position <= 6) {
				intspeed = slowerSpeed;
			}else if (position > 6 && position < 9) {
				intspeed = slowSpeed;
			}else {
				intspeed = nonslowSpeed;
			}
			
			position = position + intspeed*timeIncr;
		}else {
			finished = true;
		}
	}
	
	public void display() {
		if (!finished) {
			System.out.println(name + " ran " + position + " miles.");
		}else {
			System.out.println(name + " finished.");
		}
		
	}

}
