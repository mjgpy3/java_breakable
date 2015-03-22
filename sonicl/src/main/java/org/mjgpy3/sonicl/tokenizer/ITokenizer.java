package org.mjgpy3.sonicl.tokenizer;

import java.util.Collection;

import org.mjgpy3.sonicl.tokenizer.token.Token;

public interface ITokenizer {

	public Collection<Token> tokenize();
}
