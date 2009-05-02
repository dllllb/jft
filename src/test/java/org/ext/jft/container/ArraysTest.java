package org.ext.jft.container;

import static org.ext.jft.container.Arrays.array;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class ArraysTest {

	@Test
	public void arrayTest() {
		Integer[] arr = array(1, 2, 3);
		Integer[] control = {1, 2, 3};
		assertArrayEquals(control, arr);
	}
}
