package com.mjgpy3.sonicleet.tokenizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tokenizer implements ITokenizer {
	
	private final Map<String, TokenType> SYMBOL_TO_TOKEN_TYPE =
			new HashMap<String, TokenType>() {{
				put("[", TokenType.OPEN_SQUARE);
				put("]", TokenType.CLOSE_SQUARE);
				put("(", TokenType.OPEN_PAREN);
				put(")", TokenType.CLOSE_PAREN);
				put(",", TokenType.COMMA);
				put("=", TokenType.BIND);
			}};
	private final Set<String> IGNORED_SYMBOLS = new HashSet<String>() {{
		add(" ");
		add("\t");
		add("\n");
	}};

	public Collection<IToken> tokenize(String code) {
		if (code.isEmpty()) { return empty(); }

		Collection<IToken> result = empty();
		Integer i = 0;
		IToken currentToken;
		
		while (i < code.length()) {
			currentToken = nextToken(i, code);
			i += currentToken.length();

			if (currentToken.tokenType() != TokenType.IGNORED) {
				result.add(currentToken);
			}
		}

		return result;
	}
	
	private boolean isWordCharacter(String s) {
		return !isSymbol(s) && !isIgnored(s);
	}
	
	private boolean isSymbol(String s) {
		return SYMBOL_TO_TOKEN_TYPE.containsKey(s);
	}
	
	private boolean isIgnored(String s) {
		return IGNORED_SYMBOLS.contains(s);
	}
	
	private String next(String s, Integer i) {
		return s.substring(i, i+1);
	}
	
	private IToken nextToken(Integer index, String code) {
		StringBuilder word = new StringBuilder();
		
		while (isWordCharacter(next(code, index))) {
			word.append(code.substring(index, index + 1));
			index += 1;
			if (index == code.length() || !isWordCharacter(next(code, index))) {
                return new WordToken(word.toString());
			}
		}
		
		if (isSymbol(next(code, index))) {
			return new SymbolToken(SYMBOL_TO_TOKEN_TYPE.get(code.substring(index, index+1)));
		}
		
        return new IgnoredToken();
	}

	private Collection<IToken> empty() {
		return new ArrayList<IToken>();
	}
}
