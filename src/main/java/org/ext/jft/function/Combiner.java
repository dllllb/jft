package org.ext.jft.function;

import org.ext.jft.container.Pair;

/**
 * @author Dmitri Babaev
 */
public abstract class Combiner<FromLeft, FromRight, To> {
    public abstract To apply(FromLeft left, FromRight right);

    public Mapper<Pair<FromLeft, FromRight>, To> asMapper() {
        return new Mapper<Pair<FromLeft, FromRight>, To>() {
            public To apply(Pair<FromLeft, FromRight> from) {
                return Combiner.this.apply(from.first(), from.second());
            }
        };
    }
}
