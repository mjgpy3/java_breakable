package com.mjgpy3.sonicleet.tokenizer;

import java.util.Collection;

public interface ITokenizer {
	Collection<IToken> tokenize(String string);
}
