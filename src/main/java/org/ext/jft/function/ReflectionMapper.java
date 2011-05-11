package org.ext.jft.function;

import java.lang.reflect.Method;

import org.ext.jft.container.Containers;

public class ReflectionMapper<From, To> extends Mapper<From, To> {
	private String methodName;
	private Object[] params;
	
	public static <From, To> ReflectionMapper<From, To> newInstance(String methodName, Object... params) {
		return new ReflectionMapper<From, To>(methodName, params);
	}
	
	public ReflectionMapper(String methodName, Object... params) {
		this.methodName = methodName;
		this.params = params;
	}
	
	public To apply(From from) {
		try {
			Class<?> clazz = from.getClass();
			Class<?>[] paramClasses = getParamClasses();
			Method method = clazz.getMethod(methodName, paramClasses);
			@SuppressWarnings("unchecked")
			To res = (To)method.invoke(from, params);
			return res;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	};
	
	private Class<?>[] getParamClasses() {
		return Containers.asList(params).map(Mappers.toClassM()).toArrayList().toArray(new Class[0]);
	}
}
