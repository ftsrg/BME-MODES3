package hu.bme.mit.inf.safetylogic.patterns.util;

import com.google.common.collect.Sets;
import hu.bme.mit.inf.safetylogic.patterns.SoloClockwiseBlindTrackMatch;
import hu.bme.mit.inf.safetylogic.patterns.SoloClockwiseBlindTrackMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate SoloClockwiseBlindTrackMatcher in a type-safe way.
 * 
 * @see SoloClockwiseBlindTrackMatcher
 * @see SoloClockwiseBlindTrackMatch
 * 
 */
@SuppressWarnings("all")
public final class SoloClockwiseBlindTrackQuerySpecification extends BaseGeneratedEMFQuerySpecification<SoloClockwiseBlindTrackMatcher> {
  private SoloClockwiseBlindTrackQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SoloClockwiseBlindTrackQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SoloClockwiseBlindTrackMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SoloClockwiseBlindTrackMatcher.on(engine);
  }
  
  @Override
  public SoloClockwiseBlindTrackMatch newEmptyMatch() {
    return SoloClockwiseBlindTrackMatch.newEmptyMatch();
  }
  
  @Override
  public SoloClockwiseBlindTrackMatch newMatch(final Object... parameters) {
    return SoloClockwiseBlindTrackMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static SoloClockwiseBlindTrackQuerySpecification INSTANCE = make();
    
    public static SoloClockwiseBlindTrackQuerySpecification make() {
      return new SoloClockwiseBlindTrackQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SoloClockwiseBlindTrackQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.soloClockwiseBlindTrack";
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
      		PVariable var_turnout = body.getOrCreateVariableByName("turnout");
      		new TypeConstraint(body, new FlatTuple(var_section), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_section, "section")
      		));
      		// 	BlindTrack(section)
      		new TypeConstraint(body, new FlatTuple(var_section), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "BlindTrack")));
      		// 	Section.clockwise(section,turnout)
      		new TypeConstraint(body, new FlatTuple(var_section), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_section, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section", "clockwise")));
      		new Equality(body, var__virtual_0_, var_turnout);
      		// 	Turnout(turnout)
      		new TypeConstraint(body, new FlatTuple(var_turnout), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
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
