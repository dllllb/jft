package org.ext.jft.tool;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dmitri Babaev
 */
public class RegExpTest {

    @Test
    public void testFind() {
        String res = RegExp.find("abc.", "---abcf---").getOrThrow("error");
        Assert.assertEquals("abcf", res);
    }
}
