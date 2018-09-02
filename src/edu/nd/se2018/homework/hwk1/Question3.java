package edu.nd.se2018.homework.hwk1;

import java.util.Arrays;

public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
		int mirrorCount = 0;
		int length = numbers.length;
		int tempCount = 0;
		// function to reverse array
		// return reversed array
		int [] numbersReverse = reverse(Arrays.copyOf(numbers, length));
		
		// compare reversed with original
		// if same, then maxCount++
		for(int j = 0; j < length; j++) {
			if(numbers[j] == numbersReverse[j]) {
				tempCount++;
			} else {
				mirrorCount = (tempCount > mirrorCount) ? tempCount : mirrorCount;
				tempCount = 0;
			}
		}
//		for(int k = 0; k < length; k++) {
//			System.out.println(numbers[k]);
//		}
//		System.out.println("");
//		for(int k = 0; k < length; k++) {
//			System.out.println(numbersReverse[k]);
//		}
//		System.out.println("count: " + mirrorCount);
		
		mirrorCount = (tempCount > mirrorCount) ? tempCount : mirrorCount;
    	return mirrorCount;	
	}
    
    public int[] reverse(int[] arr) {
		for(int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
		return arr;
	}
}
