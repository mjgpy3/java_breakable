package com.mjgpy3.sonicleet.tokenizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tokenizer implements ITokenizer {
	
	private final Map<String, TokenType> SYMBOL_TO_TOKEN_TYPE =
			new HashMap<String, TokenType>() {{
				put("[", TokenType.OPEN_SQUARE);
				put("]", TokenType.CLOSE_SQUARE);
				put("(", TokenType.OPEN_PAREN);
				put(")", TokenType.CLOSE_PAREN);
				put(",", TokenType.COMMA);
			}};

	public Collection<IToken> tokenize(String code) {
		if (code.isEmpty()) { return empty(); }

		Collection<IToken> result = empty();

		result.add(nextToken(0, code));

		return result;
	}
	
	private IToken nextToken(Integer index, String code) {
		if (SYMBOL_TO_TOKEN_TYPE.containsKey(code.substring(0, 1))) {
			return new SymbolToken(SYMBOL_TO_TOKEN_TYPE.get(code.substring(index, index+1)));
		}
		return new WordToken();
	}

	private Collection<IToken> empty() {
		return new ArrayList<IToken>();
	}
}
