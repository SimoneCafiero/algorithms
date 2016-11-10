package com.intel.ile.algorithms.exercise1;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WeightedQuickUnionCompressed {

	private static final Logger logger = LogManager.getLogger(WeightedQuickUnionCompressed.class);
	
	private final int[] elements;
	private final int[] sizes;
	
	public WeightedQuickUnionCompressed(int size){
		if(size <= 0) throw new IllegalArgumentException();
		this.elements = new int[size];
		this.sizes = new int[size];
		for(int i = 0; i < this.elements.length; i++)
			this.elements[i] = i;
	}
	
	private int root(int i){
		while(i != elements[i]){
			elements[i] = elements[elements[i]];
			i = elements[i];
		}
		return i;
	}
	
	public void union(int from, int to){
		if(from < 0 || from >= elements.length || from == to) return;
		if(to < 0 || to >= elements.length) return;
		
		int fromRoot = root(from);
		int toRoot = root(to);
		if(fromRoot == toRoot) return;
		if(sizes[fromRoot] < sizes[toRoot]){
			elements[fromRoot] = toRoot;
			sizes[fromRoot] += sizes[toRoot];
		}else{
			elements[toRoot] = fromRoot;
			sizes[toRoot] += sizes[fromRoot];
		}		
	}
	
	public boolean connected(int from, int to){
		if(from < 0 || from >= elements.length) return false;
		if(to < 0 || to >= elements.length) return false;
		return root(from) == root(to);
	}
	
	public String toString(){
		return Arrays.toString(elements);
	}
	
	public static void main(String ... args){
		logger.info("Quick find basic implementation");
		WeightedQuickUnionCompressed quickFind = new WeightedQuickUnionCompressed(10);
		quickFind.union(4, 3);
		quickFind.union(3, 8);
		quickFind.union(6, 5);
		quickFind.union(9, 4);
		logger.info(quickFind.toString());
	}
}