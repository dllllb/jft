package org.ext.jft.container;

import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.container.Containers.hashMap;
import static org.ext.jft.test.Asserts.assertElementsEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.ext.jft.function.Mappers;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class MapFTest {
	private final MapF<Integer, String> map = hashMap();
	private final int key = 1;
	private final int notKey = 2;
	private final String data = "test";

	@Before
	public void setUp() {
		map.put(key, data);
	}

	@Test
	public void testGetOrThrow() {
		assertEquals(data, map.getOrThrow(key, new RuntimeException("no key")));
	}

	@Test(expected = RuntimeException.class)
	public void testGetOrThrowException() {
		map.getOrThrow(notKey, new RuntimeException("no key"));
	}
	
	@Test
	public void testGetOrElseUpdate() {
		MapF<Integer, List<Integer>> map = hashMap();
		map.getOrElseUpdate(1, Mappers.<Integer, Integer>newArrayListM()).add(1);
		assertElementsEquals(arrayList(1), map.get(1));
		MapF<Integer, List<Integer>> map2 = hashMap();
		map2.getOrElseUpdate(1, Containers.<Integer>arrayList()).add(1);
		assertElementsEquals(arrayList(1), map2.get(1));
	}
}
