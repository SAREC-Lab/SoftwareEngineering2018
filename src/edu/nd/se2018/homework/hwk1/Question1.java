package edu.nd.se2018.homework.hwk1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		int total = 0;
		Set<Integer> hashSet = new HashSet();
		for(int i=0; i<numbers.length; i++){
			hashSet.add(numbers[i]);
		}
		for(int i:hashSet){
			total += i;
		}
		return total;
	}
	/*
	public static void main(String[] args){
		int[] numbers= {1,2,3,2};
		Question1 question1 = new Question1();
		int res = question1.getSumWithoutDuplicates(numbers);
		System.out.println(res);

	}*/
}
