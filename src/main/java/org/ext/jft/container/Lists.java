package org.ext.jft.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ext.jft.function.Combiner;
import org.ext.jft.function.Mapper;
import org.ext.jft.function.Predicate;
import org.ext.jft.function.Separator;

/**
 * List operations utility class
 * @author Dmitri Babaev
 */
public class Lists {
	static public <Value> Option<Value> getFrontOption(List<Value> list) {
		if (list.isEmpty())
			return Option.none();
		return Option.some(list.get(0));
	}

	static public <Key, Value, Ex extends Throwable> Value getFrontOrThrow(
			List<Value> list, Ex ex) throws Ex {
		return getFrontOption(list).getOrThrow(ex);
	}

	static public <Value> Value getFrontOrElse(List<Value> list, Value elseVal) {
		return getFrontOption(list).getOrElse(elseVal);
	}

	static public <From, To> List<To> map(List<From> collection,
			Mapper<From, To> mapper) {
		List<To> res = arrayList();

		for (From from : collection) {
			res.add(mapper.map(from));
		}
		return res;
	}

	static public <T> List<T> filter(List<T> collection, Predicate<T> predicate) {
		List<T> res = arrayList();

		for (T val : collection) {
			if (predicate.test(val))
				res.add(val);
		}
		return res;
	}

	static public <T> T reduce(List<T> list, Combiner<T, T, T> combiner,
			T initial) {
		T res = initial;
		for (T val : list) {
			res = combiner.combine(res, val);
		}
		return res;
	}

	static public <T> Set<T> unique(List<T> collection) {
		return Sets.hashSet(collection);
	}

	static public <T> List<T> arrayList(T... values) {
		return arrayList(Arrays.asList(values));
	}
	
	static public <T> List<T> linkedList(T... values) {
		return linkedList(Arrays.asList(values));
	}

	static public <T> List<T> arrayList(List<T> values) {
		return new ArrayList<T>(values);
	}
	
	static public <T> List<T> arrayList(Iterable<T> iterable) {
		List<T> list = Lists.arrayList();
		for (T t : iterable)
			list.add(t);
		return list;
	}
	
	static public <T> List<T> linkedList(List<T> values) {
		return new LinkedList<T>(values);
	}

	public static <T> List<T> arrayList() {
		return new ArrayList<T>();
	}
	
	public static <T> List<T> linkedList() {
		return new LinkedList<T>();
	}

	public static <T, B extends Comparable<Object>> List<T> sortBy(
			List<T> list, final Mapper<T, B> mapper) {
		List<T> res = arrayList(list);
		Collections.sort(res, new Comparator<T>() {
			public int compare(T o1, T o2) {
				return mapper.map(o1).compareTo(mapper.map(o2));
			}
		});
		return res;
	}

	public static <MapKey, MapValue, ListValue> Map<MapKey, MapValue> toMap(
			List<ListValue> list,
			Separator<ListValue, MapKey, MapValue> separator) {
		Map<MapKey, MapValue> map = Maps.hashMap();

		for (ListValue val : list) {
			Pair<MapKey, MapValue> pair = separator.separate(val);
			map.put(pair.first(), pair.second());
		}

		return map;
	}

	public static <Key, Value> Map<Key, Value> toMapMappingToKey(
			List<Value> list, final Mapper<Value, Key> mapper) {
		Separator<Value, Key, Value> separator = new Separator<Value, Key, Value>() {
			public Pair<Key, Value> separate(Value from) {
				return Pair.create(mapper.map(from), from);
			}
		};

		return toMap(list, separator);
	}
	
	public static <T> Option<T> getRandomValue(List<T> list) {
		int size = list.size();
		int n = (int) Math.random() * size;
		return n < size ? Option.<T> some(list.get(n)) : Option.<T> none();
	}
}
