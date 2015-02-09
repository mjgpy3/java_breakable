package com.mjgpy3.sonicleet.tokenizer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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
				{"{", TokenType.OPEN_CURLY},
				{"}", TokenType.CLOSE_CURLY},
				{",", TokenType.COMMA},
				{":", TokenType.COLON},
				{"|", TokenType.PIPE},
				{"\n", TokenType.NEWLINE},
				{"..", TokenType.RANGE},
				{"data", TokenType.KWD_DATA},
				{"foo", TokenType.WORD},
				{"equal?", TokenType.WORD},
				{"<=", TokenType.WORD},
				{">=", TokenType.WORD},
				{">", TokenType.WORD},
				{"<", TokenType.WORD},
				{"=", TokenType.BIND},
				{"42", TokenType.INTEGER},
				{"-42", TokenType.INTEGER},
				{"42.9", TokenType.DOUBLE},
				{"-42.9", TokenType.DOUBLE},
				{"-.9", TokenType.DOUBLE},
				{"-1.", TokenType.DOUBLE},
				{"-1-", TokenType.WORD},
				{"4.2.9", TokenType.WORD},
				{"-", TokenType.WORD},
				{"-.", TokenType.WORD},
				{"2..2", TokenType.WORD},
				{"''", TokenType.STRING},
				{"'a'", TokenType.STRING},
				{"'a b c'", TokenType.STRING},
				{"' \\' '", TokenType.STRING},
				{"\"a\"", TokenType.CHARACTER},
				{"\"\n\"", TokenType.CHARACTER},
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
