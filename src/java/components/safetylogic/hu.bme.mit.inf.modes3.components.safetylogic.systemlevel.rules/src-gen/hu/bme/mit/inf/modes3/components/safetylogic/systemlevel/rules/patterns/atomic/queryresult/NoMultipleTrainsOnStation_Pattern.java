package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.NoMultipleTrainsOnStation_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class NoMultipleTrainsOnStation_Pattern extends AtomicEventPatternImpl {
  public NoMultipleTrainsOnStation_Pattern() {
    super();
    setType(NoMultipleTrainsOnStation_Event.class.getCanonicalName());
    setId("hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.nomultipletrainsonstation_pattern");
  }
}
