package com.mjgpy3.sonicleet.tokenizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tokenizer implements ITokenizer {
	
	private final Map<String, Tok> SYMBOL_TO_TOKEN_TYPE =
			new HashMap<String, Tok>() {{
				put("[", Tok.OPEN_SQUARE);
				put("]", Tok.CLOSE_SQUARE);
				put("(", Tok.OPEN_PAREN);
				put(")", Tok.CLOSE_PAREN);
				put(",", Tok.COMMA);
			}};

	public Collection<Tok> tokenize(String string) {
		List<Tok> result = new ArrayList<Tok>();
		
		if (SYMBOL_TO_TOKEN_TYPE.containsKey(string.substring(0, 1))) {
			result.add(SYMBOL_TO_TOKEN_TYPE.get(string.substring(0, 1)));
		}
		
		return result;
	}
}
