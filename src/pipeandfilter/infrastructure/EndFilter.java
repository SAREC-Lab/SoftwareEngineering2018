package pipeandfilter.infrastructure;

public class EndFilter extends Filter implements Runnable {

	Integer value;
	long startTime;
	boolean stop = false;
	
	public EndFilter() {
		value = 0;
	}
	
	@Override
	public void run() {
		while (true) {
			if (inPipe.hasNext()) {
				Integer tempvalue = inPipe.getNext();		
				if (tempvalue<0) { // Stop condition
					System.out.println("Stopping: EndFilter");
					long elapsedTime = System.currentTimeMillis()-startTime;
					System.out.println("Elapsed time: " + elapsedTime);
					System.out.println("Final answer: " + value);
					break;
				}	
				value = tempvalue;
				performOperation();	
			}
		}					
	}
	
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	@Override
	public void performOperation() {
		// No job.  Its the sink!
	}

	@Override
	public Integer performOperation(Integer oldValue) {		
		value = oldValue;
		return value;
	}
	
	public Integer getValue() {
		return value;
	}
}
