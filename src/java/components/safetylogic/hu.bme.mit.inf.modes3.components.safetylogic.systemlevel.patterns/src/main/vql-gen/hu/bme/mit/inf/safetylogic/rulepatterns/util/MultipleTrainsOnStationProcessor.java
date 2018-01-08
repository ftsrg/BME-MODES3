/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/rulepatterns/RulePatterns.vql
 */
package hu.bme.mit.inf.safetylogic.rulepatterns.util;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train;
import hu.bme.mit.inf.safetylogic.rulepatterns.MultipleTrainsOnStationMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.safetylogic.rulepatterns.multipleTrainsOnStation pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MultipleTrainsOnStationProcessor implements IMatchProcessor<MultipleTrainsOnStationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pT1 the value of pattern parameter t1 in the currently processed match
   * @param pT2 the value of pattern parameter t2 in the currently processed match
   * 
   */
  public abstract void process(final Train pT1, final Train pT2);
  
  @Override
  public void process(final MultipleTrainsOnStationMatch match) {
    process(match.getT1(), match.getT2());
  }
}
