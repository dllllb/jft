package org.ext.jft.container;

/**
 * @author Dmitri Babaev
 */
public interface QueueNode<T> {
	T getValue();

	double getWeight();
}
