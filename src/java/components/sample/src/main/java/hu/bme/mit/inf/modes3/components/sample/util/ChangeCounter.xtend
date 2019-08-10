package hu.bme.mit.inf.modes3.components.sample.util

import java.util.concurrent.atomic.AtomicInteger

/**
 * A thread-safe counter.
 * 
 * @author benedekh
 */
class ChangeCounter {

	val AtomicInteger numberOfChanges

	/**
	 * Creates a new counter with initial value {@link AtomicInteger#AtomicInteger()}.
	 */
	new() {
		numberOfChanges = new AtomicInteger
	}

	/**
	 * Increments the value of the counter by one.
	 */
	def increment() {
		numberOfChanges.incrementAndGet
	}
	
	/**
	 * Resets the counter for value 1.
	 */
	def reset(){
		numberOfChanges.set(1)
	}
}
