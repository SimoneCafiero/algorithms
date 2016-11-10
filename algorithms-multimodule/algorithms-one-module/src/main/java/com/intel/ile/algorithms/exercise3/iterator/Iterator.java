package com.intel.ile.algorithms.exercise3.iterator;

public interface Iterator<E> {
	
	boolean hasNext();
	E next();
	void remove();
}