/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/SafetyPatterns.vql
 */
package hu.bme.mit.inf.safetylogic.patterns.util;

import com.google.common.collect.Sets;
import hu.bme.mit.inf.safetylogic.patterns.NextSectionMatch;
import hu.bme.mit.inf.safetylogic.patterns.NextSectionMatcher;
import hu.bme.mit.inf.safetylogic.patterns.internal.NotNullQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.ViablePathsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;

/**
 * A pattern-specific query specification that can instantiate NextSectionMatcher in a type-safe way.
 * 
 * @see NextSectionMatcher
 * @see NextSectionMatch
 * 
 */
@SuppressWarnings("all")
public final class NextSectionQuerySpecification extends BaseGeneratedEMFQuerySpecification<NextSectionMatcher> {
  private NextSectionQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static NextSectionQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected NextSectionMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return NextSectionMatcher.on(engine);
  }
  
  @Override
  public NextSectionMatcher instantiate() throws ViatraQueryException {
    return NextSectionMatcher.create();
  }
  
  @Override
  public NextSectionMatch newEmptyMatch() {
    return NextSectionMatch.newEmptyMatch();
  }
  
  @Override
  public NextSectionMatch newMatch(final Object... parameters) {
    return NextSectionMatch.newMatch((hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement) parameters[0], (hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement) parameters[1], (hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: hu.bme.mit.inf.safetylogic.patterns.util.NextSectionQuerySpecification (visibility: PUBLIC, simpleName: NextSectionQuerySpecification, identifier: hu.bme.mit.inf.safetylogic.patterns.util.NextSectionQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.inf.safetylogic.patterns.util) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: hu.bme.mit.inf.safetylogic.patterns.util.NextSectionQuerySpecification (visibility: PUBLIC, simpleName: NextSectionQuerySpecification, identifier: hu.bme.mit.inf.safetylogic.patterns.util.NextSectionQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.inf.safetylogic.patterns.util) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static NextSectionQuerySpecification INSTANCE = new NextSectionQuerySpecification();
    
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
    private final static NextSectionQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pOld = new PParameter("Old", "hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pCurrent = new PParameter("Current", "hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pNext = new PParameter("Next", "hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pOld, parameter_pCurrent, parameter_pNext);
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.nextSection";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("Old","Current","Next");
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
              PVariable var_Old = body.getOrCreateVariableByName("Old");
              PVariable var_Current = body.getOrCreateVariableByName("Current");
              PVariable var_Next = body.getOrCreateVariableByName("Next");
              PVariable var_p = body.getOrCreateVariableByName("p");
              new TypeConstraint(body, Tuples.flatTupleOf(var_Old), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
              new TypeConstraint(body, Tuples.flatTupleOf(var_Current), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
              new TypeConstraint(body, Tuples.flatTupleOf(var_Next), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_Old, parameter_pOld),
                 new ExportedParameter(body, var_Current, parameter_pCurrent),
                 new ExportedParameter(body, var_Next, parameter_pNext)
              ));
              // 	find viablePaths(Current, p)
              new PositivePatternCall(body, new FlatTuple(var_Current, var_p), ViablePathsQuerySpecification.instance().getInternalQueryRepresentation());
              // 	Path.from(p, Old)
              new TypeConstraint(body, Tuples.flatTupleOf(var_p), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
              PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_p, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "from")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
              new Equality(body, var__virtual_0_, var_Old);
              // 	Path.via(p, Current)
              new TypeConstraint(body, Tuples.flatTupleOf(var_p), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
              PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_p, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "via")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
              new Equality(body, var__virtual_1_, var_Current);
              // 	Path.to(p, Next)
              new TypeConstraint(body, Tuples.flatTupleOf(var_p), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
              PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_p, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "to")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
              new Equality(body, var__virtual_2_, var_Next);
              bodies.add(body);
          }
          {
              PBody body = new PBody(this);
              PVariable var_Old = body.getOrCreateVariableByName("Old");
              PVariable var_Current = body.getOrCreateVariableByName("Current");
              PVariable var_Next = body.getOrCreateVariableByName("Next");
              PVariable var_RailRoad = body.getOrCreateVariableByName("RailRoad");
              PVariable var_p = body.getOrCreateVariableByName("p");
              PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
              new TypeConstraint(body, Tuples.flatTupleOf(var_Old), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
              new TypeConstraint(body, Tuples.flatTupleOf(var_Current), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
              new TypeConstraint(body, Tuples.flatTupleOf(var_Next), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_Old, parameter_pOld),
                 new ExportedParameter(body, var_Current, parameter_pCurrent),
                 new ExportedParameter(body, var_Next, parameter_pNext)
              ));
              // 		neg find notNull(Old)
              new NegativePatternCall(body, new FlatTuple(var_Old), NotNullQuerySpecification.instance().getInternalQueryRepresentation());
              //  // Check for null, as if it is, we don't know the direction		RailRoadModel.sections(RailRoad,Old)
              new TypeConstraint(body, Tuples.flatTupleOf(var_RailRoad), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadModel")));
              PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_RailRoad, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadModel", "sections")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
              new Equality(body, var__virtual_0_, var_Old);
              // 	RailRoadModel.sections(RailRoad,Next)
              new TypeConstraint(body, Tuples.flatTupleOf(var_RailRoad), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadModel")));
              PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_RailRoad, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadModel", "sections")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
              new Equality(body, var__virtual_1_, var_Next);
              // 	RailRoadModel.sections(RailRoad,Current)
              new TypeConstraint(body, Tuples.flatTupleOf(var_RailRoad), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadModel")));
              PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_RailRoad, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadModel", "sections")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
              new Equality(body, var__virtual_2_, var_Current);
              // 		find viablePaths(Current, p)
              new PositivePatternCall(body, new FlatTuple(var_Current, var_p), ViablePathsQuerySpecification.instance().getInternalQueryRepresentation());
              // 	Path.from(p, _)
              new TypeConstraint(body, Tuples.flatTupleOf(var_p), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
              PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_p, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "from")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
              new Equality(body, var__virtual_3_, var___0_);
              // 	Path.via(p, Current)
              new TypeConstraint(body, Tuples.flatTupleOf(var_p), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
              PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_p, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "via")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_4_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
              new Equality(body, var__virtual_4_, var_Current);
              // 	Path.to(p, Next)
              new TypeConstraint(body, Tuples.flatTupleOf(var_p), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
              PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_p, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "to")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_5_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
              new Equality(body, var__virtual_5_, var_Next);
              bodies.add(body);
          }
      } catch (ViatraQueryException ex) {
          throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
