package org.ext.jft.tool;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class AnyTypeTest {
	
	@Test
	public void checkCast() {
		Object a = new Integer(1);
		Integer b = AnyType.cast(a);
		assertEquals(a, b);
	}
}
