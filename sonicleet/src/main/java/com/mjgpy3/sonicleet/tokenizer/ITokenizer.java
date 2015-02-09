package com.mjgpy3.sonicleet.tokenizer;

import java.util.Collection;

import com.mjgpy3.sonicleet.tokenizer.tokens.IToken;

public interface ITokenizer {
	Collection<IToken> tokenize(String string);
}
