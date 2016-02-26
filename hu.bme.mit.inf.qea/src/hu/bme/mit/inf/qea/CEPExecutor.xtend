package hu.bme.mit.inf.qea

import EventAutomatonModel.Automaton
import EventAutomatonModel.ComplexEventProcessor
import EventAutomatonModel.Event
import EventAutomatonModel.SymbolicInputEvent
import java.util.HashMap

class CEPExecutor {

	protected val ComplexEventProcessor cep
	protected val Executors = new HashMap<Automaton, AutomatonExecutor>
	public var log = new StringBuilder

	def void println(StringBuilder builder, String toAppend) {
		builder.append(toAppend)
		builder.append('\n')
	}

	new(ComplexEventProcessor cep) {
		this.cep = cep
		cep.automata.forEach[Executors.put(it, new AutomatonExecutor(it))]
	}

	public def pushEvent(Event e) {
		log.println("================ STEP FINISHED ==================")
		log.println("Caused by event " + (e.type as SymbolicInputEvent).name)
		log.println("=================================================")

		Executors.forEach [ automata, executor |
			executor.pushEvent(e) // TODO synchronizing on the whole CEP, and not just automatons would be wise
		]
		Executors.forEach[ automata, Executor | 
			log.append(Executor.log)
			Executor.log = new StringBuilder
		]
	}
}
