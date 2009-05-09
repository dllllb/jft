package org.ext.jft.container;

import java.util.List;

/**
 * @author Dmitri Babaev
 */
public class CollectionsF {
	static <T> ListF<T> decorate(List<T> list) {
		return DecoratedList.decorate(list);
	}
}
