package edu.nd.se2018.homework.hwk1;
/**
 * Homework 2 Problem 2
 * @author Elijah hager
 *
 */

public class Question3 {
	
	public int getMirrorCount(int[] arr) {
		int[] reversedArr = mirrorArr(arr);
		
		return maxCount(arr, reversedArr);
	}
	
	private int[] mirrorArr(int[] arr) {
		int[] newArray = new int[arr.length];

		for (int i = arr.length-1, j = 0; i >= 0; i--, j++) {
			newArray[j] = arr[i];
		}
		
		return newArray;
	}
	
	private int maxCount(int[] forward, int[] reversed) {
		int maxCount = 0;
		int count = 0;

		for (int i = 0; i < forward.length; i++) {
			
			if (forward[i] == reversed[i]) {
				count++;
			}else {
				count = 0;
			}
			
			if (count > maxCount) {
				maxCount = count;
			}
			
		  }
		System.out.println(maxCount);
		return maxCount;
	}

}
