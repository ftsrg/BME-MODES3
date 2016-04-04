package hu.bme.mit.inf.safetylogic.patterns.util;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Train;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout;
import hu.bme.mit.inf.safetylogic.patterns.TrainsNextTurnoutMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.safetylogic.patterns.trainsNextTurnout pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TrainsNextTurnoutProcessor implements IMatchProcessor<TrainsNextTurnoutMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTrain the value of pattern parameter train in the currently processed match
   * @param pTurnout the value of pattern parameter turnout in the currently processed match
   * 
   */
  public abstract void process(final Train pTrain, final Turnout pTurnout);
  
  @Override
  public void process(final TrainsNextTurnoutMatch match) {
    process(match.getTrain(), match.getTurnout());
  }
}
