package org.ext.jft.container;

import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.container.Containers.decorate;
import static org.ext.jft.container.Pair.pair;
import static org.ext.jft.generator.Range.range;
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
        ListF<Pair<Integer, String>> list = ListBuilder.arrayList(pair(1, "a"))
                .and(pair(2, "b")).get();

        Map<Integer, Pair<Integer, String>> map = list.toMapMappingToKey(Pair.<Integer, String>getFirstM());
        assertEquals(pair(1, "a"), map.get(1));
    }

    @Test
    public void testMapFilterReduce() {
        int res = decorate(arrayList(range(10))).map(new Mapper<Integer, Integer>() {
            public Integer apply(Integer from) {
                return from + 1;
            }
        }).filter(new Predicate<Integer>() {
            public boolean apply(Integer val) {
                return val % 2 == 0;
            }
        }).reduce(new Combiner<Integer, Integer, Integer>() {
                    public Integer apply(Integer left, Integer right) {
                        return left + right;
                    }
                }, 0);

        assertEquals(30, res);
    }

    @Test
    public void testMap() {
        List<String> res = arrayList(1, 2)
                .map(Mappers.toStringM())
                .toArrayList();

        assertEquals(arrayList("1", "2"), res);
    }

    @Test
    public void testFilter() {
        List<Integer> res = arrayList(null, 1, 2)
                .filter(Predicates.notNullP())
                .toArrayList();

        assertEquals(arrayList(1, 2), res);
    }

    @Test
    public void testZipWith() {
        ListF<Integer> first = arrayList(1, 2, 3, 4);
        ListF<Integer> second = arrayList(4, 5, 6);

        ListF<Pair<Integer, Integer>> res = first.zipWith(second).toArrayList();
        assertEquals(3, res.size());
        Map<Integer, Integer> map = res.toMap(Mappers.<Pair<Integer, Integer>>selfMapper());

        assertEquals(Integer.valueOf(4), map.get(1));
        assertEquals(Integer.valueOf(6), map.get(3));
    }

    @Test
    public void testGroupBy() {
        CollectionF<Pair<String, Integer>> col = ListBuilder
                .arrayList(Pair.pair("a", 1))
                .and(Pair.pair("b", 1))
                .and(Pair.pair("c", 2))
                .get();
        
        MapF<Integer, CollectionF<Pair<String, Integer>>> res =
                col.groupBy(Pair.<String, Integer>getSecondM());

        assertEquals(ListBuilder.arrayList(pair("a", 1)).and(pair("b", 1)).get(), res.get(1));
        assertEquals(ListBuilder.arrayList(pair("c", 2)).get(), res.get(2));
    }
}
