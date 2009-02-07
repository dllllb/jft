package org.ext.jft.container;

/**
 * @author Dmitri Babaev
 */
public interface Queue<T> {
	QueueNode<T> put(T value, double weight);

	T getValue();

	T pullValue();

	void decreaseWeight(QueueNode<T> iNode, double weight);

	boolean isEmpty();

	QueueNode<T> pullNode();

	QueueNode<T> getNode();
}
