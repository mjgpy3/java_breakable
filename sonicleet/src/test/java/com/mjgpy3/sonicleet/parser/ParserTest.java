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
import com.mjgpy3.sonicleet.tokenizer.tokens.WordToken;


public class ParserTest {
	
	private IParser uut;
	
	@Before
	public void setUp() {
		uut = new Parser();
	}
	
	private Collection<IToken> tokens(IToken... args) {
		Collection<IToken> given = new ArrayList<IToken>();
		
		for (IToken arg : args) {
			given.add(arg);
		}
		
		return given;
	}

	@Test
	public void IntegerToken_parses_to_SLInteger() {
		Collection<IToken> given = tokens(new IntegerToken("-42"));
		
		IAstNode result = uut.parse(given);
		
		assertThat(result, instanceOf(SLInteger.class));
	}

	@Test
	public void SLIntegers_value_is_original_parsed_as_a_java_Integer() {
		Collection<IToken> given = tokens(new IntegerToken("-42"));

		IAstNode result = uut.parse(given);

		assertThat(((SLInteger) result).value(), is(-42));
	}

	@Test
	public void WordToken_becomes_an_Apply() {
		Collection<IToken> given = tokens(new WordToken("foobar"));

		IAstNode result = uut.parse(given);

		assertThat(result, instanceOf(Apply.class));
	}

	@Test
	public void Apply_has_the_words_text_as_its_name() {
		Collection<IToken> given = tokens(new WordToken("foobar"));

		IAstNode result = uut.parse(given);

		assertThat(((Apply) result).name(), is("foobar"));
	}
}
