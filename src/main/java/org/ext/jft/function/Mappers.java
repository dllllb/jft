package org.ext.jft.function;

import java.util.List;

import org.ext.jft.container.Containers;

/**
 * @author Dmitri Babaev
 */
public class Mappers {
	
	public static <From> Mapper<From, String> toStringM() {
		return new Mapper<From, String>() {
			public String map(From from) {
				return from.toString();
			}
		};
	}
	
	public static <From> Mapper<From, Class<From>> toClassM() {
		return new Mapper<From, Class<From>>() {
			@SuppressWarnings("unchecked")
			public Class<From> map(From from) {
				return (Class<From>) from.getClass();
			}
		};
	}
	
	public static <T> Mapper<Factory<T>, T> constructM() {
		return new Mapper<Factory<T>, T>() {
			public T map(Factory<T> builder) {
				return builder.construct();
			}
		};
	}
	
	public static <From, E> Mapper<From, List<E>> newArrayListM() {
		return new Mapper<From, List<E>>() {
			public List<E> map(From from) {
				return Containers.arrayList();
			}
		};
	}
}
