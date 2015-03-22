package org.mjgpy3.sonicl.tokenizer.token;

public class Token {
	private String value;
	private TokenType type;
	
	public Token(String value, TokenType type) {
		this.value = value;
		this.type = type;
	}

	public String value() {
		return value;
	}
	
	public TokenType type() {
		return type;
	}
}
