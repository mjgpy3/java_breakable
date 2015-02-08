package com.mjgpy3.sonicleet.tokenizer;

public class StringExtractor implements IExtractor {
	
	private String code;
	private String last;
	private Integer index;

	public StringExtractor(String code, Integer index) {
		this.code = code;
		this.index = index;
	}

	public IToken extract() {
		StringBuilder word = new StringBuilder();

		do {
			word.append(next());
		} while (!wasEscape() && index != code.length() && !nextIsStringEnding());

		return new StringToken(word.append("'").toString());
	}
	
	private boolean wasEscape() {
		return last.equals("\\");
	}
	
	private String next() {
		String next = code.substring(index, index+1);
		last = next;
		index += 1;
		return next;
	}
	
	private boolean nextIsStringEnding() {
		return code.substring(index, index+1).equals("'");
	}
}