package org.ext.jft.tool;

import org.junit.Assert;
import org.junit.Test;

public class RegExpTest {
	
	@Test
	public void checkFind() {
		String res = RegExp.find("abc.", "---abcf---").getOrThrow("error");
		Assert.assertEquals("abcf", res);
	}
}
