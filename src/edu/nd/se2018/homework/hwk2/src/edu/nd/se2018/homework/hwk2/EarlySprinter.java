package src.edu.nd.se2018.homework.hwk2;

public class EarlySprinter implements strategy {
	@Override
	public int moveForward(int pos, int maxSpeed) {
		int delta = 0;
		if(pos < 200) {
			delta = maxSpeed;
			
		} else {
			delta = (int) ((int) maxSpeed * 0.75);

		}

		System.out.println(pos + " " + delta +" ES ");
		return delta;
	}

}
