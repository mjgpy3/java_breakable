package com.mjgpy3.sonicleet.tokenizer.tokens;

public interface IToken {

	public TokenType tokenType();
	
	public Integer length();
	
	public String value();
}