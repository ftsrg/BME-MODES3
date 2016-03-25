package hu.bme.mit.inf.safetylogic.patterns.util;

import com.google.common.collect.Sets;
import hu.bme.mit.inf.safetylogic.patterns.NextSectionFromSectionInClockwiseMatch;
import hu.bme.mit.inf.safetylogic.patterns.NextSectionFromSectionInClockwiseMatcher;
import hu.bme.mit.inf.safetylogic.patterns.util.TurnoutQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate NextSectionFromSectionInClockwiseMatcher in a type-safe way.
 * 
 * @see NextSectionFromSectionInClockwiseMatcher
 * @see NextSectionFromSectionInClockwiseMatch
 * 
 */
@SuppressWarnings("all")
public final class NextSectionFromSectionInClockwiseQuerySpecification extends BaseGeneratedEMFQuerySpecification<NextSectionFromSectionInClockwiseMatcher> {
  private NextSectionFromSectionInClockwiseQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static NextSectionFromSectionInClockwiseQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected NextSectionFromSectionInClockwiseMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return NextSectionFromSectionInClockwiseMatcher.on(engine);
  }
  
  @Override
  public NextSectionFromSectionInClockwiseMatch newEmptyMatch() {
    return NextSectionFromSectionInClockwiseMatch.newEmptyMatch();
  }
  
  @Override
  public NextSectionFromSectionInClockwiseMatch newMatch(final Object... parameters) {
    return NextSectionFromSectionInClockwiseMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) parameters[0], (hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static NextSectionFromSectionInClockwiseQuerySpecification INSTANCE = make();
    
    public static NextSectionFromSectionInClockwiseQuerySpecification make() {
      return new NextSectionFromSectionInClockwiseQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static NextSectionFromSectionInClockwiseQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.nextSectionFromSectionInClockwise";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("section","nextSection");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("section", "hu.bme.mit.inf.safetylogic.model.railroadmodel.Section"),new PParameter("nextSection", "hu.bme.mit.inf.safetylogic.model.railroadmodel.Section"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_section = body.getOrCreateVariableByName("section");
      		PVariable var_nextSection = body.getOrCreateVariableByName("nextSection");
      		new TypeConstraint(body, new FlatTuple(var_section), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		new TypeConstraint(body, new FlatTuple(var_nextSection), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_section, "section"),
      		   new ExportedParameter(body, var_nextSection, "nextSection")
      		));
      		// 	Section.clockwise(section, nextSection)
      		new TypeConstraint(body, new FlatTuple(var_section), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_section, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section", "clockwise")));
      		new Equality(body, var__virtual_0_, var_nextSection);
      		//  // if the next is not a turnout, we return it.	neg find turnout(nextSection)
      		new NegativePatternCall(body, new FlatTuple(var_nextSection), TurnoutQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_section = body.getOrCreateVariableByName("section");
      		PVariable var_nextSection = body.getOrCreateVariableByName("nextSection");
      		PVariable var_nextNonSection = body.getOrCreateVariableByName("nextNonSection");
      		new TypeConstraint(body, new FlatTuple(var_section), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		new TypeConstraint(body, new FlatTuple(var_nextSection), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_section, "section"),
      		   new ExportedParameter(body, var_nextSection, "nextSection")
      		));
      		// 	Section.clockwise(section, nextNonSection)
      		new TypeConstraint(body, new FlatTuple(var_section), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_section, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section", "clockwise")));
      		new Equality(body, var__virtual_0_, var_nextNonSection);
      		//  //if the next is a turnout, we recurse.	Turnout(nextNonSection)
      		new TypeConstraint(body, new FlatTuple(var_nextNonSection), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Turnout")));
      		//  //TODO generalize	find nextSectionFromSectionInClockwise(nextNonSection, nextSection)
      		new PositivePatternCall(body, new FlatTuple(var_nextNonSection, var_nextSection), this);
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
