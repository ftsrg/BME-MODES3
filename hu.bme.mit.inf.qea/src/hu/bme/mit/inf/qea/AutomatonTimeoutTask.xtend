package hu.bme.mit.inf.qea

import EventAutomatonModel.SymbolicTimer
import EventAutomatonModel.Token
import EventAutomatonModel.Transition
import java.util.HashSet
import java.util.Set
import java.util.concurrent.TimeUnit

class AutomatonTimeoutTask implements Runnable {
	var Set<Token> subscribedTokens
	var Object lock
	SymbolicTimer timer
	Set<AutomatonTimeoutTask> registry

	new(Token t, SymbolicTimer timer, int timeoutValue, Set<AutomatonTimeoutTask> registry,  Object lock) {
		AutomatonTimerScheduler.INSTANCE.schedule(this, timeoutValue, TimeUnit.MILLISECONDS) 
		this.registry = registry
		registry.add(this)
		this.subscribedTokens = new HashSet<Token>
		subscribedTokens.add(t)
		this.timer = timer
		this.lock = lock
	}

	public def subscribe(Token t) {
		this.subscribedTokens.add(t)
	}

	public def unsubscribe(Token t) {
		this.subscribedTokens.remove(t)
	}
	
	public def getSubscribed(){
		subscribedTokens
	}
	
	public def getSymbolicTimer(){
		timer
	}

	override run() {
		println("Egy idozito lejart!!")
		synchronized (lock){
			if(!subscribedTokens.empty){
				println("Volt subscribed token")
				for (token : subscribedTokens) {
					var activeEdge = token.on.outgoingTransitions.filter[it instanceof Transition].filter[(it as Transition).eventguard.type==this.timer.timeoutEvent].head
					if(activeEdge != null){
						println("A timer activated and throwing the token away :)")
						token.on = activeEdge.to
					}
				}
			}
			registry.remove(this)	
		}
	}
}
