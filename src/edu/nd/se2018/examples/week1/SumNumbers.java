package edu.nd.se2018.examples.week1;

/**
 * This program sums all numbers from lowerNumber to upperNumber inclusive 
 * and returns the results.
 * 
 * @author Jane
 *
 */
public class SumNumbers {
	
	public SumNumbers(){}
	
	public int sumNumberRange(int lowerNumber, int upperNumber){
		int total = 0;
		for (int j = lowerNumber; j <= upperNumber; j++)
			total += j;
		return total;
	}

	public static void main(String[] args) {
		SumNumbers sumNumbers = new SumNumbers();
		int result = sumNumbers.sumNumberRange(3,5);
		System.out.println("The answer is:" + result);
	}

}
