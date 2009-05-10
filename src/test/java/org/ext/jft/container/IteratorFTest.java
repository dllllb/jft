package org.ext.jft.container;

import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.test.Asserts.assertSame;

import org.junit.Test;

public class IteratorFTest {

	@Test
	public void iterableIterator() {
		ListF<Integer> expected = arrayList(1, 2, 3);
		ListF<Integer> actual = arrayList(expected.iterator());
		
		assertSame(expected, actual);
	}

}
