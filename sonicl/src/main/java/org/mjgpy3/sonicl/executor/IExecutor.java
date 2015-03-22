package org.mjgpy3.sonicl.executor;

import org.mjgpy3.sonicl.environment.IEnvironment;
import org.mjgpy3.sonicl.value.SlValue;

public interface IExecutor {

	public SlValue executeUnderEnv(IEnvironment env);	
}
