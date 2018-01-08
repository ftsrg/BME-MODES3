package hu.bme.mit.inf.modes3.components.sample.util

import java.util.concurrent.atomic.AtomicInteger

class ChangeCounter {

	val AtomicInteger numberOfChanges

	new() {
		numberOfChanges = new AtomicInteger
	}

	def increment() {
		numberOfChanges.incrementAndGet
	}
	
	def reset(){
		numberOfChanges.set(1)
	}
}
