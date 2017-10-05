package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.TrainOnStation_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class TrainOnStation_Pattern extends AtomicEventPatternImpl {
  public TrainOnStation_Pattern() {
    super();
    setType(TrainOnStation_Event.class.getCanonicalName());
    setId("hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.trainonstation_pattern");
  }
}
