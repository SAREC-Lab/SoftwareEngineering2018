package edu.nd.se2018.homework.hwk1;

import java.util.Stack;

public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
    	if (numbers.length == 0) {
    		System.out.println("0");
    		return 0;
    	}
    	int midPoint = numbers.length / 2;
    	int mirroredNum = (numbers.length % 2 == 1) ? 1 : 0;
    	int tempNum = (numbers.length % 2 == 1) ? 1 : 0;
    	boolean connected = true;
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	// pushing onto stack
    	for (int i = 0; i < midPoint; i++) {
    		stack.push(numbers[i]);
    	}
    	    	
    	// pop off of stack
    	for (int j = (numbers.length % 2 == 1) ? midPoint + 1 : midPoint; j < numbers.length; j++) {
    		if (numbers[j] == stack.pop()) {
    			tempNum += (connected) ? 2 : 1;
    			if (tempNum > mirroredNum) { mirroredNum = tempNum; }
    		}
    		else {
    			connected = false;
    			tempNum = 0;
    		}
    	}
    	
    	System.out.println(mirroredNum);
		return mirroredNum;	
	}
}
