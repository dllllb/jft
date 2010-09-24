package org.ext.jft.function;

import static org.ext.jft.container.Containers.arrayList;

import java.util.List;

import org.ext.jft.test.Asserts;
import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class ReflectionMapperTest {
	
	@Test
	public void checkReflectionMapper() {
		List<String> res = arrayList(new Integer(1), new Integer(2))
			.map(ReflectionMapper.<Integer, String>newInstance("toString")).toArrayList();
		Asserts.assertElementsEquals(arrayList("1", "2"), res);
		
		List<Integer> res2 = arrayList("---+++---", "//+++//")
			.map(ReflectionMapper.<String, Integer>newInstance("indexOf", "+++")).toArrayList();
		Asserts.assertElementsEquals(arrayList(3, 2), res2);
	}
}
