package edu.nd.se2018.homework.hwk1;

import java.util.HashMap;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
		int max = 0;
		String mostFrequent = null;
		
		for (String word: input.split(" "))
		{
			if (!frequencies.containsKey(word))
				frequencies.put(word, 1);
			else
				frequencies.put(word, frequencies.get(word) + 1);
		}
		
		for (String stopWord: stopwords.split(" "))
		{
			for (String word: frequencies.keySet())
			{
				if (word.equals(stopWord) && frequencies.get(word) != 0)
				{
					frequencies.put(word, 0);
					break;
				}
			}
		}
		
		for (String word: frequencies.keySet())
		{
			if (frequencies.get(word) > max)
			{
				max = frequencies.get(word);
				mostFrequent = word;
			}
			else if (frequencies.get(word) == max)
				mostFrequent = null;
		}
		
		return mostFrequent;
	}
}
