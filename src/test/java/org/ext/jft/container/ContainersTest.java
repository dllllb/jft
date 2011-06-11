package org.ext.jft.container;

import static org.ext.jft.container.Containers.array;
import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.container.Containers.asList;
import static org.ext.jft.container.Containers.hashMap;
import static org.ext.jft.container.Containers.hashSet;
import static org.ext.jft.container.Containers.linkedList;
import static org.ext.jft.container.Containers.treeMap;
import static org.ext.jft.container.Pair.pair;
import static org.ext.jft.test.Asserts.assertElementsEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.ext.jft.function.Mappers;
import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class ContainersTest {

	@Test
	public void testArray() {
		assertArrayEquals(new Integer[] {1, 2, 3}, array(1, 2, 3));
	}
	
	@Test
	public void testAsList() {
		assertElementsEquals(arrayList(1, 2, 3), asList(1, 2, 3));
		assertElementsEquals(arrayList(1, 2, 3), Containers.asList(array(1, 2, 3)));
	}
	
	@Test
	public void testLinkedList() {
		assertElementsEquals(arrayList(1, 2, 3), linkedList(1, 2, 3));
		assertElementsEquals(arrayList(1, 2, 3), linkedList((Iterable<Integer>)arrayList(1, 2, 3)));
	}
	
	@Test
	public void testHashMap() {
		@SuppressWarnings("unchecked")
		Map<Integer, String> map = hashMap(pair(1, "a"), pair(2, "b"));
		
		Map<Integer, String> control = new HashMap<Integer, String>();
		control.put(1, "a");
		control.put(2, "b");
		
		assertElementsEquals(control.entrySet(), map.entrySet());
	}
	
	@Test
	public void testHashSet() {
		assertElementsEquals(arrayList(1, 2, 3), hashSet(1, 2, 3));
		assertElementsEquals(arrayList(1, 2, 3), hashSet((Iterable<Integer>)arrayList(1, 2, 3)));
	}
	
	@Test
	public void testTreeMap() {
		assertElementsEquals(arrayList(), treeMap().values());
	}
	
	@Test
	public void testIterableIterator() {
		CollectionF<Integer> expected = arrayList(1, 2, 3);
		ListF<Integer> actual = arrayList(Containers.iterable(expected.iterator()));
		
		assertElementsEquals(expected, actual);
	}
	

	@Test
	public void testIteratorEnumerator() {
		CollectionF<Integer> expected = arrayList(1, 2, 3);
		ListF<Integer> actual = arrayList(Containers.iterable(Containers.enumerator(expected.iterator())));
		
		assertElementsEquals(expected, actual);
	}
	
	@Test
	public void testZipIterable() {
		ListF<Integer> first = arrayList(1, 2, 3, 4);
		ListF<Integer> second = arrayList(4, 5, 6);
		
		ListF<Pair<Integer, Integer>> list = arrayList(Containers.zipIterable(first, second));
		assertEquals(3, list.size());
		Map<Integer, Integer> map = list.toMap(Mappers.<Pair<Integer, Integer>>selfMapper());
		
		assertEquals(Integer.valueOf(4), map.get(1));
		assertEquals(Integer.valueOf(6), map.get(3));
	}
	
	@Test
	public void testFlatten() {
		@SuppressWarnings("unchecked")
		ListF<ListF<Integer>> lst = arrayList(arrayList(1,2,3), arrayList(4,5));
		assertElementsEquals(arrayList(1, 2, 3, 4, 5), arrayList(Containers.flatten(lst)));
	}
}
