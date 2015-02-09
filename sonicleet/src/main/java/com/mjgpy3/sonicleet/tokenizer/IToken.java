package com.mjgpy3.sonicleet.tokenizer;

public interface IToken {

	public TokenType tokenType();
	
	public Integer length();
	
	public String value();
}