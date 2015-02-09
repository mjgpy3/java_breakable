package com.mjgpy3.sonicleet.tokenizer;

public class CharacterExtractor implements IExtractor {

	private String code;
	private Integer index;

	public CharacterExtractor(String current, String code, Integer index) {
		this.code = code;
		this.index = index;
	}

	public IToken extract() {
		index += 1;
		StringBuilder chr = new StringBuilder();
		chr.append('"');
		while (code.charAt(index) != '"') {
			chr.append(code.charAt(index));
			index += 1;
		}
		chr.append('"');
		return new CharacterToken(chr.toString());
	}

}
