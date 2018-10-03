package edu.nd.se2018.examples;

public class BasisExample {
	
	@SuppressWarnings("unused")

	private void delElement (int value, int[] array) {
		int arraySize = array.length;
		int j;
		int location = arraySize + 1; 

		for (j = 0; j < arraySize; j++){
		     if ( array[j] == value )
		          location = j;
		 }

		for (j = location; j< arraySize; j++){
		      array[j] = array[j+1];
		}
		arraySize --;
	} 

	
	
	public static void main(String[] args) {
		new BasisExample();

	}

}
