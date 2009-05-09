package org.ext.jft.container;

import static org.ext.jft.container.Lists.arrayList;
import static org.ext.jft.test.Asserts.assertCollectionEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.ext.jft.function.impl.Mapper;
import org.ext.jft.function.impl.Predicate;
import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class ListsTest {
	@Test
	public void mapTest() {
		List<String> res = Lists.map(arrayList(1, 2), Mapper.<Integer> toStringM());
		assertCollectionEquals(Lists.arrayList("1", "2"), res);
	}

	@Test
	public void filterTest() {
		List<Integer> res = Lists.filter(arrayList(null, 1, 2), Predicate.<Integer> notNullP());
		assertCollectionEquals(Lists.arrayList(1, 2), res);
	}
	
	@Test
	public void arrayListTest() {
		assertCollectionEquals(Arrays.asList(1, 2, 3), arrayList(1, 2, 3));
	}
	
	@Test
	public void getRandomValueTest() {
		List<Integer> vals = arrayList(1, 2);
		assertTrue(vals.contains(Lists.getRandomValue(vals).get()));
		
		assertTrue(Lists.getRandomValue(arrayList()).isEmpty());
	}
}
