package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.cep.core.api.engine.CEPEngine;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.streams.EventStream;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.mapping.QueryEngine2ViatraCep;

public class SafetyLogicRuleEngine {
	
	private ResourceSet resourceSet;
	
	private CEPEngine cepEngine;
	
	private EventStream eventStream;
	
	private QueryEngine2ViatraCep mapping;
	
	public SafetyLogicRuleEngine(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
		cepEngine = CEPEngine.newEngine().eventContext(EventContext.CHRONICLE).rules(CepFactory.getInstance().allRules()).prepare();
		eventStream = cepEngine.getStreamManager().newEventStream();
	}
	
	public void start() {
		mapping  = QueryEngine2ViatraCep.register(this.resourceSet, eventStream);
	}
	
	public void stop() {
		mapping.dispose();
	}
}
