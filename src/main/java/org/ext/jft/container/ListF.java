package org.ext.jft.container;

import java.util.List;

import org.ext.jft.function.Combiner;
import org.ext.jft.function.Mapper;
import org.ext.jft.function.Predicate;

/**
 * @author Dmitri Babaev
 */
public interface ListF<E> extends List<E> {

	public <To> ListF<To> map(Mapper<E, To> mapper);

	public ListF<E> filter(Predicate<E> predicate);

	public E reduce(Combiner<E, E, E> combiner, E initial);

}