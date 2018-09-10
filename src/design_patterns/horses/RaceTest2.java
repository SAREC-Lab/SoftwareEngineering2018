package design_patterns.horses;
import org.junit.Test;

public class RaceTest2 {
	@Test
	public void test() throws InterruptedException {
		Horse test1 = new SteadyRunner(null, 0);
		test1.run();
		Horse test2 = new SlowStarter(null, 0);
		test2.run();
		Horse test3 = new EarlySprinter(null, 0);
		test3.run();
	}	
}