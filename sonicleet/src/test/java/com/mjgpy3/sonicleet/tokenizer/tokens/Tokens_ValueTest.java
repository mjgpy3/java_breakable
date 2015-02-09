package com.mjgpy3.sonicleet.tokenizer.tokens;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Tokens_ValueTest {

	@Test
	public void word_tokens_value_is_the_value_it_was_initialized_with() {
		assertThat(new WordToken("foobar").value(), is("foobar"));
	}

	@Test
	public void integer_tokens_value_is_the_value_it_was_initialized_with() {
		assertThat(new IntegerToken("-1234").value(), is("-1234"));
	}

	@Test
	public void double_tokens_value_is_the_value_it_was_initialized_with() {
		assertThat(new DoubleToken("-1234.009").value(), is("-1234.009"));
	}

	@Test
	public void string_tokens_value_is_the_value_without_quotes() {
		assertThat(new StringToken("'foobar'").value(), is("foobar"));
	}

	@Test
	public void character_tokens_value_is_the_value_without_quotes() {
		assertThat(new CharacterToken("\"a\"").value(), is("a"));
	}
}
