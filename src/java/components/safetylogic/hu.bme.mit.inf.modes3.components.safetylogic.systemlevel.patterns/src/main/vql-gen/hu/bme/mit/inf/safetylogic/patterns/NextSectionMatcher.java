/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/SafetyPatterns.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement;
import hu.bme.mit.inf.safetylogic.patterns.NextSectionMatch;
import hu.bme.mit.inf.safetylogic.patterns.util.NextSectionQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.inf.safetylogic.patterns.nextSection pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link NextSectionMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern nextSection(Old : RailRoadElement, Current : RailRoadElement, Next : RailRoadElement){
 * 	find viablePaths(Current, p);
 * 	Path.from(p, Old);
 * 	Path.via(p, Current);
 * 	Path.to(p, Next);
 * } or {
 * 	neg find notNull(Old); // Check for null, as if it is, we don't know the direction
 * 	find viablePaths(Current, p);
 * 	Path.from(p, _);
 * 	Path.via(p, Current);
 * 	Path.to(p, Next);
 * }
 * </pre></code>
 * 
 * @see NextSectionMatch
 * @see NextSectionProcessor
 * @see NextSectionQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class NextSectionMatcher extends BaseMatcher<NextSectionMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static NextSectionMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    NextSectionMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (NextSectionMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static NextSectionMatcher create() throws ViatraQueryException {
    return new NextSectionMatcher();
  }
  
  private final static int POSITION_OLD = 0;
  
  private final static int POSITION_CURRENT = 1;
  
  private final static int POSITION_NEXT = 2;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(NextSectionMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private NextSectionMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOld the fixed value of pattern parameter Old, or null if not bound.
   * @param pCurrent the fixed value of pattern parameter Current, or null if not bound.
   * @param pNext the fixed value of pattern parameter Next, or null if not bound.
   * @return matches represented as a NextSectionMatch object.
   * 
   */
  public Collection<NextSectionMatch> getAllMatches(final RailRoadElement pOld, final RailRoadElement pCurrent, final RailRoadElement pNext) {
    return rawGetAllMatches(new Object[]{pOld, pCurrent, pNext});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOld the fixed value of pattern parameter Old, or null if not bound.
   * @param pCurrent the fixed value of pattern parameter Current, or null if not bound.
   * @param pNext the fixed value of pattern parameter Next, or null if not bound.
   * @return a match represented as a NextSectionMatch object, or null if no match is found.
   * 
   */
  public NextSectionMatch getOneArbitraryMatch(final RailRoadElement pOld, final RailRoadElement pCurrent, final RailRoadElement pNext) {
    return rawGetOneArbitraryMatch(new Object[]{pOld, pCurrent, pNext});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pOld the fixed value of pattern parameter Old, or null if not bound.
   * @param pCurrent the fixed value of pattern parameter Current, or null if not bound.
   * @param pNext the fixed value of pattern parameter Next, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final RailRoadElement pOld, final RailRoadElement pCurrent, final RailRoadElement pNext) {
    return rawHasMatch(new Object[]{pOld, pCurrent, pNext});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOld the fixed value of pattern parameter Old, or null if not bound.
   * @param pCurrent the fixed value of pattern parameter Current, or null if not bound.
   * @param pNext the fixed value of pattern parameter Next, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final RailRoadElement pOld, final RailRoadElement pCurrent, final RailRoadElement pNext) {
    return rawCountMatches(new Object[]{pOld, pCurrent, pNext});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pOld the fixed value of pattern parameter Old, or null if not bound.
   * @param pCurrent the fixed value of pattern parameter Current, or null if not bound.
   * @param pNext the fixed value of pattern parameter Next, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final RailRoadElement pOld, final RailRoadElement pCurrent, final RailRoadElement pNext, final IMatchProcessor<? super NextSectionMatch> processor) {
    rawForEachMatch(new Object[]{pOld, pCurrent, pNext}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOld the fixed value of pattern parameter Old, or null if not bound.
   * @param pCurrent the fixed value of pattern parameter Current, or null if not bound.
   * @param pNext the fixed value of pattern parameter Next, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final RailRoadElement pOld, final RailRoadElement pCurrent, final RailRoadElement pNext, final IMatchProcessor<? super NextSectionMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pOld, pCurrent, pNext}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOld the fixed value of pattern parameter Old, or null if not bound.
   * @param pCurrent the fixed value of pattern parameter Current, or null if not bound.
   * @param pNext the fixed value of pattern parameter Next, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public NextSectionMatch newMatch(final RailRoadElement pOld, final RailRoadElement pCurrent, final RailRoadElement pNext) {
    return NextSectionMatch.newMatch(pOld, pCurrent, pNext);
  }
  
  /**
   * Retrieve the set of values that occur in matches for Old.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<RailRoadElement> rawAccumulateAllValuesOfOld(final Object[] parameters) {
    Set<RailRoadElement> results = new HashSet<RailRoadElement>();
    rawAccumulateAllValues(POSITION_OLD, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Old.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RailRoadElement> getAllValuesOfOld() {
    return rawAccumulateAllValuesOfOld(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Old.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RailRoadElement> getAllValuesOfOld(final NextSectionMatch partialMatch) {
    return rawAccumulateAllValuesOfOld(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Old.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RailRoadElement> getAllValuesOfOld(final RailRoadElement pCurrent, final RailRoadElement pNext) {
    return rawAccumulateAllValuesOfOld(new Object[]{
    null, 
    pCurrent, 
    pNext
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for Current.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<RailRoadElement> rawAccumulateAllValuesOfCurrent(final Object[] parameters) {
    Set<RailRoadElement> results = new HashSet<RailRoadElement>();
    rawAccumulateAllValues(POSITION_CURRENT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Current.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RailRoadElement> getAllValuesOfCurrent() {
    return rawAccumulateAllValuesOfCurrent(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Current.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RailRoadElement> getAllValuesOfCurrent(final NextSectionMatch partialMatch) {
    return rawAccumulateAllValuesOfCurrent(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Current.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RailRoadElement> getAllValuesOfCurrent(final RailRoadElement pOld, final RailRoadElement pNext) {
    return rawAccumulateAllValuesOfCurrent(new Object[]{
    pOld, 
    null, 
    pNext
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for Next.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<RailRoadElement> rawAccumulateAllValuesOfNext(final Object[] parameters) {
    Set<RailRoadElement> results = new HashSet<RailRoadElement>();
    rawAccumulateAllValues(POSITION_NEXT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Next.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RailRoadElement> getAllValuesOfNext() {
    return rawAccumulateAllValuesOfNext(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Next.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RailRoadElement> getAllValuesOfNext(final NextSectionMatch partialMatch) {
    return rawAccumulateAllValuesOfNext(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Next.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RailRoadElement> getAllValuesOfNext(final RailRoadElement pOld, final RailRoadElement pCurrent) {
    return rawAccumulateAllValuesOfNext(new Object[]{
    pOld, 
    pCurrent, 
    null
    });
  }
  
  @Override
  protected NextSectionMatch tupleToMatch(final Tuple t) {
    try {
    	return NextSectionMatch.newMatch((RailRoadElement) t.get(POSITION_OLD), (RailRoadElement) t.get(POSITION_CURRENT), (RailRoadElement) t.get(POSITION_NEXT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NextSectionMatch arrayToMatch(final Object[] match) {
    try {
    	return NextSectionMatch.newMatch((RailRoadElement) match[POSITION_OLD], (RailRoadElement) match[POSITION_CURRENT], (RailRoadElement) match[POSITION_NEXT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NextSectionMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return NextSectionMatch.newMutableMatch((RailRoadElement) match[POSITION_OLD], (RailRoadElement) match[POSITION_CURRENT], (RailRoadElement) match[POSITION_NEXT]);
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
  public static IQuerySpecification<NextSectionMatcher> querySpecification() throws ViatraQueryException {
    return NextSectionQuerySpecification.instance();
  }
}
