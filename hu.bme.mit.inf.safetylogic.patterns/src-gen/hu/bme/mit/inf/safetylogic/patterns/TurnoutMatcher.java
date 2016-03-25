package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout;
import hu.bme.mit.inf.safetylogic.patterns.TurnoutMatch;
import hu.bme.mit.inf.safetylogic.patterns.util.TurnoutQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.inf.safetylogic.patterns.turnout pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link TurnoutMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern turnout(turnout : Turnout) {
 * 	Turnout(turnout);
 * }
 * </pre></code>
 * 
 * @see TurnoutMatch
 * @see TurnoutProcessor
 * @see TurnoutQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class TurnoutMatcher extends BaseMatcher<TurnoutMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static TurnoutMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    TurnoutMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new TurnoutMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_TURNOUT = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(TurnoutMatcher.class);
  
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
  public TurnoutMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public TurnoutMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pTurnout the fixed value of pattern parameter turnout, or null if not bound.
   * @return matches represented as a TurnoutMatch object.
   * 
   */
  public Collection<TurnoutMatch> getAllMatches(final Turnout pTurnout) {
    return rawGetAllMatches(new Object[]{pTurnout});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pTurnout the fixed value of pattern parameter turnout, or null if not bound.
   * @return a match represented as a TurnoutMatch object, or null if no match is found.
   * 
   */
  public TurnoutMatch getOneArbitraryMatch(final Turnout pTurnout) {
    return rawGetOneArbitraryMatch(new Object[]{pTurnout});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pTurnout the fixed value of pattern parameter turnout, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Turnout pTurnout) {
    return rawHasMatch(new Object[]{pTurnout});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pTurnout the fixed value of pattern parameter turnout, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Turnout pTurnout) {
    return rawCountMatches(new Object[]{pTurnout});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pTurnout the fixed value of pattern parameter turnout, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Turnout pTurnout, final IMatchProcessor<? super TurnoutMatch> processor) {
    rawForEachMatch(new Object[]{pTurnout}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pTurnout the fixed value of pattern parameter turnout, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Turnout pTurnout, final IMatchProcessor<? super TurnoutMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pTurnout}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTurnout the fixed value of pattern parameter turnout, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public TurnoutMatch newMatch(final Turnout pTurnout) {
    return TurnoutMatch.newMatch(pTurnout);
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
  
  @Override
  protected TurnoutMatch tupleToMatch(final Tuple t) {
    try {
    	return TurnoutMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout) t.get(POSITION_TURNOUT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TurnoutMatch arrayToMatch(final Object[] match) {
    try {
    	return TurnoutMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout) match[POSITION_TURNOUT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TurnoutMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return TurnoutMatch.newMutableMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout) match[POSITION_TURNOUT]);
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
  public static IQuerySpecification<TurnoutMatcher> querySpecification() throws IncQueryException {
    return TurnoutQuerySpecification.instance();
  }
}
