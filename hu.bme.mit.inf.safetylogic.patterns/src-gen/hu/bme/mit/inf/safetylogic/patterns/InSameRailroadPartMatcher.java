package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Section;
import hu.bme.mit.inf.safetylogic.patterns.InSameRailroadPartMatch;
import hu.bme.mit.inf.safetylogic.patterns.util.InSameRailroadPartQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.inf.safetylogic.patterns.inSameRailroadPart pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link InSameRailroadPartMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern inSameRailroadPart(section : Section, someSection : Section){
 * 	find sectionNeighbor+(section, someSection);
 * } or {
 * 	find soloSection(section);
 * 	find soloSection(someSection);
 * 	section == someSection;
 * }
 * </pre></code>
 * 
 * @see InSameRailroadPartMatch
 * @see InSameRailroadPartProcessor
 * @see InSameRailroadPartQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class InSameRailroadPartMatcher extends BaseMatcher<InSameRailroadPartMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static InSameRailroadPartMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    InSameRailroadPartMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new InSameRailroadPartMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SECTION = 0;
  
  private final static int POSITION_SOMESECTION = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(InSameRailroadPartMatcher.class);
  
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
  public InSameRailroadPartMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public InSameRailroadPartMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pSomeSection the fixed value of pattern parameter someSection, or null if not bound.
   * @return matches represented as a InSameRailroadPartMatch object.
   * 
   */
  public Collection<InSameRailroadPartMatch> getAllMatches(final Section pSection, final Section pSomeSection) {
    return rawGetAllMatches(new Object[]{pSection, pSomeSection});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pSomeSection the fixed value of pattern parameter someSection, or null if not bound.
   * @return a match represented as a InSameRailroadPartMatch object, or null if no match is found.
   * 
   */
  public InSameRailroadPartMatch getOneArbitraryMatch(final Section pSection, final Section pSomeSection) {
    return rawGetOneArbitraryMatch(new Object[]{pSection, pSomeSection});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pSomeSection the fixed value of pattern parameter someSection, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Section pSection, final Section pSomeSection) {
    return rawHasMatch(new Object[]{pSection, pSomeSection});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pSomeSection the fixed value of pattern parameter someSection, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Section pSection, final Section pSomeSection) {
    return rawCountMatches(new Object[]{pSection, pSomeSection});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pSomeSection the fixed value of pattern parameter someSection, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Section pSection, final Section pSomeSection, final IMatchProcessor<? super InSameRailroadPartMatch> processor) {
    rawForEachMatch(new Object[]{pSection, pSomeSection}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pSomeSection the fixed value of pattern parameter someSection, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Section pSection, final Section pSomeSection, final IMatchProcessor<? super InSameRailroadPartMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSection, pSomeSection}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pSomeSection the fixed value of pattern parameter someSection, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public InSameRailroadPartMatch newMatch(final Section pSection, final Section pSomeSection) {
    return InSameRailroadPartMatch.newMatch(pSection, pSomeSection);
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
  public Set<Section> getAllValuesOfsection(final InSameRailroadPartMatch partialMatch) {
    return rawAccumulateAllValuesOfsection(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for section.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Section> getAllValuesOfsection(final Section pSomeSection) {
    return rawAccumulateAllValuesOfsection(new Object[]{
    null, 
    pSomeSection
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for someSection.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Section> rawAccumulateAllValuesOfsomeSection(final Object[] parameters) {
    Set<Section> results = new HashSet<Section>();
    rawAccumulateAllValues(POSITION_SOMESECTION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for someSection.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Section> getAllValuesOfsomeSection() {
    return rawAccumulateAllValuesOfsomeSection(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for someSection.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Section> getAllValuesOfsomeSection(final InSameRailroadPartMatch partialMatch) {
    return rawAccumulateAllValuesOfsomeSection(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for someSection.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Section> getAllValuesOfsomeSection(final Section pSection) {
    return rawAccumulateAllValuesOfsomeSection(new Object[]{
    pSection, 
    null
    });
  }
  
  @Override
  protected InSameRailroadPartMatch tupleToMatch(final Tuple t) {
    try {
    	return InSameRailroadPartMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) t.get(POSITION_SECTION), (hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) t.get(POSITION_SOMESECTION));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected InSameRailroadPartMatch arrayToMatch(final Object[] match) {
    try {
    	return InSameRailroadPartMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) match[POSITION_SECTION], (hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) match[POSITION_SOMESECTION]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected InSameRailroadPartMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return InSameRailroadPartMatch.newMutableMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) match[POSITION_SECTION], (hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) match[POSITION_SOMESECTION]);
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
  public static IQuerySpecification<InSameRailroadPartMatcher> querySpecification() throws IncQueryException {
    return InSameRailroadPartQuerySpecification.instance();
  }
}
