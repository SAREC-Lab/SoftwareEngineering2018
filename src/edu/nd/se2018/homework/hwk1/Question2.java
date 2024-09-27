package edu.nd.se2018.homework.hwk1;
import java.util.*;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		HashMap<String, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<String>();
		for (String stop : stopwords.split(" ")) {
			if (!set.contains(stop)) {
				set.add(stop);
			}
		}
		for (String word : input.split(" ")) {
			if (map.containsKey(word)) {
				Integer n = map.get(word);
				map.put(word, n + 1);
			}
			else {
				if (!set.contains(word)) {
					map.put(word, 1);
				}
			}
		}
		int max = 0;
		String word = "";
		Boolean duplicate = false;
		for (Map.Entry<String, Integer> w : map.entrySet()) {
			if (w.getValue() > max) {
				max = w.getValue();
				duplicate = false;
				word = w.getKey();
			}
			else if (w.getValue() == max) {
				duplicate = true;
			}	
		}
		if (duplicate == false) {
			return word;	
		}
		else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		String inputString2 = "giraffe elephant giraffe tiger tiger";
		String stopWords = "and a hes the of up but with";
		Question2 mostFrequentWord = new Question2();
		String result = mostFrequentWord.getMostFrequentWord(inputString2, stopWords);
		System.out.println("The answer is:" + result);
	}

}
