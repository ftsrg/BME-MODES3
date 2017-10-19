/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/PathBuildingHelperQueries.vql
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
import org.eclipse.viatra.query.runtime.matchers.backend.IQueryBackendFactory;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
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
  public ThreeConnectedRailRoadPartsMatcher instantiate() throws ViatraQueryException {
    return ThreeConnectedRailRoadPartsMatcher.create();
  }
  
  @Override
  public ThreeConnectedRailRoadPartsMatch newEmptyMatch() {
    return ThreeConnectedRailRoadPartsMatch.newEmptyMatch();
  }
  
  @Override
  public ThreeConnectedRailRoadPartsMatch newMatch(final Object... parameters) {
    return ThreeConnectedRailRoadPartsMatch.newMatch((hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement) parameters[0], (hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement) parameters[1], (hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement) parameters[2]);
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
    
    private final PParameter parameter_pOne = new PParameter("one", "hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pMiddle = new PParameter("middle", "hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pOther = new PParameter("other", "hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pOne, parameter_pMiddle, parameter_pOther);
    
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
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      setEvaluationHints(new QueryEvaluationHint(null, (IQueryBackendFactory)null));
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
      		   new ExportedParameter(body, var_one, parameter_pOne),
      		   new ExportedParameter(body, var_middle, parameter_pMiddle),
      		   new ExportedParameter(body, var_other, parameter_pOther)
      		));
      		// 	find connected(middle, one)
      		new PositivePatternCall(body, new FlatTuple(var_middle, var_one), ConnectedQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	find connected(middle, other)
      		new PositivePatternCall(body, new FlatTuple(var_middle, var_other), ConnectedQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	one != other
      		new Inequality(body, var_one, var_other);
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
