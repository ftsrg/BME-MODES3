package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Section;
import hu.bme.mit.inf.safetylogic.patterns.SoloCounterClockwiseBlindTrackMatch;
import hu.bme.mit.inf.safetylogic.patterns.util.SoloCounterClockwiseBlindTrackQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.inf.safetylogic.patterns.soloCounterClockwiseBlindTrack pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SoloCounterClockwiseBlindTrackMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern soloCounterClockwiseBlindTrack(section : Section){
 * 	BlindTrack(section);
 * 	Section.counterClockwise(section,turnout);
 * 	Turnout(turnout);
 * }
 * </pre></code>
 * 
 * @see SoloCounterClockwiseBlindTrackMatch
 * @see SoloCounterClockwiseBlindTrackProcessor
 * @see SoloCounterClockwiseBlindTrackQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SoloCounterClockwiseBlindTrackMatcher extends BaseMatcher<SoloCounterClockwiseBlindTrackMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SoloCounterClockwiseBlindTrackMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SoloCounterClockwiseBlindTrackMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SoloCounterClockwiseBlindTrackMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SECTION = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SoloCounterClockwiseBlindTrackMatcher.class);
  
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
  public SoloCounterClockwiseBlindTrackMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public SoloCounterClockwiseBlindTrackMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @return matches represented as a SoloCounterClockwiseBlindTrackMatch object.
   * 
   */
  public Collection<SoloCounterClockwiseBlindTrackMatch> getAllMatches(final Section pSection) {
    return rawGetAllMatches(new Object[]{pSection});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @return a match represented as a SoloCounterClockwiseBlindTrackMatch object, or null if no match is found.
   * 
   */
  public SoloCounterClockwiseBlindTrackMatch getOneArbitraryMatch(final Section pSection) {
    return rawGetOneArbitraryMatch(new Object[]{pSection});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Section pSection) {
    return rawHasMatch(new Object[]{pSection});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Section pSection) {
    return rawCountMatches(new Object[]{pSection});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Section pSection, final IMatchProcessor<? super SoloCounterClockwiseBlindTrackMatch> processor) {
    rawForEachMatch(new Object[]{pSection}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Section pSection, final IMatchProcessor<? super SoloCounterClockwiseBlindTrackMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSection}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SoloCounterClockwiseBlindTrackMatch newMatch(final Section pSection) {
    return SoloCounterClockwiseBlindTrackMatch.newMatch(pSection);
  }
  
  /**
   * Retrieve the set of values that occur in matches for section.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Section> rawAccumulateAllValuesOfsection(final Object[] parameters) {
    Set<Section> results = new HashSet<Section>();
    rawAccumulateAllValues(POSITION_SECTION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for section.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Section> getAllValuesOfsection() {
    return rawAccumulateAllValuesOfsection(emptyArray());
  }
  
  @Override
  protected SoloCounterClockwiseBlindTrackMatch tupleToMatch(final Tuple t) {
    try {
    	return SoloCounterClockwiseBlindTrackMatch.newMatch((Section) t.get(POSITION_SECTION));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SoloCounterClockwiseBlindTrackMatch arrayToMatch(final Object[] match) {
    try {
    	return SoloCounterClockwiseBlindTrackMatch.newMatch((Section) match[POSITION_SECTION]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SoloCounterClockwiseBlindTrackMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return SoloCounterClockwiseBlindTrackMatch.newMutableMatch((Section) match[POSITION_SECTION]);
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
  public static IQuerySpecification<SoloCounterClockwiseBlindTrackMatcher> querySpecification() throws IncQueryException {
    return SoloCounterClockwiseBlindTrackQuerySpecification.instance();
  }
}
