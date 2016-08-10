package hu.bme.mit.inf.safetylogic.patterns.util;

import com.google.common.collect.Sets;

import hu.bme.mit.inf.safetylogic.patterns.SoloSectionMatch;
import hu.bme.mit.inf.safetylogic.patterns.SoloSectionMatcher;
import hu.bme.mit.inf.safetylogic.patterns.util.SoloBlindTrackQuerySpecification;

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

/**
 * A pattern-specific query specification that can instantiate SoloSectionMatcher in a type-safe way.
 * 
 * @see SoloSectionMatcher
 * @see SoloSectionMatch
 * 
 */
@SuppressWarnings("all")
public final class SoloSectionQuerySpecification extends BaseGeneratedEMFQuerySpecification<SoloSectionMatcher> {
  private SoloSectionQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SoloSectionQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SoloSectionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SoloSectionMatcher.on(engine);
  }
  
  @Override
  public SoloSectionMatch newEmptyMatch() {
    return SoloSectionMatch.newEmptyMatch();
  }
  
  @Override
  public SoloSectionMatch newMatch(final Object... parameters) {
    return SoloSectionMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static SoloSectionQuerySpecification INSTANCE = make();
    
    public static SoloSectionQuerySpecification make() {
      return new SoloSectionQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SoloSectionQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.soloSection";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("section");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("section", "hu.bme.mit.inf.safetylogic.model.railroadmodel.Section"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_section = body.getOrCreateVariableByName("section");
      		PVariable var_turnout1 = body.getOrCreateVariableByName("turnout1");
      		PVariable var_turnout2 = body.getOrCreateVariableByName("turnout2");
      		new TypeConstraint(body, new FlatTuple(var_section), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_section, "section")
      		));
      		//  	Section.clockwise(section, turnout1)
      		new TypeConstraint(body, new FlatTuple(var_section), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_section, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section", "clockwise")));
      		new Equality(body, var__virtual_0_, var_turnout1);
      		//  // It has two neighbors, which are both turnouts	Section.counterClockwise(section, turnout2)
      		new TypeConstraint(body, new FlatTuple(var_section), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_section, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section", "counterClockwise")));
      		new Equality(body, var__virtual_1_, var_turnout2);
      		// 	Turnout(turnout1)
      		new TypeConstraint(body, new FlatTuple(var_turnout1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		// 	Turnout(turnout2)
      		new TypeConstraint(body, new FlatTuple(var_turnout2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_section = body.getOrCreateVariableByName("section");
      		new TypeConstraint(body, new FlatTuple(var_section), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_section, "section")
      		));
      		// 	find soloBlindTrack(section)
      		new PositivePatternCall(body, new FlatTuple(var_section), SoloBlindTrackQuerySpecification.instance().getInternalQueryRepresentation());
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
