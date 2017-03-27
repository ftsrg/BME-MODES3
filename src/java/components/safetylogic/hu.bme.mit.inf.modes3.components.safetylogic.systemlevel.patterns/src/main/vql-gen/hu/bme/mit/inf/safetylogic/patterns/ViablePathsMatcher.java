/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/DerivedFeatures.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Path;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement;
import hu.bme.mit.inf.safetylogic.patterns.ViablePathsMatch;
import hu.bme.mit.inf.safetylogic.patterns.util.ViablePathsQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.inf.safetylogic.patterns.viablePaths pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ViablePathsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * //XXX {@literal @}QueryBasedFeature(feature = "viablePaths")
 * pattern viablePaths(This : RailRoadElement, path : Path) = {
 * 	Segment(This);
 * 	Segment.connectedTo(This, connected1);
 * 	Segment.connectedTo(This, connected2);
 * 	connected1 != connected2;
 * 	
 * 	Path.via(path, This);
 * 	Path.from(path, connected1);
 * 	Path.to(path, connected2);
 * } or {
 * 	Turnout(This);
 * 	Turnout.currentlyDivergent(This, true);
 * 	
 * 	Turnout.top(This, top);
 * 	Turnout.divergent(This, divergent);
 * 	Path.via(path, This);
 * 	Path.to(path, divergent);
 * 	Path.from(path, top);
 * } or {
 * 	Turnout(This);
 * 	Turnout.currentlyDivergent(This, true);
 * 	
 * 	Turnout.top(This, top);
 * 	Turnout.divergent(This, divergent);
 * 	
 * 	Path.via(path, This);
 * 	Path.to(path, top);
 * 	Path.from(path, divergent);
 * } or {
 * 	Turnout(This);
 * 	Turnout.currentlyDivergent(This, false);
 * 
 * 	Turnout.top(This, top);
 * 	Turnout.straight(This, straight);
 * 	Path.via(path, This);
 * 	Path.to(path, straight);
 * 	Path.from(path, top);
 * 
 * } or {
 * 	Turnout(This);
 * 	Turnout.currentlyDivergent(This, false);
 * 
 * 	Turnout.top(This, top);
 * 	Turnout.straight(This, straight);
 * 	Path.via(path, This);
 * 	Path.to(path, top);
 * 	Path.from(path, straight);
 * }
 * </pre></code>
 * 
 * @see ViablePathsMatch
 * @see ViablePathsProcessor
 * @see ViablePathsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ViablePathsMatcher extends BaseMatcher<ViablePathsMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ViablePathsMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    ViablePathsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (ViablePathsMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static ViablePathsMatcher create() throws ViatraQueryException {
    return new ViablePathsMatcher();
  }
  
  private final static int POSITION_THIS = 0;
  
  private final static int POSITION_PATH = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ViablePathsMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private ViablePathsMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pPath the fixed value of pattern parameter path, or null if not bound.
   * @return matches represented as a ViablePathsMatch object.
   * 
   */
  public Collection<ViablePathsMatch> getAllMatches(final RailRoadElement pThis, final Path pPath) {
    return rawGetAllMatches(new Object[]{pThis, pPath});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pPath the fixed value of pattern parameter path, or null if not bound.
   * @return a match represented as a ViablePathsMatch object, or null if no match is found.
   * 
   */
  public ViablePathsMatch getOneArbitraryMatch(final RailRoadElement pThis, final Path pPath) {
    return rawGetOneArbitraryMatch(new Object[]{pThis, pPath});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pPath the fixed value of pattern parameter path, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final RailRoadElement pThis, final Path pPath) {
    return rawHasMatch(new Object[]{pThis, pPath});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pPath the fixed value of pattern parameter path, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final RailRoadElement pThis, final Path pPath) {
    return rawCountMatches(new Object[]{pThis, pPath});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pPath the fixed value of pattern parameter path, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final RailRoadElement pThis, final Path pPath, final IMatchProcessor<? super ViablePathsMatch> processor) {
    rawForEachMatch(new Object[]{pThis, pPath}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pPath the fixed value of pattern parameter path, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final RailRoadElement pThis, final Path pPath, final IMatchProcessor<? super ViablePathsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pThis, pPath}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pPath the fixed value of pattern parameter path, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ViablePathsMatch newMatch(final RailRoadElement pThis, final Path pPath) {
    return ViablePathsMatch.newMatch(pThis, pPath);
  }
  
  /**
   * Retrieve the set of values that occur in matches for This.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<RailRoadElement> rawAccumulateAllValuesOfThis(final Object[] parameters) {
    Set<RailRoadElement> results = new HashSet<RailRoadElement>();
    rawAccumulateAllValues(POSITION_THIS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for This.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RailRoadElement> getAllValuesOfThis() {
    return rawAccumulateAllValuesOfThis(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for This.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RailRoadElement> getAllValuesOfThis(final ViablePathsMatch partialMatch) {
    return rawAccumulateAllValuesOfThis(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for This.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RailRoadElement> getAllValuesOfThis(final Path pPath) {
    return rawAccumulateAllValuesOfThis(new Object[]{
    null, 
    pPath
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for path.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Path> rawAccumulateAllValuesOfpath(final Object[] parameters) {
    Set<Path> results = new HashSet<Path>();
    rawAccumulateAllValues(POSITION_PATH, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for path.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Path> getAllValuesOfpath() {
    return rawAccumulateAllValuesOfpath(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for path.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Path> getAllValuesOfpath(final ViablePathsMatch partialMatch) {
    return rawAccumulateAllValuesOfpath(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for path.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Path> getAllValuesOfpath(final RailRoadElement pThis) {
    return rawAccumulateAllValuesOfpath(new Object[]{
    pThis, 
    null
    });
  }
  
  @Override
  protected ViablePathsMatch tupleToMatch(final Tuple t) {
    try {
    	return ViablePathsMatch.newMatch((RailRoadElement) t.get(POSITION_THIS), (Path) t.get(POSITION_PATH));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ViablePathsMatch arrayToMatch(final Object[] match) {
    try {
    	return ViablePathsMatch.newMatch((RailRoadElement) match[POSITION_THIS], (Path) match[POSITION_PATH]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ViablePathsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ViablePathsMatch.newMutableMatch((RailRoadElement) match[POSITION_THIS], (Path) match[POSITION_PATH]);
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
  public static IQuerySpecification<ViablePathsMatcher> querySpecification() throws ViatraQueryException {
    return ViablePathsQuerySpecification.instance();
  }
}
