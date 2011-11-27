package org.ext.jft.generator;

import org.ext.jft.container.Containers;
import org.ext.jft.function.Predicates;
import org.ext.jft.generator.Enumerators;
import org.ext.jft.generator.Range;
import org.junit.Test;

import java.util.List;

import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.test.Asserts.assertElementsEquals;

public class EnumeratorsTest {

    @Test public void testLimit() {
        List<Integer> res = Containers.iterable(Enumerators.limit(Range.generator(0, 10, 1), 4)).toArrayList();
        assertElementsEquals(arrayList(0, 1, 2, 3), res);
    }

    @Test public void testUntil() {
        List<Integer> res = Containers.iterable(Enumerators.until(Range.generator(0, 10, 1), Predicates.lessThanP(4))).toArrayList();
        assertElementsEquals(arrayList(0, 1, 2, 3), res);
    }
}
