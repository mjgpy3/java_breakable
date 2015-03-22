package org.mjgpy3.sonicl.executor;

import static org.junit.Assert.assertEquals;
import static org.mjgpy3.sonicl.executor.SharedSetupForExecutorTests.executeText;

import org.junit.Test;
import org.mjgpy3.sonicl.value.SlInteger;

public class SimpleMathOperationsExecutorTest {

	@Test
	public void addition_works() {
		SlInteger result = (SlInteger) executeText("[+ 35 7]");
		
		assertEquals((Integer) 42, result.integerValue());
	}

}
