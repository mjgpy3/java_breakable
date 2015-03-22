package org.mjgpy3.sonicl.parser;

import java.util.Collection;

import javax.management.modelmbean.InvalidTargetObjectTypeException;

import org.mjgpy3.sonicl.tokenizer.ITokenizer;
import org.mjgpy3.sonicl.values.SlValue;

public class Parser implements IParser {
	
	private ITokenizer tokenizer;
	
	public Parser(ITokenizer tokenizer) {
		this.tokenizer = tokenizer;
	}

	public Collection<SlValue> parse() {
		return null;
	}

}
