package org.ext.jft.container;

import static org.junit.Assert.*;

import org.ext.jft.container.Option;
import org.junit.Test;

public class OptionTest {
	
	@Test
	public void iterateTest() {
		Option<Integer> full = Option.some(10);
		
		int iterations = 0;
		for (Integer val : full) {
			assertEquals(10, val.intValue());
			if (iterations > 0)
				fail("more than one value inside Option");
			
			iterations++;
		}
		
		Option<Integer> empty = Option.none();
		
		for (Integer val : empty) {
			throw new AssertionError(val);
		}
	}
	
	@Test(expected=RuntimeException.class)
	public void getOrThrowNoneTest() {
		Option.none().getOrThrow(new RuntimeException());
	}
	
	@Test(expected=RuntimeException.class)
	public void getOrThrowStringNoneTest() {
		Option.none().getOrThrow("error");
	}
	
	@Test
	public void getOrThrowSomeTest() {
		assertEquals(10, Option.some(10).getOrThrow(new RuntimeException()).intValue());
		assertEquals(10, Option.some(10).getOrThrow("error").intValue());
	}
	
	@Test
	public void getOrElseTest() {
		assertEquals(10, Option.some(10).getOrElse(11).intValue());
		assertEquals(10, Option.<Integer>none().getOrElse(10).intValue());
	}
	
	@Test
	public void isEmptyTest() {
		assertFalse(Option.some(10).isEmpty());
		assertTrue(Option.none().isEmpty());
	}
	
	@Test
	public void isDefinedTest() {
		assertTrue(Option.some(10).isDefined());
		assertFalse(Option.none().isDefined());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createNullSomeTest() {
		Option.some(null);
	}
	
	@Test
	public void getTest() {
		assertEquals(10, Option.some(10).get().intValue());
		assertNull(Option.none().get());
	}
	
	@Test
	public void notNullTest() {
		assertTrue(Option.notNull(10).isDefined());
		assertTrue(Option.notNull(null).isEmpty());
	}
	
	@Test
	public void notEmptyTest() {
		assertTrue(Option.notEmpty("test").isDefined());
		assertTrue(Option.notEmpty("").isEmpty());
	}
}
