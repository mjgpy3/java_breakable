package org.mjgpy3.sonicl.executor;

import org.mjgpy3.sonicl.environment.IEnvironment;
import org.mjgpy3.sonicl.parser.IParser;
import org.mjgpy3.sonicl.parser.Parser;
import org.mjgpy3.sonicl.tokenizer.ITokenizer;
import org.mjgpy3.sonicl.tokenizer.RawStringTokenizer;
import org.mjgpy3.sonicl.value.SlValue;

public class SharedSetupForExecutorTests {
	
	public static SlValue executeText(String text) {
		ITokenizer tokenizer = new RawStringTokenizer(text);
		IParser parser = new Parser(tokenizer);
		IExecutor executor = new Executor(parser);
		
		IEnvironment emptyEnvironment = new IEnvironment() {
		};
		
		return executor.executeUnderEnv(emptyEnvironment);
	}
}
