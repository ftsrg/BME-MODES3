package hu.bme.mit.inf.safetylogic.patterns.util;

import com.google.common.collect.Sets;
import hu.bme.mit.inf.safetylogic.patterns.TrainIsGoingToHitMatch;
import hu.bme.mit.inf.safetylogic.patterns.TrainIsGoingToHitMatcher;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainIsGoingToHitNextAfterNextQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainIsGoingToHitNextQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.TwoTrainsInSameSectionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate TrainIsGoingToHitMatcher in a type-safe way.
 * 
 * @see TrainIsGoingToHitMatcher
 * @see TrainIsGoingToHitMatch
 * 
 */
@SuppressWarnings("all")
public final class TrainIsGoingToHitQuerySpecification extends BaseGeneratedEMFQuerySpecification<TrainIsGoingToHitMatcher> {
  private TrainIsGoingToHitQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TrainIsGoingToHitQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected TrainIsGoingToHitMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TrainIsGoingToHitMatcher.on(engine);
  }
  
  @Override
  public TrainIsGoingToHitMatch newEmptyMatch() {
    return TrainIsGoingToHitMatch.newEmptyMatch();
  }
  
  @Override
  public TrainIsGoingToHitMatch newMatch(final Object... parameters) {
    return TrainIsGoingToHitMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Train) parameters[0], (hu.bme.mit.inf.safetylogic.model.railroadmodel.Train) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static TrainIsGoingToHitQuerySpecification INSTANCE = make();
    
    public static TrainIsGoingToHitQuerySpecification make() {
      return new TrainIsGoingToHitQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static TrainIsGoingToHitQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.trainIsGoingToHit";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("t1","t2");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("t1", "hu.bme.mit.inf.safetylogic.model.railroadmodel.Train"),new PParameter("t2", "hu.bme.mit.inf.safetylogic.model.railroadmodel.Train"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_t1 = body.getOrCreateVariableByName("t1");
      		PVariable var_t2 = body.getOrCreateVariableByName("t2");
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		new TypeConstraint(body, new FlatTuple(var_t2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_t1, "t1"),
      		   new ExportedParameter(body, var_t2, "t2")
      		));
      		// 	find trainIsGoingToHitNextAfterNext(t1,t2)
      		new PositivePatternCall(body, new FlatTuple(var_t1, var_t2), TrainIsGoingToHitNextAfterNextQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_t1 = body.getOrCreateVariableByName("t1");
      		PVariable var_t2 = body.getOrCreateVariableByName("t2");
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		new TypeConstraint(body, new FlatTuple(var_t2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_t1, "t1"),
      		   new ExportedParameter(body, var_t2, "t2")
      		));
      		// 	find trainIsGoingToHitNext(t1,t2)
      		new PositivePatternCall(body, new FlatTuple(var_t1, var_t2), TrainIsGoingToHitNextQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_t1 = body.getOrCreateVariableByName("t1");
      		PVariable var_t2 = body.getOrCreateVariableByName("t2");
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		new TypeConstraint(body, new FlatTuple(var_t2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_t1, "t1"),
      		   new ExportedParameter(body, var_t2, "t2")
      		));
      		// 	find twoTrainsInSameSection(t1,t2)
      		new PositivePatternCall(body, new FlatTuple(var_t1, var_t2), TwoTrainsInSameSectionQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
