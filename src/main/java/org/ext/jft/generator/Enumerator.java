package org.ext.jft.generator;

import org.ext.jft.container.Option;

/**
 * @author Dmitri Babaev
 */
public interface Enumerator<T> {
    Option<T> getNext();
}
