package org.ext.jft.container;

import java.util.List;

import org.ext.jft.function.Mapper;

/**
 * @author Dmitri Babaev
 */
public interface ListF<E> extends List<E>, CollectionF<E> {
	
	<Ex extends Throwable> E getFrontOrThrow(Ex ex) throws Ex;
	
	E getFrontOrElse(E elseVal);
	
	Option<E> getFront();
	
	<B extends Comparable<Object>> ListF<E> sortBy(Mapper<E, B> mapper);
	 
	Option<E> getRandomValue();
	
	ListF<E> subList(int fromIndex, int toIndex);
}