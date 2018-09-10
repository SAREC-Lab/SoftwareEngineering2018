package edu.nd.se2018.homework.hwk1;
import java.util.*;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		HashSet<Integer> holder = new HashSet<Integer>();
		for (int a = 0; a < numbers.length; a++) {
			holder.add(numbers[a]);
		}
		Iterator<Integer> it = holder.iterator();
		int sum = 0;
		while(it.hasNext()) {
			sum = sum + it.next();
		}
		//System.out.println(sum);
		return sum;
	}
}
