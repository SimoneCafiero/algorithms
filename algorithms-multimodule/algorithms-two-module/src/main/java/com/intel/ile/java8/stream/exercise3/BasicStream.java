package com.intel.ile.java8.stream.exercise3;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasicStream {

	private static final Logger logger = LogManager.getLogger(BasicStream.class);

	public static void main(String ... args){
		List<String> words = Arrays.asList("hi", "hello", "bye", "goodbye");

		String reduced = words.stream().reduce("", (s1, s2) -> s1 + s2.toUpperCase());
		String reducedWithMap = words.stream().map(String::toUpperCase).reduce("", (s1, s2) -> s1 + s2);
		String reducedCommas = words.stream().reduce((s1, s2) -> s1 + ", " + s2).orElse("At least two!");
		int totalSum = words.stream().mapToInt(w -> w.length()).sum();
		int wordsContainingH = words.stream().filter(w -> w.contains("h"))
											 .mapToInt(w -> w.length()).
											 sum();

		logger.info(reduced);
		logger.info(reducedWithMap);
		logger.info(reducedCommas);
		logger.info(totalSum);
		logger.info(wordsContainingH);
	}
}