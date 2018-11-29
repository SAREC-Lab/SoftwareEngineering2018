package pipeandfilter.infrastructure;

public abstract class Filter implements Runnable{

	Pipe inPipe = null;
	Pipe outPipe = null;
		
	public void attachInQueue(Pipe pipe) {
		inPipe = pipe;		
	}

	public void attachOutQueue(Pipe pipe) {
		outPipe = pipe;		
	}
	
	protected Integer getNextItem() {
		return inPipe.getNext();
	}
	
	protected long busyWork() {
		long sum = 0;
		for(long i = 1; i < 100000; i++)
			sum = sum + i;
		return sum;
	}
	
	//Active pipe and filter
	protected abstract void performOperation();
	
	//Passive pipe and filter
	public abstract Integer performOperation(Integer value);
}
