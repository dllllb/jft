package org.ext.jft.container;

import static org.ext.jft.container.Containers.hashSet;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class SetFTest {

    @Test
    public void testUnion() {
        assertEquals(hashSet(1, 2, 3, 4), hashSet(1, 2, 3).union(hashSet(1, 4, 2)));
    }

    @Test
    public void testIntersection() {
        assertEquals(hashSet(1, 2), hashSet(1, 2, 3).intersection(hashSet(1, 4, 2)));
    }

    @Test
    public void testDifference() {
        assertEquals(hashSet(3, 4), hashSet(1, 2, 3).difference(hashSet(1, 4, 2)));
    }
}
