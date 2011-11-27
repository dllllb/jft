package org.ext.jft.container;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.ext.jft.container.MapBuilder.hashMap;
import static org.ext.jft.container.MapBuilder.treeMap;
import static org.ext.jft.test.Asserts.assertElementsEquals;

/**
 * @author Dmitri Babaev
 */
public class MapBuilderTest {
    private Map<Integer, String> control = new HashMap<Integer, String>() {{
        put(1, "a");
        put(2, "b");
    }};

    @Test
    public void testHashMap() {
        Map<Integer, String> map = hashMap(1, "a").and(2, "b").get();
        assertElementsEquals(control.entrySet(), map.entrySet());
    }

    @Test
    public void testTreeMap() {
        Map<Integer, String> map = treeMap(1, "a").and(2, "b").get();
        assertElementsEquals(control.entrySet(), map.entrySet());
    }
}
