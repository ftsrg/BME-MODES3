/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/DerivedFeatures.vql
 */
package hu.bme.mit.inf.safetylogic.patterns.util;

import hu.bme.mit.inf.safetylogic.patterns.CurrentlyConnectedMatch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.safetylogic.patterns.currentlyConnected pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class CurrentlyConnectedProcessor implements IMatchProcessor<CurrentlyConnectedMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pThis the value of pattern parameter This in the currently processed match
   * @param pConnectedTo the value of pattern parameter connectedTo in the currently processed match
   * 
   */
  public abstract void process(final EObject pThis, final EObject pConnectedTo);
  
  @Override
  public void process(final CurrentlyConnectedMatch match) {
    process(match.getThis(), match.getConnectedTo());
  }
}
