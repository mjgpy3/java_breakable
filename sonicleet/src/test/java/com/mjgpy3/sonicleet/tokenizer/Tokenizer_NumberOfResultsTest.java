package com.mjgpy3.sonicleet.tokenizer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Tokenizer_NumberOfResultsTest {
	
	private String toTokenize;
	
	private Integer expectedCount;
	
	private ITokenizer uut;

	@Before
	public void setUp() {
		uut = new Tokenizer();
	}
	
	@Parameters
	public static Collection<Object[]> cases() {
		return Arrays.asList(new Object[][] {
				{"", 0},
				{"\t", 0},
				{"\n", 1},
				{"f", 1},
				{" ", 0},
				{"a b", 2},
				{"ab", 1},
				{"foo bar", 2},
				{"[a b, a + b]", 8},
				{"add=[b c, b + c]", 10},
				{"add=[b c, + 42 -92.71]", 10},
				{"add=[b c, + -42 -.71]", 10},
				{"equal?", 1},
				{"42", 1},
				{"-42", 1},
				{"42.9", 1},
				{"4.2.9", 1},
				{"''", 1},
				{"'a'", 1},
				{"'a b c'", 1},
				{"' \\' '", 1},
				{"\"\"", 1},
				{"\"a\"", 1},
		});
	}
	
	public Tokenizer_NumberOfResultsTest(String code, Integer expectedSize) {
		toTokenize = code;
		expectedCount = expectedSize;
	}
	
	@Test
	public void tokenizing_returns_expected_number_of_results() {
		Collection<IToken> result = uut.tokenize(toTokenize);
		
		assertThat(result.size(), is(expectedCount));
	}
}
