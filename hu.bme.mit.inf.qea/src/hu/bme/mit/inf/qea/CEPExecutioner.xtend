package hu.bme.mit.inf.qea

import EventAutomatonModel.Automaton
import EventAutomatonModel.ComplexEventProcessor
import EventAutomatonModel.Event
import EventAutomatonModel.SymbolicInputEvent
import java.util.HashMap

class CEPExecutioner {
	
	protected val ComplexEventProcessor cep
	protected val executioners = new HashMap<Automaton, AutomatonExecutioner>
	
	
	new(ComplexEventProcessor cep){
		this.cep = cep
		cep.automata.forEach[executioners.put(it, new AutomatonExecutioner(it))]
	}
	
	public def pushEvent(Event e){
			println("================ STEP FINISHED ==================")
			println("Caused by event " + (e.type as SymbolicInputEvent).name)
			println("=================================================")
		
		executioners.forEach[automata, executioner|
			executioner.pushEvent(e) //TODO synchronizing on the whole CEP, and not just automatons would be wise
		]
	}
}
