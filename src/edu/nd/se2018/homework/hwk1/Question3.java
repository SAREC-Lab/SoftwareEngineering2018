package edu.nd.se2018.homework.hwk1;
public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
		int front = 0;
		int back = numbers.length - 1;
		int mirrorCount = 0;
		
		while (front < numbers.length && back >= 0)
		{
			if (numbers[front] == numbers[back])
				mirrorCount++;
			
			front++;
			back--;
		}
		
		return mirrorCount;	
	}
}
