package hu.bme.mit.ftsrg.ptregex

import com.google.inject.Injector
import hu.bme.mit.ftsrg.ptregex.regularExpression.Alphabet
import hu.bme.mit.ftsrg.ptregex.regularExpression.Any
import hu.bme.mit.ftsrg.ptregex.regularExpression.Choice
import hu.bme.mit.ftsrg.ptregex.regularExpression.Event
import hu.bme.mit.ftsrg.ptregex.regularExpression.ExpressionDeclaration
import hu.bme.mit.ftsrg.ptregex.regularExpression.Functor
import hu.bme.mit.ftsrg.ptregex.regularExpression.Inverse
import hu.bme.mit.ftsrg.ptregex.regularExpression.RegexModel
import hu.bme.mit.ftsrg.ptregex.regularExpression.Sequence
import hu.bme.mit.ftsrg.ptregex.regularExpression.Star
import hu.bme.mit.ftsrg.ptregex.regularExpression.TimedExpression
import hu.bme.mit.ftsrg.qea.model.AbstractTransition
import hu.bme.mit.ftsrg.qea.model.Automaton
import hu.bme.mit.ftsrg.qea.model.ComplexEventProcessor
import hu.bme.mit.ftsrg.qea.model.EpsilonTransition
import hu.bme.mit.ftsrg.qea.model.ModelFactory
import hu.bme.mit.ftsrg.qea.model.ResetTimerAction
import hu.bme.mit.ftsrg.qea.model.SetTimerAction
import hu.bme.mit.ftsrg.qea.model.State
import hu.bme.mit.ftsrg.qea.model.SymbolicEvent
import hu.bme.mit.ftsrg.qea.model.SymbolicInputEvent
import hu.bme.mit.ftsrg.qea.model.SymbolicTimeoutEvent
import hu.bme.mit.ftsrg.qea.model.Transition
import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import java.util.List
import java.util.Set
import java.util.Stack
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.StringInputStream
import hu.bme.mit.ftsrg.ptregex.regularExpression.Expression
import java.util.LinkedList

class RegexCompiler {
	static extension var ModelFactory factory = ModelFactory.eINSTANCE;

	val ArrayList<SymbolicInputEvent> symbolicEvents = new ArrayList<SymbolicInputEvent>()
	val HashMap<Functor, SymbolicEvent> symbolicEventMapping = new HashMap<Functor, SymbolicEvent>()
	val Set<Transition> transitionsToTrapState = new HashSet<Transition>

