/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/rulepatterns/RulePatterns.vql
 */
package hu.bme.mit.inf.safetylogic.rulepatterns.util;

import com.google.common.collect.Sets;
import hu.bme.mit.inf.safetylogic.rulepatterns.NoTrainOnStationMatch;
import hu.bme.mit.inf.safetylogic.rulepatterns.NoTrainOnStationMatcher;
import hu.bme.mit.inf.safetylogic.rulepatterns.util.TrainIsNotInStationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.PatternMatchCounter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate NoTrainOnStationMatcher in a type-safe way.
 * 
 * @see NoTrainOnStationMatcher
 * @see NoTrainOnStationMatch
 * 
 */
@SuppressWarnings("all")
public final class NoTrainOnStationQuerySpecification extends BaseGeneratedEMFQuerySpecification<NoTrainOnStationMatcher> {
  private NoTrainOnStationQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static NoTrainOnStationQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected NoTrainOnStationMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return NoTrainOnStationMatcher.on(engine);
  }
  
  @Override
  public NoTrainOnStationMatcher instantiate() throws ViatraQueryException {
    return NoTrainOnStationMatcher.create();
  }
  
  @Override
  public NoTrainOnStationMatch newEmptyMatch() {
    return NoTrainOnStationMatch.newEmptyMatch();
  }
  
  @Override
  public NoTrainOnStationMatch newMatch(final Object... parameters) {
    return NoTrainOnStationMatch.newMatch();
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: hu.bme.mit.inf.safetylogic.rulepatterns.util.NoTrainOnStationQuerySpecification (visibility: PUBLIC, simpleName: NoTrainOnStationQuerySpecification, identifier: hu.bme.mit.inf.safetylogic.rulepatterns.util.NoTrainOnStationQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.inf.safetylogic.rulepatterns.util) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: hu.bme.mit.inf.safetylogic.rulepatterns.util.NoTrainOnStationQuerySpecification (visibility: PUBLIC, simpleName: NoTrainOnStationQuerySpecification, identifier: hu.bme.mit.inf.safetylogic.rulepatterns.util.NoTrainOnStationQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.inf.safetylogic.rulepatterns.util) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static NoTrainOnStationQuerySpecification INSTANCE = new NoTrainOnStationQuerySpecification();
    
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
    private final static NoTrainOnStationQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final List<PParameter> parameters = Arrays.asList();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.rulepatterns.noTrainOnStation";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList();
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
          {
              PBody body = new PBody(this);
              PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
              ));
              // 	count find trainIsNotInStation(_) == 0
              PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
              new PatternMatchCounter(body, new FlatTuple(var___0_), TrainIsNotInStationQuerySpecification.instance().getInternalQueryRepresentation(), var__virtual_0_);
              PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
              new ConstantValue(body, var__virtual_1_, 0);
              new Equality(body, var__virtual_0_, var__virtual_1_);
              bodies.add(body);
          }
      } catch (ViatraQueryException ex) {
          throw processDependencyException(ex);
      }
      return bodies;
    }
  }
  
  private static int evaluateExpression_1_1() {
    return 0;
  }
}
