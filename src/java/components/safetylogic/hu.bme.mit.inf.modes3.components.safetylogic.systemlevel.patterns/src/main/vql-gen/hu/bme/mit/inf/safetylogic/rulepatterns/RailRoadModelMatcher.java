/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/rulepatterns/RulePatterns.vql
 */
package hu.bme.mit.inf.safetylogic.rulepatterns;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel;
import hu.bme.mit.inf.safetylogic.rulepatterns.RailRoadModelMatch;
import hu.bme.mit.inf.safetylogic.rulepatterns.util.RailRoadModelQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the hu.bme.mit.inf.safetylogic.rulepatterns.railRoadModel pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link RailRoadModelMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern railRoadModel(model : RailRoadModel) {
 * 	RailRoadModel(model);
 * }
 * </pre></code>
 * 
 * @see RailRoadModelMatch
 * @see RailRoadModelProcessor
 * @see RailRoadModelQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class RailRoadModelMatcher extends BaseMatcher<RailRoadModelMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static RailRoadModelMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    RailRoadModelMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (RailRoadModelMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static RailRoadModelMatcher create() throws ViatraQueryException {
    return new RailRoadModelMatcher();
  }
  
  private final static int POSITION_MODEL = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(RailRoadModelMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private RailRoadModelMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @return matches represented as a RailRoadModelMatch object.
   * 
   */
  public Collection<RailRoadModelMatch> getAllMatches(final RailRoadModel pModel) {
    return rawGetAllMatches(new Object[]{pModel});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @return a match represented as a RailRoadModelMatch object, or null if no match is found.
   * 
   */
  public RailRoadModelMatch getOneArbitraryMatch(final RailRoadModel pModel) {
    return rawGetOneArbitraryMatch(new Object[]{pModel});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final RailRoadModel pModel) {
    return rawHasMatch(new Object[]{pModel});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final RailRoadModel pModel) {
    return rawCountMatches(new Object[]{pModel});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final RailRoadModel pModel, final IMatchProcessor<? super RailRoadModelMatch> processor) {
    rawForEachMatch(new Object[]{pModel}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final RailRoadModel pModel, final IMatchProcessor<? super RailRoadModelMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pModel}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public RailRoadModelMatch newMatch(final RailRoadModel pModel) {
    return RailRoadModelMatch.newMatch(pModel);
  }
  
  /**
   * Retrieve the set of values that occur in matches for model.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<RailRoadModel> rawAccumulateAllValuesOfmodel(final Object[] parameters) {
    Set<RailRoadModel> results = new HashSet<RailRoadModel>();
    rawAccumulateAllValues(POSITION_MODEL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for model.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RailRoadModel> getAllValuesOfmodel() {
    return rawAccumulateAllValuesOfmodel(emptyArray());
  }
  
  @Override
  protected RailRoadModelMatch tupleToMatch(final Tuple t) {
    try {
    	return RailRoadModelMatch.newMatch((RailRoadModel) t.get(POSITION_MODEL));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected RailRoadModelMatch arrayToMatch(final Object[] match) {
    try {
    	return RailRoadModelMatch.newMatch((RailRoadModel) match[POSITION_MODEL]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected RailRoadModelMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return RailRoadModelMatch.newMutableMatch((RailRoadModel) match[POSITION_MODEL]);
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
  public static IQuerySpecification<RailRoadModelMatcher> querySpecification() throws ViatraQueryException {
    return RailRoadModelQuerySpecification.instance();
  }
}
