package hu.bme.mit.ftsrg.qea

import hu.bme.mit.ftsrg.qea.model.AbstractTransition
import hu.bme.mit.ftsrg.qea.model.Action
import hu.bme.mit.ftsrg.qea.model.Automaton
import hu.bme.mit.ftsrg.qea.model.ConstantBinding
import hu.bme.mit.ftsrg.qea.model.EpsilonTransition
import hu.bme.mit.ftsrg.qea.model.Event
import hu.bme.mit.ftsrg.qea.model.FixParameter
import hu.bme.mit.ftsrg.qea.model.FreeParameter
import hu.bme.mit.ftsrg.qea.model.ModelFactory
import hu.bme.mit.ftsrg.qea.model.ResetTimerAction
import hu.bme.mit.ftsrg.qea.model.SetTimerAction
import hu.bme.mit.ftsrg.qea.model.State
import hu.bme.mit.ftsrg.qea.model.TimerAction
import hu.bme.mit.ftsrg.qea.model.Token
import hu.bme.mit.ftsrg.qea.model.Transition
import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import java.util.Set
import java.util.Stack

class AutomatonExecutioner {
	static extension var ModelFactory factory = ModelFactory.eINSTANCE;
	var Automaton a
	var Object lock;
	var Set<AutomatonTimeoutTask> runningTimers


//	Token initialToken
	new(Automaton a) {
		this.lock = new Object
		this.a = a;
		this.runningTimers = new HashSet<AutomatonTimeoutTask>

		// initialize the first token
//		var initialToken = createToken // TODO add parameters later
//		initialToken.on = a.initialState
		epsilonClosure(a.initialState).forEach[it.tokens.add(createToken)]
	}

	def void pushEvent(Event event) {
		synchronized(lock) {
			val copyTo = new HashMap<Token, HashSet<AbstractTransition>>
			val oldTokens = new HashSet<Token>
			a.states.forEach[tokens.forEach[oldTokens.add(it)]]

			// We search for the tokens which should be moved
			for (state : a.states) {
				for (trans : state.outgoingTransitions.filter[it instanceof Transition]) { // The tokens shouldn't move on discrete transitions (such as this)
					if(transitionEnabled(trans, event)) {
						for (token : trans.from.tokens) { // There can be multiple tokens at a state, as they can have different timings
							if(copyTo.get(token) == null) copyTo.put(token, new HashSet())
							copyTo.get(token).add(trans) // save which tokens are needed to move on which transitions
						}
					}
				}
			}

			copyTo.forEach [ token, transitions |
				transitions.forEach [
					val newToken = copyToken(token)
					it.actions.forEach[it.executeOn(newToken)]
					it.to.tokens.add(newToken)

					// As the execution is nondeterministic, there could be Epsilon edges, and we need to calculate the epsilon-closure
					var stack = new Stack<Token>
					var eclosure = new HashSet<Token>
					stack.push(newToken)
					while(!stack.isEmpty()) {
						var t = stack.pop
						for (outGoingEpsilonTransition : t.on.outgoingTransitions.filter[it instanceof EpsilonTransition]) {
							val u = outGoingEpsilonTransition.to
							if(eclosure.map[it.on].findFirst[it == u] == null) { // if we didn't put a token at that place before
								val newToken2 = copyToken(t) // create a token
								newToken2.on = u // place it to the new state
								outGoingEpsilonTransition.actions.forEach[it.executeOn(newToken2) println("Action executed")] //execute all actions 
								eclosure.add(newToken2)
								stack.push(newToken2)
							}
						}
					}

				]

			]
			
			oldTokens.forEach[it.on = null]
			
//			reduceTokens
			
			println("Automaton " + a.name + "s state:")
			a.states.forEach[state | 
				if(state.tokens.length != 0)
					println("Token on " + state.id)
//				token.parameters.forEach[it.printParameter]
//				println("-------------") //TODO add parameters
			]

			
			a.states.filter[it.acceptor].forEach[
				if(it.tokens.length!= 0){
					println("A token has been accepted")
				}
			]
		}
	}
	
