/**
 * Generated from platform:/resource/hu.bme.mit.inf.safetylogic.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/RailRoadQueries.vql
 */
package hu.bme.mit.inf.safetylogic.patterns.util;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement;
import hu.bme.mit.inf.safetylogic.patterns.FooMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.safetylogic.patterns.foo pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class FooProcessor implements IMatchProcessor<FooMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pAsd the value of pattern parameter asd in the currently processed match
   * 
   */
  public abstract void process(final RailRoadElement pAsd);
  
  @Override
  public void process(final FooMatch match) {
    process(match.getAsd());
  }
}
