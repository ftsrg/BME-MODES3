/**
 * Generated from platform:/resource/hu.bme.mit.inf.safetylogic.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/PathBuildingHelperQueries.vql
 */
package hu.bme.mit.inf.safetylogic.patterns.util;

import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadElement;
import hu.bme.mit.inf.safetylogic.patterns.ThreeConnectedRailRoadPartsMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.safetylogic.patterns.threeConnectedRailRoadParts pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ThreeConnectedRailRoadPartsProcessor implements IMatchProcessor<ThreeConnectedRailRoadPartsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pOne the value of pattern parameter one in the currently processed match
   * @param pMiddle the value of pattern parameter middle in the currently processed match
   * @param pOther the value of pattern parameter other in the currently processed match
   * 
   */
  public abstract void process(final RailRoadElement pOne, final RailRoadElement pMiddle, final RailRoadElement pOther);
  
  @Override
  public void process(final ThreeConnectedRailRoadPartsMatch match) {
    process(match.getOne(), match.getMiddle(), match.getOther());
  }
}