	def reduceTokens() {
		val tokens = new HashSet<Token>
		a.states.forEach[it.tokens.forEach[tokens.add(it)]]		
		val equivalents = new HashSet<HashSet<Token>> 
		tokens.forEach[token1 | tokens.forEach [token2 | 
			if(token1.on == token2.on){
				if((runningTimers.findFirst[it.subscribed.contains(token1)] == null && runningTimers.findFirst[it.subscribed.contains(token2)] == null)
																					|| 
					(hasSameRunningTimers(token1,token2))
				){
					var equivalent1 = equivalents.findFirst[it.contains(token1)]
					var equivalent2 = equivalents.findFirst[it.contains(token2)]
					if(equivalent1 == null && equivalent2 == null){
						var equivalent = new HashSet<Token>; equivalent.add(token1); equivalent.add(token2); equivalents.add(equivalent)
					}
					else if(equivalent1 != null && equivalent2 == null){
						equivalent1.add(token2)
					}
					else if(equivalent1 == null && equivalent2 != null){
						equivalent1.add(token2)
					}else{
						throw new AssertionError("This shouldn't happen")
					}
				} 
			}
		]]
		//remove all the tokens which are not needed
		equivalents.forEach[it.tail.forEach[token | token.on = null; runningTimers.filter[it.subscribed.contains(token)].forEach[it.unsubscribe(token)]]]
	}
	
	def hasSameRunningTimers(Token token1, Token token2) {
		var runningTimers1 = runningTimers.filter[it.subscribed.contains(token1)]
		var runningTimers2 = runningTimers.filter[it.subscribed.contains(token2)]
		for(timer1 : runningTimers1){
			if(runningTimers2.findFirst[it == timer1]==null){
				return false
			} 
		}
		for(timer2 : runningTimers2){
			if(runningTimers1.findFirst[it == timer2]==null){
				return false
			}
		}
		true
	}
	
	def dispatch void executeOn(Action action, Token token){
		throw new UnsupportedOperationException
	}
	
	def dispatch void executeOn(TimerAction action, Token token){
		throw new UnsupportedOperationException
	}
	
	def dispatch void executeOn(ResetTimerAction action, Token token){
		runningTimers.filter[it.symbolicTimer == action.timer && it.subscribed.contains(token) ].forEach[it.unsubscribe(token)] //TODO change the set to a map
	}
	
	def dispatch void executeOn(SetTimerAction action, Token token){
		new AutomatonTimeoutTask(token, action.timer, action.toValue, runningTimers, lock)
	}
	
	//FIXME refactor until this becomes a static method
	//XXX move to external utility class
	def protected copyToken(Token t){
		val token = createToken
		runningTimers.filter[it.subscribed.contains(t)].forEach[it.subscribe(token)] // timing
		//TODO parameters
		
		token
	}

	def tokenParametersMatchesEvent(Token token, Event event) {
		for (param : token.parameters) {
			// Either it is a fix parameter, and they dont match
			if(param instanceof FixParameter) {
				if(!event.parameters.findFirst[it.type == param.type].equals(param)) {
					return false
				}

			// Or it is a free parameter, and already excluded
			} else if(param instanceof FreeParameter) {
				if(param.excludedValues.contains((event.parameters.findFirst[it.type == param.type] as FixParameter).value)) {
					return false
				}
			}
		}
		// if there is no inconsistency it is true.
		true
	}

	def transitionEnabled(AbstractTransition transition, Event event) {
		// The transitions eventguard and the event ust have the same type
		if(transition.eventguard.type != event.type) return false;
		// And all of the constant bindings must match with the event. (These are independent from the tokens)
		transition.eventguard.bindings.filter[it instanceof ConstantBinding].
		forall[binding|val constBinding = (binding as ConstantBinding); constBinding.boundTo.value.equals(event.parameters.findFirst[it.type == constBinding.binds])]
	}

//	def initializeInitialToken(Token token) {
//		token.parameters.clear
//		for (symparam : a.symbolicTokenParameters) {
//			var toAdd = createFreeParameter
//			toAdd.type = symparam
//			token.parameters.add(toAdd)
//		}
//	}


// Util stuff
	def dispatch printParameter(FixParameter param) {
		println("FIX = " + param.value)
	}

	def dispatch printParameter(FreeParameter param) {
		print("FREE = {")
		for (value : param.excludedValues)
			print(value.toString + ", ")
		println("}")

	}

	public static def epsilonClosure(State s){
		var list = new ArrayList<State>
		list.add(s)
		epsilonClosure(list) 
	}
	
	public static def epsilonClosure(Iterable<State> input){
		var stack = new Stack<State>
		var res = new HashSet<State>
		for(state : input){
			stack.push(state)
			res.add(state)
		}
		while(!stack.isEmpty()){
			var t = stack.pop
			for(u : t.outgoingTransitions.filter[it instanceof EpsilonTransition].map[it.to]){
				if(!res.contains(u)){
					res.add(u)
					stack.push(u)
				}
			}
		}
		return res;
	}


}
