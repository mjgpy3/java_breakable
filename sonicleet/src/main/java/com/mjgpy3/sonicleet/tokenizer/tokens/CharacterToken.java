package com.mjgpy3.sonicleet.tokenizer.tokens;

public class CharacterToken implements IToken {
	
	private String text;

	public CharacterToken(String text) {
		this.text = text;
	}

	public TokenType tokenType() {
		return TokenType.CHARACTER;
	}

	public Integer length() {
		return text.length();
	}

	public String value() {
		return text.substring(1, text.length()-1);
	}

}
