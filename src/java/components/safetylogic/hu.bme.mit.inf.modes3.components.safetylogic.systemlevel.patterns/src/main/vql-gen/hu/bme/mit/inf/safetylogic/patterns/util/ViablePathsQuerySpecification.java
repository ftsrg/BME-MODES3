/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/DerivedFeatures.vql
 */
package hu.bme.mit.inf.safetylogic.patterns.util;

import com.google.common.collect.Sets;
import hu.bme.mit.inf.safetylogic.patterns.ViablePathsMatch;
import hu.bme.mit.inf.safetylogic.patterns.ViablePathsMatcher;
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
import org.eclipse.viatra.query.runtime.matchers.backend.IQueryBackendFactory;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ViablePathsMatcher in a type-safe way.
 * 
 * @see ViablePathsMatcher
 * @see ViablePathsMatch
 * 
 */
@SuppressWarnings("all")
public final class ViablePathsQuerySpecification extends BaseGeneratedEMFQuerySpecification<ViablePathsMatcher> {
  private ViablePathsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static ViablePathsQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ViablePathsMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ViablePathsMatcher.on(engine);
  }
  
  @Override
  public ViablePathsMatcher instantiate() throws ViatraQueryException {
    return ViablePathsMatcher.create();
  }
  
  @Override
  public ViablePathsMatch newEmptyMatch() {
    return ViablePathsMatch.newEmptyMatch();
  }
  
  @Override
  public ViablePathsMatch newMatch(final Object... parameters) {
    return ViablePathsMatch.newMatch((hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement) parameters[0], (hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Path) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link ViablePathsQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link ViablePathsQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static ViablePathsQuerySpecification INSTANCE = new ViablePathsQuerySpecification();
    
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
    private final static ViablePathsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pThis = new PParameter("This", "hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pPath = new PParameter("path", "hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Path", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pThis, parameter_pPath);
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.viablePaths";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("This","path");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      setEvaluationHints(new QueryEvaluationHint(null, (IQueryBackendFactory)null));
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_This = body.getOrCreateVariableByName("This");
      		PVariable var_path = body.getOrCreateVariableByName("path");
      		PVariable var_connected1 = body.getOrCreateVariableByName("connected1");
      		PVariable var_connected2 = body.getOrCreateVariableByName("connected2");
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_This, parameter_pThis),
      		   new ExportedParameter(body, var_path, parameter_pPath)
      		));
      		// 	Segment(This)
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Segment")));
      		// 	Segment.connectedTo(This, connected1)
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Segment")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_This, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Segment", "connectedTo")));
      		new Equality(body, var__virtual_0_, var_connected1);
      		// 	Segment.connectedTo(This, connected2)
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Segment")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_This, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Segment", "connectedTo")));
      		new Equality(body, var__virtual_1_, var_connected2);
      		// 	connected1 != connected2
      		new Inequality(body, var_connected1, var_connected2);
      		// 		Path.via(path, This)
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_path, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "via")));
      		new Equality(body, var__virtual_2_, var_This);
      		// 	Path.from(path, connected1)
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_path, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "from")));
      		new Equality(body, var__virtual_3_, var_connected1);
      		// 	Path.to(path, connected2)
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new TypeConstraint(body, new FlatTuple(var_path, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "to")));
      		new Equality(body, var__virtual_4_, var_connected2);
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_This = body.getOrCreateVariableByName("This");
      		PVariable var_path = body.getOrCreateVariableByName("path");
      		PVariable var_top = body.getOrCreateVariableByName("top");
      		PVariable var_divergent = body.getOrCreateVariableByName("divergent");
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_This, parameter_pThis),
      		   new ExportedParameter(body, var_path, parameter_pPath)
      		));
      		// 	Turnout(This)
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		// 	Turnout.currentlyDivergent(This, true)
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new ConstantValue(body, var__virtual_0_, true);
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_This, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout", "currentlyDivergent")));
      		new Equality(body, var__virtual_1_, var__virtual_0_);
      		// 		Turnout.top(This, top)
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_This, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout", "top")));
      		new Equality(body, var__virtual_2_, var_top);
      		// 	Turnout.divergent(This, divergent)
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_This, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout", "divergent")));
      		new Equality(body, var__virtual_3_, var_divergent);
      		// 	Path.via(path, This)
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new TypeConstraint(body, new FlatTuple(var_path, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "via")));
      		new Equality(body, var__virtual_4_, var_This);
      		// 	Path.to(path, divergent)
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
      		new TypeConstraint(body, new FlatTuple(var_path, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "to")));
      		new Equality(body, var__virtual_5_, var_divergent);
      		// 	Path.from(path, top)
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		PVariable var__virtual_6_ = body.getOrCreateVariableByName(".virtual{6}");
      		new TypeConstraint(body, new FlatTuple(var_path, var__virtual_6_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "from")));
      		new Equality(body, var__virtual_6_, var_top);
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_This = body.getOrCreateVariableByName("This");
      		PVariable var_path = body.getOrCreateVariableByName("path");
      		PVariable var_top = body.getOrCreateVariableByName("top");
      		PVariable var_divergent = body.getOrCreateVariableByName("divergent");
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_This, parameter_pThis),
      		   new ExportedParameter(body, var_path, parameter_pPath)
      		));
      		// 	Turnout(This)
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		// 	Turnout.currentlyDivergent(This, true)
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new ConstantValue(body, var__virtual_0_, true);
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_This, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout", "currentlyDivergent")));
      		new Equality(body, var__virtual_1_, var__virtual_0_);
      		// 		Turnout.top(This, top)
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_This, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout", "top")));
      		new Equality(body, var__virtual_2_, var_top);
      		// 	Turnout.divergent(This, divergent)
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_This, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout", "divergent")));
      		new Equality(body, var__virtual_3_, var_divergent);
      		// 		Path.via(path, This)
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new TypeConstraint(body, new FlatTuple(var_path, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "via")));
      		new Equality(body, var__virtual_4_, var_This);
      		// 	Path.to(path, top)
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
      		new TypeConstraint(body, new FlatTuple(var_path, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "to")));
      		new Equality(body, var__virtual_5_, var_top);
      		// 	Path.from(path, divergent)
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		PVariable var__virtual_6_ = body.getOrCreateVariableByName(".virtual{6}");
      		new TypeConstraint(body, new FlatTuple(var_path, var__virtual_6_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "from")));
      		new Equality(body, var__virtual_6_, var_divergent);
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_This = body.getOrCreateVariableByName("This");
      		PVariable var_path = body.getOrCreateVariableByName("path");
      		PVariable var_top = body.getOrCreateVariableByName("top");
      		PVariable var_straight = body.getOrCreateVariableByName("straight");
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_This, parameter_pThis),
      		   new ExportedParameter(body, var_path, parameter_pPath)
      		));
      		// 	Turnout(This)
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		// 	Turnout.currentlyDivergent(This, false)
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new ConstantValue(body, var__virtual_0_, false);
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_This, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout", "currentlyDivergent")));
      		new Equality(body, var__virtual_1_, var__virtual_0_);
      		// 	Turnout.top(This, top)
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_This, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout", "top")));
      		new Equality(body, var__virtual_2_, var_top);
      		// 	Turnout.straight(This, straight)
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_This, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout", "straight")));
      		new Equality(body, var__virtual_3_, var_straight);
      		// 	Path.via(path, This)
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new TypeConstraint(body, new FlatTuple(var_path, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "via")));
      		new Equality(body, var__virtual_4_, var_This);
      		// 	Path.to(path, straight)
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
      		new TypeConstraint(body, new FlatTuple(var_path, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "to")));
      		new Equality(body, var__virtual_5_, var_straight);
      		// 	Path.from(path, top)
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		PVariable var__virtual_6_ = body.getOrCreateVariableByName(".virtual{6}");
      		new TypeConstraint(body, new FlatTuple(var_path, var__virtual_6_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "from")));
      		new Equality(body, var__virtual_6_, var_top);
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_This = body.getOrCreateVariableByName("This");
      		PVariable var_path = body.getOrCreateVariableByName("path");
      		PVariable var_top = body.getOrCreateVariableByName("top");
      		PVariable var_straight = body.getOrCreateVariableByName("straight");
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "RailRoadElement")));
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_This, parameter_pThis),
      		   new ExportedParameter(body, var_path, parameter_pPath)
      		));
      		// 	Turnout(This)
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		// 	Turnout.currentlyDivergent(This, false)
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new ConstantValue(body, var__virtual_0_, false);
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_This, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout", "currentlyDivergent")));
      		new Equality(body, var__virtual_1_, var__virtual_0_);
      		// 	Turnout.top(This, top)
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_This, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout", "top")));
      		new Equality(body, var__virtual_2_, var_top);
      		// 	Turnout.straight(This, straight)
      		new TypeConstraint(body, new FlatTuple(var_This), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_This, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout", "straight")));
      		new Equality(body, var__virtual_3_, var_straight);
      		// 	Path.via(path, This)
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new TypeConstraint(body, new FlatTuple(var_path, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "via")));
      		new Equality(body, var__virtual_4_, var_This);
      		// 	Path.to(path, top)
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
      		new TypeConstraint(body, new FlatTuple(var_path, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "to")));
      		new Equality(body, var__virtual_5_, var_top);
      		// 	Path.from(path, straight)
      		new TypeConstraint(body, new FlatTuple(var_path), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path")));
      		PVariable var__virtual_6_ = body.getOrCreateVariableByName(".virtual{6}");
      		new TypeConstraint(body, new FlatTuple(var_path, var__virtual_6_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Path", "from")));
      		new Equality(body, var__virtual_6_, var_straight);
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
  
  private static boolean evaluateExpression_2_1() {
    return true;
  }
  
  private static boolean evaluateExpression_3_1() {
    return true;
  }
  
  private static boolean evaluateExpression_4_1() {
    return false;
  }
  
  private static boolean evaluateExpression_5_1() {
    return false;
  }
}
