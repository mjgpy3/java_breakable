package com.mjgpy3.sonicleet.ast;

import com.mjgpy3.sonicleet.env.IEnvironment;

public interface IAstNode {
	
	public IAstNode execute(IEnvironment env);

}
