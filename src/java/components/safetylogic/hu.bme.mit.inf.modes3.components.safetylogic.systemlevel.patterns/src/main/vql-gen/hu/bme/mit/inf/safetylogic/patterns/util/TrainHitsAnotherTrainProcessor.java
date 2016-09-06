/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/SafetyPatterns.vql
 */
package hu.bme.mit.inf.safetylogic.patterns.util;

import hu.bme.mit.inf.safetylogic.patterns.TrainHitsAnotherTrainMatch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.safetylogic.patterns.trainHitsAnotherTrain pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TrainHitsAnotherTrainProcessor implements IMatchProcessor<TrainHitsAnotherTrainMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pOffender the value of pattern parameter Offender in the currently processed match
   * @param pVictim the value of pattern parameter Victim in the currently processed match
   * 
   */
  public abstract void process(final EObject pOffender, final EObject pVictim);
  
  @Override
  public void process(final TrainHitsAnotherTrainMatch match) {
    process(match.getOffender(), match.getVictim());
  }
}
