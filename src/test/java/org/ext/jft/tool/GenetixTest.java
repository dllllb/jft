package org.ext.jft.tool;

import org.ext.jft.container.Containers;
import org.ext.jft.container.Enumerators;
import org.ext.jft.container.ListF;
import org.ext.jft.function.Combiner;
import org.ext.jft.function.Combiners;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Dmitri Babaev
 */
public class GenetixTest {

    @Test
    public void breedTest() {
        Genetix.Breeder<Integer> breeder = new Genetix.AbstractBreeder<Integer>() {
            @Override
            protected Integer descend(Integer left, Integer right) {
                return left + right;
            }
        };

        Iterable<Integer> br = Containers.iterable(Enumerators.limit(Genetix.generator(
                Containers.arrayList(1, 2, 3, 4, 5), breeder, new Random(1)), 10));
        ListF<Integer> res = Containers.arrayList(br);
        assertEquals(10, res.size());

        Integer sum = res.reduce(
                new Combiner<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer left, Integer right) {
                        return left + right;
                    }
                }, 0);

        assertTrue(sum >= 20);
        assertTrue(sum <= 32);

        Integer min = res.reduce(Combiners.<Integer>min(), Integer.MAX_VALUE);
        Integer max = res.reduce(Combiners.<Integer>max(), Integer.MIN_VALUE);

        assertTrue(max <= 10);
        assertTrue(min >= 2);
    }
}
