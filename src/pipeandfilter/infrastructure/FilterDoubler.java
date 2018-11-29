package pipeandfilter.infrastructure;

public class FilterDoubler extends Filter implements Runnable {

	Integer value;
	boolean stop = false;
	
	public FilterDoubler() {
		value = 0;
	}
	
	@Override
	public void run() {
		while (true) {
			if (inPipe.hasNext()) {
				Integer tempvalue = inPipe.getNext();
		
				if (tempvalue<0) { // Stop condition
					System.out.println("Stopping: FilterTotaller");
					outPipe.addItem(tempvalue); // pass stopping condition along pipeline
					break;
				}
				value = tempvalue;
				performOperation();
				busyWork();
				//System.out.println("Doubler: " + value);
				outPipe.addItem(value);	
			}
		}		
	}

	@Override
	public void performOperation() {
		value = value*2;
	}

	@Override
	public Integer performOperation(Integer value) {
		value=value*2;
		busyWork();
		//System.out.println("Doubler: " + value);
		return value;
	}
}
