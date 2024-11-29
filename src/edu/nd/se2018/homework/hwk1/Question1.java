package edu.nd.se2018.homework.hwk1;

import java.util.HashSet;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		int sum = 0;
		HashSet<Integer> set = new HashSet<>();
		
		// go through every number recording the ones you see in a set
		// if you see a number again, don't add it to the sum, else, sum it
		for(int n : numbers)
		{
			if(!set.contains(n))
			{
				sum += n;
				set.add(n);
			}
		}
		return sum;
	}
}
