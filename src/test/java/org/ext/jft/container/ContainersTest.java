package org.ext.jft.container;

import static org.ext.jft.container.Containers.array;
import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.container.Containers.asList;
import static org.ext.jft.container.Containers.hashMap;
import static org.ext.jft.container.Containers.hashSet;
import static org.ext.jft.container.Containers.linkedList;
import static org.ext.jft.container.Containers.treeMap;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.ext.jft.function.Predicates;
import org.junit.Test;

import java.util.Collections;

/**
 * @author Dmitri Babaev
 */
public class ContainersTest {

    @Test
    public void testArray() {
        assertArrayEquals(new Integer[]{1, 2, 3}, array(1, 2, 3));
    }

    @Test
    public void testAsList() {
        assertEquals(arrayList(1, 2, 3), asList(1, 2, 3));
        assertEquals(arrayList(1, 2, 3), Containers.asList(array(1, 2, 3)));
    }

    @Test
    public void testLinkedList() {
        assertEquals(arrayList(1, 2, 3), linkedList(1, 2, 3));
        assertEquals(arrayList(1, 2, 3), linkedList((Iterable<Integer>) arrayList(1, 2, 3)));
    }

    @Test
    public void testHashMap() {
        assertEquals(Collections.emptyList(), hashMap().values().toArrayList());
    }

    @Test
    public void testHashSet() {
        assertEquals(arrayList(1, 2, 3).toHashSet(), hashSet(1, 2, 3));
        assertEquals(arrayList(1, 2, 3).toHashSet(), hashSet((Iterable<Integer>) arrayList(1, 2, 3)));
    }

    @Test
    public void testTreeMap() {
        assertEquals(Collections.emptyList(), treeMap().values().toArrayList());
    }

    @Test
    public void testIterableIterator() {
        CollectionF<Integer> expected = arrayList(1, 2, 3);
        ListF<Integer> actual = Containers.transformable(expected.iterator()).toArrayList();

        assertEquals(expected, actual);
    }

    @Test
    public void testTransformableIterator() {
        CollectionF<Integer> initial = arrayList(1, 2, 3);
        ListF<Integer> res = Containers.transformable(initial.iterator()).filter(Predicates.lessThanP(3)).toArrayList();
        assertEquals(arrayList(1, 2), res);
    }

    @Test
    public void testIteratorEnumerator() {
        CollectionF<Integer> expected = arrayList(1, 2, 3);
        ListF<Integer> actual = Containers.transformable(Containers.enumerator(expected.iterator())).toArrayList();

        assertEquals(expected, actual);
    }

    @Test
    public void testFlatten() {
        ListF<ListF<Integer>> lst = ListBuilder.arrayList(arrayList(1, 2, 3)).and(arrayList(4, 5)).get();
        assertEquals(arrayList(1, 2, 3, 4, 5), arrayList(Containers.flatten(lst)));
    }
}
