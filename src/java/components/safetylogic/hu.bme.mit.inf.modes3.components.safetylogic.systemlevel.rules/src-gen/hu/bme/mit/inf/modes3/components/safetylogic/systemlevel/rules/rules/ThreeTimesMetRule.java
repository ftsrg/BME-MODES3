package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.rules;

import com.google.common.collect.Lists;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.jobs.ThreeTimesMetRule_Job;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex.ThreeTimesMet_Pattern;
import java.util.List;
import org.eclipse.viatra.cep.core.api.evm.CepActivationStates;
import org.eclipse.viatra.cep.core.api.patterns.IObservableComplexEventPattern;
import org.eclipse.viatra.cep.core.api.rules.CepJob;
import org.eclipse.viatra.cep.core.api.rules.ICepRule;
import org.eclipse.viatra.cep.core.metamodels.events.EventPattern;

@SuppressWarnings("all")
public class ThreeTimesMetRule implements ICepRule {
  private List<EventPattern> eventPatterns = Lists.newArrayList();
  
  private CepJob<IObservableComplexEventPattern> job = new ThreeTimesMetRule_Job(CepActivationStates.ACTIVE);
  
  public ThreeTimesMetRule() {
    eventPatterns.add(new ThreeTimesMet_Pattern());
  }
  
  @Override
  public List<EventPattern> getEventPatterns() {
    return this.eventPatterns;
  }
  
  @Override
  public CepJob<IObservableComplexEventPattern> getJob() {
    return this.job;
  }
}
