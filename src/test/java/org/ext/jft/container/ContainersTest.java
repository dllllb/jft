package org.ext.jft.container;

import static org.ext.jft.container.Containers.array;
import static org.junit.Assert.assertArrayEquals;
import static org.ext.jft.test.Asserts.assertSame;
import static org.ext.jft.container.Containers.*;
import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class ContainersTest {

	@Test
	public void arrayTest() {
		assertArrayEquals(new Integer[] {1, 2, 3}, array(1, 2, 3));
	}
	
	@Test
	public void linkedListTest() {
		assertSame(arrayList(1, 2, 3), linkedList(1, 2, 3));
		assertSame(arrayList(1, 2, 3), linkedList((Iterable<Integer>)arrayList(1, 2, 3)));
	}
	
	@Test
	public void hashSetTest() {
		assertSame(arrayList(1, 2, 3), hashSet(1, 2, 3));
		assertSame(arrayList(1, 2, 3), hashSet((Iterable<Integer>)arrayList(1, 2, 3)));
	}
	
	@Test
	public void treeMapTest() {
		assertSame(arrayList(), treeMap().values());
	}
}
