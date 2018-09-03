package edu.nd.se2018.homework.hwk1;

import java.util.HashMap;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords)
	{
		// get array of words and stop words for easier manipulation
		String[] inputWordsArray = input.split(" ");
		String[] stopWordsArray = stopwords.split(" ");
		
		// init a map for recording the frequence of each word
		HashMap<String, Integer> wordFreq = new HashMap<>();
		
		// count word frequencies
		for(int i=0; i<inputWordsArray.length; i++)
		{
			String str = inputWordsArray[i];
			boolean skip = false;
			for(String stopWord : stopWordsArray)
			{
				if(str.equals(stopWord))
				{
					skip = true;
					break;
				}
			}
			if(skip)
				continue;
			
			if(wordFreq.get(str) == null)
				wordFreq.put(str, 0);
			wordFreq.put(str, wordFreq.get(str)+1);
		}
		
		// evaluate most frequent word
		int maxFreq = 0;
		String mostFrequentWord = "";
		for(String key : wordFreq.keySet())
		{
			if(wordFreq.get(key) > maxFreq)
			{
				maxFreq = wordFreq.get(key);
				mostFrequentWord = key;
			}
			else if(wordFreq.get(key) == maxFreq)
				mostFrequentWord = null;
		}
		
		return mostFrequentWord;
	}
}
