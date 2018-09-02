package edu.nd.se2018.homework.hwk1;

import java.util.HashMap;
import java.util.Map;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		HashMap<String, Integer> stringMapping = new HashMap<>();
		
		for(String word : input.split(" ")) {
			if(!stopwords.contains(word)) {
				if(stringMapping.containsKey(word)) {
					stringMapping.put(word, stringMapping.get(word) + 1);
				} else {
					stringMapping.put(word, 1);
				}
			}
		}

		int max = 0;
		String maxWord = "";
		
		for(String word : stringMapping.keySet()) {
			int curr = stringMapping.get(word);
			if(curr > max) {
				maxWord = word;
				max = curr;
			} else if(curr == max) {
				maxWord = null;
			}
		}

		return maxWord;
	}
}
