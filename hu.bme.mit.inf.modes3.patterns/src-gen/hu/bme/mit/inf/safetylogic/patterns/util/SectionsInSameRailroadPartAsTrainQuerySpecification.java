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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

import com.google.common.collect.Sets;

import hu.bme.mit.inf.safetylogic.patterns.SectionsInSameRailroadPartAsTrainMatch;
import hu.bme.mit.inf.safetylogic.patterns.SectionsInSameRailroadPartAsTrainMatcher;

/**
 * A pattern-specific query specification that can instantiate SectionsInSameRailroadPartAsTrainMatcher in a type-safe way.
 * 
 * @see SectionsInSameRailroadPartAsTrainMatcher
 * @see SectionsInSameRailroadPartAsTrainMatch
 * 
 */
@SuppressWarnings("all")
public final class SectionsInSameRailroadPartAsTrainQuerySpecification extends BaseGeneratedEMFQuerySpecification<SectionsInSameRailroadPartAsTrainMatcher> {
  private SectionsInSameRailroadPartAsTrainQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SectionsInSameRailroadPartAsTrainQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SectionsInSameRailroadPartAsTrainMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SectionsInSameRailroadPartAsTrainMatcher.on(engine);
  }
  
  @Override
  public SectionsInSameRailroadPartAsTrainMatch newEmptyMatch() {
    return SectionsInSameRailroadPartAsTrainMatch.newEmptyMatch();
  }
  
  @Override
  public SectionsInSameRailroadPartAsTrainMatch newMatch(final Object... parameters) {
    return SectionsInSameRailroadPartAsTrainMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Train) parameters[0], (hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static SectionsInSameRailroadPartAsTrainQuerySpecification INSTANCE = make();
    
    public static SectionsInSameRailroadPartAsTrainQuerySpecification make() {
      return new SectionsInSameRailroadPartAsTrainQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SectionsInSameRailroadPartAsTrainQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.sectionsInSameRailroadPartAsTrain";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("train","section");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("train", "hu.bme.mit.inf.safetylogic.model.railroadmodel.Train"),new PParameter("section", "hu.bme.mit.inf.safetylogic.model.railroadmodel.Section"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_train = body.getOrCreateVariableByName("train");
      		PVariable var_section = body.getOrCreateVariableByName("section");
      		PVariable var_trainSection = body.getOrCreateVariableByName("trainSection");
      		new TypeConstraint(body, new FlatTuple(var_train), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		new TypeConstraint(body, new FlatTuple(var_section), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_train, "train"),
      		   new ExportedParameter(body, var_section, "section")
      		));
      		// 	Train.currentlyOn(train, trainSection)
      		new TypeConstraint(body, new FlatTuple(var_train), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_train, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "currentlyOn")));
      		new Equality(body, var__virtual_0_, var_trainSection);
      		// 	find inSameRailroadPart(trainSection, section)
      		new PositivePatternCall(body, new FlatTuple(var_trainSection, var_section), InSameRailroadPartQuerySpecification.instance().getInternalQueryRepresentation());
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
