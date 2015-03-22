package org.mjgpy3.sonicl.executor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mjgpy3.sonicl.environment.IEnvironment;
import org.mjgpy3.sonicl.values.SlInteger;

public class SimpleEvaluationExecutorTest {

	private IExecutor executor;
	
	private final IEnvironment emptyEnvironment = new IEnvironment() {
	};
	
	@Test
	public void a_number_executes_to_itself() {
		executor = new TextExecutor("42");
		
		SlInteger result = (SlInteger) executor.executeUnderEnv(emptyEnvironment);

		assertEquals((Integer) 42, result.integerValue());
	}
}
