package org.ext.jft.container;

import static org.ext.jft.container.Containers.array;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class ContainersTest {

	@Test
	public void arrayTest() {
		assertArrayEquals(new Integer[] {1, 2, 3}, array(1, 2, 3));
	}
}
