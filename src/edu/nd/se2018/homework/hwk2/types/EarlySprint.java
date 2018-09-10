package edu.nd.se2018.homework.hwk2.types;

import edu.nd.se2018.homework.hwk2.types.RaceBehavior;

public class EarlySprint implements RaceBehavior {

	@Override
	public float update(float min, float maxSpeed, float miles) {
		//System.out.println("I'm flying now");
		float incrementAmt;
		if(miles < 2) {
			incrementAmt = maxSpeed * (min/(float) 60.00);
		}
		else {
			incrementAmt = maxSpeed * (float) 0.75 * (min/(float) 60.00);
		}//float incrementAmt = maxSpeed * (min/(float) 60.00);
		float newMiles = miles + incrementAmt;
		return newMiles;
	}

}
