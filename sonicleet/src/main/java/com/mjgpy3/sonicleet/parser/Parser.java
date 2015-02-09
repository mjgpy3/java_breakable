package com.mjgpy3.sonicleet.parser;

import java.util.Collection;

import com.mjgpy3.sonicleet.ast.IAstNode;
import com.mjgpy3.sonicleet.ast.SLInteger;
import com.mjgpy3.sonicleet.tokenizer.tokens.IToken;
import com.mjgpy3.sonicleet.tokenizer.tokens.TokenType;

public class Parser implements IParser {

	public IAstNode parse(Collection<IToken> tokens) {
		IToken token = tokens.iterator().next();
		
		if (token.tokenType() == TokenType.WORD) {
			return new Apply(token.value());
		}
		
		return new SLInteger(token.value());
	}

}
