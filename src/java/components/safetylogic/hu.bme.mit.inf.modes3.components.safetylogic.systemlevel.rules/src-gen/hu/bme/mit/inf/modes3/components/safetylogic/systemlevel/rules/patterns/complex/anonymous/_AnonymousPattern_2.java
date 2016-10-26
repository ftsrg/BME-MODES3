package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex.anonymous;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.TrainLeftStation_Pattern;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.TrainOnStation_Pattern;
import org.eclipse.viatra.cep.core.api.patterns.ParameterizableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.metamodels.events.EventsFactory;

@SuppressWarnings("all")
public class _AnonymousPattern_2 extends ParameterizableComplexEventPattern {
  public _AnonymousPattern_2() {
    super();
    setOperator(EventsFactory.eINSTANCE.createFOLLOWS());
    
    // contained event patterns
    addEventPatternRefrence(new TrainLeftStation_Pattern(), 1);
    addEventPatternRefrence(new TrainOnStation_Pattern(), 1);
    setId("hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex.anonymous._anonymouspattern_2");setEventContext(EventContext.CHRONICLE);
  }
}
