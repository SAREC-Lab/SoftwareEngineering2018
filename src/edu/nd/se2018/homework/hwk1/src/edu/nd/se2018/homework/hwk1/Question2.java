package src.edu.nd.se2018.homework.hwk1;
import java.util.*;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		
		HashMap<String,Integer> freq = new HashMap <String,Integer>();
		// break up the input stings into usable arrays
		String[] words = input.split(" "); 
		String[] badwords = stopwords.split(" ");
		List<String> keys = new ArrayList<String>(); // use the list to keep track of valid words that were inserted
		for (int a = 0; a < words.length; a++) {
			if(!Arrays.asList(badwords).contains(words[a])) {
				//System.out.println(words[a]);
				Integer f = freq.get(words[a]);
				if (f == null) {
				    freq.put(words[a], 1);
				} else {
				    freq.put(words[a], f+1);
				}
				keys.add(words[a]); // add to the key once we have a valid pass
			}
		}
		int maxCount = 0;
		String maxWord = null;
		List<String> maxWords = new ArrayList<String>(); // keep track of what words have hit the max value
		for (int b = 0; b < keys.size(); b++) {
			int count = freq.get(keys.get(b)); // grab the freq from the map
			//System.out.println(keys.get(b));
			//System.out.println(count);
			if(count > maxCount) { // new max value
				maxWord = keys.get(b);
				maxCount = count;
			} else if(count == maxCount) {
				// this means we have tied for the max, and should check to see if more than 1 word shares the title
				System.out.println(keys.get(b));
				maxWords.add(keys.get(b));
			} else { 
				//System.out.println("less");
				maxWords.clear(); // if it resets clear the max list so it can refresh
				// we have a more frequent call no action
			}
			
		}
		if (maxWords.size() > 1) { // if there is more than 1 word at the max value for the list, then tie so return null
			return null;
		} else {
			return maxWord;
		}
	}
}
