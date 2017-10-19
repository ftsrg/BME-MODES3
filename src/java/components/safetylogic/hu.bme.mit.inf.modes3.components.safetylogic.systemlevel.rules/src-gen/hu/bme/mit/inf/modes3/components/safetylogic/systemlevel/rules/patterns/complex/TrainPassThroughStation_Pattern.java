package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex.anonymous._AnonymousPattern_3;
import org.eclipse.viatra.cep.core.api.patterns.ParameterizableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.metamodels.events.EventsFactory;
import org.eclipse.viatra.cep.core.metamodels.events.Timewindow;

@SuppressWarnings("all")
public class TrainPassThroughStation_Pattern extends ParameterizableComplexEventPattern {
  public TrainPassThroughStation_Pattern() {
    super();
    setOperator(EventsFactory.eINSTANCE.createFOLLOWS());
    
    // contained event patterns
    addEventPatternRefrence(new _AnonymousPattern_3(), 1);
    						
    Timewindow timewindow = EventsFactory.eINSTANCE.createTimewindow();
    timewindow.setTime(10000);
    setTimewindow(timewindow);
    	
    setId("hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex.trainpassthroughstation_pattern");setEventContext(EventContext.CHRONICLE);
  }
}
