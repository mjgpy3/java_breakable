package org.mjgpy3.sonicl.parser;

import java.util.ArrayList;
import java.util.Collection;

import org.mjgpy3.sonicl.tokenizer.ITokenizer;
import org.mjgpy3.sonicl.value.SlInteger;
import org.mjgpy3.sonicl.value.SlValue;

public class Parser implements IParser {
	
	private ITokenizer tokenizer;
	
	public Parser(ITokenizer tokenizer) {
		this.tokenizer = tokenizer;
	}

	public Collection<SlValue> parse() {
		return new ArrayList<SlValue>() {{
			add(new SlInteger(Integer.parseInt(tokenizer.tokenize().iterator().next().value())));
		}};
	}

}
