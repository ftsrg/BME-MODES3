package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult;

import org.eclipse.viatra.cep.core.api.events.ParameterizableViatraQueryPatternEventInstance;
import org.eclipse.viatra.cep.core.metamodels.events.EventSource;

@SuppressWarnings("all")
public class NoMultipleTrainsOnStation_Event extends ParameterizableViatraQueryPatternEventInstance {
  public NoMultipleTrainsOnStation_Event(final EventSource eventSource) {
    super(eventSource);
    
  }
  
  @Override
  public boolean evaluateCheckExpression() {
    return true;
  }
}
