package org.ext.jft.function;

import static org.ext.jft.function.Predicates.*;
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
    public void testOrPred() {
        Predicate<String> test = equalsP("a").or(equalsP("b"));
        assertTrue(test.apply("a"));
        assertFalse(test.apply("as"));
    }

    @Test
    public void testAndPred() {
        Predicate<String> test = equalsP("a").not().and(equalsP("b").not());
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

    @Test
    public void testInstanceOfPred() {
        Predicate<Object> test = instanceOfP(String.class);
        assertTrue(test.apply("a"));
        assertFalse(test.apply(1));
    }
}
