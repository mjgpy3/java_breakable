package com.mjgpy3.sonicleet.tokenizer;

public class IntegerToken implements IToken {
	
	private String value;
	
	public IntegerToken(String value) {
		this.value = value;
	}

	public TokenType tokenType() {
		return TokenType.INTEGER;
	}

	public Integer length() {
		return value.length();
	}

	public String value() {
		return null;
	}

}
