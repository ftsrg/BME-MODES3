/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/rulepatterns/RulePatterns.vql
 */
package hu.bme.mit.inf.safetylogic.rulepatterns.util;

import com.google.common.collect.Sets;
import hu.bme.mit.inf.safetylogic.rulepatterns.MultipleTrainsOnStationMatch;
import hu.bme.mit.inf.safetylogic.rulepatterns.MultipleTrainsOnStationMatcher;
import hu.bme.mit.inf.safetylogic.rulepatterns.util.TrainOnStationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.backend.IQueryBackendFactory;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate MultipleTrainsOnStationMatcher in a type-safe way.
 * 
 * @see MultipleTrainsOnStationMatcher
 * @see MultipleTrainsOnStationMatch
 * 
 */
@SuppressWarnings("all")
public final class MultipleTrainsOnStationQuerySpecification extends BaseGeneratedEMFQuerySpecification<MultipleTrainsOnStationMatcher> {
  private MultipleTrainsOnStationQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static MultipleTrainsOnStationQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected MultipleTrainsOnStationMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return MultipleTrainsOnStationMatcher.on(engine);
  }
  
  @Override
  public MultipleTrainsOnStationMatcher instantiate() throws ViatraQueryException {
    return MultipleTrainsOnStationMatcher.create();
  }
  
  @Override
  public MultipleTrainsOnStationMatch newEmptyMatch() {
    return MultipleTrainsOnStationMatch.newEmptyMatch();
  }
  
  @Override
  public MultipleTrainsOnStationMatch newMatch(final Object... parameters) {
    return MultipleTrainsOnStationMatch.newMatch((hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train) parameters[0], (hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link MultipleTrainsOnStationQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link MultipleTrainsOnStationQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static MultipleTrainsOnStationQuerySpecification INSTANCE = new MultipleTrainsOnStationQuerySpecification();
    
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
    private final static MultipleTrainsOnStationQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pT1 = new PParameter("t1", "hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pT2 = new PParameter("t2", "hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pT1, parameter_pT2);
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.rulepatterns.multipleTrainsOnStation";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("t1","t2");
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
      		PVariable var_t1 = body.getOrCreateVariableByName("t1");
      		PVariable var_t2 = body.getOrCreateVariableByName("t2");
      		PVariable var_railroad = body.getOrCreateVariableByName("railroad");
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		new TypeConstraint(body, new FlatTuple(var_t2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_t1, parameter_pT1),
      		   new ExportedParameter(body, var_t2, parameter_pT2)
      		));
      		// 	RailRoadModel.trains(railroad, t1)
      		new TypeConstraint(body, new FlatTuple(var_railroad), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadModel")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_railroad, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadModel", "trains")));
      		new Equality(body, var__virtual_0_, var_t1);
      		// 	RailRoadModel.trains(railroad, t2)
      		new TypeConstraint(body, new FlatTuple(var_railroad), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadModel")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_railroad, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadModel", "trains")));
      		new Equality(body, var__virtual_1_, var_t2);
      		// 	find trainOnStation(t1)
      		new PositivePatternCall(body, new FlatTuple(var_t1), TrainOnStationQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	find trainOnStation(t2)
      		new PositivePatternCall(body, new FlatTuple(var_t2), TrainOnStationQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	t1 != t2
      		new Inequality(body, var_t1, var_t2);
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
