package com.intel.ile.algorithms.exercise3.array;

import java.util.StringJoiner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.intel.ile.algorithms.exercise3.iterator.Iterable;
import com.intel.ile.algorithms.exercise3.iterator.Iterator;

public class Stack<E> implements Iterable<E>{

	private static final Logger logger = LogManager.getLogger(Stack.class);
	
	private int size;
	private E[] elements;

	@SuppressWarnings("unchecked")
	public Stack(){
		this.size = 0;
		this.elements = (E[]) new Object[10];
	}

	@SuppressWarnings("unchecked")
	public Stack(int capacity){
		this.size = 0;
		this.elements = (E[]) new Object[capacity];
	}

	private boolean isFull(){
		return size == elements.length;
	}
	
	private boolean isOneQuarterFull(){
		return size == elements.length / 4;
	}

	@SuppressWarnings("unchecked")
	private void doubleCapacity(){
		E[] elements = (E[]) new Object[this.elements.length * 2];
		System.arraycopy(this.elements, 0, elements, 0, this.elements.length);
		this.elements = elements;
	}
	
	@SuppressWarnings("unchecked")
	private void halveCapacity(){
		E[] elements = (E[]) new Object[this.elements.length / 2];
		System.arraycopy(this.elements, 0, elements, 0, elements.length);
		this.elements = elements;
	}

	public void push(E element){
		if(isFull()) doubleCapacity();
		elements[size] = element;
		size++;
	}

	public E pop(){
		if(isEmpty()) throw new IllegalStateException();
		E element = elements[size - 1];
		elements[size - 1] = null;
		size--;
		if(isOneQuarterFull()) halveCapacity();
		return element;
	}

	public boolean isEmpty(){
		return size == 0;
	}
	
	public String toString(){
		StringJoiner joiner = new StringJoiner("-");
		for(int i = size - 1; i >= 0; i--)
			joiner.add(elements[i].toString());
		return joiner.toString();
	}

	@Override
	public Iterator<E> iterator() {
		return new ReverseStackIterator();
	}
	
	private class ReverseStackIterator implements Iterator<E>{

		private int index = size;
		
		@Override
		public boolean hasNext() {
			return index > 0;
		}

		@Override
		public E next() {
			return elements[--index];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}		
	}
	
	public static void main(String ... args){
		String [] elements = new String[]{"first", "second", "third", "fourth",};
		Stack<String> stack = new Stack<>();
		for(String s: elements){
			stack.push(s);
		}
		logger.info("The stack structure is: {}", stack.toString());
		logger.info("Popping element: {}", stack.pop());
		logger.info("Popping element: {}", stack.pop());
		logger.info("Popping element: {}", stack.pop());
		logger.info("The stack structure is: {}", stack.toString());
	}
}