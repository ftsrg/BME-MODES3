package hu.bme.mit.inf.ptregex2automaton

import EventAutomatonModel.Automaton
import EventAutomatonModel.EpsilonTransition
import EventAutomatonModel.EventAutomatonModelFactory
import EventAutomatonModel.ResetTimerAction
import EventAutomatonModel.SetTimerAction
import EventAutomatonModel.State
import EventAutomatonModel.SymbolicEvent
import EventAutomatonModel.SymbolicInputEvent
import EventAutomatonModel.SymbolicTimeoutEvent
import EventAutomatonModel.Transition
import hu.bme.mit.inf.parametricTimedRegularExpression.Alphabet
import hu.bme.mit.inf.parametricTimedRegularExpression.And
import hu.bme.mit.inf.parametricTimedRegularExpression.Any
import hu.bme.mit.inf.parametricTimedRegularExpression.Choice
import hu.bme.mit.inf.parametricTimedRegularExpression.Event
import hu.bme.mit.inf.parametricTimedRegularExpression.Expression
import hu.bme.mit.inf.parametricTimedRegularExpression.ExpressionDeclaration
import hu.bme.mit.inf.parametricTimedRegularExpression.Functor
import hu.bme.mit.inf.parametricTimedRegularExpression.Inverse
import hu.bme.mit.inf.parametricTimedRegularExpression.RegexModel
import hu.bme.mit.inf.parametricTimedRegularExpression.Sequence
import hu.bme.mit.inf.parametricTimedRegularExpression.Star
import hu.bme.mit.inf.parametricTimedRegularExpression.TimedExpression
import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import java.util.LinkedList
import java.util.List
import java.util.Set
import java.util.Stack
import org.eclipse.emf.ecore.util.EcoreUtil
import hu.bme.mit.inf.parametricTimedRegularExpression.NegExpression
import hu.bme.mit.inf.parametricTimedRegularExpression.Plus
import hu.bme.mit.inf.parametricTimedRegularExpression.Cardinality
import hu.bme.mit.inf.parametricTimedRegularExpression.ParametricTimedRegularExpressionFactory

class RegexCompiler {
	static extension var EventAutomatonModelFactory factory = EventAutomatonModelFactory.eINSTANCE;

	val ArrayList<SymbolicInputEvent> symbolicEvents = new ArrayList<SymbolicInputEvent>()
	val HashMap<Functor, SymbolicEvent> symbolicEventMapping = new HashMap<Functor, SymbolicEvent>()
	val Set<Transition> transitionsToTrapState = new HashSet<Transition>
	var timerCnt = 0
	public val tgfLogs = new HashMap<Automaton, StringBuilder>;
	public val log = new StringBuilder
	
	def void println(StringBuilder builder, String toAppend){
		builder.append(toAppend)
		builder.append('\n')
	}

	def compile(RegexModel input) {
		log.println("Compilation starts")
		val retvalue = createComplexEventProcessor
		symbolicEventsFromAlphabet(input.alphabet) // we must set this before the compilation starts, the 		
		input.declarations.map[recursiveCompile(it)].forEach[retvalue.automata.add(it)]

		symbolicEvents.forEach[retvalue.symbolicEvents.add(it)]

		retvalue.automata.forEach[var trapState = createState; it.states.add(trapState); it.trapState = trapState] // create trapstates
		retvalue.automata.forEach [automaton|
			automaton.states.forEach [state|
				transitionsToTrapState.forEach[if(it.from == state) it.to = automaton.trapState]
			]
		] // the timeout events must point to the trapstate
		
		
		var id = 0
		for (automaton : retvalue.automata) {
			for (state : automaton.states) {
				state.id = id++
			}
		}

		log.println("Compilation finished!")

		for (automaton : retvalue.automata) {
			tgfLogs.put(automaton, new StringBuilder)
			tgfLogs.get(automaton).println(automaton.automatonToYed)
		}
		retvalue
	}

