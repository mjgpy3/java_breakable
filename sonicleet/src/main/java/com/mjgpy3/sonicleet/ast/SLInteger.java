package com.mjgpy3.sonicleet.ast;


public class SLInteger implements IAstNode {

	private String value;

	public SLInteger(String value) {
		this.value = value;
	}

	public Integer value() {
		return Integer.parseInt(value);
	}

}
