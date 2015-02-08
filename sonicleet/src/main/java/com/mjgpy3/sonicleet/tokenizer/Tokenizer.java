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

	public Collection<IToken> tokenize(String string) {
		List<IToken> result = new ArrayList<IToken>();
		
		if (string.isEmpty()) {
			return result;
		}

		IToken token;
		
		if (SYMBOL_TO_TOKEN_TYPE.containsKey(string.substring(0, 1))) {
			token = new SymbolToken(SYMBOL_TO_TOKEN_TYPE.get(string.substring(0, 1)));
		} else {
			token = new WordToken();
		}

		result.add(token);

		return result;
	}
}
