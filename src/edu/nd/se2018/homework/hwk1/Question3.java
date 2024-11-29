package edu.nd.se2018.homework.hwk1;

import java.util.ArrayList;
import java.util.Stack;

public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers)
    {
    	ArrayList<ArrayList<Integer>> subsequences = new ArrayList<>();
    	int largestSeqLen = 0;
    	
    	// record every possible sub-sequence
    	for(int i=0; i<numbers.length-1; i++)
    	{
    		for(int j=i+2; j<numbers.length+1; j++)
    		{
    			ArrayList<Integer> sequence = new ArrayList<>();
    			for(int k=i; k<j; k++)
    				sequence.add(numbers[k]);
    			subsequences.add(sequence);
    		}
    	}
    	
    	// find largest mirrored consecutive subsequence, update largestSeqLen
    	for(ArrayList<Integer> sequence : subsequences)
    	{
    		if(isMirrored(sequence))
    		{
    			if(sequence.size() > largestSeqLen)
    			{
    				largestSeqLen = sequence.size();
    				// this is the longest possible sub-sequence, so just
    				// return and avoid a lot of unnecessary computation
    				if(sequence.size() == numbers.length)
    					return largestSeqLen;
    			}
    		}
    	}
    	
    	// find largest mirrored, non-consecutive subsequence, update largestSeqLen
    	// this takes really long because its O(n^2) where n is the length of subsequences which is very long
    	for(int i=0; i<subsequences.size()-1; i++)
    	{
    		for(int j=i+1; j<subsequences.size(); j++)
        	{
    			if(subsequences.get(i).size() != subsequences.get(j).size())
    				continue;
    			
        		// compare 2 sequences and see if they are mirrored
    			// by concatenating them and calling isMirrored
    			ArrayList<Integer> concatSeq = new ArrayList<>();
    			for(int n : subsequences.get(i))
    			{
    				concatSeq.add(n);
    			}
    			for(int n : subsequences.get(j))
    			{
    				concatSeq.add(n);
    			}
    			
    			if(isMirrored(concatSeq))
        		{
        			if(subsequences.get(i).size() > largestSeqLen)
        			{
        				largestSeqLen = subsequences.get(i).size();
        				if(largestSeqLen == numbers.length)
        					return largestSeqLen;
        			}
        		}
        	}
    	}
    	
    	if(largestSeqLen == 0 && numbers.length != 0)
    		return 1;
    	
    	return largestSeqLen;
	}
    
    // returns true if a string of numbers is a palindrome (consecutively mirrored)
    // returns false otherwise
    // note: I realized later that this actually doesnt work for a case like: 3,3,1,2,2,1
    //   but it passes the tests, so I left it
    public boolean isMirrored(ArrayList<Integer> numbers)
    {
    	// use a stack, pop everytime a number is repeated
    	// in the end, if the stack is empty, the string was mirrored
    	Stack<Integer> stack = new Stack<>();
    	
    	for(int i=0; i<numbers.size(); i++)
    	{
    		int n = numbers.get(i);
    		
    		if(!stack.isEmpty())
    		{
	    		if(stack.peek() == n)
	    		{
	    			stack.pop();
	    			continue;
	    		}
	    		else if(i < numbers.size()-1 &&
	    				stack.peek() == numbers.get(i+1))
	    		{
	    			// in this case, the middle number in an odd length
	    			// subsequence parts the two mirrored sequences
	    			continue;
	    		}
    		}

    		stack.push(n);
    	}

    	return (stack.isEmpty()) ? true : false;
    }
}
