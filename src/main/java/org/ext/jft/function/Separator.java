package org.ext.jft.function;

import org.ext.jft.container.Pair;

/**
 * @author Dmitri Babaev
 */
public abstract class Separator<From, ToLeft, ToRight> extends Mapper<From, Pair<ToLeft, ToRight>> {
	public Pair<ToLeft,ToRight> map(From from ){
		return separate(from);
	};
	
	public abstract Pair<ToLeft,ToRight> separate(From from);
}
