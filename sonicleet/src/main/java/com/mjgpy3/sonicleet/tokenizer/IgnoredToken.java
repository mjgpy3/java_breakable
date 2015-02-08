package com.mjgpy3.sonicleet.tokenizer;

public class IgnoredToken implements IToken {

	public TokenType tokenType() {
		return TokenType.IGNORED;
	}

	public Integer length() {
		return 1;
	}

}