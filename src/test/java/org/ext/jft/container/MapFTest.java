package org.ext.jft.container;

import static org.ext.jft.container.Containers.array;
import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.container.Containers.hashMap;
import static org.ext.jft.test.Asserts.assertSame;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public void getOrThrowTest() {
		assertEquals(data, map.getOrThrow(key, new RuntimeException("no key")));
	}

	@Test(expected = RuntimeException.class)
	public void getOrThrowExceptionTest() {
		map.getOrThrow(notKey, new RuntimeException("no key"));
	}
	
	@Test
	public void hashMapTest() {
		Map<Integer, String> map = hashMap(array(1, 2), array("a", "b"));
		
		Map<Integer, String> control = new HashMap<Integer, String>();
		control.put(1, "a");
		control.put(2, "b");
		
		assertSame(control, map);
	}
	
	@Test
	public void getOrElseUpdate() {
		MapF<Integer, List<Integer>> map = hashMap();
		map.getOrElseUpdate(1, Mappers.<Integer, Integer>newArrayListM()).add(1);
		assertSame(arrayList(1), map.get(1));
		MapF<Integer, List<Integer>> map2 = hashMap();
		map2.getOrElseUpdate(1, Containers.<Integer>arrayList()).add(1);
		assertSame(arrayList(1), map2.get(1));
	}
}
