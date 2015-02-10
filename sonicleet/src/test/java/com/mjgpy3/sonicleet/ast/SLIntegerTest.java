package com.mjgpy3.sonicleet.ast;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

import com.mjgpy3.sonicleet.env.IEnvironment;

public class SLIntegerTest {

	private SLInteger uut;

	@Before
	public void setUp() {
		uut = new SLInteger("-42");
	}

	@Test
	public void execute_evaluates_to_the_integer_itself() {
		assertThat((SLInteger) uut.execute(new IEnvironment() {}), is(uut));
	}

}
