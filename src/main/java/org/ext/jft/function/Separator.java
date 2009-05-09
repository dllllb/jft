package org.ext.jft.function;

import org.ext.jft.container.Pair;

/**
 * @author Dmitri Babaev
 */
public interface Separator<From, ToLeft, ToRight> {
	Pair<ToLeft, ToRight> separate(From from);
}
