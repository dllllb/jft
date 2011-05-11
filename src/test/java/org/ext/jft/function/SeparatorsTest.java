package org.ext.jft.function;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import org.ext.jft.container.Pair;
import org.junit.Test;

public class SeparatorsTest {
	@Test
	public void testDuplicatingSeparator() {
		Integer val = 1;
		Pair<Integer, Integer> res = Separators.<Integer>duplicatingSeparator().apply(val);
		assertEquals(val, res.first());
		assertEquals(res.first(), res.second());
		assertTrue(val == res.first());
		assertTrue(res.first() == res.second());
	}
}
