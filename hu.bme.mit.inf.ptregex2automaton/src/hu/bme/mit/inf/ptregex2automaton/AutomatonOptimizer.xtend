package hu.bme.mit.inf.ptregex2automaton

import EventAutomatonModel.Action
import EventAutomatonModel.Automaton
import EventAutomatonModel.EpsilonTransition
import EventAutomatonModel.EventAutomatonModelFactory
import EventAutomatonModel.State
import EventAutomatonModel.SymbolicEvent
import EventAutomatonModel.SymbolicInputEvent
import EventAutomatonModel.Transition
import hu.bme.mit.inf.parametricTimedRegularExpression.And
import hu.bme.mit.inf.parametricTimedRegularExpression.Any
import hu.bme.mit.inf.parametricTimedRegularExpression.Choice
import hu.bme.mit.inf.parametricTimedRegularExpression.Event
import hu.bme.mit.inf.parametricTimedRegularExpression.Expression
import hu.bme.mit.inf.parametricTimedRegularExpression.ExpressionDeclaration
import hu.bme.mit.inf.parametricTimedRegularExpression.Inverse
import hu.bme.mit.inf.parametricTimedRegularExpression.NegExpression
import hu.bme.mit.inf.parametricTimedRegularExpression.Sequence
import hu.bme.mit.inf.parametricTimedRegularExpression.Star
import hu.bme.mit.inf.parametricTimedRegularExpression.TimedExpression
import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import java.util.Set
import java.util.Stack
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.macro.declaration.Declaration
import hu.bme.mit.inf.parametricTimedRegularExpression.Plus

class AutomatonOptimizer {

	static extension val EventAutomatonModelFactory factory = EventAutomatonModelFactory.eINSTANCE;

	public def expressionContainsTiming(ExpressionDeclaration dec) {
		recursiveCheckForTiming(dec.body)
	}

	def dispatch boolean recursiveCheckForTiming(Expression e) {
		throw new UnsupportedOperationException('''«e.class.name»''')
	}

	def dispatch boolean recursiveCheckForTiming(NegExpression expression) {
		return recursiveCheckForTiming(expression.body)
	}

	def dispatch boolean recursiveCheckForTiming(TimedExpression expression) {
		return true;
	}

	def dispatch boolean recursiveCheckForTiming(Event e) {
		return false;
	}

	def dispatch boolean recursiveCheckForTiming(Inverse e) {
		return false;
	}

	def dispatch boolean recursiveCheckForTiming(Any e) {
		return false;
	}

	def dispatch boolean recursiveCheckForTiming(Sequence seq) {
		return seq.elements.map[recursiveCheckForTiming].exists[it == true];
	}

	def dispatch boolean recursiveCheckForTiming(Choice choice) {
		return choice.elements.map[recursiveCheckForTiming].exists[it == true];
	}

	def dispatch boolean recursiveCheckForTiming(And and) {
		return and.elements.map[recursiveCheckForTiming].exists[it == true];
	}

	def dispatch boolean recursiveCheckForTiming(Star star) {
		return star.body.recursiveCheckForTiming
	}
	
	def dispatch boolean recursiveCheckForTiming(Plus star) {
		return star.body.recursiveCheckForTiming
	}

	def boolean expressionContainsExactlyOneTiming(ExpressionDeclaration dec) {
		return recursiveCountForTiming(dec.body) == 1;
	}

	
	def dispatch int recursiveCountForTiming(Expression e) {
		throw new UnsupportedOperationException('''«e.class.name»''')
	}

	def dispatch int recursiveCountForTiming(NegExpression expression) {
		return recursiveCountForTiming(expression.body)
	}

	def dispatch int recursiveCountForTiming(TimedExpression expression) {
		return 1;
	}

	def dispatch int recursiveCountForTiming(Event e) {
		return 0;
	}

	def dispatch int recursiveCountForTiming(Inverse e) {
		return 0;
	}

	def dispatch int recursiveCountForTiming(Any e) {
		return 0;
	}

	def dispatch int recursiveCountForTiming(Sequence seq) {
		var count = 0;
		for(expressionCount : seq.elements.map[recursiveCountForTiming]){
			count += expressionCount
		}
		return count
	}

	def dispatch int recursiveCountForTiming(Choice choice) {
		var count = 0;
		for(expressionCount : choice.elements.map[recursiveCountForTiming]){
			count += expressionCount
		}
		return count
	}

