package com.intel.ile.algorithms.exercise2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BinarySearch {
	
	private static final Logger logger = LogManager.getLogger(BinarySearch.class);
	
	private BinarySearch(){}
	
	public static int recursiveBinarySearch(int[] array, int min, int max, int element){
		if(min > max) return -1;
		int med = (max + min)/2;
		if(element == array[med]) return med;
		if(element < array[med]) return BinarySearch.recursiveBinarySearch(array, min, med - 1, element);
		return BinarySearch.recursiveBinarySearch(array, med + 1, max, element);
	}
	
	public static int iterativeBinarySearch(int[] array, int element){
		int min = 0;
		int max = array.length - 1;
		int med = (max + min) / 2; 
		
		while(min <= max){
			med = (max + min) / 2;
			if(array[med] == element) return med;
			if(array[med] < element) min = med + 1;
			if(array[med] > element) max = med - 1;
		}
		return -1;
	}
	
	public static void main(String ... args){
		int[] array = new int[]{0, 2, 4, 5};
		int indexRecursive = BinarySearch.recursiveBinarySearch(array, 0, array.length - 1, 4);
		int indexIterative = BinarySearch.iterativeBinarySearch(array, 4);
		logger.info("Element at: {}", indexRecursive);
		logger.info("Element at: {}", indexIterative);
	}

}
