/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/SafetyPatterns.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train;
import hu.bme.mit.inf.safetylogic.patterns.TrainCutsTurnoutMatch;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainCutsTurnoutQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.inf.safetylogic.patterns.trainCutsTurnout pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link TrainCutsTurnoutMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern trainCutsTurnout(Offender : Train, Victim : RailRoadElement){
 * 	find trainCutsTurnoutNext(Offender, Victim);
 * } or {
 * 	find trainCutsTurnoutNextAfterNext(Offender, Victim);
 * }
 * </pre></code>
 * 
 * @see TrainCutsTurnoutMatch
 * @see TrainCutsTurnoutProcessor
 * @see TrainCutsTurnoutQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class TrainCutsTurnoutMatcher extends BaseMatcher<TrainCutsTurnoutMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static TrainCutsTurnoutMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    TrainCutsTurnoutMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (TrainCutsTurnoutMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static TrainCutsTurnoutMatcher create() throws ViatraQueryException {
    return new TrainCutsTurnoutMatcher();
  }
  
  private final static int POSITION_OFFENDER = 0;
  
  private final static int POSITION_VICTIM = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(TrainCutsTurnoutMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private TrainCutsTurnoutMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOffender the fixed value of pattern parameter Offender, or null if not bound.
   * @param pVictim the fixed value of pattern parameter Victim, or null if not bound.
   * @return matches represented as a TrainCutsTurnoutMatch object.
   * 
   */
  public Collection<TrainCutsTurnoutMatch> getAllMatches(final Train pOffender, final RailRoadElement pVictim) {
    return rawGetAllMatches(new Object[]{pOffender, pVictim});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOffender the fixed value of pattern parameter Offender, or null if not bound.
   * @param pVictim the fixed value of pattern parameter Victim, or null if not bound.
   * @return a match represented as a TrainCutsTurnoutMatch object, or null if no match is found.
   * 
   */
  public TrainCutsTurnoutMatch getOneArbitraryMatch(final Train pOffender, final RailRoadElement pVictim) {
    return rawGetOneArbitraryMatch(new Object[]{pOffender, pVictim});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pOffender the fixed value of pattern parameter Offender, or null if not bound.
   * @param pVictim the fixed value of pattern parameter Victim, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Train pOffender, final RailRoadElement pVictim) {
    return rawHasMatch(new Object[]{pOffender, pVictim});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOffender the fixed value of pattern parameter Offender, or null if not bound.
   * @param pVictim the fixed value of pattern parameter Victim, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Train pOffender, final RailRoadElement pVictim) {
    return rawCountMatches(new Object[]{pOffender, pVictim});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pOffender the fixed value of pattern parameter Offender, or null if not bound.
   * @param pVictim the fixed value of pattern parameter Victim, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Train pOffender, final RailRoadElement pVictim, final IMatchProcessor<? super TrainCutsTurnoutMatch> processor) {
    rawForEachMatch(new Object[]{pOffender, pVictim}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOffender the fixed value of pattern parameter Offender, or null if not bound.
   * @param pVictim the fixed value of pattern parameter Victim, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Train pOffender, final RailRoadElement pVictim, final IMatchProcessor<? super TrainCutsTurnoutMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pOffender, pVictim}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOffender the fixed value of pattern parameter Offender, or null if not bound.
   * @param pVictim the fixed value of pattern parameter Victim, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public TrainCutsTurnoutMatch newMatch(final Train pOffender, final RailRoadElement pVictim) {
    return TrainCutsTurnoutMatch.newMatch(pOffender, pVictim);
  }
  
  /**
   * Retrieve the set of values that occur in matches for Offender.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Train> rawAccumulateAllValuesOfOffender(final Object[] parameters) {
    Set<Train> results = new HashSet<Train>();
    rawAccumulateAllValues(POSITION_OFFENDER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Offender.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOfOffender() {
    return rawAccumulateAllValuesOfOffender(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Offender.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOfOffender(final TrainCutsTurnoutMatch partialMatch) {
    return rawAccumulateAllValuesOfOffender(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Offender.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOfOffender(final RailRoadElement pVictim) {
    return rawAccumulateAllValuesOfOffender(new Object[]{
    null, 
    pVictim
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for Victim.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<RailRoadElement> rawAccumulateAllValuesOfVictim(final Object[] parameters) {
    Set<RailRoadElement> results = new HashSet<RailRoadElement>();
    rawAccumulateAllValues(POSITION_VICTIM, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Victim.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RailRoadElement> getAllValuesOfVictim() {
    return rawAccumulateAllValuesOfVictim(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Victim.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RailRoadElement> getAllValuesOfVictim(final TrainCutsTurnoutMatch partialMatch) {
    return rawAccumulateAllValuesOfVictim(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Victim.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RailRoadElement> getAllValuesOfVictim(final Train pOffender) {
    return rawAccumulateAllValuesOfVictim(new Object[]{
    pOffender, 
    null
    });
  }
  
  @Override
  protected TrainCutsTurnoutMatch tupleToMatch(final Tuple t) {
    try {
    	return TrainCutsTurnoutMatch.newMatch((Train) t.get(POSITION_OFFENDER), (RailRoadElement) t.get(POSITION_VICTIM));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TrainCutsTurnoutMatch arrayToMatch(final Object[] match) {
    try {
    	return TrainCutsTurnoutMatch.newMatch((Train) match[POSITION_OFFENDER], (RailRoadElement) match[POSITION_VICTIM]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TrainCutsTurnoutMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return TrainCutsTurnoutMatch.newMutableMatch((Train) match[POSITION_OFFENDER], (RailRoadElement) match[POSITION_VICTIM]);
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
  public static IQuerySpecification<TrainCutsTurnoutMatcher> querySpecification() throws ViatraQueryException {
    return TrainCutsTurnoutQuerySpecification.instance();
  }
}
