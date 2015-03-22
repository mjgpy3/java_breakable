package org.mjgpy3.sonicl.value;


public class SlString extends SlValue {

	private String value;

	public SlString(String value) {
		this.value = value;
	}
	
	public Object stringValue() {
		return value;
	}

}
