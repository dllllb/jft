package org.ext.jft.tool;

import static org.ext.jft.container.Containers.arrayList;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class AnyTypeTest {
	
	@Test
	public void testCast() {
		Object a = new ArrayList<Integer>(arrayList(1, 2, 3));
		ArrayList<Integer> b = AnyType.cast(a);
		assertEquals(a, b);
	}
}
