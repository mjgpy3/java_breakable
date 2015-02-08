package com.mjgpy3.sonicleet.tokenizer;

public class WordExtractor implements IExtractor {

	private static final String DOUBLE_MATCHER = "-?[0-9.]{2,}";
	private static final String INTEGER_MATCHER = "-?\\d+";
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
			if (index == code.length() || !nextIsWordCharacter()) {
				if (word.toString().matches(INTEGER_MATCHER)) {
					result = new IntegerToken(word.toString());
					break;
				}
				if (word.toString().matches(DOUBLE_MATCHER) && decimalCount == 1) {
					result = new DoubleToken(word.toString());
					break;
				}
				result = new WordToken(word.toString());
			}
		}
		
		return result;
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
