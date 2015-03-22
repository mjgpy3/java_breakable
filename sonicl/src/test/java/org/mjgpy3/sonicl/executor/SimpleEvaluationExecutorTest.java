package org.mjgpy3.sonicl.executor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mjgpy3.sonicl.environment.IEnvironment;
import org.mjgpy3.sonicl.parser.IParser;
import org.mjgpy3.sonicl.parser.Parser;
import org.mjgpy3.sonicl.tokenizer.ITokenizer;
import org.mjgpy3.sonicl.tokenizer.RawStringTokenizer;
import org.mjgpy3.sonicl.value.SlInteger;
import org.mjgpy3.sonicl.value.SlValue;

public class SimpleEvaluationExecutorTest {

	private SlValue executeText(String text) {
		ITokenizer tokenizer = new RawStringTokenizer(text);
		IParser parser = new Parser(tokenizer);
		IExecutor executor = new Executor(parser);
		
		IEnvironment emptyEnvironment = new IEnvironment() {
		};
		
		return executor.executeUnderEnv(emptyEnvironment);
	}
	
	@Test
	public void a_number_executes_to_itself() {
		SlInteger result = (SlInteger) executeText("42");

		assertEquals((Integer) 42, result.integerValue());
	}
}
