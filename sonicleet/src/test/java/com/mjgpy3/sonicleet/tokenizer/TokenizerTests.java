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
public class TokenizerTests {
	
	private ITokenizer uut;
	
	private String singleInput;
	
	private Tok expectedOutput;
	
	@Before
	public void setUp() {
		uut = new Tokenizer();
	}
	
	@Parameters
	public static Collection<Object[]> cases() {
		return Arrays.asList(new Object[][] {
				{"[", Tok.OPEN_SQUARE},
				{"]", Tok.CLOSE_SQUARE},
				{"(", Tok.OPEN_PAREN},
				{")", Tok.CLOSE_PAREN},
				{",", Tok.COMMA},
		});
	}
	
	public TokenizerTests(String input, Tok output) {
		singleInput = input;
		expectedOutput = output;
	}

	@Test
	public void square_brace_is_tokenizable() {
		Collection<Tok> result = uut.tokenize(singleInput);
		assertThat(result.iterator().next(), is(expectedOutput));
	}
}
