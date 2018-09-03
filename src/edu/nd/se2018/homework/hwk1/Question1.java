package edu.nd.se2018.homework.hwk1;

import java.util.HashSet;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] arr){
		int sum = 0 ;
		HashSet<Integer> h = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++) {
			if(h.contains(arr[i])) {
				break;
			}else {
				h.add(arr[i]);
				sum+=arr[i];
			}
		}
		return sum;
	}
}
