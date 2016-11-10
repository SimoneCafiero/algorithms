package com.intel.ile.java8.stream.exercise4;

@FunctionalInterface
public interface Operation {
  void run();
  
  static double time(Operation operation) {
    long startTime = System.nanoTime();
    operation.run();
    long endTime = System.nanoTime();
    double oneBillion = 1_000_000_000;
    return (endTime - startTime)/oneBillion;
  }
}