package org.ext.jft.container.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ext.jft.container.IteratorF;

/**
 * @author Dmitri Babaev
 */
public class ResultSetIterator implements IteratorF<ResultSet> {
	private ResultSet resultSet;
	
	public ResultSetIterator(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	
	public IteratorF<ResultSet> iterator() {
		return this;
	}

	public boolean hasNext() {
		try {
			return !resultSet.isClosed() && !resultSet.isLast() && !resultSet.isAfterLast();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ResultSet next() {
		try {
			resultSet.next();
			return resultSet;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove() {
		throw new UnsupportedOperationException();
	};
}
