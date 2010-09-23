package org.ext.jft.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ext.jft.container.Option;

/**
 * @author Dmitri Babaev
 */
public class RegExp {
	public static Option<String> find(Pattern pattern, String input) {
		Matcher m = pattern.matcher(input);
		if (!m.find())
			return Option.none();
		else
			return Option.some(m.group());
	}

	public static Option<String> find(String pattern, String input) {
		return find(Pattern.compile(pattern), input);
	}
}
