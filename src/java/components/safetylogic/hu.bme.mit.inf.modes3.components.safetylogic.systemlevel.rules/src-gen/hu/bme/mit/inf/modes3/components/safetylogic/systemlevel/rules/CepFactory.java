package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules;

import com.google.common.collect.Lists;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.MultipleTrainsOnStation_Event;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.NoMultipleTrainsOnStation_Event;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.NoTrainOnStation_Event;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.TrainLeftStation_Event;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.TrainOnStation_Event;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.MultipleTrainsOnStation_Pattern;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.NoMultipleTrainsOnStation_Pattern;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.NoTrainOnStation_Pattern;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.TrainLeftStation_Pattern;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.atomic.queryresult.TrainOnStation_Pattern;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex.ThreeTimesMet_Pattern;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex.TrainPassThroughStation_Pattern;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex.Transfer_Pattern;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.rules.MultipleTrainsOnStationRule;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.rules.ThreeTimesMetRule;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.rules.TrainPassedThroughStationRule;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.rules.TransferRule;
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
   * Factory method for event class {@link NoTrainOnStation_Event}.
   */
  public NoTrainOnStation_Event createNoTrainOnStation_Event(final EventSource eventSource) {
    return new NoTrainOnStation_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link NoTrainOnStation_Event}.
   */
  public NoTrainOnStation_Event createNoTrainOnStation_Event() {
    return new NoTrainOnStation_Event(null);
  }
  
  /**
   * Factory method for event class {@link MultipleTrainsOnStation_Event}.
   */
  public MultipleTrainsOnStation_Event createMultipleTrainsOnStation_Event(final EventSource eventSource) {
    return new MultipleTrainsOnStation_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link MultipleTrainsOnStation_Event}.
   */
  public MultipleTrainsOnStation_Event createMultipleTrainsOnStation_Event() {
    return new MultipleTrainsOnStation_Event(null);
  }
  
  /**
   * Factory method for event class {@link NoMultipleTrainsOnStation_Event}.
   */
  public NoMultipleTrainsOnStation_Event createNoMultipleTrainsOnStation_Event(final EventSource eventSource) {
    return new NoMultipleTrainsOnStation_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link NoMultipleTrainsOnStation_Event}.
   */
  public NoMultipleTrainsOnStation_Event createNoMultipleTrainsOnStation_Event() {
    return new NoMultipleTrainsOnStation_Event(null);
  }
  
  /**
   * Factory method for atomic query result event pattern {@link MultipleTrainsOnStation_Pattern}.
   */
  public Class<? extends ICepRule> rule_MultipleTrainsOnStation_Pattern() {
    return MultipleTrainsOnStationRule.class;
  }
  
  /**
   * Factory method for complex event pattern {@link Transfer_Pattern}.
   */
  public Class<? extends ICepRule> rule_Transfer_Pattern() {
    return TransferRule.class;
  }
  
  /**
   * Factory method for complex event pattern {@link TrainPassThroughStation_Pattern}.
   */
  public Class<? extends ICepRule> rule_TrainPassThroughStation_Pattern() {
    return TrainPassedThroughStationRule.class;
  }
  
  /**
   * Factory method for complex event pattern {@link ThreeTimesMet_Pattern}.
   */
  public Class<? extends ICepRule> rule_ThreeTimesMet_Pattern() {
    return ThreeTimesMetRule.class;
  }
  
  /**
   * Factory method for rule {@link MultipleTrainsOnStationRule}.
   */
  public Class<? extends ICepRule> rule_MultipleTrainsOnStationRule() {
    return MultipleTrainsOnStationRule.class;
  }
  
  /**
   * Factory method for rule {@link TrainPassedThroughStationRule}.
   */
  public Class<? extends ICepRule> rule_TrainPassedThroughStationRule() {
    return TrainPassedThroughStationRule.class;
  }
  
  /**
   * Factory method for rule {@link TransferRule}.
   */
  public Class<? extends ICepRule> rule_TransferRule() {
    return TransferRule.class;
  }
  
  /**
   * Factory method for rule {@link ThreeTimesMetRule}.
   */
  public Class<? extends ICepRule> rule_ThreeTimesMetRule() {
    return ThreeTimesMetRule.class;
  }
  
  /**
   * Factory method for instantiating every defined rule.
   */
  public List<Class<? extends ICepRule>> allRules() {
    List<Class<? extends ICepRule>> rules = Lists.newArrayList();
    rules.add(MultipleTrainsOnStationRule.class);
    rules.add(TrainPassedThroughStationRule.class);
    rules.add(TransferRule.class);
    rules.add(ThreeTimesMetRule.class);
    return rules;
  }
}
