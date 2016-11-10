package com.intel.ile.java8.stream.exercise1;

import java.util.function.Predicate;
import java.util.stream.Stream;

public final class FunctionUtils {

	private FunctionUtils(){}
	
	@SafeVarargs
	public static <T> Predicate<T> allPassPredicate(Predicate<T> ... predicates){
		Predicate<T> result = e -> true;
		for(Predicate<T> predicate: predicates){
			result = result.and(predicate);
		}
		return result;
	}
	
	@SafeVarargs
	public static <T> T firstAllMatch(Stream<T> stream, Predicate<T> ... predicates){
		Predicate<T> combined = allPassPredicate(predicates);
		return stream.filter(combined)
					 .findFirst()
					 .orElse(null);
	}
	
	@SafeVarargs
	public static <T> Predicate<T> anyPassPredicate(Predicate<T> ... predicates){
		Predicate<T> result = e -> false;
		for(Predicate<T> predicate: predicates){
			result = result.or(predicate);
		}
		return result;
	}
	
	@SafeVarargs
	public static <T> T firstAnyMatch(Stream<T> stream, Predicate<T> ... predicates){
		Predicate<T> combined = anyPassPredicate(predicates);
		return stream.filter(combined)
					 .findFirst()
					 .orElse(null);
	}
}