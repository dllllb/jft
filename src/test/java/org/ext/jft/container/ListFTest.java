package org.ext.jft.container;

import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.container.Containers.decorate;
import static org.ext.jft.container.Range.range;
import static org.ext.jft.test.Asserts.assertSame;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.ext.jft.function.Combiner;
import org.ext.jft.function.Mapper;
import org.ext.jft.function.Mappers;
import org.ext.jft.function.Predicate;
import org.ext.jft.function.Predicates;
import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class ListFTest {
	@Test
	public void mapFilterReduce() {
		int res = decorate(arrayList(range(10))).map(new Mapper<Integer, Integer>() {
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
	public void map() {
		List<String> res = arrayList(1, 2)
				.map(Mappers.<Integer>toStringM())
				.toArrayList();
		
		assertSame(arrayList("1", "2"), res);
	}

	@Test
	public void filter() {
		List<Integer> res = arrayList(null, 1, 2)
				.filter(Predicates.<Integer>notNullP())
				.toArrayList();
		
		assertSame(arrayList(1, 2), res);
	}
	
	@Test
	public void newArrayList() {
		assertSame(Arrays.asList(1, 2, 3), arrayList(1, 2, 3));
	}
}
