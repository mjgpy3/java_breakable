package com.mjgpy3.sonicleet.tokenizer.extractors;

import java.util.HashMap;
import java.util.Map;

import com.mjgpy3.sonicleet.tokenizer.Tokenizer;
import com.mjgpy3.sonicleet.tokenizer.tokens.DoubleToken;
import com.mjgpy3.sonicleet.tokenizer.tokens.IToken;
import com.mjgpy3.sonicleet.tokenizer.tokens.IntegerToken;
import com.mjgpy3.sonicleet.tokenizer.tokens.MultiSymbolToken;
import com.mjgpy3.sonicleet.tokenizer.tokens.TokenType;
import com.mjgpy3.sonicleet.tokenizer.tokens.WordToken;

public class WordExtractor implements IExtractor {

	private static final String DOUBLE_MATCHER = "-?[0-9.]{2,}";
	private static final String INTEGER_MATCHER = "-?\\d+";
	private static final Map<String, TokenType> WORD_TO_SPECIFIC_TOKEN_TYPE = new HashMap<String, TokenType>() {{
		put("..", TokenType.RANGE);
		put("data", TokenType.KWD_DATA);
	}};
	private Integer index;
	private String code;
	
	public WordExtractor(String code, Integer index) {
		this.index = index;
		this.code = code;
	}

	public IToken extract() {
		IToken result = null;
		StringBuilder word = new StringBuilder();
		int decimalCount = 0;

		while (nextIsWordCharacter()) {
			String current = next();
			word.append(current);
			decimalCount += current.equals(".") ? 1 : 0;
			if (endOfWord()) {
				String value = word.toString();
				if (value.matches(INTEGER_MATCHER)) {
					result = new IntegerToken(value);
				}
				else if (value.matches(DOUBLE_MATCHER) && decimalCount == 1) {
					result = new DoubleToken(value);
				}
				else if (WORD_TO_SPECIFIC_TOKEN_TYPE.containsKey(value)) {
					result = new MultiSymbolToken(WORD_TO_SPECIFIC_TOKEN_TYPE.get(value), value);
				}
				else {
					result = new WordToken(value);
				}
			}
		}
		
		return result;
	}

	private boolean endOfWord() {
		return index == code.length() || !nextIsWordCharacter();
	}

	private boolean isWordCharacter(String s) {
		return !Tokenizer.SYMBOL_TO_TOKEN_TYPE.containsKey(s) &&
				!Tokenizer.IGNORED_SYMBOLS.contains(s);
	}
	
	private boolean nextIsWordCharacter() {
		return index < code.length() && isWordCharacter(peek());
	}

	private String peek() {
		return code.substring(index, index+1);
	}
	
	private String next() {
		String result = code.substring(index, index+1);
		index += 1;
		return result;
	}
}
