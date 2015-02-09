package com.mjgpy3.sonicleet.tokenizer.tokens;

public class WordToken implements IToken {
	
	private String word;
	
	public WordToken(String word) {
		this.word = word;
	}
	
	public TokenType tokenType() {
		return TokenType.WORD;
	}

	public Integer length() {
		return word.length();
	}

	public String value() {
		return word;
	}
}
