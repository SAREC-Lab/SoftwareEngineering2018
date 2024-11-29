package edu.nd.se2018.homework.hwk1;
/**
 * Homework 2 Problem 1
 * @author Elijah hager
 *
 */
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Iterator;

public class Question1 {

	public int getSumWithoutDuplicates(int[] arr) {
		HashSet<Integer> nums = IntStream.of(arr).boxed().collect(Collectors.toCollection(HashSet::new));
		
		int sum = 0;
		Iterator<Integer> it = nums.iterator();
	    while(it.hasNext()){
	        sum += it.next();
	    }
	    
	    System.out.println(sum);
		return sum;
	}
	
}