	def dispatch int recursiveCountForTiming(And and) {
		var count = 0;
		for(expressionCount : and.elements.map[recursiveCountForTiming]){
			count += expressionCount
		}
		return count
	}

	def dispatch int recursiveCountForTiming(Star star) {
		return star.body.recursiveCountForTiming
	}

	def dispatch int recursiveCountForTiming(Plus plus){
		return plus.body.recursiveCountForTiming
	}

	public def Automaton minimizeNFA(Automaton a) {
		val epsilonLess = removeEpsilons(a)
		val merged = mergeEquivalent(epsilonLess)
		return merged;
	}

	def Automaton removeEpsilons(Automaton automaton) {
		val mapping = new HashMap<State, Set<Action>>
		val states = automaton.states.filter[it.incomingTransitions.exists[it instanceof EpsilonTransition]]
		states.forEach [
			mapping.put(it, collectActionFromStateOnEpsilonTransitions(it))
		]

		val HashSet<EpsilonTransition> epsilonTransitions = new HashSet
		states.forEach[it.outgoingTransitions.filter[it instanceof EpsilonTransition].forEach[epsilonTransitions.add(it as EpsilonTransition)]]
		epsilonTransitions.forEach[it.from.outgoingTransitions.remove(it)] // remove all epsilon transitions
		val HashSet<Transition> nonEpsilonTransitions = new HashSet
		states.forEach[it.outgoingTransitions.filter[it instanceof Transition].forEach[nonEpsilonTransitions.add(it as Transition)]]

		nonEpsilonTransitions.forEach [ nonEpsilon |
			val epsilonClosure = epsilonClosure(nonEpsilon.to)
			epsilonClosure.forEach [
				val newTransition = createTransition
				newTransition.eventguard = EcoreUtil.copy(nonEpsilon.eventguard)

				mapping.get(it).forEach [
					newTransition.actions.add(EcoreUtil.copy(it))
				]
			]
		]

		nonEpsilonTransitions.forEach[it.from.outgoingTransitions.remove(it)] // remove the 'old' transitions
		return automaton;
	}

	def Set<Action> collectActionFromStateOnEpsilonTransitions(State state) {
		val retvalue = new HashSet<Action>
		val unchecked = new Stack<EpsilonTransition>
		val marked = new HashSet<EpsilonTransition>

		state.incomingTransitions.filter[it instanceof EpsilonTransition].forEach[unchecked.add(it as EpsilonTransition)]

		while(!unchecked.empty()) {
			val t = unchecked.pop
			marked.add(t)
			t.actions.forEach[retvalue.add(it)]
			t.from.incomingTransitions.filter[it instanceof EpsilonTransition && !marked.contains(it)].forEach[unchecked.add(it as EpsilonTransition)]
		}

		return retvalue;
	}

	def Automaton mergeEquivalent(Automaton automaton) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	public def DeterminizationResult determinizeNFA(Automaton NFA, ArrayList<SymbolicInputEvent> symbolicEvents) {
		val DFA = createAutomaton
		DFA.name = NFA.name

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

		Dtrans.forEach [ p1, p2 |
			p2.forEach [ p3, p4 |
				var newTrans = createTransition
				newTrans.from = Dstates2DFAStates.get(p1)
				newTrans.to = Dstates2DFAStates.get(p4)
				newTrans.eventguard = createEventGuard
				newTrans.eventguard.type = p3
			]
		]

		DFA.initialState = Dstates2DFAStates.get(initialState)
		for (state : DFA.states) {
			if(Dstates2DFAStates.filter[i, j|j == state].keySet.head.filter[it.acceptor == true].length > 0)
				state.acceptor = true
		}

		return new DeterminizationResult(DFA, NFA, Dstates2DFAStates)
	}

	public static def epsilonClosure(State s) {
		var list = new ArrayList<State>
		list.add(s)
		epsilonClosure(list)
	}

	public static def epsilonClosure(Iterable<State> input) {
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
			var outGoingOnA = state.outgoingTransitions.filter[!(it instanceof EpsilonTransition)].filter [
				(it as Transition).eventguard.type == a
			].head
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
}

class DeterminizationResult {
	val public Automaton DFA;
	val public HashMap<HashSet<State>, State> mapping;
	val public Automaton NFA;

	new(Automaton DFA, Automaton NFA, HashMap<HashSet<State>, State> mapping) {
		this.DFA = DFA
		this.NFA = NFA
		this.mapping = mapping
	}

}
