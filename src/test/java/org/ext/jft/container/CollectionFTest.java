package org.ext.jft.container;

import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.container.Containers.decorate;
import static org.ext.jft.container.Pair.pair;
import static org.ext.jft.container.Range.range;
import static org.ext.jft.test.Asserts.assertElementsEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.ext.jft.function.Combiner;
import org.ext.jft.function.Mapper;
import org.ext.jft.function.Mappers;
import org.ext.jft.function.Predicate;
import org.ext.jft.function.Predicates;
import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class CollectionFTest {

	@Test
	public void testToMapMappingToKey() {
		@SuppressWarnings("unchecked")
		ListF<Pair<Integer, String>> list = arrayList(pair(1, "a"), pair(2, "b"));
		
		Map<Integer, Pair<Integer, String>> map = list.toMapMappingToKey(Pair.<Integer, String>getFirstM());
		assertEquals(pair(1, "a"), map.get(1));
	}
	
	@Test
	public void testMapFilterReduce() {
		int res = decorate(arrayList(range(10))).map(new Mapper<Integer, Integer>() {
			public Integer apply(Integer from) {
				return from + 1;
			}
		}).filter(new Predicate<Integer>(){
			public boolean apply(Integer val) {
				return val % 2 == 0;
			}
		}).reduce(new Combiner<Integer, Integer, Integer>() {
			public Integer apply(Integer fromLeft, Integer fromRight) {
				return fromLeft+fromRight;
			}
		}, 0);
		
		assertEquals(30, res);
	}
	
	@Test
	public void testMap() {
		List<String> res = arrayList(1, 2)
				.map(Mappers.toStringM())
				.toArrayList();
		
		assertElementsEquals(arrayList("1", "2"), res);
	}

	@Test
	public void testFilter() {
		List<Integer> res = arrayList(null, 1, 2)
				.filter(Predicates.notNullP())
				.toArrayList();
		
		assertElementsEquals(arrayList(1, 2), res);
	}
}
