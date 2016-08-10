package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Section;
import hu.bme.mit.inf.safetylogic.patterns.NextSectionFromSectionInClockwiseMatch;
import hu.bme.mit.inf.safetylogic.patterns.NextSectionFromSectionInClockwiseMatcher;
import hu.bme.mit.inf.safetylogic.patterns.util.NextSectionFromSectionInClockwiseQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.inf.safetylogic.patterns.nextSectionFromSectionInClockwise pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link NextSectionFromSectionInClockwiseMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern nextSectionFromSectionInClockwise(section : Section, nextSection : Section){
 * 	Section.clockwise(section, nextSection); // if the next is not a turnout, we return it.
 * 	neg find turnout(nextSection);
 * } or {
 * 	Section.clockwise(section, nextNonSection); //if the next is a turnout, we recurse.
 * 	Turnout(nextNonSection); //TODO generalize
 * 	find nextSectionFromSectionInClockwise(nextNonSection, nextSection);
 * }
 * </pre></code>
 * 
 * @see NextSectionFromSectionInClockwiseMatch
 * @see NextSectionFromSectionInClockwiseProcessor
 * @see NextSectionFromSectionInClockwiseQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class NextSectionFromSectionInClockwiseMatcher extends BaseMatcher<NextSectionFromSectionInClockwiseMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static NextSectionFromSectionInClockwiseMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    NextSectionFromSectionInClockwiseMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new NextSectionFromSectionInClockwiseMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SECTION = 0;
  
  private final static int POSITION_NEXTSECTION = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(NextSectionFromSectionInClockwiseMatcher.class);
  
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
  public NextSectionFromSectionInClockwiseMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public NextSectionFromSectionInClockwiseMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pNextSection the fixed value of pattern parameter nextSection, or null if not bound.
   * @return matches represented as a NextSectionFromSectionInClockwiseMatch object.
   * 
   */
  public Collection<NextSectionFromSectionInClockwiseMatch> getAllMatches(final Section pSection, final Section pNextSection) {
    return rawGetAllMatches(new Object[]{pSection, pNextSection});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pNextSection the fixed value of pattern parameter nextSection, or null if not bound.
   * @return a match represented as a NextSectionFromSectionInClockwiseMatch object, or null if no match is found.
   * 
   */
  public NextSectionFromSectionInClockwiseMatch getOneArbitraryMatch(final Section pSection, final Section pNextSection) {
    return rawGetOneArbitraryMatch(new Object[]{pSection, pNextSection});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pNextSection the fixed value of pattern parameter nextSection, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Section pSection, final Section pNextSection) {
    return rawHasMatch(new Object[]{pSection, pNextSection});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pNextSection the fixed value of pattern parameter nextSection, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Section pSection, final Section pNextSection) {
    return rawCountMatches(new Object[]{pSection, pNextSection});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pNextSection the fixed value of pattern parameter nextSection, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Section pSection, final Section pNextSection, final IMatchProcessor<? super NextSectionFromSectionInClockwiseMatch> processor) {
    rawForEachMatch(new Object[]{pSection, pNextSection}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pNextSection the fixed value of pattern parameter nextSection, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Section pSection, final Section pNextSection, final IMatchProcessor<? super NextSectionFromSectionInClockwiseMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSection, pNextSection}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pNextSection the fixed value of pattern parameter nextSection, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public NextSectionFromSectionInClockwiseMatch newMatch(final Section pSection, final Section pNextSection) {
    return NextSectionFromSectionInClockwiseMatch.newMatch(pSection, pNextSection);
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
  public Set<Section> getAllValuesOfsection(final NextSectionFromSectionInClockwiseMatch partialMatch) {
    return rawAccumulateAllValuesOfsection(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for section.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Section> getAllValuesOfsection(final Section pNextSection) {
    return rawAccumulateAllValuesOfsection(new Object[]{
    null, 
    pNextSection
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for nextSection.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Section> rawAccumulateAllValuesOfnextSection(final Object[] parameters) {
    Set<Section> results = new HashSet<Section>();
    rawAccumulateAllValues(POSITION_NEXTSECTION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for nextSection.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Section> getAllValuesOfnextSection() {
    return rawAccumulateAllValuesOfnextSection(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for nextSection.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Section> getAllValuesOfnextSection(final NextSectionFromSectionInClockwiseMatch partialMatch) {
    return rawAccumulateAllValuesOfnextSection(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for nextSection.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Section> getAllValuesOfnextSection(final Section pSection) {
    return rawAccumulateAllValuesOfnextSection(new Object[]{
    pSection, 
    null
    });
  }
  
  @Override
  protected NextSectionFromSectionInClockwiseMatch tupleToMatch(final Tuple t) {
    try {
    	return NextSectionFromSectionInClockwiseMatch.newMatch((Section) t.get(POSITION_SECTION), (Section) t.get(POSITION_NEXTSECTION));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NextSectionFromSectionInClockwiseMatch arrayToMatch(final Object[] match) {
    try {
    	return NextSectionFromSectionInClockwiseMatch.newMatch((Section) match[POSITION_SECTION], (Section) match[POSITION_NEXTSECTION]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NextSectionFromSectionInClockwiseMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return NextSectionFromSectionInClockwiseMatch.newMutableMatch((Section) match[POSITION_SECTION], (Section) match[POSITION_NEXTSECTION]);
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
  public static IQuerySpecification<NextSectionFromSectionInClockwiseMatcher> querySpecification() throws IncQueryException {
    return NextSectionFromSectionInClockwiseQuerySpecification.instance();
  }
}
