package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules;

import com.google.common.collect.Lists;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.DivergentTurnoutEvent_Event;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.DivergentTurnoutEvent_Pattern;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.rules.DivergentTurnoutRule;
import java.util.List;
import org.eclipse.viatra.cep.core.api.rules.ICepRule;
import org.eclipse.viatra.cep.core.metamodels.events.EventSource;

@SuppressWarnings("all")
public class CepFactory {
  private static CepFactory instance;
  
  public static CepFactory getInstance() {
    if(instance == null){
    	instance = new CepFactory();
    }
    return instance;
  }
  
  /**
   * Factory method for event class {@link DivergentTurnoutEvent_Event}.
   */
  public DivergentTurnoutEvent_Event createDivergentTurnoutEvent_Event(final EventSource eventSource) {
    return new DivergentTurnoutEvent_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link DivergentTurnoutEvent_Event}.
   */
  public DivergentTurnoutEvent_Event createDivergentTurnoutEvent_Event() {
    return new DivergentTurnoutEvent_Event(null);
  }
  
  /**
   * Factory method for atomic query result event pattern {@link DivergentTurnoutEvent_Pattern}.
   */
  public Class<? extends ICepRule> rule_DivergentTurnoutEvent_Pattern() {
    return DivergentTurnoutRule.class;
  }
  
  /**
   * Factory method for rule {@link DivergentTurnoutRule}.
   */
  public Class<? extends ICepRule> rule_DivergentTurnoutRule() {
    return DivergentTurnoutRule.class;
  }
  
  /**
   * Factory method for instantiating every defined rule.
   */
  public List<Class<? extends ICepRule>> allRules() {
    List<Class<? extends ICepRule>> rules = Lists.newArrayList();
    rules.add(DivergentTurnoutRule.class);
    return rules;
  }
}
