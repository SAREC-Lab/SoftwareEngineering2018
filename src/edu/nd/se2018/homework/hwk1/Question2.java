package edu.nd.se2018.homework.hwk1;
/**
 * Homework 2 Problem 2
 * @author Elijah hager
 *
 */
import java.util.*;
import java.util.Map.Entry;

public class Question2 {

	public Object getMostFrequentWord(String inputString, String stopWords) {
		HashMap<String, Integer> map = new HashMap<>();
		
		String[] tokens1 = stopWords.split(" "); // split by space
		HashSet<String> stopSet = new HashSet<>(Arrays.asList(tokens1));
		
		String[] tokens2 = inputString.split(" "); // split by space
		
		for (String token: tokens2){
			if(!stopSet.contains(token)) {
				if(map.containsKey(token)) {
					int count = map.get(token);
					map.put(token, count+1); // increment word count
				} else {
					map.put(token, 1);
				}
			}
		}
	
		Object[] numbers = map.values().toArray();  // turn map values into sorted array to check last two values
		Arrays.sort(numbers);	
		if (numbers[numbers.length-1] == numbers[numbers.length-2]) { // check last two numbers
			return null;
		}
		
		Map.Entry<String,Integer> temp = (Entry<String, Integer>) map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).findFirst().get();
		System.out.println(temp.getKey());
		
		return temp.getKey();
	}
}