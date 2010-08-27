package org.ext.jft.tool;

public class Cast {
	@SuppressWarnings("unchecked")
	public static <To> To uncheckedCast(Object value) {
		return (To) value;
	}
}
