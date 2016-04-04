package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Train;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout;
import hu.bme.mit.inf.safetylogic.patterns.TrainGoingToCutTheTurnoutMatch;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainGoingToCutTheTurnoutQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;

/**
 * Generated pattern matcher API of the hu.bme.mit.inf.safetylogic.patterns.trainGoingToCutTheTurnout pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link TrainGoingToCutTheTurnoutMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern trainGoingToCutTheTurnout(train : Train, turnout : Turnout){
 * 	find trainsNextTurnout(train, turnout);
 * 	Train.goingClockwise(train,true);
 * 	Section.clockwise(sectionNearTheTurnout, turnout);
 * 	Turnout.notConnectedSection(turnout, sectionNearTheTurnout);
 * 	Train.currentlyOn(train, trainSection);
 * 	find inSameRailroadPart(trainSection, sectionNearTheTurnout);
 * } or {
 * 	find trainsNextTurnout(train, turnout);
 * 	Train.goingClockwise(train,false);
 * 	Section.counterClockwise(sectionNearTheTurnout, turnout);
 * 	Turnout.notConnectedSection(turnout, sectionNearTheTurnout);
 * 	Train.currentlyOn(train, trainSection);
 * 	find inSameRailroadPart(trainSection, sectionNearTheTurnout);
 * } or {
 * 	EnglishTurnout(turnout); // the english turnout only behaves badly from ccw direction 
 * 	find trainsNextTurnout(train, turnout);
 * 	Train.goingClockwise(train,false);
 * 	Section.counterClockwise(sectionNearTheTurnout, turnout);
 * 	EnglishTurnout.notConnectedClockwiseSection(turnout, sectionNearTheTurnout);
 * 	Train.currentlyOn(train, trainSection);
 * 	find inSameRailroadPart(trainSection, sectionNearTheTurnout);
 * }
 * </pre></code>
 * 
 * @see TrainGoingToCutTheTurnoutMatch
 * @see TrainGoingToCutTheTurnoutProcessor
 * @see TrainGoingToCutTheTurnoutQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class TrainGoingToCutTheTurnoutMatcher extends BaseMatcher<TrainGoingToCutTheTurnoutMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static TrainGoingToCutTheTurnoutMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    TrainGoingToCutTheTurnoutMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new TrainGoingToCutTheTurnoutMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_TRAIN = 0;
  
  private final static int POSITION_TURNOUT = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(TrainGoingToCutTheTurnoutMatcher.class);
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet).
   * If a pattern matcher is already constructed with the same root, only a light-weight reference is returned.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead, e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}
   * 
   */
  @Deprecated
  public TrainGoingToCutTheTurnoutMatcher(final Notifier emfRoot) throws IncQueryException {
    this(IncQueryEngine.on(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead
   * 
   */
  @Deprecated
  public TrainGoingToCutTheTurnoutMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pTrain the fixed value of pattern parameter train, or null if not bound.
   * @param pTurnout the fixed value of pattern parameter turnout, or null if not bound.
   * @return matches represented as a TrainGoingToCutTheTurnoutMatch object.
   * 
   */
  public Collection<TrainGoingToCutTheTurnoutMatch> getAllMatches(final Train pTrain, final Turnout pTurnout) {
    return rawGetAllMatches(new Object[]{pTrain, pTurnout});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pTrain the fixed value of pattern parameter train, or null if not bound.
   * @param pTurnout the fixed value of pattern parameter turnout, or null if not bound.
   * @return a match represented as a TrainGoingToCutTheTurnoutMatch object, or null if no match is found.
   * 
   */
  public TrainGoingToCutTheTurnoutMatch getOneArbitraryMatch(final Train pTrain, final Turnout pTurnout) {
    return rawGetOneArbitraryMatch(new Object[]{pTrain, pTurnout});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pTrain the fixed value of pattern parameter train, or null if not bound.
   * @param pTurnout the fixed value of pattern parameter turnout, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Train pTrain, final Turnout pTurnout) {
    return rawHasMatch(new Object[]{pTrain, pTurnout});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pTrain the fixed value of pattern parameter train, or null if not bound.
   * @param pTurnout the fixed value of pattern parameter turnout, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Train pTrain, final Turnout pTurnout) {
    return rawCountMatches(new Object[]{pTrain, pTurnout});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pTrain the fixed value of pattern parameter train, or null if not bound.
   * @param pTurnout the fixed value of pattern parameter turnout, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Train pTrain, final Turnout pTurnout, final IMatchProcessor<? super TrainGoingToCutTheTurnoutMatch> processor) {
    rawForEachMatch(new Object[]{pTrain, pTurnout}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pTrain the fixed value of pattern parameter train, or null if not bound.
   * @param pTurnout the fixed value of pattern parameter turnout, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Train pTrain, final Turnout pTurnout, final IMatchProcessor<? super TrainGoingToCutTheTurnoutMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pTrain, pTurnout}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTrain the fixed value of pattern parameter train, or null if not bound.
   * @param pTurnout the fixed value of pattern parameter turnout, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public TrainGoingToCutTheTurnoutMatch newMatch(final Train pTrain, final Turnout pTurnout) {
    return TrainGoingToCutTheTurnoutMatch.newMatch(pTrain, pTurnout);
  }
  
  /**
   * Retrieve the set of values that occur in matches for train.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Train> rawAccumulateAllValuesOftrain(final Object[] parameters) {
    Set<Train> results = new HashSet<Train>();
    rawAccumulateAllValues(POSITION_TRAIN, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for train.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOftrain() {
    return rawAccumulateAllValuesOftrain(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for train.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOftrain(final TrainGoingToCutTheTurnoutMatch partialMatch) {
    return rawAccumulateAllValuesOftrain(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for train.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOftrain(final Turnout pTurnout) {
    return rawAccumulateAllValuesOftrain(new Object[]{
    null, 
    pTurnout
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for turnout.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Turnout> rawAccumulateAllValuesOfturnout(final Object[] parameters) {
    Set<Turnout> results = new HashSet<Turnout>();
    rawAccumulateAllValues(POSITION_TURNOUT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for turnout.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Turnout> getAllValuesOfturnout() {
    return rawAccumulateAllValuesOfturnout(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for turnout.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Turnout> getAllValuesOfturnout(final TrainGoingToCutTheTurnoutMatch partialMatch) {
    return rawAccumulateAllValuesOfturnout(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for turnout.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Turnout> getAllValuesOfturnout(final Train pTrain) {
    return rawAccumulateAllValuesOfturnout(new Object[]{
    pTrain, 
    null
    });
  }
  
  @Override
  protected TrainGoingToCutTheTurnoutMatch tupleToMatch(final Tuple t) {
    try {
    	return TrainGoingToCutTheTurnoutMatch.newMatch((Train) t.get(POSITION_TRAIN), (Turnout) t.get(POSITION_TURNOUT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TrainGoingToCutTheTurnoutMatch arrayToMatch(final Object[] match) {
    try {
    	return TrainGoingToCutTheTurnoutMatch.newMatch((Train) match[POSITION_TRAIN], (Turnout) match[POSITION_TURNOUT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TrainGoingToCutTheTurnoutMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return TrainGoingToCutTheTurnoutMatch.newMutableMatch((Train) match[POSITION_TRAIN], (Turnout) match[POSITION_TURNOUT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<TrainGoingToCutTheTurnoutMatcher> querySpecification() throws IncQueryException {
    return TrainGoingToCutTheTurnoutQuerySpecification.instance();
  }
}
