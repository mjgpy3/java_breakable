package com.mjgpy3.sonicleet.ast;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

import com.mjgpy3.sonicleet.env.IEnvironment;

public class SLIntegerTest {

	private SLInteger uut;
	private IEnvironment arbitraryEnvironment;

	@Before
	public void setUp() {
		uut = new SLInteger("-42");
		arbitraryEnvironment = new IEnvironment() {};
	}

	@Test
	public void execute_evaluates_to_the_integer_itself() {
		assertThat((SLInteger) uut.execute(arbitraryEnvironment), is(uut));
	}

	@Test
	public void executed_integer_has_the_expected_value() {
		assertThat(((SLInteger) uut.execute(arbitraryEnvironment)).value(), is(-42));
	}

}
