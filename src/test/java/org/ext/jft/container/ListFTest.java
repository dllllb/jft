package org.ext.jft.container;

import static org.ext.jft.container.CollectionsF.*;
import static org.ext.jft.container.Lists.*;
import static org.ext.jft.container.Range.*;
import static org.junit.Assert.*;
import static org.ext.jft.test.Asserts.*;

import java.util.ArrayList;
import java.util.List;

import org.ext.jft.function.Combiner;
import org.ext.jft.function.impl.Mapper;
import org.ext.jft.function.impl.Predicate;
import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class ListFTest {
	@Test
	public void mapFilterReduce() {
		int res = decorate(arrayList(range(10))).map(new Mapper<Integer, Integer>(){
			public Integer map(Integer from) {
				return from + 1;
			}
		}).filter(new Predicate<Integer>(){
			public boolean test(Integer val) {
				return val % 2 == 0;
			}
		}).reduce(new Combiner<Integer, Integer, Integer>() {
			public Integer combine(Integer fromLeft, Integer fromRight) {
				return fromLeft+fromRight;
			}
		}, 0);
		
		assertEquals(30, res);
	}
	
	@Test
	public void asCollection() {
		ListF<Integer> list = decorate(arrayList(range(10)));
		List<Integer> expected = new ArrayList<Integer>(list);
		assertCollectionEquals(expected, list);
	}
}
