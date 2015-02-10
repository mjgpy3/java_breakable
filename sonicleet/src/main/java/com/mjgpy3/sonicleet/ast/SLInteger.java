package com.mjgpy3.sonicleet.ast;

import com.mjgpy3.sonicleet.env.IEnvironment;


public class SLInteger implements IAstNode {

	private String value;

	public SLInteger(String value) {
		this.value = value;
	}

	public Integer value() {
		return Integer.parseInt(value);
	}

	public void execute(IEnvironment env) {
		// TODO Auto-generated method stub
		
	}

}
