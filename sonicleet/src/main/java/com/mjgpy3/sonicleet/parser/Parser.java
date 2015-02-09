package com.mjgpy3.sonicleet.parser;

import java.util.Collection;

import com.mjgpy3.sonicleet.ast.IAstNode;
import com.mjgpy3.sonicleet.ast.SLInteger;
import com.mjgpy3.sonicleet.tokenizer.tokens.IToken;

public class Parser implements IParser {

	public IAstNode parse(Collection<IToken> given) {
		return new SLInteger();
	}

}
