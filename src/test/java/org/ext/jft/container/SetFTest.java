package org.ext.jft.container;

import static org.ext.jft.container.Containers.hashSet;
import static org.ext.jft.test.Asserts.assertElementsEquals;

import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class SetFTest {
	
	@Test
	public void checkUnion() {
		assertElementsEquals(hashSet(1, 2, 3, 4), hashSet(1, 2, 3).union(hashSet(1, 4, 2)));
	}
	
	@Test
	public void checkIntersection() {
		assertElementsEquals(hashSet(1, 2), hashSet(1, 2, 3).intersection(hashSet(1, 4, 2)));
	}
	
	@Test
	public void checkDifference() {
		assertElementsEquals(hashSet(3, 4), hashSet(1, 2, 3).difference(hashSet(1, 4, 2)));
	}
}
