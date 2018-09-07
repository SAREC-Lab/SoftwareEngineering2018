package edu.nd.se2018.homework.hwk1;
import java.util.*;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		int total = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (!set.contains(numbers[i])) {
				set.add(numbers[i]);
				total += numbers[i];
			}
			
		}
		return total;
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 3, 5, 5, 2};
		Question1 getSum = new Question1();
		int result = getSum.getSumWithoutDuplicates(nums);
		System.out.println("The answer is:" + result);
	}
}
