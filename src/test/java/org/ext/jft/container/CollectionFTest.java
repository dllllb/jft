package org.ext.jft.container;

import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.container.Pair.pair;
import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class CollectionFTest {

	@Test
	public void toMapMappingToKey() {
		@SuppressWarnings("unchecked")
		ListF<Pair<Integer, String>> list = arrayList(pair(1, "a"), pair(2, "b"));
		
		Map<Integer, Pair<Integer, String>> map = list.toMapMappingToKey(Pair.<Integer, String>getFirstM());
		assertEquals(pair(1, "a"), map.get(1));
	}
}
