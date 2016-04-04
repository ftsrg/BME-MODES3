package hu.bme.mit.inf.safetylogic.patterns.util;

import com.google.common.collect.Sets;
import hu.bme.mit.inf.safetylogic.patterns.TrainIsGoingToHitNextAfterNextMatch;
import hu.bme.mit.inf.safetylogic.patterns.TrainIsGoingToHitNextAfterNextMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate TrainIsGoingToHitNextAfterNextMatcher in a type-safe way.
 * 
 * @see TrainIsGoingToHitNextAfterNextMatcher
 * @see TrainIsGoingToHitNextAfterNextMatch
 * 
 */
@SuppressWarnings("all")
public final class TrainIsGoingToHitNextAfterNextQuerySpecification extends BaseGeneratedEMFQuerySpecification<TrainIsGoingToHitNextAfterNextMatcher> {
  private TrainIsGoingToHitNextAfterNextQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TrainIsGoingToHitNextAfterNextQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected TrainIsGoingToHitNextAfterNextMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TrainIsGoingToHitNextAfterNextMatcher.on(engine);
  }
  
  @Override
  public TrainIsGoingToHitNextAfterNextMatch newEmptyMatch() {
    return TrainIsGoingToHitNextAfterNextMatch.newEmptyMatch();
  }
  
  @Override
  public TrainIsGoingToHitNextAfterNextMatch newMatch(final Object... parameters) {
    return TrainIsGoingToHitNextAfterNextMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Train) parameters[0], (hu.bme.mit.inf.safetylogic.model.railroadmodel.Train) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static TrainIsGoingToHitNextAfterNextQuerySpecification INSTANCE = make();
    
    public static TrainIsGoingToHitNextAfterNextQuerySpecification make() {
      return new TrainIsGoingToHitNextAfterNextQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static TrainIsGoingToHitNextAfterNextQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.trainIsGoingToHitNextAfterNext";
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
      		PVariable var_trainSection = body.getOrCreateVariableByName("trainSection");
      		PVariable var_nearTrainSection = body.getOrCreateVariableByName("nearTrainSection");
      		PVariable var_notSoNearTheFuckinTrainSection = body.getOrCreateVariableByName("notSoNearTheFuckinTrainSection");
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		new TypeConstraint(body, new FlatTuple(var_t2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_t1, "t1"),
      		   new ExportedParameter(body, var_t2, "t2")
      		));
      		// 	t1 != t2
      		new Inequality(body, var_t1, var_t2);
      		// 	Train.goingClockwise(t1, true)
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new ConstantValue(body, var__virtual_0_, true);
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_t1, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "goingClockwise")));
      		new Equality(body, var__virtual_1_, var__virtual_0_);
      		// //XXX	Train.currentlyOn.clockwise.clockwise(t1,nextSection);	Train.currentlyOn(t1, trainSection)
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_t1, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "currentlyOn")));
      		new Equality(body, var__virtual_2_, var_trainSection);
      		// 	Section.clockwise(trainSection, nearTrainSection)
      		new TypeConstraint(body, new FlatTuple(var_trainSection), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_trainSection, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section", "clockwise")));
      		new Equality(body, var__virtual_3_, var_nearTrainSection);
      		// 	Section.clockwise(nearTrainSection, notSoNearTheFuckinTrainSection)
      		new TypeConstraint(body, new FlatTuple(var_nearTrainSection), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new TypeConstraint(body, new FlatTuple(var_nearTrainSection, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section", "clockwise")));
      		new Equality(body, var__virtual_4_, var_notSoNearTheFuckinTrainSection);
      		// 	Train.currentlyOn(t2, notSoNearTheFuckinTrainSection)
      		new TypeConstraint(body, new FlatTuple(var_t2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
      		new TypeConstraint(body, new FlatTuple(var_t2, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "currentlyOn")));
      		new Equality(body, var__virtual_5_, var_notSoNearTheFuckinTrainSection);
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_t1 = body.getOrCreateVariableByName("t1");
      		PVariable var_t2 = body.getOrCreateVariableByName("t2");
      		PVariable var_trainSection = body.getOrCreateVariableByName("trainSection");
      		PVariable var_nearTrainSection = body.getOrCreateVariableByName("nearTrainSection");
      		PVariable var_notSoNearTheFuckinTrainSection = body.getOrCreateVariableByName("notSoNearTheFuckinTrainSection");
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		new TypeConstraint(body, new FlatTuple(var_t2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_t1, "t1"),
      		   new ExportedParameter(body, var_t2, "t2")
      		));
      		// 	t1 != t2
      		new Inequality(body, var_t1, var_t2);
      		// 	Train.goingClockwise(t1, false)
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new ConstantValue(body, var__virtual_0_, false);
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_t1, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "goingClockwise")));
      		new Equality(body, var__virtual_1_, var__virtual_0_);
      		// //XXX	Train.currentlyOn.counterClockwise.counterClockwise(t1,nextSection);	Train.currentlyOn(t1, trainSection)
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_t1, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "currentlyOn")));
      		new Equality(body, var__virtual_2_, var_trainSection);
      		// 	Section.counterClockwise(trainSection, nearTrainSection)
      		new TypeConstraint(body, new FlatTuple(var_trainSection), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_trainSection, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section", "counterClockwise")));
      		new Equality(body, var__virtual_3_, var_nearTrainSection);
      		// 	Section.counterClockwise(nearTrainSection, notSoNearTheFuckinTrainSection)
      		new TypeConstraint(body, new FlatTuple(var_nearTrainSection), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new TypeConstraint(body, new FlatTuple(var_nearTrainSection, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section", "counterClockwise")));
      		new Equality(body, var__virtual_4_, var_notSoNearTheFuckinTrainSection);
      		// 	Train.currentlyOn(t2, notSoNearTheFuckinTrainSection)
      		new TypeConstraint(body, new FlatTuple(var_t2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
      		new TypeConstraint(body, new FlatTuple(var_t2, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "currentlyOn")));
      		new Equality(body, var__virtual_5_, var_notSoNearTheFuckinTrainSection);
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
