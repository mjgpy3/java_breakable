package com.mjgpy3.sonicleet.tokenizer.tokens;

public class IgnoredToken implements IToken {

	public TokenType tokenType() {
		return TokenType.IGNORED;
	}

	public Integer length() {
		return 1;
	}

	public String value() {
		return null;
	}

}