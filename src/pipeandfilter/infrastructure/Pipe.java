package pipeandfilter.infrastructure;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Pipe {
	BlockingQueue<Integer> fifo;
	String pipeName;
	
	public Pipe(String pipeName) {
		fifo = new LinkedBlockingQueue<Integer>();
		this.pipeName = pipeName;
	}
	
	public void addItem(Integer item) {
		try {
			fifo.put(item);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean hasNext() {

		if (!fifo.isEmpty())
			return true;
		else
			return false;
	}
	
	
	public Integer getNext() {
		try {
			return fifo.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
