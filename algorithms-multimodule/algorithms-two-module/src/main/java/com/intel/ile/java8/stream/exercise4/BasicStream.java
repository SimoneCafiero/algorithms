package com.intel.ile.java8.stream.exercise4;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasicStream {

	private static final Logger logger = LogManager.getLogger(BasicStream.class);
	
	public static void main(String ... args) {
		double[] randoms = new Random().doubles(10000).toArray();
		
		double squareRootSum = DoubleStream.of(randoms).map(Math::sqrt).sum();
		double parallelSquareRootSum = DoubleStream.of(randoms).parallel().map(Math::sqrt).sum();
	
		logger.info(squareRootSum);
		logger.info(parallelSquareRootSum);
		
		double sequentialTime = Operation.time(() -> DoubleStream.of(randoms).map(Math::sqrt).sum());
		double parallelTime = Operation.time(() -> DoubleStream.of(randoms).parallel().map(Math::sqrt).sum());
				
		logger.info(sequentialTime);
		logger.info(parallelTime);
		
		double[] fiveElements = BasicStream.createDoubleStream(10).limit(5).toArray();
		List<Double> tenElementsList = BasicStream.createStream(10).limit(10).collect(Collectors.toList());
		Double[] twentyElementsArray = BasicStream.createStream(10).limit(20).toArray(Double[]::new);
		
		logger.info(fiveElements);
		logger.info(tenElementsList);
		logger.info(twentyElementsArray);
	}
	
	public static DoubleStream createDoubleStream(double max){
		return DoubleStream.generate(() -> Math.random() * max);
	}
	
	public static Stream<Double> createStream(double max){
		return Stream.generate(() -> Math.random() * max);
	}
}