package src.edu.nd.se2018.homework.hwk2;

public class steadyRunner implements strategy{
	@Override
	public int moveForward(int pos, int maxSpeed) {
		
		int delta = 0;
		delta = (int) (maxSpeed * 0.8);
		//System.out.println(pos + " " + delta + " SR ");
		return delta;
	}

}
