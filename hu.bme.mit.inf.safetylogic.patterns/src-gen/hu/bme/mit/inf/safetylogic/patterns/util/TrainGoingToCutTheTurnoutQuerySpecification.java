package hu.bme.mit.inf.safetylogic.patterns.util;

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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

import com.google.common.collect.Sets;

import hu.bme.mit.inf.safetylogic.patterns.TrainGoingToCutTheTurnoutMatch;
import hu.bme.mit.inf.safetylogic.patterns.TrainGoingToCutTheTurnoutMatcher;

/**
 * A pattern-specific query specification that can instantiate TrainGoingToCutTheTurnoutMatcher in a type-safe way.
 * 
 * @see TrainGoingToCutTheTurnoutMatcher
 * @see TrainGoingToCutTheTurnoutMatch
 * 
 */
@SuppressWarnings("all")
public final class TrainGoingToCutTheTurnoutQuerySpecification extends BaseGeneratedEMFQuerySpecification<TrainGoingToCutTheTurnoutMatcher> {
  private TrainGoingToCutTheTurnoutQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TrainGoingToCutTheTurnoutQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected TrainGoingToCutTheTurnoutMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TrainGoingToCutTheTurnoutMatcher.on(engine);
  }
  
  @Override
  public TrainGoingToCutTheTurnoutMatch newEmptyMatch() {
    return TrainGoingToCutTheTurnoutMatch.newEmptyMatch();
  }
  
  @Override
  public TrainGoingToCutTheTurnoutMatch newMatch(final Object... parameters) {
    return TrainGoingToCutTheTurnoutMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Train) parameters[0], (hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static TrainGoingToCutTheTurnoutQuerySpecification INSTANCE = make();
    
    public static TrainGoingToCutTheTurnoutQuerySpecification make() {
      return new TrainGoingToCutTheTurnoutQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static TrainGoingToCutTheTurnoutQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.trainGoingToCutTheTurnout";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("train","turnout");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("train", "hu.bme.mit.inf.safetylogic.model.railroadmodel.Train"),new PParameter("turnout", "hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_train = body.getOrCreateVariableByName("train");
      		PVariable var_turnout = body.getOrCreateVariableByName("turnout");
      		PVariable var_sectionNearTheTurnout = body.getOrCreateVariableByName("sectionNearTheTurnout");
      		PVariable var_trainSection = body.getOrCreateVariableByName("trainSection");
      		new TypeConstraint(body, new FlatTuple(var_train), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		new TypeConstraint(body, new FlatTuple(var_turnout), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_train, "train"),
      		   new ExportedParameter(body, var_turnout, "turnout")
      		));
      		// 	find trainsNextTurnout(train, turnout)
      		new PositivePatternCall(body, new FlatTuple(var_train, var_turnout), TrainsNextTurnoutQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Train.goingClockwise(train,true)
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new ConstantValue(body, var__virtual_0_, true);
      		new TypeConstraint(body, new FlatTuple(var_train), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_train, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "goingClockwise")));
      		new Equality(body, var__virtual_1_, var__virtual_0_);
      		// 	Section.clockwise(sectionNearTheTurnout, turnout)
      		new TypeConstraint(body, new FlatTuple(var_sectionNearTheTurnout), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_sectionNearTheTurnout, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section", "clockwise")));
      		new Equality(body, var__virtual_2_, var_turnout);
      		// 	Turnout.notConnectedSection(turnout, sectionNearTheTurnout)
      		new TypeConstraint(body, new FlatTuple(var_turnout), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_turnout, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout", "notConnectedSection")));
      		new Equality(body, var__virtual_3_, var_sectionNearTheTurnout);
      		// 	Train.currentlyOn(train, trainSection)
      		new TypeConstraint(body, new FlatTuple(var_train), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new TypeConstraint(body, new FlatTuple(var_train, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "currentlyOn")));
      		new Equality(body, var__virtual_4_, var_trainSection);
      		// 	find inSameRailroadPart(trainSection, sectionNearTheTurnout)
      		new PositivePatternCall(body, new FlatTuple(var_trainSection, var_sectionNearTheTurnout), InSameRailroadPartQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_train = body.getOrCreateVariableByName("train");
      		PVariable var_turnout = body.getOrCreateVariableByName("turnout");
      		PVariable var_sectionNearTheTurnout = body.getOrCreateVariableByName("sectionNearTheTurnout");
      		PVariable var_trainSection = body.getOrCreateVariableByName("trainSection");
      		new TypeConstraint(body, new FlatTuple(var_train), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		new TypeConstraint(body, new FlatTuple(var_turnout), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_train, "train"),
      		   new ExportedParameter(body, var_turnout, "turnout")
      		));
      		// 	find trainsNextTurnout(train, turnout)
      		new PositivePatternCall(body, new FlatTuple(var_train, var_turnout), TrainsNextTurnoutQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Train.goingClockwise(train,false)
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new ConstantValue(body, var__virtual_0_, false);
      		new TypeConstraint(body, new FlatTuple(var_train), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_train, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "goingClockwise")));
      		new Equality(body, var__virtual_1_, var__virtual_0_);
      		// 	Section.counterClockwise(sectionNearTheTurnout, turnout)
      		new TypeConstraint(body, new FlatTuple(var_sectionNearTheTurnout), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_sectionNearTheTurnout, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section", "counterClockwise")));
      		new Equality(body, var__virtual_2_, var_turnout);
      		// 	Turnout.notConnectedSection(turnout, sectionNearTheTurnout)
      		new TypeConstraint(body, new FlatTuple(var_turnout), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_turnout, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout", "notConnectedSection")));
      		new Equality(body, var__virtual_3_, var_sectionNearTheTurnout);
      		// 	Train.currentlyOn(train, trainSection)
      		new TypeConstraint(body, new FlatTuple(var_train), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new TypeConstraint(body, new FlatTuple(var_train, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "currentlyOn")));
      		new Equality(body, var__virtual_4_, var_trainSection);
      		// 	find inSameRailroadPart(trainSection, sectionNearTheTurnout)
      		new PositivePatternCall(body, new FlatTuple(var_trainSection, var_sectionNearTheTurnout), InSameRailroadPartQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_train = body.getOrCreateVariableByName("train");
      		PVariable var_turnout = body.getOrCreateVariableByName("turnout");
      		PVariable var_sectionNearTheTurnout = body.getOrCreateVariableByName("sectionNearTheTurnout");
      		PVariable var_trainSection = body.getOrCreateVariableByName("trainSection");
      		new TypeConstraint(body, new FlatTuple(var_train), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		new TypeConstraint(body, new FlatTuple(var_turnout), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_train, "train"),
      		   new ExportedParameter(body, var_turnout, "turnout")
      		));
      		// 	EnglishTurnout(turnout)
      		new TypeConstraint(body, new FlatTuple(var_turnout), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "EnglishTurnout")));
      		//  // the english turnout only behaves badly from ccw direction 	find trainsNextTurnout(train, turnout)
      		new PositivePatternCall(body, new FlatTuple(var_train, var_turnout), TrainsNextTurnoutQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Train.goingClockwise(train,false)
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new ConstantValue(body, var__virtual_0_, false);
      		new TypeConstraint(body, new FlatTuple(var_train), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_train, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "goingClockwise")));
      		new Equality(body, var__virtual_1_, var__virtual_0_);
      		// 	Section.counterClockwise(sectionNearTheTurnout, turnout)
      		new TypeConstraint(body, new FlatTuple(var_sectionNearTheTurnout), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_sectionNearTheTurnout, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section", "counterClockwise")));
      		new Equality(body, var__virtual_2_, var_turnout);
      		// 	EnglishTurnout.notConnectedClockwiseSection(turnout, sectionNearTheTurnout)
      		new TypeConstraint(body, new FlatTuple(var_turnout), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "EnglishTurnout")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_turnout, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "EnglishTurnout", "notConnectedClockwiseSection")));
      		new Equality(body, var__virtual_3_, var_sectionNearTheTurnout);
      		// 	Train.currentlyOn(train, trainSection)
      		new TypeConstraint(body, new FlatTuple(var_train), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new TypeConstraint(body, new FlatTuple(var_train, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "currentlyOn")));
      		new Equality(body, var__virtual_4_, var_trainSection);
      		// 	find inSameRailroadPart(trainSection, sectionNearTheTurnout)
      		new PositivePatternCall(body, new FlatTuple(var_trainSection, var_sectionNearTheTurnout), InSameRailroadPartQuerySpecification.instance().getInternalQueryRepresentation());
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
