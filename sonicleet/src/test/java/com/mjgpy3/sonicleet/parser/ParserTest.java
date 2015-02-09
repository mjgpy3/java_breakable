package com.mjgpy3.sonicleet.parser;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.mjgpy3.sonicleet.ast.IAstNode;
import com.mjgpy3.sonicleet.ast.SLInteger;
import com.mjgpy3.sonicleet.tokenizer.tokens.IToken;
import com.mjgpy3.sonicleet.tokenizer.tokens.IntegerToken;


public class ParserTest {
	
	private IParser uut;
	
	@Before
	public void setUp() {
		uut = new Parser();
	}

	@Test
	public void IntegerToken_parses_to_SLInteger() {
		Collection<IToken> given = new ArrayList<IToken>() {{
			add(new IntegerToken("-42"));
		}};
		
		IAstNode result = uut.parse(given);
		
		assertThat(result, instanceOf(SLInteger.class));
	}

	@Test
	public void SLIntegers_value_is_original_parsed_as_a_java_Integer() {
		Collection<IToken> given = new ArrayList<IToken>() {{
			add(new IntegerToken("-42"));
		}};

		IAstNode result = uut.parse(given);

		assertThat(((SLInteger) result).value(), is(-42));
	}
}
