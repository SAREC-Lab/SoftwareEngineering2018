package horse_race_hwk2;
import org.junit.Test;

import design_patterns.horses.EarlySprinter;
import design_patterns.horses.Horse;
import design_patterns.horses.SlowStarter;
import design_patterns.horses.SteadyRunner;

public class RaceTest3 {
	@Test
	public void test() throws InterruptedException {
		Horse test1 = new SteadyRunner(null, 0);
		test1.display();
		Horse test2 = new SlowStarter(null, 0);
		test2.display();
		Horse test3 = new EarlySprinter(null, 0);
		test3.display();
	}	
}