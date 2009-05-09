package org.ext.jft.container;

import static org.ext.jft.container.Lists.arrayList;
import static org.ext.jft.test.Asserts.assertCollectionEquals;

import java.util.List;

import org.ext.jft.container.IterableIterator;
import org.junit.Test;

public class IterableIteratorTest {

	@Test
	public void testIterableIterator() {
		List<Integer> expected = arrayList(1, 2, 3);
		List<Integer> actual = arrayList(new IterableIterator<Integer>(expected.iterator()));
		
		assertCollectionEquals(expected, actual);
	}

}
