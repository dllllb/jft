package org.ext.jft.container;

import static org.junit.Assert.*;

import org.ext.jft.container.Option;
import org.junit.Test;

public class OptionTest {
	
	@Test
	public void iterate() {
		Option<Integer> full = Option.some(10);
		
		int iterations = 0;
		for (Integer val : full) {
			assertEquals(Integer.valueOf(10), val);
			if (iterations > 0)
				throw new AssertionError("more than one value inside Option");
			
			iterations++;
		}
		
		Option<Integer> empty = Option.none();
		
		for (Integer val : empty) {
			throw new AssertionError(val);
		}
	}
}
