package org.ext.jft.function;

/**
 * @author Dmitri Babaev
 */
public interface Combiner<FromLeft, FromRight, To> {
	To combine(FromLeft fromLeft, FromRight fromRight);
}
