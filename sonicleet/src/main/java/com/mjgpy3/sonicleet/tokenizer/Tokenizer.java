package com.mjgpy3.sonicleet.tokenizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Tokenizer implements ITokenizer {
	
	private static final String STRING_DELIMS = "'\"";
	public static final String IGNORED_SYMBOLS = " \t\n";
	public static final Map<String, TokenType> SYMBOL_TO_TOKEN_TYPE =
			new HashMap<String, TokenType>() {{
				put("[", TokenType.OPEN_SQUARE);
				put("]", TokenType.CLOSE_SQUARE);
				put("{", TokenType.OPEN_CURLY);
				put("}", TokenType.CLOSE_CURLY);
				put("(", TokenType.OPEN_PAREN);
				put(")", TokenType.CLOSE_PAREN);
				put(",", TokenType.COMMA);
				put("=", TokenType.BIND);
				put(":", TokenType.COLON);
				put("|", TokenType.PIPE);
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

	private IToken nextToken(Integer index, String code) {
		String current = code.substring(index, index + 1);

		if (isStringStarter(current)) {
			return new StringExtractor(current, code, index).extract();
		}
		if (isWordCharacter(current)) {
			return new WordExtractor(code, index).extract();
		}
		
		if (isSymbol(current)) {
			return new SymbolToken(SYMBOL_TO_TOKEN_TYPE.get(code.substring(index, index+1)));
		}
		
        return new IgnoredToken();
	}

	private boolean isWordCharacter(String s) {
		return !isSymbol(s) && !IGNORED_SYMBOLS.contains(s);
	}
	
	private boolean isSymbol(String s) {
		return SYMBOL_TO_TOKEN_TYPE.containsKey(s);
	}
	
	private boolean isStringStarter(String s) {
		return STRING_DELIMS.contains(s);
	}

	private Collection<IToken> empty() {
		return new ArrayList<IToken>();
	}
}