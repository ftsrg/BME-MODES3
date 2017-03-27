/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/rulepatterns/RulePatterns.vql
 */
package hu.bme.mit.inf.safetylogic.rulepatterns;

import hu.bme.mit.inf.safetylogic.rulepatterns.NoTrainOnStationMatch;
import hu.bme.mit.inf.safetylogic.rulepatterns.util.NoTrainOnStationQuerySpecification;
import org.apache.log4j.Logger;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the hu.bme.mit.inf.safetylogic.rulepatterns.noTrainOnStation pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link NoTrainOnStationMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern noTrainOnStation() {
 * 	count find trainIsNotInStation(_) == 0;
 * }
 * </pre></code>
 * 
 * @see NoTrainOnStationMatch
 * @see NoTrainOnStationProcessor
 * @see NoTrainOnStationQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class NoTrainOnStationMatcher extends BaseMatcher<NoTrainOnStationMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static NoTrainOnStationMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    NoTrainOnStationMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (NoTrainOnStationMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static NoTrainOnStationMatcher create() throws ViatraQueryException {
    return new NoTrainOnStationMatcher();
  }
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(NoTrainOnStationMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private NoTrainOnStationMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Indicates whether the (parameterless) pattern matches or not.
   * @return true if the pattern has a valid match.
   * 
   */
  public boolean hasMatch() {
    return rawHasMatch(new Object[]{});
  }
  
  @Override
  protected NoTrainOnStationMatch tupleToMatch(final Tuple t) {
    try {
    	return NoTrainOnStationMatch.newMatch();
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NoTrainOnStationMatch arrayToMatch(final Object[] match) {
    try {
    	return NoTrainOnStationMatch.newMatch();
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NoTrainOnStationMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return NoTrainOnStationMatch.newMutableMatch();
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<NoTrainOnStationMatcher> querySpecification() throws ViatraQueryException {
    return NoTrainOnStationQuerySpecification.instance();
  }
}
