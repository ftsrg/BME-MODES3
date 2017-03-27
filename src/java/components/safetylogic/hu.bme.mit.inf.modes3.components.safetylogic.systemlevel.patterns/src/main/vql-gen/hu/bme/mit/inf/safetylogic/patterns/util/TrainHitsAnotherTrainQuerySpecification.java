/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/SafetyPatterns.vql
 */
package hu.bme.mit.inf.safetylogic.patterns.util;

import com.google.common.collect.Sets;
import hu.bme.mit.inf.safetylogic.patterns.TrainHitsAnotherTrainMatch;
import hu.bme.mit.inf.safetylogic.patterns.TrainHitsAnotherTrainMatcher;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainHitsAnotherTrainNextAfterNextQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainHitsAnotherTrainNextQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainsAreTooCloseQuerySpecification;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate TrainHitsAnotherTrainMatcher in a type-safe way.
 * 
 * @see TrainHitsAnotherTrainMatcher
 * @see TrainHitsAnotherTrainMatch
 * 
 */
@SuppressWarnings("all")
public final class TrainHitsAnotherTrainQuerySpecification extends BaseGeneratedEMFQuerySpecification<TrainHitsAnotherTrainMatcher> {
  private TrainHitsAnotherTrainQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static TrainHitsAnotherTrainQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected TrainHitsAnotherTrainMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return TrainHitsAnotherTrainMatcher.on(engine);
  }
  
  @Override
  public TrainHitsAnotherTrainMatcher instantiate() throws ViatraQueryException {
    return TrainHitsAnotherTrainMatcher.create();
  }
  
  @Override
  public TrainHitsAnotherTrainMatch newEmptyMatch() {
    return TrainHitsAnotherTrainMatch.newEmptyMatch();
  }
  
  @Override
  public TrainHitsAnotherTrainMatch newMatch(final Object... parameters) {
    return TrainHitsAnotherTrainMatch.newMatch((hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train) parameters[0], (hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link TrainHitsAnotherTrainQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link TrainHitsAnotherTrainQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static TrainHitsAnotherTrainQuerySpecification INSTANCE = new TrainHitsAnotherTrainQuerySpecification();
    
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
    private final static TrainHitsAnotherTrainQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pOffender = new PParameter("Offender", "hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pVictim = new PParameter("Victim", "hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pOffender, parameter_pVictim);
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.trainHitsAnotherTrain";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("Offender","Victim");
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
      		PVariable var_Offender = body.getOrCreateVariableByName("Offender");
      		PVariable var_Victim = body.getOrCreateVariableByName("Victim");
      		new TypeConstraint(body, new FlatTuple(var_Offender), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		new TypeConstraint(body, new FlatTuple(var_Victim), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_Offender, parameter_pOffender),
      		   new ExportedParameter(body, var_Victim, parameter_pVictim)
      		));
      		// 	find trainHitsAnotherTrainNext(Offender, Victim)
      		new PositivePatternCall(body, new FlatTuple(var_Offender, var_Victim), TrainHitsAnotherTrainNextQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_Offender = body.getOrCreateVariableByName("Offender");
      		PVariable var_Victim = body.getOrCreateVariableByName("Victim");
      		new TypeConstraint(body, new FlatTuple(var_Offender), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		new TypeConstraint(body, new FlatTuple(var_Victim), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_Offender, parameter_pOffender),
      		   new ExportedParameter(body, var_Victim, parameter_pVictim)
      		));
      		// 	find trainHitsAnotherTrainNextAfterNext(Offender, Victim)
      		new PositivePatternCall(body, new FlatTuple(var_Offender, var_Victim), TrainHitsAnotherTrainNextAfterNextQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_Offender = body.getOrCreateVariableByName("Offender");
      		PVariable var_Victim = body.getOrCreateVariableByName("Victim");
      		new TypeConstraint(body, new FlatTuple(var_Offender), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		new TypeConstraint(body, new FlatTuple(var_Victim), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_Offender, parameter_pOffender),
      		   new ExportedParameter(body, var_Victim, parameter_pVictim)
      		));
      		// 	find trainsAreTooClose(Offender, Victim)
      		new PositivePatternCall(body, new FlatTuple(var_Offender, var_Victim), TrainsAreTooCloseQuerySpecification.instance().getInternalQueryRepresentation());
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
