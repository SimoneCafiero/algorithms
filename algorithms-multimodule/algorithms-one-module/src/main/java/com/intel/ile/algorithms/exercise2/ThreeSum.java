package com.intel.ile.algorithms.exercise2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreeSum {
	
	private static final Logger logger = LogManager.getLogger(ThreeSum.class);
	
	private ThreeSum(){}
	
	public static int count(int[] array){
		int count = 0;
		
		for(int i = 0; i < array.length; i++)
			for(int j = i + 1; j < array.length; j++)
				for(int k = j + 1; k < array.length; k++)
					if(array[i] + array[j] + array[k] == 0)
						count++;
		
		return count;
	}
	
	public static int sortedCount(int[] array){
		int count = 0;
		
		for(int i = 0; i < array.length; i++)
			for(int j = i + 1; j < array.length; j++){
				int index = BinarySearch.recursiveBinarySearch(array, j, array.length - 1, -(array[i] + array[j]));
				if( index > -1 && index != i && index != j)
					count++;
			}
		
		return count;
	}
	
	public static void main(String ... args){
		int countZero = ThreeSum.count(new int[]{0,1,2});
		int countTwo = ThreeSum.count(new int[]{0,10,20,-30,10});
		int countTwoBetter = ThreeSum.sortedCount(new int[]{-30, 0, 10, 10, 20});
		logger.info("Zero sum triples: {}", countZero);
		logger.info("Zero sum triples: {}", countTwo);
		logger.info("Zero sum triples: {}", countTwoBetter);
	}
}