package org.ext.jft.container.impl;

import static org.ext.jft.container.Containers.hashSet;

import java.util.Set;

import org.ext.jft.container.SetF;
import org.ext.jft.function.Mapper;
import org.ext.jft.function.Predicate;

/**
 * @author Dmitri Babaev
 */
public abstract class AbstractSetF<E> extends AbstractCollectionF<E> implements SetF<E> {

	public SetF<E> difference(Set<E> right) {
		SetF<E> res = union(right);
		res.removeAll(intersection(right));
		return res;
	}

	@Override
	public SetF<E> filter(Predicate<E> predicate) {
		SetF<E> res = hashSet();

		for (E val : this) {
			if (predicate.test(val))
				res.add(val);
		}
		return res;
	}

	public SetF<E> intersection(Set<E> right) {
		SetF<E> res = hashSet(this);
		res.retainAll(right);
		return res;
	}

	@Override
	public <To> SetF<To> map(Mapper<E, To> mapper) {
		SetF<To> res = hashSet();

		for (E from : this) {
			res.add(mapper.map(from));
		}
		return res;
	}

	public SetF<E> union(Set<E> right) {
		SetF<E> res = hashSet(this);
		res.addAll(right);
		return res;
	}
}
