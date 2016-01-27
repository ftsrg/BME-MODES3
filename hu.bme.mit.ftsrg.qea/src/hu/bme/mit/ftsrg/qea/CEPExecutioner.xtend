package hu.bme.mit.ftsrg.qea

import hu.bme.mit.ftsrg.qea.model.ComplexEventProcessor
import java.util.HashMap
import hu.bme.mit.ftsrg.qea.model.Automaton
import hu.bme.mit.ftsrg.qea.model.Event

class CEPExecutioner {
	
	protected val ComplexEventProcessor cep
	protected val executioners = new HashMap<Automaton, AutomatonExecutioner>
	
	
	new(ComplexEventProcessor cep){
		this.cep = cep
		cep.automata.forEach[executioners.put(it, new AutomatonExecutioner(it))]
	}
	
	public def pushEvent(Event e){
			println("================ STEP FINISHED ==================")
			println("Caused by event " + e.type.name)
			println("=================================================")
		
		executioners.forEach[automata, executioner|
			executioner.pushEvent(e) //TODO synchronizing on the whole CEP, and not just automatons would be wise
		]
	}
}