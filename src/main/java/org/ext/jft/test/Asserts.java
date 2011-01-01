package org.ext.jft.test;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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

	public static <K, V> void assertElementsEquals(Map<K, V> expectedElements, Map<K, V> actualElements) {
		assertNotNull("expected map is null", expectedElements);
		assertNotNull("actual map is null", actualElements);
		
		Assert.assertEquals("size of the maps is different:",
				expectedElements.size(), actualElements.size());
		
		Iterator<Entry<K, V>> actualsIt = actualElements.entrySet().iterator();
		
		while (actualsIt.hasNext()) {
			Entry<K, V> actual = actualsIt.next();
			V expectedVal = expectedElements.get(actual.getKey());
			assertTrue(String.format("expected map doesn't contains key '%s':", actual.getKey()),
					expectedVal != null);
			Assert.assertEquals(
					String.format("difference in the map values for the key '%s':",
							actual.getKey()),
					expectedVal, actual.getValue());
		}
	}
}
