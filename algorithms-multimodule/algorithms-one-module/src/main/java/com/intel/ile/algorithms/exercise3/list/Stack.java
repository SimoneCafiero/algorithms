package com.intel.ile.algorithms.exercise3.list;

import java.util.StringJoiner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.intel.ile.algorithms.exercise3.iterator.Iterable;
import com.intel.ile.algorithms.exercise3.iterator.Iterator;

public class Stack<E> implements Iterable<E>{
	
	private static final Logger logger = LogManager.getLogger(Stack.class);
	
	private Node<E> first;
	
	public void push(E element){
		Node<E> old = first;
		first = new Node<E>();
		first.value = element;
		first.next = old;
	}
	
	public E pop(){
		E value = first.value;
		first = first.next;
		return value;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public String toString(){
		StringJoiner stringJoiner = new StringJoiner("-");
		Node<E> node = first;
		while(node != null){
			stringJoiner.add(node.value.toString());
			node = node.next;
		}
		return stringJoiner.toString();
	}
	
	private class Node<T>{
		T value;
		Node<T> next;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<E> {

		private Node<E> current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			E element = current.value;
			current = current.next;
			return element;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}		
	}
	
	public static void main(String ... args){
		String [] elements = new String[]{"first", "second", "third"};
		Stack<String> stack = new Stack<>();
		for(String s: elements){
			stack.push(s);
		}
		logger.info("The stack structure is: {}", stack.toString());
		logger.info("Popping element: {}", stack.pop());
		logger.info("The stack structure is: {}", stack.toString());
	}
}