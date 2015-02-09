package com.mjgpy3.sonicleet.tokenizer.tokens;

public class DoubleToken implements IToken {
	
	private String value;
	
	public DoubleToken(String value) {
		this.value = value;
	}

	public TokenType tokenType() {
		return TokenType.DOUBLE;
	}

	public Integer length() {
		return value.length();
	}

	public String value() {
		return value;
	}

}
