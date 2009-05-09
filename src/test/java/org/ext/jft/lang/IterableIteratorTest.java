package org.ext.jft.lang;

import static org.ext.jft.container.Lists.arrayList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.ext.jft.lang.IterableIterator;
import org.junit.Test;

public class IterableIteratorTest {

	@Test
	public void testIterableIterator() {
		List<Integer> list = arrayList(1, 2, 3);
		
		int sum = 0;
		for (Integer val : new IterableIterator<Integer>(list.iterator())) {
			sum += val;
		}
		
		assertEquals(6, sum);
	}

}
