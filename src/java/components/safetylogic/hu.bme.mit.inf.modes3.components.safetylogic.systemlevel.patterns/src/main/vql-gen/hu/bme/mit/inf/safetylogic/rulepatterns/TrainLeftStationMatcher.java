/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/rulepatterns/RulePatterns.vql
 */
package hu.bme.mit.inf.safetylogic.rulepatterns;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train;
import hu.bme.mit.inf.safetylogic.rulepatterns.TrainLeftStationMatch;
import hu.bme.mit.inf.safetylogic.rulepatterns.util.TrainLeftStationQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.inf.safetylogic.rulepatterns.trainLeftStation pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link TrainLeftStationMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern trainLeftStation(t : Train) {
 * 	Train.previouslyOn.id(t, 18);
 * } or {
 * 	Train.previouslyOn.id(t, 19);
 * } or {
 * 	Train.previouslyOn.id(t, 20);
 * }
 * </pre></code>
 * 
 * @see TrainLeftStationMatch
 * @see TrainLeftStationProcessor
 * @see TrainLeftStationQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class TrainLeftStationMatcher extends BaseMatcher<TrainLeftStationMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static TrainLeftStationMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    TrainLeftStationMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (TrainLeftStationMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static TrainLeftStationMatcher create() throws ViatraQueryException {
    return new TrainLeftStationMatcher();
  }
  
  private final static int POSITION_T = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(TrainLeftStationMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private TrainLeftStationMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @return matches represented as a TrainLeftStationMatch object.
   * 
   */
  public Collection<TrainLeftStationMatch> getAllMatches(final Train pT) {
    return rawGetAllMatches(new Object[]{pT});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @return a match represented as a TrainLeftStationMatch object, or null if no match is found.
   * 
   */
  public TrainLeftStationMatch getOneArbitraryMatch(final Train pT) {
    return rawGetOneArbitraryMatch(new Object[]{pT});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Train pT) {
    return rawHasMatch(new Object[]{pT});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Train pT) {
    return rawCountMatches(new Object[]{pT});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Train pT, final IMatchProcessor<? super TrainLeftStationMatch> processor) {
    rawForEachMatch(new Object[]{pT}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Train pT, final IMatchProcessor<? super TrainLeftStationMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pT}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public TrainLeftStationMatch newMatch(final Train pT) {
    return TrainLeftStationMatch.newMatch(pT);
  }
  
  /**
   * Retrieve the set of values that occur in matches for t.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Train> rawAccumulateAllValuesOft(final Object[] parameters) {
    Set<Train> results = new HashSet<Train>();
    rawAccumulateAllValues(POSITION_T, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for t.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOft() {
    return rawAccumulateAllValuesOft(emptyArray());
  }
  
  @Override
  protected TrainLeftStationMatch tupleToMatch(final Tuple t) {
    try {
    	return TrainLeftStationMatch.newMatch((Train) t.get(POSITION_T));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TrainLeftStationMatch arrayToMatch(final Object[] match) {
    try {
    	return TrainLeftStationMatch.newMatch((Train) match[POSITION_T]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TrainLeftStationMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return TrainLeftStationMatch.newMutableMatch((Train) match[POSITION_T]);
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
  public static IQuerySpecification<TrainLeftStationMatcher> querySpecification() throws ViatraQueryException {
    return TrainLeftStationQuerySpecification.instance();
  }
}
