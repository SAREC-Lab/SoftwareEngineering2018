package edu.nd.se2018.homework.hwk1;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		int sum = 0;
		int[] checked = new int[arr.length];

		for (int x = 0; x < arr.length; x++)
		{
			if (arr[x] != 0)
			{
				int checkCount = 0;
				boolean flagged = false;
				while (checkCount != arr.length && checked[x] != 0) 
				{
					if (checked[checkCount] == arr[x]) 
					{
						flagged = true;
						break;
					}
					
					checkCount++;
				}
				
				if (flagged == false)
					sum += arr[x];
			}
		}
		
		return sum;
	}
}
