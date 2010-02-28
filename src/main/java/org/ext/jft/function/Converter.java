package org.ext.jft.function;

/**
 * Converts From object into To object
 * @author Dmitri Babaev
 */
public interface Converter <From, To> {
	To convert(From from);
}
