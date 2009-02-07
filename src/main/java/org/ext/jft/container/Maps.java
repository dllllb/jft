package org.ext.jft.container;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

import org.ext.jft.function.Combiner;
import org.ext.jft.function.Mapper;
import org.ext.jft.lang.Option;

/**
 * @author Dmitri Babaev
 */
public class Maps {
	static public <Key, Value> Option<Value> getOption(Map<Key, Value> map,
			Key key) {
		Value res = map.get(key);
		if (res != null)
			return Option.some(res);
		return Option.none();
	}

	static public <Key, Value, Ex extends Throwable> Value getOrThrow(
			Map<Key, Value> map, Key key, Ex ex) throws Ex {
		return getOption(map, key).getOrThrow(ex);
	}

	static public <Key, Value> Value getOrThrow(Map<Key, Value> map, Key key,
			String exStr) {
		return getOption(map, key).getOrThrow(new NoSuchElementException(exStr));
	}

	static public <Key, Value> Value getOrElse(Map<Key, Value> map, Key key,
			Value elseVal) {
		return getOption(map, key).getOrElse(elseVal);
	}

	static public <Key, Value> Value getOrElse(Map<Key, Value> map, Key key,
			Mapper<Key, Value> factory) {
		Value res = map.get(key);
		if (res != null)
			return res;
		try {
			res = factory.map(key);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return res;
	}

	static public <Key, Value> Value getOrElseUpdate(Map<Key, Value> map,
			Key key, Value elseVal) {
		Value res = map.get(key);
		if (res != null)
			return res;

		map.put(key, elseVal);
		return elseVal;
	}

	static public <Key, Value> Value getOrElseUpdate(Map<Key, Value> map,
			Key key, Mapper<Key, Value> factory) {
		Value res = map.get(key);
		if (res != null)
			return res;

		try {
			res = factory.map(key);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		map.put(key, res);
		return res;
	}

	public static <K, V> Map<K, V> hashMap() {
		return new HashMap<K, V>();
	}

	static public <Key, Value, To> List<To> map(Map<Key, Value> map,
			Combiner<Key, Value, To> combiner) {
		List<To> res = Lists.arrayList();

		for (Entry<Key, Value> entry : map.entrySet())
			res.add(combiner.combine(entry.getKey(), entry.getValue()));

		return res;
	}
	
	static public <K, V> Map<K, V> hashMap(K[] keys, V[] values) {
		Map<K, V> res = hashMap();
		
		for (int i = 0; i < keys.length; ++i) {
			res.put(keys[i], values[i]);
		}
		
		return res;
	}

	private Maps() {
		assert false;
	}
}
