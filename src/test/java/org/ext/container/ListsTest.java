package org.ext.container;

import static org.ext.jft.container.Lists.arrayList;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.ext.jft.container.Lists;
import org.ext.jft.function.impl.Mapper;
import org.ext.jft.function.impl.Predicate;
import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class ListsTest {
	@Test
	public void mapTest() {
		List<Integer> data = arrayList(1, 2);
		List<String> res = Lists.map(data, Mapper.<Integer> toStringM());

		assertEquals(Lists.arrayList("1", "2"), res);
	}

	@Test
	public void filterTest() {
		List<Integer> data = arrayList(null, 1, 2);
		List<Integer> res = Lists.filter(data, Predicate.<Integer> notNullP());

		assertEquals(Lists.arrayList(1, 2), res);
	}
	
	@Test
	public void arrayListTest() {
		List<Integer> list = arrayList(1, 2, 3);
		
		List<Integer> control = new ArrayList<Integer>();
		control.add(1);
		control.add(2);
		control.add(3);
		
		assertEquals(control, list);
	}
}
