package org.ext.jft.container;

import static org.ext.jft.container.Arrays.array;
import static org.ext.jft.container.Maps.hashMap;
import static org.ext.jft.test.Asserts.assertMapEquals;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class MapsTest {
	private final Map<Integer, String> map = hashMap();
	private static final int key = 1;
	private static final int notKey = 2;
	private static final String data = "test";

	@Before
	public void setUp() {
		map.put(key, data);
	}

	@Test
	public void getOrThrowTest() {
		String res = Maps.getOrThrow(map, key, new RuntimeException("no key"));
		assertEquals(data, res);
	}

	@Test(expected = RuntimeException.class)
	public void getOrThrowExceptionTest() {
		Maps.getOrThrow(map, notKey, new RuntimeException("no key"));
	}
	
	@Test
	public void hashMapTest() {
		Map<Integer, String> map = hashMap(array(1, 2), array("a", "b"));
		
		Map<Integer, String> control = new HashMap<Integer, String>();
		control.put(1, "a");
		control.put(2, "b");
		
		assertMapEquals(control, map);
	}
}
