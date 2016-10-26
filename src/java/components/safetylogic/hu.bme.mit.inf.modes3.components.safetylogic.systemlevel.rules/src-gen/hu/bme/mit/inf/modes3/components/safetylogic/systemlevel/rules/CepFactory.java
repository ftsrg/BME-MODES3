package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules;

import com.google.common.collect.Lists;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.TrainLeftStation_Event;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.TrainOnStation_Event;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.TrainLeftStation_Pattern;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.TrainOnStation_Pattern;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex.TrainPassThroughStation_Pattern;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.rules.TrainPassedThroughStationRule;
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
   * Factory method for event class {@link TrainOnStation_Event}.
   */
  public TrainOnStation_Event createTrainOnStation_Event(final EventSource eventSource) {
    return new TrainOnStation_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link TrainOnStation_Event}.
   */
  public TrainOnStation_Event createTrainOnStation_Event() {
    return new TrainOnStation_Event(null);
  }
  
  /**
   * Factory method for event class {@link TrainLeftStation_Event}.
   */
  public TrainLeftStation_Event createTrainLeftStation_Event(final EventSource eventSource) {
    return new TrainLeftStation_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link TrainLeftStation_Event}.
   */
  public TrainLeftStation_Event createTrainLeftStation_Event() {
    return new TrainLeftStation_Event(null);
  }
  
  /**
   * Factory method for complex event pattern {@link TrainPassThroughStation_Pattern}.
   */
  public Class<? extends ICepRule> rule_TrainPassThroughStation_Pattern() {
    return TrainPassedThroughStationRule.class;
  }
  
  /**
   * Factory method for rule {@link TrainPassedThroughStationRule}.
   */
  public Class<? extends ICepRule> rule_TrainPassedThroughStationRule() {
    return TrainPassedThroughStationRule.class;
  }
  
  /**
   * Factory method for instantiating every defined rule.
   */
  public List<Class<? extends ICepRule>> allRules() {
    List<Class<? extends ICepRule>> rules = Lists.newArrayList();
    rules.add(TrainPassedThroughStationRule.class);
    return rules;
  }
}
