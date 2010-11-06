package org.ext.jft.container;

import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.test.Asserts.assertElementsEquals;

import org.junit.Test;

public class IterableIteratorTest {

	@Test
	public void checkIterableIterator() {
		ListF<Integer> expected = arrayList(1, 2, 3);
		ListF<Integer> actual = arrayList(Containers.newIterable(expected.iterator()));
		
		assertElementsEquals(expected, actual);
	}

}
