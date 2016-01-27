package hu.bme.mit.ftsrg.qea

import hu.bme.mit.ftsrg.qea.model.ModelFactory

class AutomatonTestHelper {
	static extension var ModelFactory factory = ModelFactory.eINSTANCE;

	public static def test1(){
		var cep = createComplexEventProcessor
		var automaton = createAutomaton
		var a = createSymbolicInputEvent a.name = 'a'
		var b = createSymbolicInputEvent b.name = 'b'
		
		var s1 = createState
		var s2 = createState
		var s3 = createState
		
		var t1 = createTransition
		var t2 = createTransition
		var ttimeout = createTransition
		
		var timer1 = createSymbolicTimer
		var timeout1 = createSymbolicTimeoutEvent
		timer1.timeoutEvent = timeout1
		timer1.name = 'timer1'
		
		cep.automata.add(automaton)
		cep.symbolicEvents.add(a)
		cep.symbolicEvents.add(b)
		
		automaton.states.add(s1)
		automaton.states.add(s2)
		automaton.states.add(s3)
		
		t1.from = s1
		t1.to = s2
		
		var t1guard = createEventGuard
		t1guard.type = a
		t1.eventguard = t1guard
		
		var t1timer = createSetTimerAction
		t1timer.timer = timer1
		t1timer.toValue = 1000
		
		t1.actions.add(t1timer)
		

		
		t2.from = s2
		t2.to = s3
		
		var t2guard = createEventGuard
		t2guard.type = b
		t2.eventguard = t2guard
		
		var t2timer = createResetTimerAction
		t2timer.timer = timer1
		
		t2.actions.add(t2timer)
		

		var ttimeoutguard = createEventGuard
		ttimeoutguard.type = timeout1
		ttimeout.eventguard = ttimeoutguard
		ttimeout.from = s2
		ttimeout.to = s1
		 
		
		automaton.initialState = s1
		s3.acceptor = true		
		
		//TESTING
		
		var eventA = createEvent
		eventA.type = a
		var eventB = createEvent
		eventB.type = b
		
		var exec = new AutomatonExecutioner(automaton)
		
		
		exec.pushEvent(eventA)
		Thread.sleep(2000)
		exec.pushEvent(eventB)
		

	 	
	}

	
}