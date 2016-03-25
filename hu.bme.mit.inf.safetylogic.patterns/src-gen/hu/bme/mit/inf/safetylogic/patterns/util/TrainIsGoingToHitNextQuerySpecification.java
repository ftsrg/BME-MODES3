package hu.bme.mit.inf.safetylogic.patterns.util;

import com.google.common.collect.Sets;
import hu.bme.mit.inf.safetylogic.patterns.TrainIsGoingToHitNextMatch;
import hu.bme.mit.inf.safetylogic.patterns.TrainIsGoingToHitNextMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate TrainIsGoingToHitNextMatcher in a type-safe way.
 * 
 * @see TrainIsGoingToHitNextMatcher
 * @see TrainIsGoingToHitNextMatch
 * 
 */
@SuppressWarnings("all")
public final class TrainIsGoingToHitNextQuerySpecification extends BaseGeneratedEMFQuerySpecification<TrainIsGoingToHitNextMatcher> {
  private TrainIsGoingToHitNextQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TrainIsGoingToHitNextQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected TrainIsGoingToHitNextMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TrainIsGoingToHitNextMatcher.on(engine);
  }
  
  @Override
  public TrainIsGoingToHitNextMatch newEmptyMatch() {
    return TrainIsGoingToHitNextMatch.newEmptyMatch();
  }
  
  @Override
  public TrainIsGoingToHitNextMatch newMatch(final Object... parameters) {
    return TrainIsGoingToHitNextMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Train) parameters[0], (hu.bme.mit.inf.safetylogic.model.railroadmodel.Train) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static TrainIsGoingToHitNextQuerySpecification INSTANCE = make();
    
    public static TrainIsGoingToHitNextQuerySpecification make() {
      return new TrainIsGoingToHitNextQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static TrainIsGoingToHitNextQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.trainIsGoingToHitNext";
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
      		PVariable var_nextSection = body.getOrCreateVariableByName("nextSection");
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		new TypeConstraint(body, new FlatTuple(var_t2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_t1, "t1"),
      		   new ExportedParameter(body, var_t2, "t2")
      		));
      		// 	Train.goingClockwise(t1, true)
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new ConstantValue(body, var__virtual_0_, true);
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_t1, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "goingClockwise")));
      		new Equality(body, var__virtual_1_, var__virtual_0_);
      		// 	Train.currentlyOn.clockwise(t1,nextSection)
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_t1, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "currentlyOn")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var__virtual_2_, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section", "clockwise")));
      		new Equality(body, var__virtual_3_, var_nextSection);
      		// 	Train.currentlyOn(t2, nextSection)
      		new TypeConstraint(body, new FlatTuple(var_t2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new TypeConstraint(body, new FlatTuple(var_t2, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "currentlyOn")));
      		new Equality(body, var__virtual_4_, var_nextSection);
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_t1 = body.getOrCreateVariableByName("t1");
      		PVariable var_t2 = body.getOrCreateVariableByName("t2");
      		PVariable var_nextSection = body.getOrCreateVariableByName("nextSection");
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		new TypeConstraint(body, new FlatTuple(var_t2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_t1, "t1"),
      		   new ExportedParameter(body, var_t2, "t2")
      		));
      		// 	Train.goingClockwise(t1, false)
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new ConstantValue(body, var__virtual_0_, false);
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_t1, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "goingClockwise")));
      		new Equality(body, var__virtual_1_, var__virtual_0_);
      		// 	Train.currentlyOn.counterClockwise(t1,nextSection)
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_t1, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "currentlyOn")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var__virtual_2_, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section", "counterClockwise")));
      		new Equality(body, var__virtual_3_, var_nextSection);
      		// 	Train.currentlyOn(t2, nextSection)
      		new TypeConstraint(body, new FlatTuple(var_t2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new TypeConstraint(body, new FlatTuple(var_t2, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "currentlyOn")));
      		new Equality(body, var__virtual_4_, var_nextSection);
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