	// XXX move this to an external utility class
	public static def String automatonToYed(Automaton automaton) {
		return '''
			9999999999 «automaton.name»
«««			=========================
			«FOR state : automaton.states»
				«state.id» «state.id» «IF state.acceptor == true» acceptor«ELSEIF automaton.trapState == state» trap« ELSEIF automaton.initialState == state» initial«ENDIF»
			«ENDFOR»
			#
			«FOR state : automaton.states»
				«FOR transition : state.outgoingTransitions»
				«transition.from.id» «transition.to.id»«IF transition instanceof EpsilonTransition» epsilon «ENDIF»«IF transition instanceof Transition»«IF transition.eventguard.type instanceof SymbolicInputEvent» «(transition.eventguard.type as SymbolicInputEvent).name»«ENDIF»«IF transition.eventguard.type instanceof SymbolicTimeoutEvent» « (transition.eventguard.type as SymbolicTimeoutEvent).timer.name» timeout«ENDIF»«ENDIF» «FOR action : transition.actions BEFORE ' actions = [ ' SEPARATOR ', ' AFTER ' ]'» «IF action instanceof SetTimerAction» set «action.timer.name»«ENDIF»«IF action instanceof ResetTimerAction» reset «action.timer.name»«ENDIF»«ENDFOR»
				«ENDFOR»
			«ENDFOR»
«««			=========================
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

	protected def dispatch Automaton recursiveCompile(ExpressionDeclaration declaration) {
		log.println("compiling " + declaration.name)
		var compiled = recursiveCompile(declaration.body)
		compiled.name = declaration.name
		log.println(declaration.name + ' compiled')
		compiled
	}
	
	protected def dispatch Automaton recursiveCompile(NegExpression expression){
		val compiled = expression.body.recursiveCompile
		compiled.states.forEach[it.acceptor = !it.acceptor]
		return compiled;
	}

	protected def dispatch Automaton recursiveCompile(TimedExpression expression) {
		val compiled = recursiveCompile(expression.body)
		val timer = createSymbolicTimer
		timer.name = "t" + (timerCnt++)
		val timeoutEvent = createSymbolicTimeoutEvent
		timer.timeoutEvent = timeoutEvent
		compiled.initialState.outgoingTransitions.forEach [
			var newAction = createSetTimerAction;
			newAction.timer = timer
			newAction.toValue = expression.timeout
			it.actions.add(newAction)
		]
		compiled.states.filter[it.acceptor].forEach[it.incomingTransitions.forEach [
			var newAction = createResetTimerAction
			newAction.timer = timer
			it.actions.add(newAction)
		]]
		
		compiled.states.filter[it != compiled.initialState && !it.acceptor].forEach [
			val newTrans = createTransition
			newTrans.from = it
			newTrans.to = compiled.initialState

			transitionsToTrapState.add(newTrans)

			val newEventGuard = createEventGuard
			newEventGuard.type = timeoutEvent
			newTrans.eventguard = newEventGuard
		]
		compiled
	}

	protected def dispatch Automaton recursiveCompile(Any expression) {
		var retvalue = createAutomaton;
		retvalue.initialState = createState
		var last = createState
		last.acceptor = true
		retvalue.states.add(retvalue.initialState)
		retvalue.states.add(last)

		for (symbol : symbolicEvents) {
			var newTransition = createTransition
			newTransition.eventguard = createEventGuard
			newTransition.eventguard.type = symbol
			newTransition.from = retvalue.initialState
			newTransition.to = last
		// TODO add parameters
		}

		retvalue
	}

	protected def dispatch Automaton recursiveCompile(Inverse expression) {
		var retvalue = createAutomaton
		retvalue.initialState = createState
		var last = createState
		last.acceptor = true
		retvalue.states.add(retvalue.initialState)
		retvalue.states.add(last)

		val excludedLetters = expression.excludes.map[it.functor]
		var includedLetters = new ArrayList<Functor>
		for (possibleLetter : symbolicEventMapping.keySet) {
			if (!excludedLetters.contains(possibleLetter))
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
			newTransition.from = retvalue.initialState
			newTransition.to = last
		// TODO add parameters
		}

		retvalue
	}

	protected def dispatch Automaton recursiveCompile(Event expression) {
		var retvalue = createAutomaton
		retvalue.initialState = createState
		var last = createState
		last.acceptor = true
		retvalue.states.add(retvalue.initialState)
		retvalue.states.add(last)

		var transition = createTransition
		transition.from = retvalue.initialState
		transition.to = last

		transition.eventguard = createEventGuard
		transition.eventguard.type = symbolicEventMapping.get(expression.functor)
		// TODO parameters
		
		retvalue
	}

	protected def dispatch Automaton recursiveCompile(Sequence expression) {
		var compiledExpressions = expression.elements.map[recursiveCompile(it)]
		compiledExpressions.tail.fold(compiledExpressions.head, [i, j|merge(i, j)])
	}

	protected def merge(Automaton firstAutomaton, Automaton secondAutomaton) {

		val intermediateState = secondAutomaton.initialState
		firstAutomaton.states.filter[it.acceptor].forEach[
			it.acceptor = false
			var epsilonTrans = createEpsilonTransition
			epsilonTrans.from = it
			epsilonTrans.to = intermediateState
		]
		
		for(state : secondAutomaton.states.clone()){ //The clone is needed, as the list changes when items are removed
			firstAutomaton.states.add(state)
			secondAutomaton.states.remove(state) //Not sure tho
		}

		return firstAutomaton
	}

	protected def dispatch Automaton recursiveCompile(Choice expression) {
		val retvalue = createAutomaton
		val newFirst = createState
		val newLast = createState
		
		retvalue.initialState = newFirst
		newLast.acceptor = true
		
		retvalue.states.add(newFirst)
		retvalue.states.add(newLast)
		
		for(expr : expression.elements){
			val compiled = expr.recursiveCompile
			val epsilonFromInitial = createEpsilonTransition
			epsilonFromInitial.from = newFirst
			epsilonFromInitial.to = compiled.initialState
			
			compiled.states.filter[it.acceptor].clone.forEach[
				it.acceptor = false
				var epsilonToLast = createEpsilonTransition
				epsilonToLast.from = it
				epsilonToLast.to = newLast
			]
			
			 compiled.states.clone().forEach[
			 	compiled.states.remove(it)
			 	retvalue.states.add(it)
			 ]
		}

		return retvalue
	}
	
	protected def dispatch Automaton recursiveCompile(Plus expression){
		var sequence = ParametricTimedRegularExpressionFactory.eINSTANCE.createSequence
		var star = ParametricTimedRegularExpressionFactory.eINSTANCE.createStar
		star.body = EcoreUtil.copy(expression)
		sequence.elements.add(star)
		sequence.elements.add(EcoreUtil.copy(expression))
		return recursiveCompile(sequence);
	}
	
	protected def dispatch Automaton recursiveCompile(Cardinality expression){
		var sequence = ParametricTimedRegularExpressionFactory.eINSTANCE.createSequence
		for(var i = 0; i!= expression.n; i++){
			sequence.elements.add(EcoreUtil.copy(expression))
		}
		return recursiveCompile(sequence)
	}

	protected def dispatch Automaton recursiveCompile(Star expression) {
		val compiledAutomaton = recursiveCompile(expression.body)
		val first = createState
		val last = createState
		compiledAutomaton.states.add(first)
		compiledAutomaton.states.add(last)

		val beginEpsilon = createEpsilonTransition

		val skipEpsilon = createEpsilonTransition

		beginEpsilon.from = first
		beginEpsilon.to = compiledAutomaton.initialState

		compiledAutomaton.states.filter[it.acceptor].clone.forEach[
			var endEpsilon = createEpsilonTransition
			var returnEpsilon = createEpsilonTransition
			
			returnEpsilon.from = it
			returnEpsilon.to = compiledAutomaton.initialState
			
			endEpsilon.from = it
			endEpsilon.to = last
		]

		skipEpsilon.from = first
		skipEpsilon.to = last

		compiledAutomaton.initialState = first
		last.acceptor = true

		compiledAutomaton
	}

	protected def dispatch Automaton recursiveCompile(And expression) {
		var compiledExpressions = expression.elements.map[recursiveCompile(it)]
		compiledExpressions.tail.fold(compiledExpressions.head, [i, j|product(i, j)])
	}

	protected def Automaton product(Automaton left, Automaton right) {
		val retvalue = createAutomaton
		
		var id = 0
		
		left.name = 'left'
		right.name = 'right'		

		for(state : left.states){
			state.id = id++
		}
		for(state : right.states){
			state.id = id++
		}
		println(automatonToYed(left))
		println(automatonToYed(right))
		
		val leftTrace = new HashMap<State, HashSet<State>> // for each state of the left operand, there are a row of states in the new matrix of states
		val rightTrace = new HashMap<State, HashSet<State>> // for each state of the right operand, there are a column of states in the new matrix of states 
		// constructing the new matrix of states for the product.
		
		for (leftState : left.states) {
			for (rightState : right.states) {
				var newState = createState
				if(!leftTrace.containsKey(leftState)) leftTrace.put(leftState, new HashSet)
				if(!rightTrace.containsKey(rightState)) rightTrace.put(rightState, new HashSet)

				retvalue.states.add(newState)

				leftTrace.get(leftState).add(newState)
				rightTrace.get(rightState).add(newState)
				newState.id = id++
			}
		}
		
		println(automatonToYed(retvalue))
		
		println('LEFTTRACE')
		leftTrace.forEach[originalState, newState|
			println(originalState.id)
			newState.forEach[println('\t'+it.id)]
		]
		
		println('RIGHTTRACE')
		rightTrace.forEach[originalState, newState|
			println(originalState.id)
			newState.forEach[println('\t'+it.id)]
		]
		
		for (state : retvalue.states) {
			val leftOriginal = leftTrace.filter[oldState, newStates|newStates.contains(state)].keySet.head
			val rightOriginal = rightTrace.filter[oldState, newStates|newStates.contains(state)].keySet.head
			println('For ciklus leftoriginalja : ' + leftOriginal.id + '\t RightOriginalja : ' + rightOriginal.id)
			rightOriginal.outgoingTransitions.forEach [ transition |
				println('<<RIGHT>> from ' + transition.from.id + '\t to ' + transition.to.id)
				var cloneTransition = EcoreUtil.copy(transition)
				println('LeftOriginalId = '+ leftOriginal.id + '\tRightOriginalId = ' + rightOriginal.id + '\tnewState.id = ' + state.id)
				cloneTransition.from = state
				cloneTransition.to = leftTrace.get(leftOriginal).findFirst[rightTrace.get(transition.to).contains(it)]
			]

			leftOriginal.outgoingTransitions.forEach [ transition |
				println('<<LEFT>> from ' + transition.from.id + '\t to ' + transition.to.id)
				var cloneTransition = EcoreUtil.copy(transition)
				println('LeftOriginalId = '+ leftOriginal.id + '\tRightOriginalId = ' + rightOriginal.id + '\tnewState.id = ' + state.id)
				cloneTransition.from = state
				cloneTransition.to = rightTrace.get(rightOriginal).findFirst[leftTrace.get(transition.to).contains(it)]
			]
			if(leftOriginal.acceptor && rightOriginal.acceptor) state.acceptor = true
		}

		retvalue.initialState = retvalue.states.filter [
			leftTrace.get(left.initialState).contains(it) && rightTrace.get(right.initialState).contains(it)
		].head


		return retvalue
	}

	public static def epsilonClosure(State s) { // FIXME move this to an external utility package
		var list = new ArrayList<State>
		list.add(s)
		epsilonClosure(list)
	}

	public static def epsilonClosure(Iterable<State> input) { // FIXME move this to an external utility package
		var stack = new Stack<State>
		var res = new HashSet<State>
		for (state : input) {
			stack.push(state)
			res.add(state)
		}
		while (!stack.isEmpty()) {
			var t = stack.pop
			for (u : t.outgoingTransitions.filter[it instanceof EpsilonTransition].map[it.to]) {
				if (!res.contains(u)) {
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
			var outGoingOnA = state.outgoingTransitions.filter[!(it instanceof EpsilonTransition)].filter [
				(it as Transition).eventguard.type == a
			].head
			if (outGoingOnA != null) {
				res.add(outGoingOnA.to)
			}
		}
		return res;
	}

	protected def sameDFAState(Set<State> state1, Set<State> state2) {
		for (state : state1) {
			if (!state2.contains(state)) {
				return false
			}
		}

		for (state : state2) {
			if (!state1.contains(state)) {
				return false
			}
		}

		return true;
	}

	protected def Automaton determinizeNFA(Automaton NFA) {
		val DFA = createAutomaton
		DFA.name = NFA.name

		val Dstates = new HashSet<HashSet<State>>
		val Dtrans = new HashMap<HashSet<State>, HashMap<SymbolicEvent, HashSet<State>>>
		val marked = new HashSet<HashSet<State>>
		var initialState = epsilonClosure(NFA.initialState)
		Dstates.add(initialState)

		while (!Dstates.map[marked.contains(it)].fold(true, [i, j|i && j])) {
			var T = Dstates.filter[!marked.contains(it)].head
			marked.add(T)
			for (symbol : symbolicEvents) {
				val U = epsilonClosure(move(T, symbol))
				var sameU = Dstates.filter[sameDFAState(it, U)].head
				if (sameU == null) {
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
		Dtrans.forEach [p1, p2|
			p2.forEach [p3, p4|
				var newTrans = createTransition
				newTrans.from = Dstates2DFAStates.get(p1)
				newTrans.to = Dstates2DFAStates.get(p4)
				newTrans.eventguard = createEventGuard
				newTrans.eventguard.type = p3
			]
		]

		DFA.initialState = Dstates2DFAStates.get(initialState)
		for (state : DFA.states) {
			if (Dstates2DFAStates.filter[i, j|j == state].keySet.head.filter[it.acceptor == true].length > 0)
				state.acceptor = true
		}

		return DFA
	}

	static def List<List<Expression>> generatePerm(List<Expression> left, List<Expression> right) {
		val result = new LinkedList<List<Expression>>
		if (left.head != null) {
			generatePerm(left.tail.toList, right).forEach [
				val newRes = new LinkedList<Expression>;
				newRes.add(left.head);
				it.forEach[newRes.add(it)];
				result.add(newRes)
			]
		}
		if (right.head != null) {
			generatePerm(left, right.tail.toList).forEach [
				val newRes = new LinkedList<Expression>;
				newRes.add(right.head);
				it.forEach[newRes.add(it)];
				result.add(newRes)
			]
		}
		if (right.head == null && left.head == null) {
			result.add(new LinkedList<Expression>)
		}
		return result
	}
}