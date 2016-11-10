package com.intel.ile.java8.stream.exercise5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasicStream {

	private static final Logger logger = LogManager.getLogger(BasicStream.class);
	
	public static void main(String ... args) {
		List<Double> listOfDoubles = BasicStream.createList(100);
		double average = BasicStream.average(listOfDoubles);
		
		logger.info(listOfDoubles);
		logger.info(average);
		
		List<Double> listOfDoublesWithCutoff = BasicStream.createList(100, 0.5);
		double averageWithCutoff = BasicStream.average(listOfDoublesWithCutoff);
		
		logger.info(listOfDoublesWithCutoff);
		logger.info(averageWithCutoff);
		
		List<Double> doubledList = doubleValuesList(listOfDoubles);
		logger.info(doubledList);
		
		List<Double> sortedList = listOfDoubles.stream().sorted().collect(Collectors.toList());
		logger.info(sortedList);
	}
	
	public static List<Double> createList(int size){
		return Stream.generate(Math::random).limit(size).collect(Collectors.toList());
	}
	
	public static List<Double> createList(int size, double cutoff){
		return Stream.generate(Math::random).filter(d -> d >= cutoff).limit(size).collect(Collectors.toList());
	}
	
	public static List<Double> doubleValuesList(List<Double> list){
		return list.stream().map(d -> d * 2).collect(Collectors.toList());
	}
	
	public static double average(List<Double> list){
		return list.stream().mapToDouble( d -> d.doubleValue()).average().orElse(Double.NaN);
	}
}