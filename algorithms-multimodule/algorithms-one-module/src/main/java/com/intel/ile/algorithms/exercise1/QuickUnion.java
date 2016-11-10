package com.intel.ile.algorithms.exercise1;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuickUnion {

	private static final Logger logger = LogManager.getLogger(QuickUnion.class);
	
	private final int[] array;
	
	public QuickUnion(int size){
		if(size <= 0) throw new IllegalArgumentException();
		this.array = new int[size];
		for(int i = 0; i < this.array.length; i++)
			this.array[i] = i;
	}
	
	private int root(int i){
		while(i != array[i])
			i = array[i];
		return i;
	}
	
	public void union(int from, int to){
		if(from < 0 || from >= array.length || from == to) return;
		if(to < 0 || to >= array.length) return;
		
		int fromRoot = root(from);
		int toRoot = root(to);
		array[fromRoot] = toRoot;
	}
	
	public boolean connected(int from, int to){
		if(from < 0 || from >= array.length) return false;
		if(to < 0 || to >= array.length) return false;
		return root(from) == root(to);
	}
	
	public String toString(){
		return Arrays.toString(array);
	}
	
	public static void main(String ... args){
		logger.info("Quick find basic implementation");
		QuickUnion quickFind = new QuickUnion(10);
		quickFind.union(4, 3);
		quickFind.union(3, 8);
		quickFind.union(6, 5);
		quickFind.union(9, 4);
		logger.info(quickFind.toString());
	}
}