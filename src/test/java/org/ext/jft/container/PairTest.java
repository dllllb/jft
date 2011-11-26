package org.ext.jft.container;

import org.junit.Test;

import static org.ext.jft.container.Pair.pair;
import static org.junit.Assert.*;

/**
 * @author Dmitri Babaev
 */
public class PairTest {

    @Test
    public void testCreation() {
        assertEquals(1, pair(1, 2).first().intValue());
        assertEquals(2, pair(1, 2).second().intValue());
    }

    @Test
    public void testEquals() {
        assertTrue(pair(1, 2).equals(pair(1, 2)));
        assertFalse(pair(1, 2).equals(pair(3, 4)));
    }

    @Test
    public void testSwap() {
        assertEquals(pair(1, 2), pair(2, 1).swap());
    }
}
