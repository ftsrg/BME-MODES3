package hu.bme.mit.inf.safetylogic.patterns.util;

import com.google.common.collect.Sets;
import hu.bme.mit.inf.safetylogic.patterns.SoloBlindTrackMatch;
import hu.bme.mit.inf.safetylogic.patterns.SoloBlindTrackMatcher;
import hu.bme.mit.inf.safetylogic.patterns.util.SoloClockwiseBlindTrackQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.SoloCounterClockwiseBlindTrackQuerySpecification;
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
 * A pattern-specific query specification that can instantiate SoloBlindTrackMatcher in a type-safe way.
 * 
 * @see SoloBlindTrackMatcher
 * @see SoloBlindTrackMatch
 * 
 */
@SuppressWarnings("all")
public final class SoloBlindTrackQuerySpecification extends BaseGeneratedEMFQuerySpecification<SoloBlindTrackMatcher> {
  private SoloBlindTrackQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SoloBlindTrackQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SoloBlindTrackMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SoloBlindTrackMatcher.on(engine);
  }
  
  @Override
  public SoloBlindTrackMatch newEmptyMatch() {
    return SoloBlindTrackMatch.newEmptyMatch();
  }
  
  @Override
  public SoloBlindTrackMatch newMatch(final Object... parameters) {
    return SoloBlindTrackMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static SoloBlindTrackQuerySpecification INSTANCE = make();
    
    public static SoloBlindTrackQuerySpecification make() {
      return new SoloBlindTrackQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SoloBlindTrackQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.soloBlindTrack";
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
      		new TypeConstraint(body, new FlatTuple(var_section), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_section, "section")
      		));
      		// 	find soloClockwiseBlindTrack(section)
      		new PositivePatternCall(body, new FlatTuple(var_section), SoloClockwiseBlindTrackQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_section = body.getOrCreateVariableByName("section");
      		new TypeConstraint(body, new FlatTuple(var_section), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_section, "section")
      		));
      		// 	find soloCounterClockwiseBlindTrack(section)
      		new PositivePatternCall(body, new FlatTuple(var_section), SoloCounterClockwiseBlindTrackQuerySpecification.instance().getInternalQueryRepresentation());
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
