package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.MultipleTrainsOnStation_Pattern;
import org.eclipse.viatra.cep.core.api.patterns.ParameterizableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.metamodels.events.EventsFactory;

@SuppressWarnings("all")
public class ThreeTimesMet_Pattern extends ParameterizableComplexEventPattern {
  public ThreeTimesMet_Pattern() {
    super();
    setOperator(EventsFactory.eINSTANCE.createFOLLOWS());
    
    // contained event patterns
    addEventPatternRefrence(new MultipleTrainsOnStation_Pattern(), 3);
    setId("hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex.threetimesmet_pattern");setEventContext(EventContext.CHRONICLE);
  }
}
