package org.ext.jft.function;

/**
 * Transforms From object into To object
 * @author Dmitri Babaev
 */
public interface Mapper<From, To> {
	To map(From from);
}
