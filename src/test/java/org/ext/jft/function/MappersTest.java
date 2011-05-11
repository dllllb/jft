package org.ext.jft.function;

import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.test.Asserts.assertElementsEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ext.jft.container.ListF;
import org.junit.Test;

public class MappersTest {

	@Test
	public void testAndThenPredicate() {
		ListF<String> test = arrayList("33333", "444444");
		ListF<String> res = arrayList("111", "2222", "33333", "444444")
			.filter(ReflectionMapper.<String, Integer>newInstance("length")
			.andThen(Predicates.moreThanP(4))).toArrayList();
		
		assertElementsEquals(test, res);
	}
	
	@Test
	public void testCastMapper() {
		ListF<Integer> list = arrayList(1, 2, 3);
		ListF<Number> nList = list.map(Mappers.<Integer, Number>castMapper()).toArrayList();
		assertElementsEquals(list, nList);
	}
	
	@Test(expected=ClassCastException.class)
	public void testCastMapperClassCastException() {
		ListF<Integer> list = arrayList(1, 2, 3);
		ListF<Double> nList = list.map(Mappers.<Integer, Double>castMapper()).toArrayList();
		@SuppressWarnings("unused")
		Double el = nList.get(0);
	}
	
	@Test
	public void testSelfMapper() {
		Integer val = 1;
		Integer res = Mappers.<Integer>selfMapper().apply(val);
		assertEquals(val, res);
		assertTrue(val == res);
	}
}
