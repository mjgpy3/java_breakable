package com.mjgpy3.sonicleet.tokenizer;

public class SymbolToken implements IToken {

	private TokenType type;

	public SymbolToken(TokenType t) {
		type = t;
	}
	
	public TokenType tokenType() {
		return type;
	}

	public Integer length() {
		return 1;
	}

}
