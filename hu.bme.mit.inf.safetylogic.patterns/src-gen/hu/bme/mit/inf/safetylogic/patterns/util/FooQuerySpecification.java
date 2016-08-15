/**
 * Generated from platform:/resource/hu.bme.mit.inf.safetylogic.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/RailRoadQueries.vql
 */
package hu.bme.mit.inf.safetylogic.patterns.util;

import com.google.common.collect.Sets;
import hu.bme.mit.inf.safetylogic.patterns.FooMatch;
import hu.bme.mit.inf.safetylogic.patterns.FooMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate FooMatcher in a type-safe way.
 * 
 * @see FooMatcher
 * @see FooMatch
 * 
 */
@SuppressWarnings("all")
public final class FooQuerySpecification extends BaseGeneratedEMFQuerySpecification<FooMatcher> {
  private FooQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static FooQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected FooMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return FooMatcher.on(engine);
  }
  
  @Override
  public FooMatch newEmptyMatch() {
    return FooMatch.newEmptyMatch();
  }
  
  @Override
  public FooMatch newMatch(final Object... parameters) {
    return FooMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link FooQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link FooQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static FooQuerySpecification INSTANCE = new FooQuerySpecification();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private final static Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternalSneaky();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static FooQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.foo";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("asd");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(
      			 new PParameter("asd", "hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")))
      			);
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_asd = body.getOrCreateVariableByName("asd");
      		new TypeConstraint(body, new FlatTuple(var_asd), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_asd, "asd")
      		));
      		// 	RailRoadElement(asd)
      		new TypeConstraint(body, new FlatTuple(var_asd), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
      		bodies.add(body);
      	}
      	// to silence compiler error
      	if (false) throw new ViatraQueryException("Never", "happens");
      } catch (ViatraQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
