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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

import com.google.common.collect.Sets;

import hu.bme.mit.inf.safetylogic.patterns.SectionNeighborMatch;
import hu.bme.mit.inf.safetylogic.patterns.SectionNeighborMatcher;

/**
 * A pattern-specific query specification that can instantiate SectionNeighborMatcher in a type-safe way.
 * 
 * @see SectionNeighborMatcher
 * @see SectionNeighborMatch
 * 
 */
@SuppressWarnings("all")
public final class SectionNeighborQuerySpecification extends BaseGeneratedEMFQuerySpecification<SectionNeighborMatcher> {
  private SectionNeighborQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SectionNeighborQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SectionNeighborMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SectionNeighborMatcher.on(engine);
  }
  
  @Override
  public SectionNeighborMatch newEmptyMatch() {
    return SectionNeighborMatch.newEmptyMatch();
  }
  
  @Override
  public SectionNeighborMatch newMatch(final Object... parameters) {
    return SectionNeighborMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) parameters[0], (hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static SectionNeighborQuerySpecification INSTANCE = make();
    
    public static SectionNeighborQuerySpecification make() {
      return new SectionNeighborQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SectionNeighborQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.sectionNeighbor";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("s1","s2");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("s1", "hu.bme.mit.inf.safetylogic.model.railroadmodel.Section"),new PParameter("s2", "hu.bme.mit.inf.safetylogic.model.railroadmodel.Section"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_s1 = body.getOrCreateVariableByName("s1");
      		PVariable var_s2 = body.getOrCreateVariableByName("s2");
      		new TypeConstraint(body, new FlatTuple(var_s1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		new TypeConstraint(body, new FlatTuple(var_s2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_s1, "s1"),
      		   new ExportedParameter(body, var_s2, "s2")
      		));
      		// 	neg find turnout(s1)
      		new NegativePatternCall(body, new FlatTuple(var_s1), TurnoutQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find turnout(s2)
      		new NegativePatternCall(body, new FlatTuple(var_s2), TurnoutQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Section.clockwise(s1,s2)
      		new TypeConstraint(body, new FlatTuple(var_s1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_s1, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section", "clockwise")));
      		new Equality(body, var__virtual_0_, var_s2);
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_s1 = body.getOrCreateVariableByName("s1");
      		PVariable var_s2 = body.getOrCreateVariableByName("s2");
      		new TypeConstraint(body, new FlatTuple(var_s1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		new TypeConstraint(body, new FlatTuple(var_s2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_s1, "s1"),
      		   new ExportedParameter(body, var_s2, "s2")
      		));
      		// 	neg find turnout(s1)
      		new NegativePatternCall(body, new FlatTuple(var_s1), TurnoutQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find turnout(s2)
      		new NegativePatternCall(body, new FlatTuple(var_s2), TurnoutQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Section.counterClockwise(s1,s2)
      		new TypeConstraint(body, new FlatTuple(var_s1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_s1, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section", "counterClockwise")));
      		new Equality(body, var__virtual_0_, var_s2);
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
