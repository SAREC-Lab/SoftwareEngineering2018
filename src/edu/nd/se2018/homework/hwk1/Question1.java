package edu.nd.se2018.homework.hwk1;

import java.util.HashSet;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		int sum = 0;
		HashSet<Integer> checked = new HashSet<Integer>();

		for (int x = 0; x < numbers.length; x++)
		{
			if (checked.add(numbers[x]))
				sum += numbers[x];
		}
		
		return sum;
	}
}
