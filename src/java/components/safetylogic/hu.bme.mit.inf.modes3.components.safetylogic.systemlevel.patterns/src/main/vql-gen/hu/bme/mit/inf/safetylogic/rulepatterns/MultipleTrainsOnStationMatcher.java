/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/rulepatterns/RulePatterns.vql
 */
package hu.bme.mit.inf.safetylogic.rulepatterns;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train;
import hu.bme.mit.inf.safetylogic.rulepatterns.MultipleTrainsOnStationMatch;
import hu.bme.mit.inf.safetylogic.rulepatterns.util.MultipleTrainsOnStationQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.inf.safetylogic.rulepatterns.multipleTrainsOnStation pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link MultipleTrainsOnStationMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern multipleTrainsOnStation(t1 : Train, t2 : Train) {
 * 	RailRoadModel.trains(railroad, t1);
 * 	RailRoadModel.trains(railroad, t2);
 * 	find trainOnStation(t1);
 * 	find trainOnStation(t2);
 * 	t1 != t2;
 * }
 * </pre></code>
 * 
 * @see MultipleTrainsOnStationMatch
 * @see MultipleTrainsOnStationProcessor
 * @see MultipleTrainsOnStationQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class MultipleTrainsOnStationMatcher extends BaseMatcher<MultipleTrainsOnStationMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static MultipleTrainsOnStationMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    MultipleTrainsOnStationMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (MultipleTrainsOnStationMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static MultipleTrainsOnStationMatcher create() throws ViatraQueryException {
    return new MultipleTrainsOnStationMatcher();
  }
  
  private final static int POSITION_T1 = 0;
  
  private final static int POSITION_T2 = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(MultipleTrainsOnStationMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private MultipleTrainsOnStationMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pT1 the fixed value of pattern parameter t1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter t2, or null if not bound.
   * @return matches represented as a MultipleTrainsOnStationMatch object.
   * 
   */
  public Collection<MultipleTrainsOnStationMatch> getAllMatches(final Train pT1, final Train pT2) {
    return rawGetAllMatches(new Object[]{pT1, pT2});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pT1 the fixed value of pattern parameter t1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter t2, or null if not bound.
   * @return a match represented as a MultipleTrainsOnStationMatch object, or null if no match is found.
   * 
   */
  public MultipleTrainsOnStationMatch getOneArbitraryMatch(final Train pT1, final Train pT2) {
    return rawGetOneArbitraryMatch(new Object[]{pT1, pT2});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pT1 the fixed value of pattern parameter t1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter t2, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Train pT1, final Train pT2) {
    return rawHasMatch(new Object[]{pT1, pT2});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pT1 the fixed value of pattern parameter t1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter t2, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Train pT1, final Train pT2) {
    return rawCountMatches(new Object[]{pT1, pT2});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pT1 the fixed value of pattern parameter t1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter t2, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Train pT1, final Train pT2, final IMatchProcessor<? super MultipleTrainsOnStationMatch> processor) {
    rawForEachMatch(new Object[]{pT1, pT2}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pT1 the fixed value of pattern parameter t1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter t2, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Train pT1, final Train pT2, final IMatchProcessor<? super MultipleTrainsOnStationMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pT1, pT2}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pT1 the fixed value of pattern parameter t1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter t2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public MultipleTrainsOnStationMatch newMatch(final Train pT1, final Train pT2) {
    return MultipleTrainsOnStationMatch.newMatch(pT1, pT2);
  }
  
  /**
   * Retrieve the set of values that occur in matches for t1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Train> rawAccumulateAllValuesOft1(final Object[] parameters) {
    Set<Train> results = new HashSet<Train>();
    rawAccumulateAllValues(POSITION_T1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for t1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOft1() {
    return rawAccumulateAllValuesOft1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for t1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOft1(final MultipleTrainsOnStationMatch partialMatch) {
    return rawAccumulateAllValuesOft1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for t1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOft1(final Train pT2) {
    return rawAccumulateAllValuesOft1(new Object[]{
    null, 
    pT2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for t2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Train> rawAccumulateAllValuesOft2(final Object[] parameters) {
    Set<Train> results = new HashSet<Train>();
    rawAccumulateAllValues(POSITION_T2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for t2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOft2() {
    return rawAccumulateAllValuesOft2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for t2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOft2(final MultipleTrainsOnStationMatch partialMatch) {
    return rawAccumulateAllValuesOft2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for t2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Train> getAllValuesOft2(final Train pT1) {
    return rawAccumulateAllValuesOft2(new Object[]{
    pT1, 
    null
    });
  }
  
  @Override
  protected MultipleTrainsOnStationMatch tupleToMatch(final Tuple t) {
    try {
    	return MultipleTrainsOnStationMatch.newMatch((Train) t.get(POSITION_T1), (Train) t.get(POSITION_T2));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MultipleTrainsOnStationMatch arrayToMatch(final Object[] match) {
    try {
    	return MultipleTrainsOnStationMatch.newMatch((Train) match[POSITION_T1], (Train) match[POSITION_T2]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MultipleTrainsOnStationMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return MultipleTrainsOnStationMatch.newMutableMatch((Train) match[POSITION_T1], (Train) match[POSITION_T2]);
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
  public static IQuerySpecification<MultipleTrainsOnStationMatcher> querySpecification() throws ViatraQueryException {
    return MultipleTrainsOnStationQuerySpecification.instance();
  }
}
