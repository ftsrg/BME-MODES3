package hu.bme.mit.inf.ptregex2automaton.tests;

import EventAutomatonModel.Automaton;
import EventAutomatonModel.ComplexEventProcessor;
import EventAutomatonModel.Event;
import EventAutomatonModel.EventAutomatonModelFactory;
import EventAutomatonModel.State;
import EventAutomatonModel.SymbolicEvent;
import EventAutomatonModel.SymbolicInputEvent;
import com.google.common.base.Objects;
import hu.bme.mit.inf.qea.CEPExecutor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;

@SuppressWarnings("all")
public class TestExecutor {
  public final CEPExecutor exec;
  
  public final ComplexEventProcessor model;
  
  public TestExecutor(final ComplexEventProcessor input) {
    CEPExecutor _cEPExecutor = new CEPExecutor(input);
    this.exec = _cEPExecutor;
    this.model = input;
  }
  
  public void pushEvent(final Event e) {
    this.exec.pushEvent(e);
  }
  
  public void pushEvent(final String eventName) {
    try {
      final Event newEvent = EventAutomatonModelFactory.eINSTANCE.createEvent();
      EList<SymbolicInputEvent> _symbolicEvents = this.model.getSymbolicEvents();
      final Function1<SymbolicInputEvent, Boolean> _function = (SymbolicInputEvent it) -> {
        String _name = it.getName();
        return Boolean.valueOf(_name.equals(eventName));
      };
      SymbolicInputEvent _findFirst = IterableExtensions.<SymbolicInputEvent>findFirst(_symbolicEvents, _function);
      newEvent.setType(_findFirst);
      SymbolicEvent _type = newEvent.getType();
      boolean _equals = Objects.equal(_type, null);
      if (_equals) {
        throw new Exception(("There is no event named " + eventName));
      }
      this.pushEvent(newEvent);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean acceptedLastTime(final String name) {
    EList<Automaton> _automata = this.model.getAutomata();
    final Function1<Automaton, Boolean> _function = (Automaton it) -> {
      String _name = it.getName();
      return Boolean.valueOf(_name.equals(name));
    };
    final Automaton expression = IterableExtensions.<Automaton>findFirst(_automata, _function);
    boolean _equals = Objects.equal(expression, null);
    if (_equals) {
      Assert.fail(("There is no expression called " + name));
    }
    EList<State> _states = expression.getStates();
    final Function1<State, Boolean> _function_1 = (State it) -> {
      return Boolean.valueOf((it.isAcceptor() && (((Object[])Conversions.unwrapArray(it.getTokens(), Object.class)).length > 0)));
    };
    State _findFirst = IterableExtensions.<State>findFirst(_states, _function_1);
    return (!Objects.equal(_findFirst, null));
  }
}
