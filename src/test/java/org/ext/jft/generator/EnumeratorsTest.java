package org.ext.jft.generator;

import org.ext.jft.container.Containers;
import org.ext.jft.function.Predicates;
import org.junit.Test;

import java.util.List;

import static org.ext.jft.container.Containers.arrayList;
import static org.junit.Assert.assertEquals;

public class EnumeratorsTest {

    @Test public void testLimit() {
        List<Integer> res = Containers.transformable(
                Enumerators.limit(Range.generator(0, 10, 1), 4)).toArrayList();
        assertEquals(arrayList(0, 1, 2, 3), res);
    }

    @Test public void testUntil() {
        List<Integer> res = Containers.transformable(
                Enumerators.until(Range.generator(0, 10, 1), Predicates.moreThanP(3))).toArrayList();
        assertEquals(arrayList(0, 1, 2, 3), res);
    }
}
