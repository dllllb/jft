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
	
	public static <T> void assertSame(Collection<T> expecteds, Collection<T> actuals) {
		assertNotNull("expected collection is null", expecteds);
		assertNotNull("actual collection is null", actuals);
		
		Assert.assertEquals("size of the collections is different:",
				expecteds.size(), actuals.size());
		
		Iterator<T> expectedIt = expecteds.iterator();
		Iterator<T> actualsIt = actuals.iterator();

		for (int i = 1; expectedIt.hasNext(); i++) {
			Assert.assertEquals(String.format("difference in the collection elements number '%d':", i),
					expectedIt.next(), actualsIt.next());
		}
	}

	public static <K, V> void assertSame(Map<K, V> expecteds, Map<K, V> actuals) {
		assertNotNull("expected map is null", expecteds);
		assertNotNull("actual map is null", actuals);
		
		Assert.assertEquals("size of the maps is different:",
				expecteds.size(), actuals.size());
		
		Iterator<Entry<K, V>> actualsIt = actuals.entrySet().iterator();
		
		while (actualsIt.hasNext()) {
			Entry<K, V> actual = actualsIt.next();
			V expectedVal = expecteds.get(actual.getKey());
			assertTrue(String.format("expected map doesn't contains key '%s':", actual.getKey()),
					expectedVal != null);
			Assert.assertEquals(
					String.format("difference in the map values for the key '%s':",
							actual.getKey()),
					expectedVal, actual.getValue());
		}
	}
}
