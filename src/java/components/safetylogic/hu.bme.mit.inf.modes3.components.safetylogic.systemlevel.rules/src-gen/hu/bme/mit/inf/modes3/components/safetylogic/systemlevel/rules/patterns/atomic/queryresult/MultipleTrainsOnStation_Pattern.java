package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.MultipleTrainsOnStation_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class MultipleTrainsOnStation_Pattern extends AtomicEventPatternImpl {
  public MultipleTrainsOnStation_Pattern() {
    super();
    setType(MultipleTrainsOnStation_Event.class.getCanonicalName());
    setId("hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.multipletrainsonstation_pattern");
  }
}
