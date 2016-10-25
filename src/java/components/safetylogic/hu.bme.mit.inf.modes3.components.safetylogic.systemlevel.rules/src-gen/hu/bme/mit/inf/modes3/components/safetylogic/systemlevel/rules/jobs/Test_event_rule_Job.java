package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.jobs;

import org.eclipse.viatra.cep.core.api.patterns.IObservableComplexEventPattern;
import org.eclipse.viatra.cep.core.api.rules.CepJob;
import org.eclipse.viatra.transformation.evm.api.Activation;
import org.eclipse.viatra.transformation.evm.api.Context;
import org.eclipse.viatra.transformation.evm.api.event.ActivationState;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class Test_event_rule_Job extends CepJob<IObservableComplexEventPattern> {
  public Test_event_rule_Job(final ActivationState activationState) {
    super(activationState);
  }
  
  @Override
  public void execute(final Activation<? extends IObservableComplexEventPattern> ruleInstance, final Context context) {
    InputOutput.<String>println("Test rule fired");
  }
  
  @Override
  public void handleError(final Activation<? extends IObservableComplexEventPattern> ruleInstance, final Exception exception, final Context context) {
    //not gonna happen
  }
}
