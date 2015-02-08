package com.mjgpy3.sonicleet.tokenizer;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.is;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class Tokenizer_NumberOfResultsTest {
	
	private ITokenizer uut;

	@Before
	public void setUp() {
		uut = new Tokenizer();
	}

	@Test
	public void tokenizing_the_empty_string_returns_no_results() {
		Collection<IToken> result = uut.tokenize("");
		
		assertThat(result.size(), is(0));
	}

	@Test
	public void tokenizing_a_word_has_one_element() {
		Collection<IToken> result = uut.tokenize("foobar");
		
		assertThat(result.size(), is(1));
	}

}
