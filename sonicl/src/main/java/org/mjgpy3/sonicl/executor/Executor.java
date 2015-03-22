package org.mjgpy3.sonicl.executor;

import org.mjgpy3.sonicl.environment.IEnvironment;
import org.mjgpy3.sonicl.parser.IParser;
import org.mjgpy3.sonicl.values.SlInteger;
import org.mjgpy3.sonicl.values.SlValue;

public class Executor implements IExecutor {
	
	private IParser parser;

	public Executor(IParser parser) {
		this.parser = parser;
	}

	public SlValue executeUnderEnv(IEnvironment env) {
		return new SlInteger();
	}
}
