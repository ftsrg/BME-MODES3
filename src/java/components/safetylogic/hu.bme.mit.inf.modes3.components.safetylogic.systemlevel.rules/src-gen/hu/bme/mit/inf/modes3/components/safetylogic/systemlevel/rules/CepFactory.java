package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules;

import com.google.common.collect.Lists;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.RailRoadTest_Event;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.RailRoadTest_Pattern;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.rules.Test_event_rule;
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
   * Factory method for event class {@link RailRoadTest_Event}.
   */
  public RailRoadTest_Event createRailRoadTest_Event(final EventSource eventSource) {
    return new RailRoadTest_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link RailRoadTest_Event}.
   */
  public RailRoadTest_Event createRailRoadTest_Event() {
    return new RailRoadTest_Event(null);
  }
  
  /**
   * Factory method for atomic query result event pattern {@link RailRoadTest_Pattern}.
   */
  public Class<? extends ICepRule> rule_RailRoadTest_Pattern() {
    return Test_event_rule.class;
  }
  
  /**
   * Factory method for rule {@link Test_event_rule}.
   */
  public Class<? extends ICepRule> rule_Test_event_rule() {
    return Test_event_rule.class;
  }
  
  /**
   * Factory method for instantiating every defined rule.
   */
  public List<Class<? extends ICepRule>> allRules() {
    List<Class<? extends ICepRule>> rules = Lists.newArrayList();
    rules.add(Test_event_rule.class);
    return rules;
  }
}
