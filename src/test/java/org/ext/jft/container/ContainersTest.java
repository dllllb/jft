package org.ext.jft.container;

import static org.ext.jft.container.Containers.array;
import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.container.Containers.asList;
import static org.ext.jft.container.Containers.hashMap;
import static org.ext.jft.container.Containers.hashSet;
import static org.ext.jft.container.Containers.linkedList;
import static org.ext.jft.container.Containers.treeMap;
import static org.ext.jft.test.Asserts.assertElementsEquals;
import static org.junit.Assert.assertArrayEquals;

import org.ext.jft.function.Predicates;
import org.junit.Test;

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
        assertElementsEquals(arrayList(1, 2, 3), asList(1, 2, 3));
        assertElementsEquals(arrayList(1, 2, 3), Containers.asList(array(1, 2, 3)));
    }

    @Test
    public void testLinkedList() {
        assertElementsEquals(arrayList(1, 2, 3), linkedList(1, 2, 3));
        assertElementsEquals(arrayList(1, 2, 3), linkedList((Iterable<Integer>) arrayList(1, 2, 3)));
    }

    @Test
    public void testHashMap() {
        assertElementsEquals(arrayList(), hashMap().values());
    }

    @Test
    public void testHashSet() {
        assertElementsEquals(arrayList(1, 2, 3), hashSet(1, 2, 3));
        assertElementsEquals(arrayList(1, 2, 3), hashSet((Iterable<Integer>) arrayList(1, 2, 3)));
    }

    @Test
    public void testTreeMap() {
        assertElementsEquals(arrayList(), treeMap().values());
    }

    @Test
    public void testIterableIterator() {
        CollectionF<Integer> expected = arrayList(1, 2, 3);
        ListF<Integer> actual = Containers.transformable(expected.iterator()).toArrayList();

        assertElementsEquals(expected, actual);
    }

    @Test
    public void testTransformableIterator() {
        CollectionF<Integer> initial = arrayList(1, 2, 3);
        ListF<Integer> res = Containers.transformable(initial.iterator()).filter(Predicates.lessThanP(3)).toArrayList();
        assertElementsEquals(arrayList(1, 2), res);
    }

    @Test
    public void testIteratorEnumerator() {
        CollectionF<Integer> expected = arrayList(1, 2, 3);
        ListF<Integer> actual = Containers.iterable(Containers.enumerator(expected.iterator())).toArrayList();

        assertElementsEquals(expected, actual);
    }

    @Test
    public void testFlatten() {
        @SuppressWarnings("unchecked") //TODO: use builder for checked cast
        ListF<ListF<Integer>> lst = arrayList(arrayList(1, 2, 3), arrayList(4, 5));
        assertElementsEquals(arrayList(1, 2, 3, 4, 5), arrayList(Containers.flatten(lst)));
    }
}
