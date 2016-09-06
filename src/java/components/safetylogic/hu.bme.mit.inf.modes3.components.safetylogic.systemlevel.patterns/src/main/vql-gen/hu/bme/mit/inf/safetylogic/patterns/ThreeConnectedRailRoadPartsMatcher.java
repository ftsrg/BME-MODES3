/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/PathBuildingHelperQueries.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.patterns.ThreeConnectedRailRoadPartsMatch;
import hu.bme.mit.inf.safetylogic.patterns.util.ThreeConnectedRailRoadPartsQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the hu.bme.mit.inf.safetylogic.patterns.threeConnectedRailRoadParts pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ThreeConnectedRailRoadPartsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern threeConnectedRailRoadParts(one : RailRoadElement, middle : RailRoadElement, other : RailRoadElement) {
 * 	find connected(middle, one);
 * 	find connected(middle, other);
 * 	one != other;
 * }
 * </pre></code>
 * 
 * @see ThreeConnectedRailRoadPartsMatch
 * @see ThreeConnectedRailRoadPartsProcessor
 * @see ThreeConnectedRailRoadPartsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ThreeConnectedRailRoadPartsMatcher extends BaseMatcher<ThreeConnectedRailRoadPartsMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ThreeConnectedRailRoadPartsMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    ThreeConnectedRailRoadPartsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ThreeConnectedRailRoadPartsMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_ONE = 0;
  
  private final static int POSITION_MIDDLE = 1;
  
  private final static int POSITION_OTHER = 2;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ThreeConnectedRailRoadPartsMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private ThreeConnectedRailRoadPartsMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOne the fixed value of pattern parameter one, or null if not bound.
   * @param pMiddle the fixed value of pattern parameter middle, or null if not bound.
   * @param pOther the fixed value of pattern parameter other, or null if not bound.
   * @return matches represented as a ThreeConnectedRailRoadPartsMatch object.
   * 
   */
  public Collection<ThreeConnectedRailRoadPartsMatch> getAllMatches(final EObject pOne, final EObject pMiddle, final EObject pOther) {
    return rawGetAllMatches(new Object[]{pOne, pMiddle, pOther});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOne the fixed value of pattern parameter one, or null if not bound.
   * @param pMiddle the fixed value of pattern parameter middle, or null if not bound.
   * @param pOther the fixed value of pattern parameter other, or null if not bound.
   * @return a match represented as a ThreeConnectedRailRoadPartsMatch object, or null if no match is found.
   * 
   */
  public ThreeConnectedRailRoadPartsMatch getOneArbitraryMatch(final EObject pOne, final EObject pMiddle, final EObject pOther) {
    return rawGetOneArbitraryMatch(new Object[]{pOne, pMiddle, pOther});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pOne the fixed value of pattern parameter one, or null if not bound.
   * @param pMiddle the fixed value of pattern parameter middle, or null if not bound.
   * @param pOther the fixed value of pattern parameter other, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final EObject pOne, final EObject pMiddle, final EObject pOther) {
    return rawHasMatch(new Object[]{pOne, pMiddle, pOther});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOne the fixed value of pattern parameter one, or null if not bound.
   * @param pMiddle the fixed value of pattern parameter middle, or null if not bound.
   * @param pOther the fixed value of pattern parameter other, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final EObject pOne, final EObject pMiddle, final EObject pOther) {
    return rawCountMatches(new Object[]{pOne, pMiddle, pOther});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pOne the fixed value of pattern parameter one, or null if not bound.
   * @param pMiddle the fixed value of pattern parameter middle, or null if not bound.
   * @param pOther the fixed value of pattern parameter other, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final EObject pOne, final EObject pMiddle, final EObject pOther, final IMatchProcessor<? super ThreeConnectedRailRoadPartsMatch> processor) {
    rawForEachMatch(new Object[]{pOne, pMiddle, pOther}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOne the fixed value of pattern parameter one, or null if not bound.
   * @param pMiddle the fixed value of pattern parameter middle, or null if not bound.
   * @param pOther the fixed value of pattern parameter other, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final EObject pOne, final EObject pMiddle, final EObject pOther, final IMatchProcessor<? super ThreeConnectedRailRoadPartsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pOne, pMiddle, pOther}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOne the fixed value of pattern parameter one, or null if not bound.
   * @param pMiddle the fixed value of pattern parameter middle, or null if not bound.
   * @param pOther the fixed value of pattern parameter other, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ThreeConnectedRailRoadPartsMatch newMatch(final EObject pOne, final EObject pMiddle, final EObject pOther) {
    return ThreeConnectedRailRoadPartsMatch.newMatch(pOne, pMiddle, pOther);
  }
  
  /**
   * Retrieve the set of values that occur in matches for one.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<EObject> rawAccumulateAllValuesOfone(final Object[] parameters) {
    Set<EObject> results = new HashSet<EObject>();
    rawAccumulateAllValues(POSITION_ONE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for one.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfone() {
    return rawAccumulateAllValuesOfone(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for one.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfone(final ThreeConnectedRailRoadPartsMatch partialMatch) {
    return rawAccumulateAllValuesOfone(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for one.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfone(final EObject pMiddle, final EObject pOther) {
    return rawAccumulateAllValuesOfone(new Object[]{
    null, 
    pMiddle, 
    pOther
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for middle.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<EObject> rawAccumulateAllValuesOfmiddle(final Object[] parameters) {
    Set<EObject> results = new HashSet<EObject>();
    rawAccumulateAllValues(POSITION_MIDDLE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for middle.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfmiddle() {
    return rawAccumulateAllValuesOfmiddle(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for middle.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfmiddle(final ThreeConnectedRailRoadPartsMatch partialMatch) {
    return rawAccumulateAllValuesOfmiddle(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for middle.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfmiddle(final EObject pOne, final EObject pOther) {
    return rawAccumulateAllValuesOfmiddle(new Object[]{
    pOne, 
    null, 
    pOther
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for other.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<EObject> rawAccumulateAllValuesOfother(final Object[] parameters) {
    Set<EObject> results = new HashSet<EObject>();
    rawAccumulateAllValues(POSITION_OTHER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for other.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfother() {
    return rawAccumulateAllValuesOfother(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for other.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfother(final ThreeConnectedRailRoadPartsMatch partialMatch) {
    return rawAccumulateAllValuesOfother(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for other.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfother(final EObject pOne, final EObject pMiddle) {
    return rawAccumulateAllValuesOfother(new Object[]{
    pOne, 
    pMiddle, 
    null
    });
  }
  
  @Override
  protected ThreeConnectedRailRoadPartsMatch tupleToMatch(final Tuple t) {
    try {
    	return ThreeConnectedRailRoadPartsMatch.newMatch((EObject) t.get(POSITION_ONE), (EObject) t.get(POSITION_MIDDLE), (EObject) t.get(POSITION_OTHER));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ThreeConnectedRailRoadPartsMatch arrayToMatch(final Object[] match) {
    try {
    	return ThreeConnectedRailRoadPartsMatch.newMatch((EObject) match[POSITION_ONE], (EObject) match[POSITION_MIDDLE], (EObject) match[POSITION_OTHER]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ThreeConnectedRailRoadPartsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ThreeConnectedRailRoadPartsMatch.newMutableMatch((EObject) match[POSITION_ONE], (EObject) match[POSITION_MIDDLE], (EObject) match[POSITION_OTHER]);
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
  public static IQuerySpecification<ThreeConnectedRailRoadPartsMatcher> querySpecification() throws ViatraQueryException {
    return ThreeConnectedRailRoadPartsQuerySpecification.instance();
  }
}
