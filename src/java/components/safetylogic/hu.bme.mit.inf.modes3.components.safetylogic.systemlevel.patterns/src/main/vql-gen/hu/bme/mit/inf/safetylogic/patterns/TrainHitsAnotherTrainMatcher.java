/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/SafetyPatterns.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train;
import hu.bme.mit.inf.safetylogic.patterns.TrainHitsAnotherTrainMatch;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainHitsAnotherTrainQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.inf.safetylogic.patterns.trainHitsAnotherTrain pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link TrainHitsAnotherTrainMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern trainHitsAnotherTrain(Offender : Train, Victim : Train){
 * 	find trainHitsAnotherTrainNext(Offender, Victim);
 * } or {
 * 	find trainHitsAnotherTrainNextAfterNext(Offender, Victim);
 * } or {
 * 	find trainsAreTooClose(Offender, Victim);
 * }
 * </pre></code>
 * 
 * @see TrainHitsAnotherTrainMatch
 * @see TrainHitsAnotherTrainProcessor
 * @see TrainHitsAnotherTrainQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class TrainHitsAnotherTrainMatcher extends BaseMatcher<TrainHitsAnotherTrainMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static TrainHitsAnotherTrainMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    TrainHitsAnotherTrainMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (TrainHitsAnotherTrainMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static TrainHitsAnotherTrainMatcher create() throws ViatraQueryException {
    return new TrainHitsAnotherTrainMatcher();
  }
  
  private final static int POSITION_OFFENDER = 0;
  
  private final static int POSITION_VICTIM = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(TrainHitsAnotherTrainMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private TrainHitsAnotherTrainMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOffender the fixed value of pattern parameter Offender, or null if not bound.
   * @param pVictim the fixed value of pattern parameter Victim, or null if not bound.
   * @return matches represented as a TrainHitsAnotherTrainMatch object.
   * 
   */
  public Collection<TrainHitsAnotherTrainMatch> getAllMatches(final Train pOffender, final Train pVictim) {
    return rawGetAllMatches(new Object[]{pOffender, pVictim});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOffender the fixed value of pattern parameter Offender, or null if not bound.
   * @param pVictim the fixed value of pattern parameter Victim, or null if not bound.
   * @return a match represented as a TrainHitsAnotherTrainMatch object, or null if no match is found.
   * 
   */
  public TrainHitsAnotherTrainMatch getOneArbitraryMatch(final Train pOffender, final Train pVictim) {
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
  public boolean hasMatch(final Train pOffender, final Train pVictim) {
    return rawHasMatch(new Object[]{pOffender, pVictim});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOffender the fixed value of pattern parameter Offender, or null if not bound.
   * @param pVictim the fixed value of pattern parameter Victim, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Train pOffender, final Train pVictim) {
    return rawCountMatches(new Object[]{pOffender, pVictim});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pOffender the fixed value of pattern parameter Offender, or null if not bound.
   * @param pVictim the fixed value of pattern parameter Victim, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Train pOffender, final Train pVictim, final IMatchProcessor<? super TrainHitsAnotherTrainMatch> processor) {
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
  public boolean forOneArbitraryMatch(final Train pOffender, final Train pVictim, final IMatchProcessor<? super TrainHitsAnotherTrainMatch> processor) {
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
  public TrainHitsAnotherTrainMatch newMatch(final Train pOffender, final Train pVictim) {
    return TrainHitsAnotherTrainMatch.newMatch(pOffender, pVictim);
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
  public Set<Train> getAllValuesOfOffender(final TrainHitsAnotherTrainMatch partialMatch) {
    return rawAccumulateAllValuesOfOffender(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Offender.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOfOffender(final Train pVictim) {
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
  protected Set<Train> rawAccumulateAllValuesOfVictim(final Object[] parameters) {
    Set<Train> results = new HashSet<Train>();
    rawAccumulateAllValues(POSITION_VICTIM, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Victim.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOfVictim() {
    return rawAccumulateAllValuesOfVictim(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Victim.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOfVictim(final TrainHitsAnotherTrainMatch partialMatch) {
    return rawAccumulateAllValuesOfVictim(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Victim.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOfVictim(final Train pOffender) {
    return rawAccumulateAllValuesOfVictim(new Object[]{
    pOffender, 
    null
    });
  }
  
  @Override
  protected TrainHitsAnotherTrainMatch tupleToMatch(final Tuple t) {
    try {
    	return TrainHitsAnotherTrainMatch.newMatch((Train) t.get(POSITION_OFFENDER), (Train) t.get(POSITION_VICTIM));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TrainHitsAnotherTrainMatch arrayToMatch(final Object[] match) {
    try {
    	return TrainHitsAnotherTrainMatch.newMatch((Train) match[POSITION_OFFENDER], (Train) match[POSITION_VICTIM]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TrainHitsAnotherTrainMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return TrainHitsAnotherTrainMatch.newMutableMatch((Train) match[POSITION_OFFENDER], (Train) match[POSITION_VICTIM]);
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
  public static IQuerySpecification<TrainHitsAnotherTrainMatcher> querySpecification() throws ViatraQueryException {
    return TrainHitsAnotherTrainQuerySpecification.instance();
  }
}
