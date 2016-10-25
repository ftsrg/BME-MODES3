package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.mapping;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.RailRoadTest_Event;
import hu.bme.mit.inf.safetylogic.rulepatterns.RailRoadModelMatch;
import hu.bme.mit.inf.safetylogic.rulepatterns.RailRoadModelMatcher;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.cep.core.streams.EventStream;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.transformation.evm.specific.Lifecycles;
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum;
import org.eclipse.viatra.transformation.runtime.emf.rules.EventDrivenTransformationRuleGroup;
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRule;
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRuleFactory;
import org.eclipse.viatra.transformation.runtime.emf.transformation.eventdriven.EventDrivenTransformation;
import org.eclipse.viatra.transformation.runtime.emf.transformation.eventdriven.InconsistentEventSemanticsException;

@SuppressWarnings("all")
public class QueryEngine2ViatraCep {
  private EventStream eventStream;
  
  private ResourceSet resourceSet;
  
  private EventDrivenTransformation transformation;
  
  private QueryEngine2ViatraCep(final ResourceSet resourceSet, final EventStream eventStream) {
    this.resourceSet = resourceSet;
    this.eventStream = eventStream;
    registerRules();
  }
  
  public static QueryEngine2ViatraCep register(final ResourceSet resourceSet, final EventStream eventStream) {
    return new QueryEngine2ViatraCep(resourceSet, eventStream);
  }
  
  public EventDrivenTransformationRuleGroup getRules() {
    EventDrivenTransformationRuleGroup ruleGroup = new EventDrivenTransformationRuleGroup(
    	createrailRoadModel_MappingRule()
    );
    return ruleGroup;
  }
  
  private void registerRules() {
    try {
    	transformation = EventDrivenTransformation.forScope(new EMFScope(resourceSet)).addRules(getRules()).build();
    } catch (ViatraQueryException e) {
    	e.printStackTrace();
    }
  }
  
  public EventDrivenTransformationRule<RailRoadModelMatch, RailRoadModelMatcher> createrailRoadModel_MappingRule() {
    try{
      EventDrivenTransformationRuleFactory.EventDrivenTransformationRuleBuilder<RailRoadModelMatch, RailRoadModelMatcher> builder = new EventDrivenTransformationRuleFactory().createRule();
      builder.addLifeCycle(Lifecycles.getDefault(false, true));
      builder.precondition(RailRoadModelMatcher.querySpecification());
      
      IMatchProcessor<RailRoadModelMatch> actionOnAppear_0 = new IMatchProcessor<RailRoadModelMatch>() {
        public void process(final RailRoadModelMatch matchedPattern) {
          RailRoadTest_Event event = new RailRoadTest_Event(null);
          event.setQueryMatch(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(CRUDActivationStateEnum.CREATED, actionOnAppear_0);
      
      IMatchProcessor<RailRoadModelMatch> actionOnDisappear_0 = new IMatchProcessor<RailRoadModelMatch>() {
        public void process(final RailRoadModelMatch matchedPattern) {
        }
      };
      builder.action(CRUDActivationStateEnum.DELETED, actionOnDisappear_0);
      
      return builder.build();
    } catch (ViatraQueryException e) {
      e.printStackTrace();
    } catch (InconsistentEventSemanticsException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public void dispose() {
    this.transformation = null;
  }
}
