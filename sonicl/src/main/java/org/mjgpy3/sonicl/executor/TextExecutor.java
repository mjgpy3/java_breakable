package org.mjgpy3.sonicl.executor;

import org.mjgpy3.sonicl.environment.IEnvironment;
import org.mjgpy3.sonicl.values.SlInteger;
import org.mjgpy3.sonicl.values.SlValue;

public class TextExecutor implements IExecutor {
	
	private String code;

	public TextExecutor(String codeToExecute) {
		code = codeToExecute;
	}

	public SlValue executeUnderEnv(IEnvironment env) {
		return new SlInteger();
	}
}
