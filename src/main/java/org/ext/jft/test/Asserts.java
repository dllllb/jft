package org.ext.jft.test;

import static org.junit.Assert.assertNotNull;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Assert;

/**
 * @author Dmitri Babaev
 */
public class Asserts {

    public static <E1, E2> void assertElementsEquals(Collection<E1> expectedElements, Collection<E2> actualElements) {
        assertNotNull("expected collection is null", expectedElements);
        assertNotNull("actual collection is null", actualElements);

        Assert.assertEquals("size of the collections is different:",
                expectedElements.size(), actualElements.size());

        Iterator<E1> expectedIt = expectedElements.iterator();
        Iterator<E2> actualsIt = actualElements.iterator();

        for (int i = 1; expectedIt.hasNext(); i++) {
            Assert.assertEquals(String.format("difference in the collection elements number '%d':", i),
                    expectedIt.next(), actualsIt.next());
        }
    }
}
