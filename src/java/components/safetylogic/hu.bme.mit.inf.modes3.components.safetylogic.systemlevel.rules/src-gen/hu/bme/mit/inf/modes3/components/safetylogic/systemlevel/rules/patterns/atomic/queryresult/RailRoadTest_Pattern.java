package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.RailRoadTest_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class RailRoadTest_Pattern extends AtomicEventPatternImpl {
  public RailRoadTest_Pattern() {
    super();
    setType(RailRoadTest_Event.class.getCanonicalName());
    setId("hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.railroadtest_pattern");
  }
}
