package com.mjgpy3.sonicleet.tokenizer;

public class MultiSymbolToken implements IToken {

	private TokenType type;
	private String value;

	public MultiSymbolToken(TokenType type, String value) {
		this.type = type;
		this.value = value;
	}

	public TokenType tokenType() {
		return type;
	}

	public Integer length() {
		return value.length();
	}

	public String value() {
		return null;
	}

}
