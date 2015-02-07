package com.mjgpy3.sonicleet.tokenizer;

import org.junit.Test;

public class TokenizerTests implements ITokenizationConfig {

	@Test
	public void theTokenizerAcceptsATokenizationConfig() {
		new Tokenizer(new TokenizationConfig());
	}

}
