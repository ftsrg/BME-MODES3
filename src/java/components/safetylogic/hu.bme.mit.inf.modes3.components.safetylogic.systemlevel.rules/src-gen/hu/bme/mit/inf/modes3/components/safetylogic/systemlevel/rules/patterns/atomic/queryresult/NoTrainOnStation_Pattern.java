package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.NoTrainOnStation_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class NoTrainOnStation_Pattern extends AtomicEventPatternImpl {
  public NoTrainOnStation_Pattern() {
    super();
    setType(NoTrainOnStation_Event.class.getCanonicalName());
    setId("hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.notrainonstation_pattern");
  }
}
