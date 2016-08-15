/**
 * Generated from platform:/resource/hu.bme.mit.inf.safetylogic.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/RailRoadQueries.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement;
import hu.bme.mit.inf.safetylogic.patterns.FooMatch;
import hu.bme.mit.inf.safetylogic.patterns.util.FooQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.inf.safetylogic.patterns.foo pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link FooMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern foo(asd : RailRoadElement){
 * 	RailRoadElement(asd);
 * }
 * </pre></code>
 * 
 * @see FooMatch
 * @see FooProcessor
 * @see FooQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class FooMatcher extends BaseMatcher<FooMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static FooMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    FooMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new FooMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_ASD = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(FooMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private FooMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pAsd the fixed value of pattern parameter asd, or null if not bound.
   * @return matches represented as a FooMatch object.
   * 
   */
  public Collection<FooMatch> getAllMatches(final RailRoadElement pAsd) {
    return rawGetAllMatches(new Object[]{pAsd});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pAsd the fixed value of pattern parameter asd, or null if not bound.
   * @return a match represented as a FooMatch object, or null if no match is found.
   * 
   */
  public FooMatch getOneArbitraryMatch(final RailRoadElement pAsd) {
    return rawGetOneArbitraryMatch(new Object[]{pAsd});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pAsd the fixed value of pattern parameter asd, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final RailRoadElement pAsd) {
    return rawHasMatch(new Object[]{pAsd});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pAsd the fixed value of pattern parameter asd, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final RailRoadElement pAsd) {
    return rawCountMatches(new Object[]{pAsd});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pAsd the fixed value of pattern parameter asd, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final RailRoadElement pAsd, final IMatchProcessor<? super FooMatch> processor) {
    rawForEachMatch(new Object[]{pAsd}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pAsd the fixed value of pattern parameter asd, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final RailRoadElement pAsd, final IMatchProcessor<? super FooMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pAsd}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAsd the fixed value of pattern parameter asd, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public FooMatch newMatch(final RailRoadElement pAsd) {
    return FooMatch.newMatch(pAsd);
  }
  
  /**
   * Retrieve the set of values that occur in matches for asd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<RailRoadElement> rawAccumulateAllValuesOfasd(final Object[] parameters) {
    Set<RailRoadElement> results = new HashSet<RailRoadElement>();
    rawAccumulateAllValues(POSITION_ASD, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for asd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RailRoadElement> getAllValuesOfasd() {
    return rawAccumulateAllValuesOfasd(emptyArray());
  }
  
  @Override
  protected FooMatch tupleToMatch(final Tuple t) {
    try {
    	return FooMatch.newMatch((RailRoadElement) t.get(POSITION_ASD));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected FooMatch arrayToMatch(final Object[] match) {
    try {
    	return FooMatch.newMatch((RailRoadElement) match[POSITION_ASD]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected FooMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return FooMatch.newMutableMatch((RailRoadElement) match[POSITION_ASD]);
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
  public static IQuerySpecification<FooMatcher> querySpecification() throws ViatraQueryException {
    return FooQuerySpecification.instance();
  }
}
