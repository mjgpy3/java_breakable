package org.mjgpy3.sonicl.executor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mjgpy3.sonicl.values.SlInteger;

public class SimpleEvaluationExecutorTest {

	private IExecutor executor;
	
	@Test
	public void a_number_executes_to_itself() {
		executor = new TextExecutor("42");
		
		SlInteger result = (SlInteger) executor.execute();

		assertEquals((Integer) 42, result.integerValue());
	}
}
