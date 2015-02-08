package com.mjgpy3.sonicleet.tokenizer;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Tokenizer_TypeOfResultTests {
	
	private ITokenizer uut;
	
	private String singleInput;
	
	private TokenType expectedOutput;
	
	@Before
	public void setUp() {
		uut = new Tokenizer();
	}
	
	@Parameters
	public static Collection<Object[]> cases() {
		return Arrays.asList(new Object[][] {
				{"[", TokenType.OPEN_SQUARE},
				{"]", TokenType.CLOSE_SQUARE},
				{"(", TokenType.OPEN_PAREN},
				{")", TokenType.CLOSE_PAREN},
				{",", TokenType.COMMA},
				{"foo", TokenType.WORD},
		});
	}
	
	public Tokenizer_TypeOfResultTests(String input, TokenType output) {
		singleInput = input;
		expectedOutput = output;
	}

	@Test
	public void token_type_is_correct() {
		Collection<IToken> result = uut.tokenize(singleInput);
		assertThat(result.iterator().next().tokenType(), is(expectedOutput));
	}
}
