package hu.bme.mit.inf.safetylogic.patterns;

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

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Section;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Train;
import hu.bme.mit.inf.safetylogic.patterns.util.SectionsInSameRailroadPartAsTrainProcessor;
import hu.bme.mit.inf.safetylogic.patterns.util.SectionsInSameRailroadPartAsTrainQuerySpecification;

/**
 * Generated pattern matcher API of the hu.bme.mit.inf.safetylogic.patterns.sectionsInSameRailroadPartAsTrain pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SectionsInSameRailroadPartAsTrainMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern sectionsInSameRailroadPartAsTrain(train : Train, section : Section){
 * 	Train.currentlyOn(train, trainSection);
 * 	find inSameRailroadPart(trainSection, section);
 * }
 * </pre></code>
 * 
 * @see SectionsInSameRailroadPartAsTrainMatch
 * @see SectionsInSameRailroadPartAsTrainProcessor
 * @see SectionsInSameRailroadPartAsTrainQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SectionsInSameRailroadPartAsTrainMatcher extends BaseMatcher<SectionsInSameRailroadPartAsTrainMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SectionsInSameRailroadPartAsTrainMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SectionsInSameRailroadPartAsTrainMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SectionsInSameRailroadPartAsTrainMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_TRAIN = 0;
  
  private final static int POSITION_SECTION = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SectionsInSameRailroadPartAsTrainMatcher.class);
  
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
  public SectionsInSameRailroadPartAsTrainMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public SectionsInSameRailroadPartAsTrainMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pTrain the fixed value of pattern parameter train, or null if not bound.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @return matches represented as a SectionsInSameRailroadPartAsTrainMatch object.
   * 
   */
  public Collection<SectionsInSameRailroadPartAsTrainMatch> getAllMatches(final Train pTrain, final Section pSection) {
    return rawGetAllMatches(new Object[]{pTrain, pSection});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pTrain the fixed value of pattern parameter train, or null if not bound.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @return a match represented as a SectionsInSameRailroadPartAsTrainMatch object, or null if no match is found.
   * 
   */
  public SectionsInSameRailroadPartAsTrainMatch getOneArbitraryMatch(final Train pTrain, final Section pSection) {
    return rawGetOneArbitraryMatch(new Object[]{pTrain, pSection});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pTrain the fixed value of pattern parameter train, or null if not bound.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Train pTrain, final Section pSection) {
    return rawHasMatch(new Object[]{pTrain, pSection});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pTrain the fixed value of pattern parameter train, or null if not bound.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Train pTrain, final Section pSection) {
    return rawCountMatches(new Object[]{pTrain, pSection});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pTrain the fixed value of pattern parameter train, or null if not bound.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Train pTrain, final Section pSection, final IMatchProcessor<? super SectionsInSameRailroadPartAsTrainMatch> processor) {
    rawForEachMatch(new Object[]{pTrain, pSection}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pTrain the fixed value of pattern parameter train, or null if not bound.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Train pTrain, final Section pSection, final IMatchProcessor<? super SectionsInSameRailroadPartAsTrainMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pTrain, pSection}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTrain the fixed value of pattern parameter train, or null if not bound.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SectionsInSameRailroadPartAsTrainMatch newMatch(final Train pTrain, final Section pSection) {
    return SectionsInSameRailroadPartAsTrainMatch.newMatch(pTrain, pSection);
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
  public Set<Train> getAllValuesOftrain(final SectionsInSameRailroadPartAsTrainMatch partialMatch) {
    return rawAccumulateAllValuesOftrain(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for train.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOftrain(final Section pSection) {
    return rawAccumulateAllValuesOftrain(new Object[]{
    null, 
    pSection
    });
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
  
  /**
   * Retrieve the set of values that occur in matches for section.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Section> getAllValuesOfsection(final SectionsInSameRailroadPartAsTrainMatch partialMatch) {
    return rawAccumulateAllValuesOfsection(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for section.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Section> getAllValuesOfsection(final Train pTrain) {
    return rawAccumulateAllValuesOfsection(new Object[]{
    pTrain, 
    null
    });
  }
  
  @Override
  protected SectionsInSameRailroadPartAsTrainMatch tupleToMatch(final Tuple t) {
    try {
    	return SectionsInSameRailroadPartAsTrainMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Train) t.get(POSITION_TRAIN), (hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) t.get(POSITION_SECTION));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SectionsInSameRailroadPartAsTrainMatch arrayToMatch(final Object[] match) {
    try {
    	return SectionsInSameRailroadPartAsTrainMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Train) match[POSITION_TRAIN], (hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) match[POSITION_SECTION]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SectionsInSameRailroadPartAsTrainMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return SectionsInSameRailroadPartAsTrainMatch.newMutableMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Train) match[POSITION_TRAIN], (hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) match[POSITION_SECTION]);
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
  public static IQuerySpecification<SectionsInSameRailroadPartAsTrainMatcher> querySpecification() throws IncQueryException {
    return SectionsInSameRailroadPartAsTrainQuerySpecification.instance();
  }
}
