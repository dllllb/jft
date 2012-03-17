package org.ext.jft.container;

import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.container.Containers.hashMap;
import static org.ext.jft.container.Pair.pair;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.ext.jft.function.Mapper;
import org.ext.jft.function.Mappers;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class MapFTest {
    private final MapF<Integer, String> map = hashMap();
    private final int key = 1;
    private final String data = "test";

    @Before
    public void setUp() {
        map.put(key, data);
    }

    @Test
    public void testGetOrThrow() {
        assertEquals(data, map.getOrThrow(key, new RuntimeException("no key")));
    }

    @Test(expected = RuntimeException.class)
    public void testGetOrThrowException() {
        map.getOrThrow(2, new RuntimeException("no key"));
    }

    @Test
    public void testGetOrElseUpdate() {
        MapF<Integer, ListF<Integer>> map = hashMap();
        map.getOrElseUpdate(1, new Mapper<Integer, ListF<Integer>>() {
            @Override
            public ListF<Integer> apply(Integer integer) {
                return arrayList();
            }
        }).add(1);
        assertEquals(arrayList(1), map.get(1));

        MapF<Integer, List<Integer>> map2 = hashMap();
        map2.getOrElseUpdate(1, Containers.<Integer>arrayList()).add(1);
        assertEquals(arrayList(1), map2.get(1));
    }
    
    @Test
    public void testGroupBy() {
        MapF<Integer, Pair<String, Integer>> map = MapBuilder
                .hashMap(1, pair("a", 1))
                .and(2, pair("b", 1))
                .and(3, pair("c", 2))
                .get();
        
        MapF<Integer, CollectionF<Pair<String, Integer>>> res =
                map.groupBy(Pair.<String, Integer>getSecondM());

        assertEquals(ListBuilder.arrayList(pair("a", 1)).and(pair("b", 1)).get(), res.get(1));
        assertEquals(ListBuilder.arrayList(pair("c", 2)).get(), res.get(2));
    }

    @Test
    public void testProject() {
        MapF<Integer, Pair<String, Integer>> map = MapBuilder
                .hashMap(1, pair("a", 1))
                .and(2, pair("b", 1))
                .and(3, pair("c", 2))
                .get();
        
        MapF<Integer, Integer> res = map.project(Pair.<String, Integer>getSecondM());

        assertEquals(Integer.valueOf(1), res.get(1));
        assertEquals(Integer.valueOf(1), res.get(2));
        assertEquals(Integer.valueOf(2), res.get(3));
    }
}
