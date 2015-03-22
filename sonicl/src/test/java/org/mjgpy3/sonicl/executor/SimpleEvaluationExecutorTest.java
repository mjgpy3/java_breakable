package org.mjgpy3.sonicl.executor;

import static org.junit.Assert.assertEquals;
import static org.mjgpy3.sonicl.executor.SharedSetupForExecutorTests.executeText;

import org.junit.Test;
import org.mjgpy3.sonicl.value.SlInteger;

public class SimpleEvaluationExecutorTest {

	@Test
	public void a_number_executes_to_itself() {
		SlInteger result = (SlInteger) executeText("42");

		assertEquals((Integer) 42, result.integerValue());
	}

	@Test
	public void another_number_executes_to_itself() {
		SlInteger result = (SlInteger) executeText("20");

		assertEquals((Integer) 20, result.integerValue());
	}
}
