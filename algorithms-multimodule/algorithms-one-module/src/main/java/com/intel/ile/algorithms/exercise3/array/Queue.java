package com.intel.ile.algorithms.exercise3.array;

import java.util.StringJoiner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Queue<E>{

	private static final Logger logger = LogManager.getLogger(Queue.class);
	
	private int size;
	private E[] elements;

	@SuppressWarnings("unchecked")
	public Queue(){
		this.size = 0;
		this.elements = (E[]) new Object[10];
	}

	@SuppressWarnings("unchecked")
	public Queue(int capacity){
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

	public void enqueue(E element){
		if(isFull()) doubleCapacity();
		elements[size] = element;
		size++;
	}

	public E dequeue(){
		if(isEmpty()) throw new IllegalStateException();
		E element = elements[0];
		for(int i = 0; i < size - 1; i ++ )
			elements[i] = elements[i+1];
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
		for(int i = 0; i < size; i++)
			joiner.add(elements[i].toString());
		return joiner.toString();
	}

	public static void main(String ... args){
		String [] elements = new String[]{"first", "second", "third", "fourth",};
		Queue<String> queue = new Queue<String>();
		for(String s: elements){
			queue.enqueue(s);
		}
		logger.info("The queue structure is: {}", queue.toString());
		logger.info("Popping element: {}", queue.dequeue());
		logger.info("Popping element: {}", queue.dequeue());
		logger.info("Popping element: {}", queue.dequeue());
		logger.info("The queue structure is: {}", queue.toString());
	}
}