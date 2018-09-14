package edu.nd.se2018.homework.hwk1;

public class Question1 {

	public Question1(){}

	public int getSumWithoutDuplicates(int[] numbers){
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			int dup = 0;
			for (int x = 0; x < i; x++) {
				if(numbers[i] == numbers[x])
					dup = 1;
			}
			if(dup == 0)
				sum += numbers[i];
		}
		System.out.print((char) sum);
		return sum;
	}
}
