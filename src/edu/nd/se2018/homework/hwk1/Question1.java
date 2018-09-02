package edu.nd.se2018.homework.hwk1;

import java.util.HashSet;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		HashSet<Integer> duplicates = new HashSet<Integer>();
		int sum = 0;
		for (int number : numbers) {
			if (!duplicates.contains(number)) {
				duplicates.add(number);
				sum += number;
			}
		}
		System.out.println("The answer is: " + sum);
		return sum;	
	}
	
}
