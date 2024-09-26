/*
 * Shane Johnson Homework 1 Question2
 * Outputing the most occurring word in a sentence
 */
package edu.nd.se2018.homework.hwk1;
import java.util.*;
import java.util.Map.Entry;
public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopWords){
		HashMap<String, Integer> map = new HashMap<>();
        String[] tokens1 = stopWords.split(" "); // splits the words
        HashSet<String> stopSet = new HashSet<>(Arrays.asList(tokens1));
        String[] tokens2 = input.split(" "); 

        for (String token: tokens2){
               if(!stopSet.contains(token)) {
                      if(map.containsKey(token)) {
                            int count = map.get(token);
                             map.put(token, count+1); 
                      } else {
                             map.put(token, 1);
                      }
               }
        } 

        Object[] numbers = map.values().toArray();  
        Arrays.sort(numbers);      
        if (numbers[numbers.length-1] == numbers[numbers.length-2]) {
               return null;
        }

        Map.Entry<String,Integer> temp = (Entry<String, Integer>) map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).findFirst().get();
       System.out.println(temp.getKey());

        return temp.getKey();
	}
}
