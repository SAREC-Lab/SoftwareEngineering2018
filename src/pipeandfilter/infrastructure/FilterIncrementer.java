package pipeandfilter.infrastructure;

public class FilterIncrementer extends Filter implements Runnable {

	Integer value;
	boolean stop = false;
	
	public FilterIncrementer() {
		value = 0;
	}
	
	@Override
	public void run() {
		while (true) {
			if (inPipe.hasNext()) {
				Integer tempvalue = inPipe.getNext();
		
				if (tempvalue<0) { // Stop condition
					System.out.println("Stopping: FilterIncrementer");
					outPipe.addItem(tempvalue); // pass stopping condition along pipeline
					break;
				}
				value = tempvalue;
				performOperation();
				busyWork();
				//System.out.println("Incrementer: " + value);
				outPipe.addItem(value);	
			}
		}		
	}

	@Override
	public void performOperation() {
		value+=1;	
	}

	@Override
	public Integer performOperation(Integer value) {
		busyWork();
		value = value+1;
		//System.out.println("Incrementer: " + value);
		return value;
	}
}
