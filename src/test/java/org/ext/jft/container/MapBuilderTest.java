package org.ext.jft.container;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.ext.jft.container.MapBuilder.entry;
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
