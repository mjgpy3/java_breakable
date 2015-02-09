package com.mjgpy3.sonicleet.tokenizer;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class Tokenizer_LengthTest {
	
	private ITokenizer uut;
	private String inputText;
	private Integer expectedLength;
	
	@Before
	public void setUp() {
		uut = new Tokenizer();
	}

	@Parameters
	public static Collection<Object[]> cases() {
		return Arrays.asList(new Object[][] {
				{"data", 4},
				{"'foobar'", 8},
				{"'a b'", 5},
				{".a.", 3},
				{"-000.0", 6},
		});
	}

	public Tokenizer_LengthTest(String input, Integer length) {
		inputText = input;
		expectedLength = length;
	}
	
	@Test
	public void correct_lengths_are_extracted() {
        assertThat(
        	uut.tokenize(inputText).iterator().next().length(),
        	is(expectedLength)
        );
	}
}
