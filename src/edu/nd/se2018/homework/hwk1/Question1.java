package edu.nd.se2018.homework.hwk1;

import java.util.Set;
import java.util.HashSet;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		Set<Integer> hashSetContains = new HashSet<>();
		int sum = 0;
		for(int i=0; i<numbers.length; i++) {
			if(hashSetContains.contains(numbers[i])) {
				continue;
			}
			else {
				hashSetContains.add(numbers[i]);
				sum += numbers[i];
			}
		}
		return sum;	
	}
}
