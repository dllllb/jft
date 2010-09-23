package org.ext.jft.tool;

public class AnyType {
	/**
	 * This helper method uses type inference to omit the type declaration which is required for the cast operator
	 */
	@SuppressWarnings("unchecked")
	public static <V> V cast(Object value) {
		return (V)value;
	}
}
