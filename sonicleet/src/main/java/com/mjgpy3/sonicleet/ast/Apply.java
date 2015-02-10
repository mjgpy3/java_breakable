package com.mjgpy3.sonicleet.ast;

import java.util.ArrayList;
import java.util.Collection;

import com.mjgpy3.sonicleet.env.IEnvironment;

public class Apply implements IAstNode {
	
	private String name;
	private Collection<IAstNode> args;
	
	public Apply(String name) {
		this.name = name;
		args = new ArrayList<IAstNode>();
	}

	public String name() {
		return name;
	}

	public Collection<IAstNode> args() {
		return args;
	}

	public void addArg(IAstNode parse) {
		args.add(parse);
	}

	public IAstNode execute(IEnvironment env) {
		return null;
	}

}
