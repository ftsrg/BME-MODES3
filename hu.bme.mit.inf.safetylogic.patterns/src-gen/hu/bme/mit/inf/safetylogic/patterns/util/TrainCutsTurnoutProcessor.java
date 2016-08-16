/**
 * Generated from platform:/resource/hu.bme.mit.inf.safetylogic.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/SafetyPatterns.vql
 */
package hu.bme.mit.inf.safetylogic.patterns.util;

import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadElement;
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Train;
import hu.bme.mit.inf.safetylogic.patterns.TrainCutsTurnoutMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.safetylogic.patterns.trainCutsTurnout pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TrainCutsTurnoutProcessor implements IMatchProcessor<TrainCutsTurnoutMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pOffender the value of pattern parameter Offender in the currently processed match
   * @param pVictim the value of pattern parameter Victim in the currently processed match
   * 
   */
  public abstract void process(final Train pOffender, final RailRoadElement pVictim);
  
  @Override
  public void process(final TrainCutsTurnoutMatch match) {
    process(match.getOffender(), match.getVictim());
  }
}
