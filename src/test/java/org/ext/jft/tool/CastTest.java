package org.ext.jft.tool;

import static org.ext.jft.tool.Cast.cast;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class CastTest {
	
	@Test
	public void castTypeInference() {
		Object a = new Integer(1);
		Integer b = cast(a);
		assertEquals(a, b);
	}
}
