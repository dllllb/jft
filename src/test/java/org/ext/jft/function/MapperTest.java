package org.ext.jft.function;

import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.test.Asserts.assertElementsEquals;

import org.junit.Test;

public class MapperTest {

	@Test
	public void andThenPredicate() {
		assertElementsEquals(
			arrayList("111", "2222", "33333", "444444")
				.filter(ReflectionMapper.<String, Integer>newInstance("length")
				.andThen(Predicates.moreThanP(4))).toArrayList(),
			arrayList("33333", "444444"));
	}
}
