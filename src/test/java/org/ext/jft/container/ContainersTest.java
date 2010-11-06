package org.ext.jft.container;

import static org.ext.jft.container.Containers.array;
import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.container.Containers.asList;
import static org.ext.jft.container.Containers.hashSet;
import static org.ext.jft.container.Containers.linkedList;
import static org.ext.jft.container.Containers.treeMap;
import static org.ext.jft.test.Asserts.assertElementsEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class ContainersTest {

	@Test
	public void checkArray() {
		assertArrayEquals(new Integer[] {1, 2, 3}, array(1, 2, 3));
	}
	
	@Test
	public void checkAsList() {
		assertElementsEquals(arrayList(1, 2, 3), asList(1, 2, 3));
		assertElementsEquals(arrayList(1, 2, 3), Containers.asList(array(1, 2, 3)));
	}
	
	@Test
	public void checkLinkedList() {
		assertElementsEquals(arrayList(1, 2, 3), linkedList(1, 2, 3));
		assertElementsEquals(arrayList(1, 2, 3), linkedList((Iterable<Integer>)arrayList(1, 2, 3)));
	}
	
	@Test
	public void checkHashSet() {
		assertElementsEquals(arrayList(1, 2, 3), hashSet(1, 2, 3));
		assertElementsEquals(arrayList(1, 2, 3), hashSet((Iterable<Integer>)arrayList(1, 2, 3)));
	}
	
	@Test
	public void checkTreeMap() {
		assertElementsEquals(arrayList(), treeMap().values());
	}
	
	@Test
	public void checkIterableIterator() {
		ListF<Integer> expected = arrayList(1, 2, 3);
		ListF<Integer> actual = arrayList(Containers.iterable(expected.iterator()));
		
		assertElementsEquals(expected, actual);
	}
	

	@Test
	public void checkIteratorEnumerator() {
		ListF<Integer> expected = arrayList(1, 2, 3);
		ListF<Integer> actual = arrayList(Containers.iterable(Containers.enumerator(expected.iterator())));
		
		assertElementsEquals(expected, actual);
	}
}
