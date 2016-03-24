package hu.bme.mit.inf.safetylogic.patterns.util;

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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.BinaryTransitiveClosure;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

import com.google.common.collect.Sets;

import hu.bme.mit.inf.safetylogic.patterns.InSameRailroadPartMatch;
import hu.bme.mit.inf.safetylogic.patterns.InSameRailroadPartMatcher;

/**
 * A pattern-specific query specification that can instantiate InSameRailroadPartMatcher in a type-safe way.
 * 
 * @see InSameRailroadPartMatcher
 * @see InSameRailroadPartMatch
 * 
 */
@SuppressWarnings("all")
public final class InSameRailroadPartQuerySpecification extends BaseGeneratedEMFQuerySpecification<InSameRailroadPartMatcher> {
  private InSameRailroadPartQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static InSameRailroadPartQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected InSameRailroadPartMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return InSameRailroadPartMatcher.on(engine);
  }
  
  @Override
  public InSameRailroadPartMatch newEmptyMatch() {
    return InSameRailroadPartMatch.newEmptyMatch();
  }
  
  @Override
  public InSameRailroadPartMatch newMatch(final Object... parameters) {
    return InSameRailroadPartMatch.newMatch((hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) parameters[0], (hu.bme.mit.inf.safetylogic.model.railroadmodel.Section) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static InSameRailroadPartQuerySpecification INSTANCE = make();
    
    public static InSameRailroadPartQuerySpecification make() {
      return new InSameRailroadPartQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static InSameRailroadPartQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.inf.safetylogic.patterns.inSameRailroadPart";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("section","someSection");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("section", "hu.bme.mit.inf.safetylogic.model.railroadmodel.Section"),new PParameter("someSection", "hu.bme.mit.inf.safetylogic.model.railroadmodel.Section"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_section = body.getOrCreateVariableByName("section");
      		PVariable var_someSection = body.getOrCreateVariableByName("someSection");
      		new TypeConstraint(body, new FlatTuple(var_section), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		new TypeConstraint(body, new FlatTuple(var_someSection), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_section, "section"),
      		   new ExportedParameter(body, var_someSection, "someSection")
      		));
      		// 	find sectionNeighbor+(section, someSection)
      		new BinaryTransitiveClosure(body, new FlatTuple(var_section, var_someSection), SectionNeighborQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_section = body.getOrCreateVariableByName("section");
      		PVariable var_someSection = body.getOrCreateVariableByName("someSection");
      		new TypeConstraint(body, new FlatTuple(var_section), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		new TypeConstraint(body, new FlatTuple(var_someSection), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://hu.bme.mit.inf.safetylogic.railroadmodel", "Section")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_section, "section"),
      		   new ExportedParameter(body, var_someSection, "someSection")
      		));
      		// 	find soloSection(section)
      		new PositivePatternCall(body, new FlatTuple(var_section), SoloSectionQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	find soloSection(someSection)
      		new PositivePatternCall(body, new FlatTuple(var_someSection), SoloSectionQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	section == someSection
      		new Equality(body, var_section, var_someSection);
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
