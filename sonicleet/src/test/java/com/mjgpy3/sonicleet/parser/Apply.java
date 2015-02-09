package com.mjgpy3.sonicleet.parser;

import com.mjgpy3.sonicleet.ast.IAstNode;

public class Apply implements IAstNode {
	
	private String name;
	
	public Apply(String name) {
		this.name = name;
	}

	public String name() {
		return name;
	}

}
