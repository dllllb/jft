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
	public void anyPred() {
		@SuppressWarnings("unchecked")
		Predicate<String> test = any(equalsP("a"), equalsP("b"));
		assertTrue(test.test("a"));
		assertFalse(test.test("as"));
	}
	
	@Test
	public void allPred() {
		@SuppressWarnings("unchecked")
		Predicate<String> test = all(equalsP("a").not(), equalsP("b").not());
		assertTrue(test.test("as"));
		assertFalse(test.test("a"));
	}
	
	@Test
	public void elementOfPred() {
		Predicate<String> test = elementOfP(Arrays.asList("a", "b"));
		assertTrue(test.test("a"));
		assertFalse(test.test("c"));
	}
	
	@Test
	public void containsPred() {
		Predicate<Collection<String>> test = Predicates.containsP("a");
		assertTrue(test.test(Arrays.asList("a", "b")));
		assertFalse(test.test(Arrays.asList("c", "d")));
	}
}
