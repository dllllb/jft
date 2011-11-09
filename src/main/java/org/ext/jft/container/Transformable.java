package org.ext.jft.container;

import static org.ext.jft.container.Containers.*;

import java.util.Iterator;

import org.ext.jft.container.impl.FilteredTransformable;
import org.ext.jft.container.impl.MappedTransformable;
import org.ext.jft.function.Combiner;
import org.ext.jft.function.Mapper;
import org.ext.jft.function.Predicate;

/**
 * @author Dmitri Babaev
 */
public interface Transformable<E> extends Iterable<E> {

    /**
	 * Operation that transforms each element of the collection to another object
	 * @param mapper - functor to perform the transformation
	 * @return the {@link Iterable} structure of mapped elements
	 */
	public <To> Transformable<To> map(Mapper<? super E, To> mapper);

    /**
	 * Operation that produces a subset of the collection with elements that matches predicate
	 * @param predicate - functor to test if element matches predicate
	 * @return the {@link Iterable} structure that represents a subset of collection's elements
	 */
	public Transformable<E> filter(Predicate<? super E> predicate);

    /**
	 * Operation that produces single object from the collection's element
	 * @param combiner - functor that produces a new resulting value
	 * from the previous resulting value and an element of the collection
	 * @param initial - initial resulting value before the reduce operation
	 * @return result of the reduce
	 */
	public <R> R reduce(Combiner<R, ? super E, R> combiner, R initial);
	
	public ListF<E> toArrayList();
	
	public ListF<E> toLinkedList();
	
	public SetF<E> toHashSet();

    public <T> Transformable<Pair<E,T>> zipWith(Iterable<T> second);
}
