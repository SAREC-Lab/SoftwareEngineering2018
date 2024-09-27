package edu.nd.se2018.homework.hwk1;

import java.util.*;

public class Question2 {

    public Question2() {
    }

    public String getMostFrequentWord(String input, String stopwords) {
        String[] strs = input.split(" ");
        Set<String> stopwordsArray = new HashSet(Arrays.asList(stopwords.split(" ")));
        Map<String, Integer> wordCount = new HashMap<>();


        for (int i = 0; i < strs.length; i++) {
            if (stopwordsArray.contains(strs[i])) {

            } else {
                if (wordCount.containsKey(strs[i])) {
                    wordCount.put(strs[i], wordCount.get(strs[i])+1);
                } else {
                    wordCount.put(strs[i], 1);
                }
            }
        }
        Collection c = wordCount.keySet();
        Iterator<String> itr = c.iterator();
        int biggest = 0;
        String res = null;
        int second = 0;
        while (itr.hasNext()) {
            String word = itr.next();
            if (wordCount.get(word) >= biggest) {
                second = biggest;
                biggest = wordCount.get(word);
                res = word;
            }


        }
        if (biggest == second) {
            return null;
        }
        return res;
    }
}
