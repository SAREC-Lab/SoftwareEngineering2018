package edu.nd.se2018.homework.hwk1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
		String[] inputWords = input.split(" ");
		String[] stopWordsArray = stopwords.split(" ");
		Set<String> stopWordsSet = new HashSet<String>(Arrays.asList(stopWordsArray));
		
		// Take out stop words
		for (String word : inputWords) {
			if (!stopWordsSet.contains(word)) {
				if (wordCount.containsKey(word)) {
					wordCount.put(word,  wordCount.get(word) + 1);
				}
				else {
					wordCount.put(word,  0);
				}
			}
		}
		
		String maxWord = "";
		int maxValue = 0;
		
		// Calculate most frequent word
		for (String word : wordCount.keySet()) {
			if (wordCount.get(word) > maxValue) {
				maxWord = word;
				maxValue = wordCount.get(word);
			}
			else if (wordCount.get(word) == maxValue) {
				maxWord = "";
			}
		}
		
		System.out.println(maxWord);
		if (maxWord == "") { return null; }
		return maxWord;
	}
}
