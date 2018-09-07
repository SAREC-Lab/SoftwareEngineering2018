package edu.nd.se2018.homework.hwk1;
public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
    	if (numbers.length == 0) {
    		return 0;
    	}
    	int count = 0;
    	for (int i = 0; i < numbers.length; i++) {
    		int num = (numbers.length) - 1 - i;

    		if (numbers[i] == numbers[num]) {
    			count++;
    		}
    		else {
    			count = 0;
    		}
    	}
    	if (count == 0) {
    		return 1;
    	}
    	else {
    		return count;
    	}
	}
    
    public static void main(String[] args) {
		Question3 mirrorCount = new Question3();
		int result = mirrorCount.getMirrorCount(new int[] {1,2,3,4,5});
		System.out.println("The answer is:" + result);
	}
}
