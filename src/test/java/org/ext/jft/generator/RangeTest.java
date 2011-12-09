package org.ext.jft.generator;

import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.generator.Range.range;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class RangeTest {

    @Test
    public void testGenerate() {
        assertEquals(arrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), arrayList(range(10)));
        assertEquals(arrayList(2, 3, 4), arrayList(range(2, 5)));
        assertEquals(arrayList(2, 4, 6, 8), arrayList(range(2, 10, 2)));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemove() {
        range(10).iterator().remove();
    }
}
