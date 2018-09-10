package src.edu.nd.se2018.homework.hwk2;

public class EarlySprinter implements strategy {
	public int moveForward(int pos, int maxSpeed) {
		int nextSpot = 0;
		int delta = 0;
		if(pos < 200) {
			delta = maxSpeed;
			nextSpot = delta + pos;
		} else {
			delta = (int) ((int) maxSpeed * 0.75);
			nextSpot = delta + pos;
		}
		delta = (int) (maxSpeed * 0.8);
		nextSpot = pos + delta;
		return nextSpot;
	}

}
