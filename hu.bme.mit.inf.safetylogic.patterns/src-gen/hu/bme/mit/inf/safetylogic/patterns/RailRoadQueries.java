/**
 * Generated from platform:/resource/hu.bme.mit.inf.safetylogic.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/RailRoadQueries.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.patterns.FooMatcher;
import hu.bme.mit.inf.safetylogic.patterns.util.FooQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all patterns defined in RailRoadQueries.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file RailRoadQueries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.inf.safetylogic.patterns, the group contains the definition of the following patterns: <ul>
 * <li>foo</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class RailRoadQueries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static RailRoadQueries instance() throws ViatraQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new RailRoadQueries();
    }
    return INSTANCE;
  }
  
  private static RailRoadQueries INSTANCE;
  
  private RailRoadQueries() throws ViatraQueryException {
    querySpecifications.add(FooQuerySpecification.instance());
  }
  
  public FooQuerySpecification getFoo() throws ViatraQueryException {
    return FooQuerySpecification.instance();
  }
  
  public FooMatcher getFoo(final ViatraQueryEngine engine) throws ViatraQueryException {
    return FooMatcher.on(engine);
  }
}
