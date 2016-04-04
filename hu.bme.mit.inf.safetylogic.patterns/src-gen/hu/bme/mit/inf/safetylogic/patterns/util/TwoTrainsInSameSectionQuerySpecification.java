package hu.bme.mit.inf.safetylogic.patterns.util;

import com.google.common.collect.Sets;
import hu.bme.mit.inf.safetylogic.patterns.TwoTrainsInSameSectionMatch;
import hu.bme.mit.inf.safetylogic.patterns.TwoTrainsInSameSectionMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate TwoTrainsInSameSectionMatcher in a type-safe way.
 * 
 * @see TwoTrainsInSameSectionMatcher
 * @see TwoTrainsInSameSectionMatch
 * 
 */
@SuppressWarnings("all")
public final class TwoTrainsInSameSectionQuerySpecification extends BaseGeneratedEMFQuerySpecification<TwoTrainsInSameSectionMatcher> {
  private TwoTrainsInSameSectionQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TwoTrainsInSameSectionQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected TwoTrainsInSameSectionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TwoTrainsInSameSectionMatcher.on(engine);
  }
  
  @Override
  public TwoTrainsInSameSectionMatch newEmptyMatch() {
    return TwoTrainsInSameSectionMatch.newEmptyMatch();
  }
  
  @Override
  public TwoTrainsInSameSectionMatch newMatch(final Object... parameters) {
    return TwoTrainsInSameSectionMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Train) parameters[0], (hu.bme.mit.inf.safetylogic.model.railroadmodel.Train) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static TwoTrainsInSameSectionQuerySpecification INSTANCE = make();
    
    public static TwoTrainsInSameSectionQuerySpecification make() {
      return new TwoTrainsInSameSectionQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static TwoTrainsInSameSectionQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.twoTrainsInSameSection";
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
      		PVariable var_section = body.getOrCreateVariableByName("section");
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		new TypeConstraint(body, new FlatTuple(var_t2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_t1, "t1"),
      		   new ExportedParameter(body, var_t2, "t2")
      		));
      		// 	t1 != t2
      		new Inequality(body, var_t1, var_t2);
      		// 	Train.currentlyOn(t1, section)
      		new TypeConstraint(body, new FlatTuple(var_t1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_t1, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "currentlyOn")));
      		new Equality(body, var__virtual_0_, var_section);
      		// 	Train.currentlyOn(t2, section)
      		new TypeConstraint(body, new FlatTuple(var_t2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_t2, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Train", "currentlyOn")));
      		new Equality(body, var__virtual_1_, var_section);
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
