package hu.bme.mit.inf.safetylogic.patterns.util;

import com.google.common.collect.Sets;

import hu.bme.mit.inf.safetylogic.patterns.BlindTrackMatch;
import hu.bme.mit.inf.safetylogic.patterns.BlindTrackMatcher;

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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate BlindTrackMatcher in a type-safe way.
 * 
 * @see BlindTrackMatcher
 * @see BlindTrackMatch
 * 
 */
@SuppressWarnings("all")
public final class BlindTrackQuerySpecification extends BaseGeneratedEMFQuerySpecification<BlindTrackMatcher> {
  private BlindTrackQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BlindTrackQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected BlindTrackMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return BlindTrackMatcher.on(engine);
  }
  
  @Override
  public BlindTrackMatch newEmptyMatch() {
    return BlindTrackMatch.newEmptyMatch();
  }
  
  @Override
  public BlindTrackMatch newMatch(final Object... parameters) {
    return BlindTrackMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.BlindTrack) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static BlindTrackQuerySpecification INSTANCE = make();
    
    public static BlindTrackQuerySpecification make() {
      return new BlindTrackQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static BlindTrackQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.blindTrack";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("blindTrack");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("blindTrack", "hu.bme.mit.inf.safetylogic.model.railroadmodel.BlindTrack"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_blindTrack = body.getOrCreateVariableByName("blindTrack");
      		new TypeConstraint(body, new FlatTuple(var_blindTrack), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "BlindTrack")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_blindTrack, "blindTrack")
      		));
      		// 	BlindTrack(blindTrack)
      		new TypeConstraint(body, new FlatTuple(var_blindTrack), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "BlindTrack")));
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
