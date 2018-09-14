package edu.nd.se2018.homework.hwk1;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Question3 {

	public Question3(){}


	// by Roman
	// https://stackoverflow.com/questions/3940194/find-an-array-inside-another-larger-array#
	public int findArray(int[] largeArray, int[] subArray) {

        /* If any of the arrays is empty then not found */
        if (largeArray.length == 0 || subArray.length == 0) {
            return -1;
        }

        /* If subarray is larger than large array then not found */
        if (subArray.length > largeArray.length) {
            return -1;
        }

        for (int i = 0; i < largeArray.length; i++) {
            /* Check if the next element of large array is the same as the first element of subarray */
            if (largeArray[i] == subArray[0]) {

                boolean subArrayFound = true;
                for (int j = 0; j < subArray.length; j++) {
                    /* If outside of large array or elements not equal then leave the loop */
                    if (largeArray.length <= i+j || subArray[j] != largeArray[i+j]) {
                        subArrayFound = false;
                        break;
                    }
                }

                /* Sub array found - return its index */
                if (subArrayFound) {
                    return i;
                }

            }
        }

        /* Return default value */
        return -1;
    }

    public int getMirrorCount(int[] numbers){
    	// Get all subarrays
    	// Reverse the subarrays
    	// Pass them into function
    	int currMax = 0;
    	for(int beg = 0; beg < numbers.length; beg++) {
    		for(int end = beg; end < numbers.length; end++) {
    			// Subarray method: http://www.techiedelight.com/get-subarray-array-specified-indexes-java/
    			int[] subarray = new int[end - beg + 1];
    			//System.out.println("F");
    			System.arraycopy(numbers, beg, subarray, 0, subarray.length);
    			//System.out.println(Arrays.toString(subarray));
    			// Mirror: http://www.java67.com/2016/10/3-ways-to-reverse-array-in-java-coding-interview-question.html
    			for(int i = 0; i<subarray.length/2; i++) {
    				int temp = subarray[i];
    				subarray[i] = subarray[subarray.length - i -1];
    				subarray[subarray.length - i -1] = temp;
    			}
    			if(findArray(numbers, subarray) != -1) {
    				if(subarray.length > currMax)
    					currMax = subarray.length;
    			}
    		}
    	}
		return currMax;
	}
}
