package edu.nd.se2018.homework.hwk1;
public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
		int front = 0;
		int back = numbers.length - 1;
		
		if (numbers.length == 0)
			return 0;
		
		int mirrorCount = 0;
		
		while (front < numbers.length && back >= 0)
		{
			if (numbers[front] == numbers[back])
				mirrorCount++;
			else
				break;
			
			front++;
			back--;
		}
		
		if (mirrorCount == 0)
			return 1;	
		else
			return mirrorCount;
	}
}
