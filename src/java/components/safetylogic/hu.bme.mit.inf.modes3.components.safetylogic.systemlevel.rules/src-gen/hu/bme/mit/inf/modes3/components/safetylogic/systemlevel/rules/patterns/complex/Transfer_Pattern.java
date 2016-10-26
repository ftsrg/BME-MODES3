package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.NoTrainOnStation_Pattern;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex.anonymous._AnonymousPattern_2;
import org.eclipse.viatra.cep.core.api.patterns.ParameterizableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.metamodels.events.EventsFactory;

@SuppressWarnings("all")
public class Transfer_Pattern extends ParameterizableComplexEventPattern {
  public Transfer_Pattern() {
    super();
    setOperator(EventsFactory.eINSTANCE.createFOLLOWS());
    
    // contained event patterns
    addEventPatternRefrence(new NoTrainOnStation_Pattern(), 1);
    addEventPatternRefrence(new _AnonymousPattern_2(), 1);
    setId("hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex.transfer_pattern");setEventContext(EventContext.CHRONICLE);
  }
}
