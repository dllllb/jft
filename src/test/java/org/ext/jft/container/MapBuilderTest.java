package org.ext.jft.container;

import org.junit.Test;

import java.util.Map;

import static org.ext.jft.container.Containers.hashMap;
import static org.ext.jft.container.MapBuilder.entry;
import static org.ext.jft.container.Pair.pair;
import static org.ext.jft.test.Asserts.assertElementsEquals;

/**
 * @author Dmitri Babaev
 */
public class MapBuilderTest {
    @SuppressWarnings({"unchecked"})
    private Map<Integer, String> control = hashMap(pair(1, "a"), pair(2, "b"));

    @Test
    public void testAsHashMap() {
        Map<Integer, String> map = entry(1, "a").and(2, "b").asHashMap();
		assertElementsEquals(control.entrySet(), map.entrySet());
    }

    @Test
    public void testAsTreeMap() {
        Map<Integer, String> map = entry(1, "a").and(2, "b").asTreeMap();
		assertElementsEquals(control.entrySet(), map.entrySet());
    }
}
