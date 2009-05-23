package org.ext.jft.container.impl;

import static org.ext.jft.container.Containers.hashSet;

import java.util.Set;

import org.ext.jft.container.SetF;

/**
 * @author Dmitri Babaev
 */
public abstract class AbstractSetF<E> extends AbstractCollectionF<E> implements SetF<E> {

	public SetF<E> difference(Set<E> right) {
		SetF<E> res = union(right);
		res.removeAll(intersection(right));
		return res;
	}

	public SetF<E> intersection(Set<E> right) {
		SetF<E> res = hashSet(this);
		res.retainAll(right);
		return res;
	}

	public SetF<E> union(Set<E> right) {
		SetF<E> res = hashSet(this);
		res.addAll(right);
		return res;
	}
}
