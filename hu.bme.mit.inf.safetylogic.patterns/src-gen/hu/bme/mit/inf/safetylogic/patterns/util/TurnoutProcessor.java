package hu.bme.mit.inf.safetylogic.patterns.util;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout;
import hu.bme.mit.inf.safetylogic.patterns.TurnoutMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.safetylogic.patterns.turnout pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TurnoutProcessor implements IMatchProcessor<TurnoutMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTurnout the value of pattern parameter turnout in the currently processed match
   * 
   */
  public abstract void process(final Turnout pTurnout);
  
  @Override
  public void process(final TurnoutMatch match) {
    process(match.getTurnout());
  }
}
