/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/PathBuildingHelperQueries.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.patterns.ThreeConnectedRailRoadPartsMatcher;
import hu.bme.mit.inf.safetylogic.patterns.util.ThreeConnectedRailRoadPartsQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all patterns defined in PathBuildingHelperQueries.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file PathBuildingHelperQueries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.inf.safetylogic.patterns, the group contains the definition of the following patterns: <ul>
 * <li>threeConnectedRailRoadParts</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class PathBuildingHelperQueries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static PathBuildingHelperQueries instance() throws ViatraQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new PathBuildingHelperQueries();
    }
    return INSTANCE;
  }
  
  private static PathBuildingHelperQueries INSTANCE;
  
  private PathBuildingHelperQueries() throws ViatraQueryException {
    querySpecifications.add(ThreeConnectedRailRoadPartsQuerySpecification.instance());
  }
  
  public ThreeConnectedRailRoadPartsQuerySpecification getThreeConnectedRailRoadParts() throws ViatraQueryException {
    return ThreeConnectedRailRoadPartsQuerySpecification.instance();
  }
  
  public ThreeConnectedRailRoadPartsMatcher getThreeConnectedRailRoadParts(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ThreeConnectedRailRoadPartsMatcher.on(engine);
  }
}
