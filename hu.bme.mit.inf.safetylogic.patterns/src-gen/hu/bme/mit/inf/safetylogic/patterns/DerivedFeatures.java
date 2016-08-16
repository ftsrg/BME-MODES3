/**
 * Generated from platform:/resource/hu.bme.mit.inf.safetylogic.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/DerivedFeatures.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.patterns.ConnectedMatcher;
import hu.bme.mit.inf.safetylogic.patterns.CurrentlyConnectedMatcher;
import hu.bme.mit.inf.safetylogic.patterns.ViablePathsMatcher;
import hu.bme.mit.inf.safetylogic.patterns.util.ConnectedQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.CurrentlyConnectedQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.ViablePathsQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all patterns defined in DerivedFeatures.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file DerivedFeatures.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.inf.safetylogic.patterns, the group contains the definition of the following patterns: <ul>
 * <li>currentlyConnected</li>
 * <li>connected</li>
 * <li>viablePaths</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class DerivedFeatures extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static DerivedFeatures instance() throws ViatraQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new DerivedFeatures();
    }
    return INSTANCE;
  }
  
  private static DerivedFeatures INSTANCE;
  
  private DerivedFeatures() throws ViatraQueryException {
    querySpecifications.add(CurrentlyConnectedQuerySpecification.instance());
    querySpecifications.add(ConnectedQuerySpecification.instance());
    querySpecifications.add(ViablePathsQuerySpecification.instance());
  }
  
  public CurrentlyConnectedQuerySpecification getCurrentlyConnected() throws ViatraQueryException {
    return CurrentlyConnectedQuerySpecification.instance();
  }
  
  public CurrentlyConnectedMatcher getCurrentlyConnected(final ViatraQueryEngine engine) throws ViatraQueryException {
    return CurrentlyConnectedMatcher.on(engine);
  }
  
  public ConnectedQuerySpecification getConnected() throws ViatraQueryException {
    return ConnectedQuerySpecification.instance();
  }
  
  public ConnectedMatcher getConnected(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ConnectedMatcher.on(engine);
  }
  
  public ViablePathsQuerySpecification getViablePaths() throws ViatraQueryException {
    return ViablePathsQuerySpecification.instance();
  }
  
  public ViablePathsMatcher getViablePaths(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ViablePathsMatcher.on(engine);
  }
}
