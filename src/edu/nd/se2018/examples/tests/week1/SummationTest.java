package edu.nd.se2018.examples.tests.week1;

import org.junit.Test;
import edu.nd.se2018.examples.week1.SumNumbers;

public class SummationTest {

	@Test
	public void test() {
		SumNumbers sumNumbers = new SumNumbers();
		assert(sumNumbers.sumNumberRange(3, 5)==12);
		assert(sumNumbers.sumNumberRange(1,4)==10);
	}

}
