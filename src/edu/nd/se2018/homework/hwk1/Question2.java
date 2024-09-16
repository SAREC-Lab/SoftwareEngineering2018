package edu.nd.se2018.homework.hwk1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Objects;

// https://stackoverflow.com/questions/15480811/for-loop-to-search-for-word-in-string
public class Question2 {

	public Question2(){}

	public String getMostFrequentWord(String input, String stopwords){
		Map<String, Integer> hmap = new HashMap<String, Integer>();
		int temp;

		for (String word1 : input.split(" ")) {
			int dup = 0;
			for (String stop : stopwords.split(" ")) {
				//System.out.println(stop);
				if (Objects.equals(stop, word1)) {
					//System.out.println(stop);
					dup = 1;
					break;
				}
			}
			if(dup == 0) {
				if(hmap.containsKey(word1)) {
					temp = hmap.get(word1);
					temp += 1;
			        hmap.put(word1, temp);
				}
				else {
					hmap.put(word1, 1);
					//System.out.println(word1);
				}
			}
		}

		int multipleMax = 0;
		String maxWord = null;
		//https://stackoverflow.com/questions/5911174/finding-key-associated-with-max-value-in-a-java-map
		int maxValueInMap = (Collections.max(hmap.values()));
		//System.out.println(maxValueInMap);
		for(Map.Entry<String, Integer> entry : hmap.entrySet()) {
			if (entry.getValue()==maxValueInMap) {
				if(multipleMax==1) {
					return null;
				}
				//System.out.println(entry.getKey());
				maxWord = entry.getKey();
				multipleMax = 1;
			}
		}
		//System.out.println(maxWord);
		return maxWord;
	}
}
