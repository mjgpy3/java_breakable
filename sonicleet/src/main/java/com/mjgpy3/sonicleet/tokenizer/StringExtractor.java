package com.mjgpy3.sonicleet.tokenizer;

public class StringExtractor implements IExtractor {
	
	private String code;
	private boolean wasEscape;
	private Integer index;
	private String starter;

	public StringExtractor(String starter, String code, Integer index) {
		this.code = code;
		this.index = index;
		this.starter = starter;
	}

	public IToken extract() {
		StringBuilder word = new StringBuilder();

		do {
			word.append(next());
		} while (index != code.length() && !(nextIsStringEnding() && !wasEscape));

		return new StringToken(word.append(starter).toString());
	}
	
	private String next() {
		String next = code.substring(index, index+1);
		wasEscape = next.equals("\\");
		index += 1;
		return next;
	}
	
	private boolean nextIsStringEnding() {
		return code.substring(index, index+1).equals(starter);
	}
}