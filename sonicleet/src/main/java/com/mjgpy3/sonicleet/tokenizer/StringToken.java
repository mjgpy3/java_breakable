package com.mjgpy3.sonicleet.tokenizer;

public class StringToken implements IToken {
	
	private String value;

	public StringToken(String value) {
		this.value = value;
	}
	
	public TokenType tokenType() {
		return TokenType.STRING;
	}

	public Integer length() {
		return value.length();
	}

}