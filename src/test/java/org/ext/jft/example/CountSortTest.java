package org.ext.jft.example;

import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.test.Asserts.assertElementsEquals;

import org.ext.jft.container.ListF;
import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class CountSortTest {

	@Test
	public void testCountSort() {
		ListF<Integer> res = CountSort.countSort(arrayList(2, 4, 1, 5, 8, 4, 5, 3, 4, 2, 2, 7));
		assertElementsEquals(arrayList(1, 2, 2, 2, 3, 4, 4, 4, 5, 5, 7, 8), res);
	}
}
