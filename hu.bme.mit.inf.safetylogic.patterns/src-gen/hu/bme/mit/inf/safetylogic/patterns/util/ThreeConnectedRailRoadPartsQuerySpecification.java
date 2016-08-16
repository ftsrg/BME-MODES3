/**
 * Generated from platform:/resource/hu.bme.mit.inf.safetylogic.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/PathBuildingHelperQueries.vql
 */
package hu.bme.mit.inf.safetylogic.patterns.util;

import com.google.common.collect.Sets;
import hu.bme.mit.inf.safetylogic.patterns.ThreeConnectedRailRoadPartsMatch;
import hu.bme.mit.inf.safetylogic.patterns.ThreeConnectedRailRoadPartsMatcher;
import hu.bme.mit.inf.safetylogic.patterns.util.ConnectedQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ThreeConnectedRailRoadPartsMatcher in a type-safe way.
 * 
 * @see ThreeConnectedRailRoadPartsMatcher
 * @see ThreeConnectedRailRoadPartsMatch
 * 
 */
@SuppressWarnings("all")
public final class ThreeConnectedRailRoadPartsQuerySpecification extends BaseGeneratedEMFQuerySpecification<ThreeConnectedRailRoadPartsMatcher> {
  private ThreeConnectedRailRoadPartsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static ThreeConnectedRailRoadPartsQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ThreeConnectedRailRoadPartsMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ThreeConnectedRailRoadPartsMatcher.on(engine);
  }
  
  @Override
  public ThreeConnectedRailRoadPartsMatch newEmptyMatch() {
    return ThreeConnectedRailRoadPartsMatch.newEmptyMatch();
  }
  
  @Override
  public ThreeConnectedRailRoadPartsMatch newMatch(final Object... parameters) {
    return ThreeConnectedRailRoadPartsMatch.newMatch((hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadElement) parameters[0], (hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadElement) parameters[1], (hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadElement) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link ThreeConnectedRailRoadPartsQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link ThreeConnectedRailRoadPartsQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static ThreeConnectedRailRoadPartsQuerySpecification INSTANCE = new ThreeConnectedRailRoadPartsQuerySpecification();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private final static Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternalSneaky();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ThreeConnectedRailRoadPartsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.threeConnectedRailRoadParts";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("one","middle","other");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(
      			 new PParameter("one", "hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement"))),
      			 new PParameter("middle", "hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement"))),
      			 new PParameter("other", "hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")))
      			);
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_one = body.getOrCreateVariableByName("one");
      		PVariable var_middle = body.getOrCreateVariableByName("middle");
      		PVariable var_other = body.getOrCreateVariableByName("other");
      		new TypeConstraint(body, new FlatTuple(var_one), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
      		new TypeConstraint(body, new FlatTuple(var_middle), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
      		new TypeConstraint(body, new FlatTuple(var_other), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_one, "one"),
      		   new ExportedParameter(body, var_middle, "middle"),
      		   new ExportedParameter(body, var_other, "other")
      		));
      		// 	find connected(middle, one)
      		new PositivePatternCall(body, new FlatTuple(var_middle, var_one), ConnectedQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	find connected(middle, other)
      		new PositivePatternCall(body, new FlatTuple(var_middle, var_other), ConnectedQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	// to silence compiler error
      	if (false) throw new ViatraQueryException("Never", "happens");
      } catch (ViatraQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
