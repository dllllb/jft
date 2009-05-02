package org.ext.jft.lang;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.ext.jft.function.Factory;

/**
 * Option represents empty or one-element list
 * This class is similar to Scala Option class
 * See http://www.scala-lang.org/docu/files/api/scala/Option.html
 * @author Dmitri Babaev
 */
public abstract class Option<T> implements Iterable<T> {
	public abstract <E extends Throwable> T getOrThrow(E e) throws E;

	public abstract T getOrThrow(String message);

	public abstract T getOrElse(T elseRes);
	
	public abstract T getOrElse(Factory<T> factory);

	public abstract boolean isEmpty();

	public abstract boolean isDefined();

	/**
	 * Extract contained value from option container
	 * @return Contained object or none if empty
	 */
	public abstract T get();

	private static final class None<T> extends Option<T> {
		@SuppressWarnings("unchecked")
		public static final None NONE = new None();

		public <E extends Throwable> T getOrThrow(E e) throws E {
			throw e;
		}

		public T getOrThrow(String message) {
			throw new RuntimeException(message);
		}

		public boolean isEmpty() {
			return true;
		}

		public T get() {
			return null;
		}

		public T getOrElse(T elseRes) {
			return elseRes;
		}
		
		public T getOrElse(Factory<T> factory) {
			return factory.construct();
		}

		public boolean isDefined() {
			return false;
		}
		
		public Iterator<T> iterator() {
			return new Iterator<T>() {
				public boolean hasNext() {
					return false;
				}
				
				public T next() {
					throw new NoSuchElementException();
				}
				
				public void remove() {
					throw new UnsupportedOperationException();
				}
			};
		}
	}

	private static final class Some<T> extends Option<T> {
		private final T content;

		public Some(T content) {
			if (content == null)
				throw new IllegalArgumentException("option content can't be null");
			
			this.content = content;
		}

		public <E extends Throwable> T getOrThrow(E e) throws E {
			return content;
		}

		public T getOrThrow(String message) {
			return content;
		}

		public boolean isEmpty() {
			return false;
		}

		public T get() {
			return content;
		}

		public T getOrElse(T elseRes) {
			return content;
		}
		
		public T getOrElse(Factory<T> factory) {
			return content;
		}

		public boolean isDefined() {
			return true;
		}
		
		public Iterator<T> iterator() {
			return new Iterator<T>() {
				private boolean extracted = false;
				
				public boolean hasNext() {
					return !extracted;
				}
				
				public T next() {
					if (extracted) throw new NoSuchElementException();
					extracted = true;
					return content;
				}
				
				public void remove() {
					throw new UnsupportedOperationException();
				}
			};
		}
	}

	public static <T> Option<T> some(T content) {
		return new Some<T>(content);
	}

	@SuppressWarnings("unchecked")
	public static <T> Option<T> none() {
		return None.NONE;
	}

	public static <T> Option<T> notNull(T x) {
		if (x != null)
			return some(x);
		else
			return none();
	}

	public static Option<String> notEmpty(String s) {
		if (s != null && s.length() > 0)
			return some(s);
		else
			return none();
	}
}
