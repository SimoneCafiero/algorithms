package com.intel.ile.algorithms.exercise1;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuickFind {

	private static final Logger logger = LogManager.getLogger(QuickFind.class);
	
	private final int[] array;
	
	public QuickFind(int size){
		if(size <= 0) throw new IllegalArgumentException();
		this.array = new int[size];
		for(int i = 0; i < this.array.length; i++)
			this.array[i] = i;
	}
	
	public void union(int from, int to){
		if(from < 0 || from >= array.length || from == to) return;
		if(to < 0 || to >= array.length) return;
		
		int fromValue = array[Math.min(from, to)];
		int toValue = array[Math.max(from, to)];
		for(int i = 0; i < array.length; i++){
			array[i] = (array[i] == toValue)? fromValue : array[i];
		}
	}
	
	public boolean connected(int from, int to){
		if(from < 0 || from >= array.length) return false;
		if(to < 0 || to >= array.length) return false;
		return array[from] == array[to];
	}
	
	public String toString(){
		return Arrays.toString(array);
	}
	
	public static void main(String ... args){
		logger.info("Quick find basic implementation");
		QuickFind quickFind = new QuickFind(7);
		quickFind.union(0, 1);
		quickFind.union(1, 2);
		quickFind.union(3, 4);
		quickFind.union(4, 5);
		logger.info(quickFind.toString());
	}
}