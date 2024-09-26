package edu.nd.se2018.homework.hwk1;

public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
    	int[] mirroredArr = mirror(numbers); 
        return maxCount(numbers, mirroredArr);
	}
    
    private int[] mirror(int[] arr) { //flips the original array to find any mirror
        int[] newArray = new int[arr.length];

        for (int i = arr.length-1, j = 0; i >= 0; i--, j++) {
               newArray[j] = arr[i];
        }
        
        return newArray;
    }
    
    private int maxCount(int[] original, int[] mirrored) { //finds the most mirrored numbers
        int maxCount = 0;
        int count = 0;

        for (int i = 0; i < original.length; i++) {             
               if (original[i] == mirrored[i]) {
                      count++;
               }else {
                      count = 0;
               }

               if (count > maxCount) {
                      maxCount = count;
               }
          }
         System.out.println(maxCount);
        return maxCount;

  }
}
