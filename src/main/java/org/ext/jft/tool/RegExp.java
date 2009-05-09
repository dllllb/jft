package org.ext.jft.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ext.jft.container.Option;

/**
 * @author Dmitri Babaev
 */
public class RegExp {
	public static Option<String> findFirstGroup(Pattern pattern, String input) {
		Matcher m = pattern.matcher(input);
		if (!m.find())
			return Option.none();
		else if (m.groupCount() < 1)
			return Option.none();
		else
			return Option.some(m.group(1));
	}

	public static Option<String> findFirstGroup(String pattern, String input) {
		return findFirstGroup(Pattern.compile(pattern), input);
	}
}
