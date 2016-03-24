package hu.bme.mit.inf.safetylogic.patterns.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.BlindTrack;
import hu.bme.mit.inf.safetylogic.patterns.BlindTrackMatch;

/**
 * A match processor tailored for the hu.bme.mit.inf.safetylogic.patterns.blindTrack pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class BlindTrackProcessor implements IMatchProcessor<BlindTrackMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBlindTrack the value of pattern parameter blindTrack in the currently processed match
   * 
   */
  public abstract void process(final BlindTrack pBlindTrack);
  
  @Override
  public void process(final BlindTrackMatch match) {
    process(match.getBlindTrack());
  }
}
