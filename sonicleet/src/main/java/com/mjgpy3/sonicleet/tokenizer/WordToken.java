package com.mjgpy3.sonicleet.tokenizer;

public class WordToken implements IToken {
	public TokenType tokenType() {
		return TokenType.WORD;
	}

	public Integer length() {
		return null;
	}
}
