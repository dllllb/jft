package org.ext.jft.function;

import org.ext.jft.container.Pair;

/**
 * @author Dmitri Babaev
 */
public abstract class Combiner<FromLeft, FromRight, To> {
	public abstract To combine(FromLeft fromLeft, FromRight fromRight);
	
	public Mapper<Pair<FromLeft, FromRight>, To> asMapper() {
		return new Mapper<Pair<FromLeft,FromRight>, To>() {
			public To map(Pair<FromLeft, FromRight> from) {
				return combine(from.first(), from.second());
			}
		};
	}
}
