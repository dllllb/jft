package org.ext.jft.function;

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
}
