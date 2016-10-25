package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.DivergentTurnoutEvent_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class DivergentTurnoutEvent_Pattern extends AtomicEventPatternImpl {
  public DivergentTurnoutEvent_Pattern() {
    super();
    setType(DivergentTurnoutEvent_Event.class.getCanonicalName());
    setId("hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.divergentturnoutevent_pattern");
  }
}
