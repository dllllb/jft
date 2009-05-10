package org.ext.jft.container;

import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.container.Range.range;
import static org.ext.jft.test.Asserts.assertSame;

import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class RangeTest {
	
	@Test
	public void generate() {
		assertSame(arrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), arrayList(range(10)));
	}
}
