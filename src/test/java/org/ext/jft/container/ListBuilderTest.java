package org.ext.jft.container;

import org.junit.Test;

import static org.ext.jft.container.ListBuilder.arrayList;
import static org.ext.jft.container.ListBuilder.linkedList;
import static org.ext.jft.test.Asserts.assertElementsEquals;

/**
 * @author Dmitri Babaev
 */
public class ListBuilderTest {

    @Test
    public void testLinkedList() {
        ListF<Integer> res = linkedList(1).and(2).get();
        assertElementsEquals(Containers.arrayList(1, 2), res);
    }

    @Test
    public void testArrayList() {
        ListF<Integer> res = arrayList(1).and(2).get();
        assertElementsEquals(Containers.arrayList(1, 2), res);
    }

    @Test
    public void testListOfLists() {
        ListF<ListF<Integer>> res = arrayList(Containers.arrayList(1, 2))
                .and(Containers.arrayList(3, 4)).get();
        assertElementsEquals(Containers.arrayList(1, 2), res.get(0));
        assertElementsEquals(Containers.arrayList(3, 4), res.get(1));
    }
}
