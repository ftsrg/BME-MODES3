package hu.bme.mit.inf.safetylogic.patterns.util;

import com.google.common.collect.Sets;
import hu.bme.mit.inf.safetylogic.patterns.TurnoutMatch;
import hu.bme.mit.inf.safetylogic.patterns.TurnoutMatcher;
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
 * A pattern-specific query specification that can instantiate TurnoutMatcher in a type-safe way.
 * 
 * @see TurnoutMatcher
 * @see TurnoutMatch
 * 
 */
@SuppressWarnings("all")
public final class TurnoutQuerySpecification extends BaseGeneratedEMFQuerySpecification<TurnoutMatcher> {
  private TurnoutQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TurnoutQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected TurnoutMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TurnoutMatcher.on(engine);
  }
  
  @Override
  public TurnoutMatch newEmptyMatch() {
    return TurnoutMatch.newEmptyMatch();
  }
  
  @Override
  public TurnoutMatch newMatch(final Object... parameters) {
    return TurnoutMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static TurnoutQuerySpecification INSTANCE = make();
    
    public static TurnoutQuerySpecification make() {
      return new TurnoutQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static TurnoutQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.turnout";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("turnout");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("turnout", "hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_turnout = body.getOrCreateVariableByName("turnout");
      		new TypeConstraint(body, new FlatTuple(var_turnout), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_turnout, "turnout")
      		));
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
