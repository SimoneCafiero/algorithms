package com.intel.ile.java8.stream.exercise2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasicStream {

	private static final Logger logger = LogManager.getLogger(BasicStream.class);

	public static void main(String ... args){
		List<String> words = Arrays.asList("hi", "hello", "bye", "goodbye");

		words.forEach(word -> logger.info("  " + word));
		words.forEach(logger::info);

		List<String> excitingWords = words.stream().map(word -> word + "!").collect(Collectors.toList());
		List<String> eyeWords = words.stream().map(word -> word.replace("i", "eye")).collect(Collectors.toList());
		List<String> upperCaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
		
		logger.info(excitingWords);
		logger.info(eyeWords);
		logger.info(upperCaseWords);
		
		List<String> shortWords = words.stream().filter(word -> word.length() < 4).collect(Collectors.toList());
		List<String> wordsWithB = words.stream().filter(word -> word.contains("b")).collect(Collectors.toList());
		List<String> evenLengthWords = words.stream().filter(word -> (word.length() % 2) == 0).collect(Collectors.toList());
	
		logger.info(shortWords);
		logger.info(wordsWithB);
		logger.info(evenLengthWords);
		
		String firstWordE = BasicStream.calculateString(words, "E");
		String firstWordQ = BasicStream.calculateString(words, "Q");
	
		logger.info(firstWordE);
		logger.info(firstWordQ);
		
		String[] upperCaseWordsArray = words.stream().map(String::toUpperCase).toArray(String[]::new);
		logger.info(Arrays.toString(upperCaseWordsArray));
	}
	
	private static String calculateString(List<String> words, String sequence){
		String word = words.stream().map(String::toUpperCase)
									.filter(w -> w.length() < 4)
									.filter(w -> w.contains(sequence))
									.findFirst()
									.orElse("Not found!");
		return word;
	}
}