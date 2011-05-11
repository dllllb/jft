package org.ext.jft.function;

import java.util.List;

import org.ext.jft.container.Containers;
import org.ext.jft.tool.AnyType;

/**
 * @author Dmitri Babaev
 */
public class Mappers {
	
	public static <From> Mapper<From, String> toStringM() {
		return new Mapper<From, String>() {
			public String apply(From from) {
				return from.toString();
			}
		};
	}
	
	public static <From> Mapper<From, Class<From>> toClassM() {
		return new Mapper<From, Class<From>>() {
			public Class<From> apply(From from) {
				@SuppressWarnings("unchecked")
				Class<From> res = (Class<From>) from.getClass();
				return res;
			}
		};
	}
	
	public static <T> Mapper<Factory<T>, T> constructM() {
		return new Mapper<Factory<T>, T>() {
			public T apply(Factory<T> builder) {
				return builder.produce();
			}
		};
	}
	
	public static <From, E> Mapper<From, List<E>> newArrayListM() {
		return new Mapper<From, List<E>>() {
			public List<E> apply(From from) {
				return Containers.arrayList();
			}
		};
	}
	
	public static <T> Mapper<T, T> selfMapper() {
		return new Mapper<T, T>() {
			public T apply(T from) {
				return from;
			}
		};
	}
	
	public static <F, T> Mapper<F, T> castMapper() {
		return new Mapper<F, T>() {
			public T apply(F from) {
				return AnyType.cast(from);
			}
		};
	}
}
