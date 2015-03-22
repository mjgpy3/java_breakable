package org.mjgpy3.sonicl.tokenizer;

import java.util.Collection;

import org.mjgpy3.sonicl.tokenizer.token.Token;

public class RawStringTokenizer implements ITokenizer {
	
	private String code;

	public RawStringTokenizer(String code) {
		this.code = code;
	}

	public Collection<Token> tokenize() {
		return null;
	}

}
