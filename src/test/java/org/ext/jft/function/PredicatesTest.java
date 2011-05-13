package org.ext.jft.function;

import static org.ext.jft.function.Predicates.all;
import static org.ext.jft.function.Predicates.any;
import static org.ext.jft.function.Predicates.elementOfP;
import static org.ext.jft.function.Predicates.equalsP;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class PredicatesTest {
	
	@Test
	public void testAnyPred() {
		@SuppressWarnings("unchecked")
		Predicate<Object> test = any(equalsP("a"), equalsP("b"));
		assertTrue(test.apply("a"));
		assertFalse(test.apply("as"));
	}
	
	@Test
	public void testAllPred() {
		@SuppressWarnings("unchecked")
		Predicate<Object> test = all(equalsP("a").not(), equalsP("b").not());
		assertTrue(test.apply("as"));
		assertFalse(test.apply("a"));
	}
	
	@Test
	public void testElementOfPred() {
		Predicate<String> test = elementOfP(Arrays.asList("a", "b"));
		assertTrue(test.apply("a"));
		assertFalse(test.apply("c"));
	}
	
	@Test
	public void testContainsPred() {
		Predicate<Collection<String>> test = Predicates.containsP("a");
		assertTrue(test.apply(Arrays.asList("a", "b")));
		assertFalse(test.apply(Arrays.asList("c", "d")));
	}
}
