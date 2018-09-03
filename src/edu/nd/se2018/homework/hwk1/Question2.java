package edu.nd.se2018.homework.hwk1;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		String cleanedInput = new String();
		for (String word: input.split(" "))
		{
			boolean flagged = false;
			for (String cut: stopWords.split(" "))
			{
				if (word == cut) 
				{
					flagged = true;
					break;
				}
			}
			
			if (!flagged)
				cleanedInput = cleanedInput + word + " ";
		}
		
		HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
		
		for (String word: cleanedInput.split(" "))
		{
			if (!frequencies.containsKey(word)) 
				frequencies.put(word, 1);
			else
				frequencies.put(word, frequencies.get(word) + 1);
		}
		
		int max = 0;
		String mostFrequent = null;
		
		for (HashMap.Entry<String, Integer> item: frequencies.entrySet())
		{
			if (item.getValue() > max)
			{
				max = item.getValue();
				mostFrequent = item.getKey();
			}
			else if (item.getValue() == max)
				mostFrequent = null;
		}
		return mostFrequent;
	}
}
