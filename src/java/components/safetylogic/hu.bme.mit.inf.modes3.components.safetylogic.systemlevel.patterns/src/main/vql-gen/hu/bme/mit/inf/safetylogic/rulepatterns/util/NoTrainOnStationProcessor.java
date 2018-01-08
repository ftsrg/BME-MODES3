/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/rulepatterns/RulePatterns.vql
 */
package hu.bme.mit.inf.safetylogic.rulepatterns.util;

import hu.bme.mit.inf.safetylogic.rulepatterns.NoTrainOnStationMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.safetylogic.rulepatterns.noTrainOnStation pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class NoTrainOnStationProcessor implements IMatchProcessor<NoTrainOnStationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * 
   */
  public abstract void process();
  
  @Override
  public void process(final NoTrainOnStationMatch match) {
    process();
  }
}
