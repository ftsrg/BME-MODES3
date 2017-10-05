package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.TrainLeftStation_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class TrainLeftStation_Pattern extends AtomicEventPatternImpl {
  public TrainLeftStation_Pattern() {
    super();
    setType(TrainLeftStation_Event.class.getCanonicalName());
    setId("hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.trainleftstation_pattern");
  }
}
