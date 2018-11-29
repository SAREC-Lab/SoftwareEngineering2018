package pipeandfilter.setup;

import pipeandfilter.infrastructure.EndFilter;
import pipeandfilter.infrastructure.Filter;
import pipeandfilter.infrastructure.FilterDoubler;
import pipeandfilter.infrastructure.FilterIncrementer;
import pipeandfilter.infrastructure.FilterReverseNumber;
import pipeandfilter.infrastructure.Pipe;

public class PipelineBuilder {
	
    private Filter filter, filter2, filter3, sink;
    private Pipe pipe1,pipe2,pipe3,pipe4;
	
	public PipelineBuilder() {}
	
	
	// Active pipeline
	public void buildActivePipeline() {
		
		// Create filters
		filter = new FilterIncrementer();
		filter2 = new FilterReverseNumber();
		filter3 = new FilterDoubler();
		sink = new EndFilter();
		
		// Create pipes
		pipe1 = new Pipe("Pipe1");
		pipe2 = new Pipe("Pipe2");
		pipe3 = new Pipe("Pipe3");
		pipe4 = new Pipe("Pipe4");
		
		// Connect everything
		filter.attachInQueue(pipe1);
		filter.attachOutQueue(pipe2);
		filter2.attachInQueue(pipe2);
		filter2.attachOutQueue(pipe3);
		filter3.attachInQueue(pipe3);
		filter3.attachOutQueue(pipe4);
		sink.attachInQueue(pipe4);
		
		
		// Start the threads
		(new Thread(filter)).start();
		(new Thread(filter2)).start();	
		(new Thread(filter3)).start();
		(new Thread(sink)).start();		
	}
	
	public void runActivePipeline() {
		long startTime = System.currentTimeMillis();
		((EndFilter)sink).setStartTime(startTime);
		Integer number = 0;
		while (number <= 200000) {
			pipe1.addItem(number++);
			//System.out.println(number);
		}
		pipe1.addItem(-1);		
	}
	
	
	// Passive pipeline
	public void buildPassivePipeline() {
		filter = new FilterIncrementer();
		filter2 = new FilterReverseNumber();
		filter3 = new FilterDoubler();
		sink = new EndFilter();
	}
	
	public void runPassivePipeline() {
		long startTime = System.currentTimeMillis();
		Integer number = 0;
		while (number <= 200000) {
			// Note this is hard to maintain!
			sink.performOperation(filter3.performOperation(filter2.performOperation(filter.performOperation(number++))));
			//System.out.println(number);
		}
		long elapsedTime = System.currentTimeMillis() - startTime;;
		System.out.println(elapsedTime);
		System.out.println("Answer: " + ((EndFilter)sink).getValue());
	}

	public static void main(String[] args) {
		boolean activePipeline = false;
		PipelineBuilder pb = new PipelineBuilder();
		if (activePipeline) {
			pb.buildActivePipeline();
			pb.runActivePipeline();
		}
		else {
			pb.buildPassivePipeline();
			pb.runPassivePipeline();
		}
	}

}
