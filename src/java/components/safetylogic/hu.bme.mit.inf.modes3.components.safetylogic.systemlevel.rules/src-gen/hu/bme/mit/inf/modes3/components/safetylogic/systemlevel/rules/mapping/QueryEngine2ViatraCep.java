package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.mapping;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.MultipleTrainsOnStation_Event;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.NoMultipleTrainsOnStation_Event;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.NoTrainOnStation_Event;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.TrainLeftStation_Event;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.events.queryresult.TrainOnStation_Event;
import hu.bme.mit.inf.safetylogic.rulepatterns.MultipleTrainsOnStationMatch;
import hu.bme.mit.inf.safetylogic.rulepatterns.MultipleTrainsOnStationMatcher;
import hu.bme.mit.inf.safetylogic.rulepatterns.NoTrainOnStationMatch;
import hu.bme.mit.inf.safetylogic.rulepatterns.NoTrainOnStationMatcher;
import hu.bme.mit.inf.safetylogic.rulepatterns.TrainOnStationMatch;
import hu.bme.mit.inf.safetylogic.rulepatterns.TrainOnStationMatcher;
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
    	createnoTrainOnStation_MappingRule(), 
    	createmultipleTrainsOnStation_MappingRule(), 
    	createtrainOnStation_MappingRule()
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
  
  public EventDrivenTransformationRule<NoTrainOnStationMatch, NoTrainOnStationMatcher> createnoTrainOnStation_MappingRule() {
    try{
      EventDrivenTransformationRuleFactory.EventDrivenTransformationRuleBuilder<NoTrainOnStationMatch, NoTrainOnStationMatcher> builder = new EventDrivenTransformationRuleFactory().createRule();
      builder.addLifeCycle(Lifecycles.getDefault(false, true));
      builder.precondition(NoTrainOnStationMatcher.querySpecification());
      
      IMatchProcessor<NoTrainOnStationMatch> actionOnAppear_0 = new IMatchProcessor<NoTrainOnStationMatch>() {
        public void process(final NoTrainOnStationMatch matchedPattern) {
          NoTrainOnStation_Event event = new NoTrainOnStation_Event(null);
          event.setQueryMatch(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(CRUDActivationStateEnum.CREATED, actionOnAppear_0);
      
      IMatchProcessor<NoTrainOnStationMatch> actionOnDisappear_0 = new IMatchProcessor<NoTrainOnStationMatch>() {
        public void process(final NoTrainOnStationMatch matchedPattern) {
          NoMultipleTrainsOnStation_Event event = new NoMultipleTrainsOnStation_Event(null);
          event.setQueryMatch(matchedPattern);
          eventStream.push(event);
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
  
  public EventDrivenTransformationRule<MultipleTrainsOnStationMatch, MultipleTrainsOnStationMatcher> createmultipleTrainsOnStation_MappingRule() {
    try{
      EventDrivenTransformationRuleFactory.EventDrivenTransformationRuleBuilder<MultipleTrainsOnStationMatch, MultipleTrainsOnStationMatcher> builder = new EventDrivenTransformationRuleFactory().createRule();
      builder.addLifeCycle(Lifecycles.getDefault(false, true));
      builder.precondition(MultipleTrainsOnStationMatcher.querySpecification());
      
      IMatchProcessor<MultipleTrainsOnStationMatch> actionOnAppear_0 = new IMatchProcessor<MultipleTrainsOnStationMatch>() {
        public void process(final MultipleTrainsOnStationMatch matchedPattern) {
          MultipleTrainsOnStation_Event event = new MultipleTrainsOnStation_Event(null);
          event.setQueryMatch(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(CRUDActivationStateEnum.CREATED, actionOnAppear_0);
      
      IMatchProcessor<MultipleTrainsOnStationMatch> actionOnDisappear_0 = new IMatchProcessor<MultipleTrainsOnStationMatch>() {
        public void process(final MultipleTrainsOnStationMatch matchedPattern) {
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
  
  public EventDrivenTransformationRule<TrainOnStationMatch, TrainOnStationMatcher> createtrainOnStation_MappingRule() {
    try{
      EventDrivenTransformationRuleFactory.EventDrivenTransformationRuleBuilder<TrainOnStationMatch, TrainOnStationMatcher> builder = new EventDrivenTransformationRuleFactory().createRule();
      builder.addLifeCycle(Lifecycles.getDefault(false, true));
      builder.precondition(TrainOnStationMatcher.querySpecification());
      
      IMatchProcessor<TrainOnStationMatch> actionOnAppear_0 = new IMatchProcessor<TrainOnStationMatch>() {
        public void process(final TrainOnStationMatch matchedPattern) {
          TrainOnStation_Event event = new TrainOnStation_Event(null);
          event.setQueryMatch(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(CRUDActivationStateEnum.CREATED, actionOnAppear_0);
      
      IMatchProcessor<TrainOnStationMatch> actionOnDisappear_0 = new IMatchProcessor<TrainOnStationMatch>() {
        public void process(final TrainOnStationMatch matchedPattern) {
          TrainLeftStation_Event event = new TrainLeftStation_Event(null);
          event.setQueryMatch(matchedPattern);
          eventStream.push(event);
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
