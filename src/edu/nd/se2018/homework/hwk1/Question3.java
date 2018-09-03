package edu.nd.se2018.homework.hwk1;

import java.util.*;

public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
    	Stack<Integer> reverse = new Stack<Integer>();
    	int breakInLine = 0; // boolean to help know if there was an interuption in the sym
    	int seqLength = 0; // keep record 
    	if(numbers.length ==0) { // if array doesn't have values then just push no sym
    		return 0;
    	}
    	int a;
    	for (a = 0; a < (numbers.length/2); a++) { // only need half for symmetry
    		reverse.push(numbers[a]); // push into stack for comparison to second half
    		//System.out.println(numbers[a]);
    	}
    	int b;
    	if(numbers.length%2 == 1) { // make sure the comparison to second half starts at the right point
    		// odd numbers
    		b = a + 1;
    	}else {
    		b = numbers.length/2;
    	}
    	while (!reverse.isEmpty()) { // run to the end of the first half
    		int comp = reverse.pop();
    		if(comp == numbers[b]) {
    			seqLength++;
    			
    		}
    		else {
    			breakInLine = 1;
    			seqLength = 0;
    			// we have ended the symmetry, reset back to 0
    		}
    		/*System.out.println(seqLength);
    		System.out.println("popped:" + comp);
    		System.out.println("b is:" + b);
    		System.out.println("compped to:" + numbers[b]);*/
    		b++;
    	}
    	if(breakInLine == 0) { // double the count if we made it through the hole first half without issue 
    		seqLength = seqLength *2;
    	}
    	//System.out.println(seqLength);
    	if(numbers.length%2 == 1 && (!reverse.isEmpty() || breakInLine == 0 || seqLength == 0)) {
    		seqLength++; // will need to add 1 if its odd, but only if no break, no sym, or not empty yet
    	}
    	//System.out.println(seqLength);
		return seqLength;	
	}
}
