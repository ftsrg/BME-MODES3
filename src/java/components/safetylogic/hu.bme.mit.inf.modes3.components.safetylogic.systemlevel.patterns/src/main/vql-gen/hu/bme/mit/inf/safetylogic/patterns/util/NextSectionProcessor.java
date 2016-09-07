/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/SafetyPatterns.vql
 */
package hu.bme.mit.inf.safetylogic.patterns.util;

import hu.bme.mit.inf.safetylogic.patterns.NextSectionMatch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.safetylogic.patterns.nextSection pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class NextSectionProcessor implements IMatchProcessor<NextSectionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pOld the value of pattern parameter Old in the currently processed match
   * @param pCurrent the value of pattern parameter Current in the currently processed match
   * @param pNext the value of pattern parameter Next in the currently processed match
   * 
   */
  public abstract void process(final EObject pOld, final EObject pCurrent, final EObject pNext);
  
  @Override
  public void process(final NextSectionMatch match) {
    process(match.getOld(), match.getCurrent(), match.getNext());
  }
}
