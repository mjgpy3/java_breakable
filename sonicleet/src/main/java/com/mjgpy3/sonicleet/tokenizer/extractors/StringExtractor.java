package com.mjgpy3.sonicleet.tokenizer.extractors;

import com.mjgpy3.sonicleet.tokenizer.tokens.IToken;
import com.mjgpy3.sonicleet.tokenizer.tokens.StringToken;

public class StringExtractor implements IExtractor {
	
	private String code;
	private boolean wasEscape;
	private Integer index;

	public StringExtractor(String code, Integer index) {
		this.code = code;
		this.index = index;
	}

	public IToken extract() {
		StringBuilder word = new StringBuilder();

		do {
			word.append(next());
		} while (index != code.length() && !(nextIsStringEnding() && !wasEscape));

		return new StringToken(word.append("'").toString());
	}
	
	private String next() {
		String next = code.substring(index, index+1);
		wasEscape = next.equals("\\");
		index += 1;
		return next;
	}
	
	private boolean nextIsStringEnding() {
		return code.substring(index, index+1).equals("'");
	}
}