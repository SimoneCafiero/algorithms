package com.intel.ile.java8.stream.exercise1;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StreamPreview {
	
	private static final Logger logger = LogManager.getLogger(StreamPreview.class);
	
	public static void main(String[] args) {
		List<String> words = Arrays.asList("hi", "hello", "bye", "goodbye");
		String s1 = words.stream()
				 		 .filter(word -> word.contains("o"))
				 		 .findFirst()
				 		 .orElse("Not found!");
		
		String s2 = words.stream()
						 .filter(word -> word.length() > 5)
						 .findFirst()
						 .orElse("Not found!");
		
		String s3 = words.stream()
						  .filter(word -> word.startsWith("h"))
						  .findFirst()
						  .orElse("Not found!");

		String s4 = words.stream()
						 .filter(word -> word.length() < 3)
						 .findAny()
						 .orElse("Not found!");
		
		String s5 = FunctionUtils.firstAllMatch(words.stream(),
										word -> word.contains("o"),
										word -> word.length() > 5);
		
		String s6 = FunctionUtils.firstAnyMatch(words.stream(),
								 		word -> word.contains("o"),
								 		word -> word.length() > 5);
		
		logger.info(s1);
		logger.info(s2);
		logger.info(s3);
		logger.info(s4);
		logger.info(s5);
		logger.info(s6);
	}
}