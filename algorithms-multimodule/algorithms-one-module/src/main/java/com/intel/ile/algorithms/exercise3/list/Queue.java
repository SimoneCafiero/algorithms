package com.intel.ile.algorithms.exercise3.list;

import java.util.StringJoiner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Queue<E> {
	
	private static final Logger logger = LogManager.getLogger(Queue.class);
	
	private Node<E> first, last;
	
	public void enqueue(E element){
		Node<E> old = last;
		last = new Node<E>();
		last.value = element;
		last.next = null;
		if(isEmpty()) first = last;
		else old.next = last;
	}
	
	public E dequeue(){
		if(first == null) throw new IllegalStateException();
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
	
	public static void main(String ... args){
		String [] elements = new String[]{"first", "second", "third"};
		Queue<String> queue = new Queue<>();
		for(String s: elements){
			queue.enqueue(s);
		}
		logger.info("The queue structure is: {}", queue.toString());
		logger.info("Dequeue element: {}", queue.dequeue());
		logger.info("The queue structure is: {}", queue.toString());
	}	
}