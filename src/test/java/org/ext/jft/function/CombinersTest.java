package org.ext.jft.function;

import static org.ext.jft.container.Containers.arrayList;

import org.junit.Assert;
import org.junit.Test;

public class CombinersTest {

    @Test
    public void testMaxCombiner() {
        Assert.assertEquals(4, arrayList(1, 2, 3, 4, 3).reduce(Combiners.<Integer>max(), Integer.MIN_VALUE).intValue());
    }

    @Test
    public void testMinCombiner() {
        Assert.assertEquals(1, arrayList(2, 3, 1, 4, 3).reduce(Combiners.<Integer>min(), Integer.MAX_VALUE).intValue());
    }
}
