package pipeandfilter.infrastructure;

public class FilterReverseNumber extends Filter implements Runnable {

	Integer value;
	boolean stop = false;
	
	public FilterReverseNumber() {
		value = 0;
	}
	
	@Override
	public void run() {
		while (true) {
			if (inPipe.hasNext()) {
				Integer tempvalue = inPipe.getNext();
		
				if (tempvalue<0) { // Stop condition
					System.out.println("Stopping: FilterReverseNumber");
					outPipe.addItem(tempvalue);
					break;
				}
				value = tempvalue;
				performOperation();
				busyWork();
				//System.out.println("Reverser: " + value);
				outPipe.addItem(value);
			}
		}			
	}

	@Override
	public void performOperation() {
		String tempString = (Integer.toString(value));
		tempString = reverseString(Integer.toString(value));
		value = Integer.parseInt(tempString);
	}
	
	private String reverseString(String str) {
		byte [] strAsByteArray = str.getBytes(); 
		  
        byte [] result =  
                   new byte [strAsByteArray.length]; 
  
        // Store result in reverse order into the 
        // result byte[] 
        for (int i = 0; i<strAsByteArray.length; i++) 
            result[i] =  
             strAsByteArray[strAsByteArray.length-i-1]; 
  
       return (new String(result)); 
	}

	@Override
	public Integer performOperation(Integer value) {
		String tempString = (Integer.toString(value));
		tempString = reverseString(Integer.toString(value));
		value = Integer.parseInt(tempString);
		busyWork();
		//System.out.println("Reverser: " + value);
		return value;
	}
	
	
}
