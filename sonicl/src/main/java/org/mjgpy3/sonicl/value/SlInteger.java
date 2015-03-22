package org.mjgpy3.sonicl.value;

public class SlInteger extends SlValue {
	
	private Integer value;

	public SlInteger(Integer value) {
		this.value = value;	
	}

	public Integer integerValue() {
		return value;
	}

}
