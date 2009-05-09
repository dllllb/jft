package org.ext.jft.container;

import static org.ext.jft.container.Lists.*;
import static org.ext.jft.container.Range.range;
import static org.ext.jft.test.Asserts.*;

import java.util.List;

import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class RangeTest {
	
	@Test
	public void generate() {
		List<Integer> res = arrayList(arrayList(range(10)));
		assertCollectionEquals(arrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), res);
	}
}