	def ComplexEventProcessor expressionToTGF(String input) {
		var Injector injector = new RegularExpressionStandaloneSetup().createInjectorAndDoEMFRegistration();
		val resourceSet = injector.getInstance(XtextResourceSet)
		val resource = resourceSet.createResource(URI.createURI("dummy:/temp.ptreg"))
		resource.load(new StringInputStream(input), #{})
		compile(resource.contents.get(0) as RegexModel)
	}

	def compile(RegexModel input) {
		println("Compilation starts")
		val retvalue = createComplexEventProcessor

		symbolicEventsFromAlphabet(input.alphabet) // we must set this before the compilation starts, the 		
		input.declarations.map[(recursiveCompile(it).toAutomaton)].forEach[retvalue.automata.add(it)] // TODO this is the point where we should determinize (after the recursive compile)
		symbolicEvents.forEach[retvalue.symbolicEvents.add(it)]

		retvalue.automata.forEach[var trapState = createState; it.states.add(trapState); it.trapState = trapState] // create trapstates
		retvalue.automata.forEach[automaton|automaton.states.forEach[state|transitionsToTrapState.forEach[if(it.from == state) it.to = automaton.trapState]]] // the timeout events must point to the trapstate
		var id = 0
		for (automaton : retvalue.automata) {
			for (state : automaton.states) {
				state.id = id++
			}
		}

		println("Compilation finished!")

		for (automaton : retvalue.automata) {
			println(automaton.automatonToYed)
		}
		retvalue
	}

	// XXX move this to an external utility class
	public static def String automatonToYed(Automaton automaton) {
		return '''
			Automaton «automaton.name»
			=========================
			
			«FOR state : automaton.states»
				«state.id» «state.id» «IF state.acceptor == true»acceptor «ELSEIF automaton.trapState == state» trap«ENDIF»«IF automaton.initialState == state» initial«ENDIF»
			«ENDFOR»
			#
			«FOR state : automaton.states»
				«FOR transition : state.outgoingTransitions»
				«transition.from.id» «transition.to.id»«IF transition instanceof EpsilonTransition» ε «ENDIF»«IF transition instanceof Transition»«IF transition.eventguard.type instanceof SymbolicInputEvent» «transition.eventguard.type.name»«ENDIF»«IF transition.eventguard.type instanceof SymbolicTimeoutEvent» « (transition.eventguard.type as SymbolicTimeoutEvent).timer.name» timeout«ENDIF»«ENDIF»
				«FOR action : transition.actions»
					actions=[ «IF action instanceof ResetTimerAction»Reset «action.timer.name»«ELSEIF action instanceof SetTimerAction»Set «(action as SetTimerAction).timer.name»«ENDIF» ]
				«ENDFOR»
				«ENDFOR»
			«ENDFOR»
			=========================
		'''
	}

	protected def symbolicEventsFromAlphabet(Alphabet alphabet) {
		for (letter : alphabet.functors) {
			var newSymbolicEvent = createSymbolicInputEvent
			newSymbolicEvent.name = letter.name;
			symbolicEvents.add(newSymbolicEvent)
			symbolicEventMapping.put(letter, newSymbolicEvent)
		}
	}

	protected def dispatch PartialAutomaton recursiveCompile(ExpressionDeclaration declaration) {
		var compiled = recursiveCompile(declaration.body)
		compiled.a.name = declaration.name
		compiled
	}

	protected def dispatch PartialAutomaton recursiveCompile(TimedExpression expression) {
		val compiled = recursiveCompile(expression.body)
		val timer = createSymbolicTimer
		timer.name = "t"
		val timeoutEvent = createSymbolicTimeoutEvent
		timer.timeoutEvent = timeoutEvent
		compiled.first.outgoingTransitions.forEach [
			var newAction = createSetTimerAction;
			newAction.timer = timer
			newAction.toValue = expression.timeout
		]
		compiled.last.incomingTransitions.forEach [
			var newAction = createResetTimerAction
			newAction.timer = timer
		]
		compiled.a.states.filter[it != compiled.first && it != compiled.last].forEach [
			val newTrans = createTransition
			newTrans.from = it
			newTrans.to = compiled.first

			transitionsToTrapState.add(newTrans)

			val newEventGuard = createEventGuard
			newEventGuard.type = timeoutEvent
			newTrans.eventguard = newEventGuard
		]
		compiled
	}

	protected def dispatch PartialAutomaton recursiveCompile(Any expression) {
		var retvalue = new PartialAutomaton();
		retvalue.first = createState
		retvalue.last = createState
		retvalue.a.states.add(retvalue.first)
		retvalue.a.states.add(retvalue.last)

		for (symbol : symbolicEvents) {
			var newTransition = createTransition
			newTransition.eventguard = createEventGuard
			newTransition.eventguard.type = symbol
			newTransition.from = retvalue.first
			newTransition.to = retvalue.last
		// TODO add parameters
		}

		retvalue
	}

	protected def dispatch PartialAutomaton recursiveCompile(Inverse expression) {
		var retvalue = new PartialAutomaton();
		retvalue.first = createState
		retvalue.last = createState
		retvalue.a.states.add(retvalue.first)
		retvalue.a.states.add(retvalue.last)

		val excludedLetters = expression.excludes.map[it.functor]
		var includedLetters = new ArrayList<Functor>
		for (possibleLetter : symbolicEventMapping.keySet) {
			if(!excludedLetters.contains(possibleLetter))
				includedLetters.add(possibleLetter)
		}
		var includedSymbols = new ArrayList<SymbolicEvent>
		for (letter : includedLetters) {
			includedSymbols.add(symbolicEventMapping.get(letter))
		}

		for (symbol : includedSymbols) {
			var newTransition = createTransition
			newTransition.eventguard = createEventGuard
			newTransition.eventguard.type = symbol
			newTransition.from = retvalue.first
			newTransition.to = retvalue.last
		// TODO add parameters
		}

		retvalue
	}

	protected def dispatch PartialAutomaton recursiveCompile(Event expression) {
		var retvalue = new PartialAutomaton();
		retvalue.first = createState
		retvalue.last = createState
		retvalue.a.states.add(retvalue.first)
		retvalue.a.states.add(retvalue.last)

		var transition = createTransition
		transition.from = retvalue.first
		transition.to = retvalue.last

		transition.eventguard = createEventGuard
		transition.eventguard.type = symbolicEventMapping.get(expression.functor)
		// TODO parameters
		retvalue
	}

	protected def dispatch PartialAutomaton recursiveCompile(Sequence expression) {
		var compiledExpressions = expression.elements.map[recursiveCompile(it)]
		compiledExpressions.tail.fold(compiledExpressions.head, [i, j|merge(i, j)])
	}

	protected def merge(PartialAutomaton firstAutomaton, PartialAutomaton secondAutomaton) {
		var List<AbstractTransition> outgoingFirst = secondAutomaton.first.outgoingTransitions.clone()
		var List<AbstractTransition> incomingFirst = secondAutomaton.first.incomingTransitions.clone()
		var List<State> secondStates = secondAutomaton.a.states.clone()

		for (state : secondStates) {
			firstAutomaton.a.states.add(state)
			secondAutomaton.a.states.remove(state)
		}

		for (transition : outgoingFirst) {
			firstAutomaton.last.outgoingTransitions.add(transition)
		}

		for (transition : incomingFirst) {
			firstAutomaton.last.incomingTransitions.add(transition)
		}

		firstAutomaton.a.states.remove(secondAutomaton.first)

		firstAutomaton.last = secondAutomaton.last

		return firstAutomaton
	}

	protected def dispatch PartialAutomaton recursiveCompile(Choice expression) {
		var first = recursiveCompile(expression.elements.head)

		var newFirst = createState
		var newLast = createState
		first.a.states.add(newFirst)
		first.a.states.add(newLast)
		var newTransBegin = createEpsilonTransition
		var newTransEnd = createEpsilonTransition

		newTransBegin.from = newFirst
		newTransBegin.to = first.first
		newTransEnd.from = first.last
		newTransEnd.to = newLast

		first.first = newFirst
		first.last = newLast

		for (expr : expression.elements.tail) {
			var compiled = recursiveCompile(expr)
			var beginTrans = createEpsilonTransition
			var endTrans = createEpsilonTransition

			var states = compiled.a.states.clone()

			for (state : states) {
				first.a.states.add(state)
				compiled.a.states.remove(state)
			}
			beginTrans.from = first.first
			beginTrans.to = compiled.first
			endTrans.from = compiled.last
			endTrans.to = first.last
		}

		return first
	}

	protected def dispatch PartialAutomaton recursiveCompile(Star expression) {
		var compiledAutomaton = recursiveCompile(expression.body)
		var first = createState
		var last = createState
		compiledAutomaton.a.states.add(first)
		compiledAutomaton.a.states.add(last)

		var beginEpsilon = createEpsilonTransition
		var endEpsilon = createEpsilonTransition
		var returnEpsilon = createEpsilonTransition
		var skipEpsilon = createEpsilonTransition

		beginEpsilon.from = first
		beginEpsilon.to = compiledAutomaton.first

		returnEpsilon.from = compiledAutomaton.last
		returnEpsilon.to = compiledAutomaton.first

		endEpsilon.from = compiledAutomaton.last
		endEpsilon.to = last

		skipEpsilon.from = first
		skipEpsilon.to = last

		compiledAutomaton.first = first
		compiledAutomaton.last = last

		compiledAutomaton
	}

	public static def epsilonClosure(State s) { // XXX move this to an external utility package
		var list = new ArrayList<State>
		list.add(s)
		epsilonClosure(list)
	}

	public static def epsilonClosure(Iterable<State> input) { // XXX move this to an external utility package
		var stack = new Stack<State>
		var res = new HashSet<State>
		for (state : input) {
			stack.push(state)
			res.add(state)
		}
		while(!stack.isEmpty()) {
			var t = stack.pop
			for (u : t.outgoingTransitions.filter[it instanceof EpsilonTransition].map[it.to]) {
				if(!res.contains(u)) {
					res.add(u)
					stack.push(u)
				}
			}
		}
		return res;
	}

	protected def move(Iterable<State> T, SymbolicEvent a) {
		var res = new HashSet<State>
		for (state : T) {
			var outGoingOnA = state.outgoingTransitions.filter[!(it instanceof EpsilonTransition)].filter[it.eventguard.type == a].head
			if(outGoingOnA != null) {
				res.add(outGoingOnA.to)
			}
		}
		return res;
	}

	protected def sameDFAState(Set<State> state1, Set<State> state2) {
		for (state : state1) {
			if(!state2.contains(state)) {
				return false
			}
		}

		for (state : state2) {
			if(!state1.contains(state)) {
				return false
			}
		}

		return true;
	}

	protected def Automaton determinize(Automaton NFA) {
		val DFA = createAutomaton

		val Dstates = new HashSet<HashSet<State>>
		val Dtrans = new HashMap<HashSet<State>, HashMap<SymbolicEvent, HashSet<State>>>
		val marked = new HashSet<HashSet<State>>
		var initialState = epsilonClosure(NFA.initialState)
		Dstates.add(initialState)

		while(!Dstates.map[marked.contains(it)].fold(true, [i, j|i && j])) {
			var T = Dstates.filter[!marked.contains(it)].head
			marked.add(T)
			for (symbol : symbolicEvents) {
				val U = epsilonClosure(move(T, symbol))
				var sameU = Dstates.filter[sameDFAState(it, U)].head
				if(sameU == null) {
					Dstates.add(U)
					sameU = U
				}
				if(Dtrans.get(T) == null) Dtrans.put(T, new HashMap<SymbolicEvent, HashSet<State>>)
				Dtrans.get(T).put(symbol, sameU)

			}
		}

		val Dstates2DFAStates = new HashMap<HashSet<State>, State>
		for (state : Dstates) {
			var newState = createState
			DFA.states.add(newState)
			Dstates2DFAStates.put(state, newState)
		}

		// TODO consider reusing the edges instead of the manual	 copy (which will be nasty when the parameters come)
		Dtrans.forEach[p1, p2|p2.forEach[p3, p4|var newTrans = createTransition newTrans.from = Dstates2DFAStates.get(p1) newTrans.to = Dstates2DFAStates.get(p4) newTrans.eventguard = createEventGuard newTrans.eventguard.type = p3]]

		DFA.initialState = Dstates2DFAStates.get(initialState)
		for (state : DFA.states) {
			if(Dstates2DFAStates.filter[i, j|j == state].keySet.head.filter[it.acceptor == true].length > 0)
				state.acceptor = true
		}

		return DFA
	}

	static def List<List<Integer>> generatePerm(List<Integer> left, List<Integer> right){
		val result = new LinkedList<List<Integer>> 
		if(left.head != null){
			generatePerm(left.tail.toList,right).forEach[
				val newRes = new LinkedList<Integer>; newRes.add(left.head); it.forEach[newRes.add(it)]; result.add(newRes)
			]
		}
		if(right.head != null){
			generatePerm(left,right.tail.toList).forEach[
				val newRes = new LinkedList<Integer>; newRes.add(right.head); it.forEach[newRes.add(it)]; result.add(newRes)
			]
		} if(right.head == null && left.head == null){
			result.add(new LinkedList<Integer>)
		}
		return result
	}
}

class PartialAutomaton {
	public State first;
	public State last;
	public Automaton a;

	new() {
		this.a = ModelFactory.eINSTANCE.createAutomaton
	}

	def toAutomaton() {
		a.initialState = first
		last.acceptor = true
		a
	}

}
