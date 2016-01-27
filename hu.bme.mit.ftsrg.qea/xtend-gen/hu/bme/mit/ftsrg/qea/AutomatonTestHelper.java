package hu.bme.mit.ftsrg.qea;

import hu.bme.mit.ftsrg.qea.AutomatonExecutioner;
import hu.bme.mit.ftsrg.qea.model.Action;
import hu.bme.mit.ftsrg.qea.model.Automaton;
import hu.bme.mit.ftsrg.qea.model.ComplexEventProcessor;
import hu.bme.mit.ftsrg.qea.model.Event;
import hu.bme.mit.ftsrg.qea.model.EventGuard;
import hu.bme.mit.ftsrg.qea.model.ModelFactory;
import hu.bme.mit.ftsrg.qea.model.ResetTimerAction;
import hu.bme.mit.ftsrg.qea.model.SetTimerAction;
import hu.bme.mit.ftsrg.qea.model.State;
import hu.bme.mit.ftsrg.qea.model.SymbolicInputEvent;
import hu.bme.mit.ftsrg.qea.model.SymbolicTimeoutEvent;
import hu.bme.mit.ftsrg.qea.model.SymbolicTimer;
import hu.bme.mit.ftsrg.qea.model.Transition;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class AutomatonTestHelper {
  @Extension
  private static ModelFactory factory = ModelFactory.eINSTANCE;
  
  public static void test1() {
    try {
      ComplexEventProcessor cep = AutomatonTestHelper.factory.createComplexEventProcessor();
      Automaton automaton = AutomatonTestHelper.factory.createAutomaton();
      SymbolicInputEvent a = AutomatonTestHelper.factory.createSymbolicInputEvent();
      a.setName("a");
      SymbolicInputEvent b = AutomatonTestHelper.factory.createSymbolicInputEvent();
      b.setName("b");
      State s1 = AutomatonTestHelper.factory.createState();
      State s2 = AutomatonTestHelper.factory.createState();
      State s3 = AutomatonTestHelper.factory.createState();
      Transition t1 = AutomatonTestHelper.factory.createTransition();
      Transition t2 = AutomatonTestHelper.factory.createTransition();
      Transition ttimeout = AutomatonTestHelper.factory.createTransition();
      SymbolicTimer timer1 = AutomatonTestHelper.factory.createSymbolicTimer();
      SymbolicTimeoutEvent timeout1 = AutomatonTestHelper.factory.createSymbolicTimeoutEvent();
      timer1.setTimeoutEvent(timeout1);
      timer1.setName("timer1");
      EList<Automaton> _automata = cep.getAutomata();
      _automata.add(automaton);
      EList<SymbolicInputEvent> _symbolicEvents = cep.getSymbolicEvents();
      _symbolicEvents.add(a);
      EList<SymbolicInputEvent> _symbolicEvents_1 = cep.getSymbolicEvents();
      _symbolicEvents_1.add(b);
      EList<State> _states = automaton.getStates();
      _states.add(s1);
      EList<State> _states_1 = automaton.getStates();
      _states_1.add(s2);
      EList<State> _states_2 = automaton.getStates();
      _states_2.add(s3);
      t1.setFrom(s1);
      t1.setTo(s2);
      EventGuard t1guard = AutomatonTestHelper.factory.createEventGuard();
      t1guard.setType(a);
      t1.setEventguard(t1guard);
      SetTimerAction t1timer = AutomatonTestHelper.factory.createSetTimerAction();
      t1timer.setTimer(timer1);
      t1timer.setToValue(1000);
      EList<Action> _actions = t1.getActions();
      _actions.add(t1timer);
      t2.setFrom(s2);
      t2.setTo(s3);
      EventGuard t2guard = AutomatonTestHelper.factory.createEventGuard();
      t2guard.setType(b);
      t2.setEventguard(t2guard);
      ResetTimerAction t2timer = AutomatonTestHelper.factory.createResetTimerAction();
      t2timer.setTimer(timer1);
      EList<Action> _actions_1 = t2.getActions();
      _actions_1.add(t2timer);
      EventGuard ttimeoutguard = AutomatonTestHelper.factory.createEventGuard();
      ttimeoutguard.setType(timeout1);
      ttimeout.setEventguard(ttimeoutguard);
      ttimeout.setFrom(s2);
      ttimeout.setTo(s1);
      automaton.setInitialState(s1);
      s3.setAcceptor(true);
      Event eventA = AutomatonTestHelper.factory.createEvent();
      eventA.setType(a);
      Event eventB = AutomatonTestHelper.factory.createEvent();
      eventB.setType(b);
      AutomatonExecutioner exec = new AutomatonExecutioner(automaton);
      exec.pushEvent(eventA);
      Thread.sleep(2000);
      exec.pushEvent(eventB);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
