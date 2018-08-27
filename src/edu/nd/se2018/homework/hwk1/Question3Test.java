package edu.nd.se2018.homework.hwk1;
import org.junit.Test;

public class Question3Test {
	@Test
	public void test() {
		Question3 question = new Question3();
		assert (question.getMirrorCount(new int[] {1,2,3,3,2,1}) ==6); 
		assert (question.getMirrorCount(new int[] {}) ==0);
		assert (question.getMirrorCount(new int[] {1,2,4,5,3,2,1}) ==2);
		assert (question.getMirrorCount(new int[] {1,2,3,4,3,2,1}) ==7);
		assert (question.getMirrorCount(new int[] {1,2,3,4,5}) ==1);		   
	}
}
