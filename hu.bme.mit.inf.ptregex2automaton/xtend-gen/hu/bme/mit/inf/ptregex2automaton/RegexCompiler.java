package hu.bme.mit.inf.ptregex2automaton;

import EventAutomatonModel.AbstractTransition;
import EventAutomatonModel.Action;
import EventAutomatonModel.Automaton;
import EventAutomatonModel.ComplexEventProcessor;
import EventAutomatonModel.EpsilonTransition;
import EventAutomatonModel.EventAutomatonModelFactory;
import EventAutomatonModel.EventGuard;
import EventAutomatonModel.ResetTimerAction;
import EventAutomatonModel.SetTimerAction;
import EventAutomatonModel.State;
import EventAutomatonModel.SymbolicEvent;
import EventAutomatonModel.SymbolicInputEvent;
import EventAutomatonModel.SymbolicTimeoutEvent;
import EventAutomatonModel.SymbolicTimer;
import EventAutomatonModel.Transition;
import com.google.common.base.Objects;
import hu.bme.mit.inf.parametricTimedRegularExpression.Alphabet;
import hu.bme.mit.inf.parametricTimedRegularExpression.And;
import hu.bme.mit.inf.parametricTimedRegularExpression.Any;
import hu.bme.mit.inf.parametricTimedRegularExpression.Choice;
import hu.bme.mit.inf.parametricTimedRegularExpression.Event;
import hu.bme.mit.inf.parametricTimedRegularExpression.Expression;
import hu.bme.mit.inf.parametricTimedRegularExpression.ExpressionDeclaration;
import hu.bme.mit.inf.parametricTimedRegularExpression.Functor;
import hu.bme.mit.inf.parametricTimedRegularExpression.Inverse;
import hu.bme.mit.inf.parametricTimedRegularExpression.RegexModel;
import hu.bme.mit.inf.parametricTimedRegularExpression.Sequence;
import hu.bme.mit.inf.parametricTimedRegularExpression.Star;
import hu.bme.mit.inf.parametricTimedRegularExpression.TimedExpression;
import hu.bme.mit.inf.ptregex2automaton.PartialAutomaton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;

@SuppressWarnings("all")
public class RegexCompiler {
  @Extension
  private static EventAutomatonModelFactory factory = EventAutomatonModelFactory.eINSTANCE;
  
  private final ArrayList<SymbolicInputEvent> symbolicEvents = new ArrayList<SymbolicInputEvent>();
  
  private final HashMap<Functor, SymbolicEvent> symbolicEventMapping = new HashMap<Functor, SymbolicEvent>();
  
  private final Set<Transition> transitionsToTrapState = new HashSet<Transition>();
  
  private int timerCnt = 0;
  
  public ComplexEventProcessor compile(final RegexModel input) {
    ComplexEventProcessor _xblockexpression = null;
    {
      InputOutput.<String>println("Compilation starts");
      final ComplexEventProcessor retvalue = RegexCompiler.factory.createComplexEventProcessor();
      Alphabet _alphabet = input.getAlphabet();
      this.symbolicEventsFromAlphabet(_alphabet);
      EList<ExpressionDeclaration> _declarations = input.getDeclarations();
      final Function1<ExpressionDeclaration, Automaton> _function = (ExpressionDeclaration it) -> {
        PartialAutomaton _recursiveCompile = this.recursiveCompile(it);
        return _recursiveCompile.toAutomaton();
      };
      List<Automaton> _map = ListExtensions.<ExpressionDeclaration, Automaton>map(_declarations, _function);
      final Consumer<Automaton> _function_1 = (Automaton it) -> {
        EList<Automaton> _automata = retvalue.getAutomata();
        _automata.add(it);
      };
      _map.forEach(_function_1);
      final Consumer<SymbolicInputEvent> _function_2 = (SymbolicInputEvent it) -> {
        EList<SymbolicInputEvent> _symbolicEvents = retvalue.getSymbolicEvents();
        _symbolicEvents.add(it);
      };
      this.symbolicEvents.forEach(_function_2);
      EList<Automaton> _automata = retvalue.getAutomata();
      final Consumer<Automaton> _function_3 = (Automaton it) -> {
        State trapState = RegexCompiler.factory.createState();
        EList<State> _states = it.getStates();
        _states.add(trapState);
        it.setTrapState(trapState);
      };
      _automata.forEach(_function_3);
      EList<Automaton> _automata_1 = retvalue.getAutomata();
      final Consumer<Automaton> _function_4 = (Automaton automaton) -> {
        EList<State> _states = automaton.getStates();
        final Consumer<State> _function_5 = (State state) -> {
          final Consumer<Transition> _function_6 = (Transition it) -> {
            State _from = it.getFrom();
            boolean _equals = Objects.equal(_from, state);
            if (_equals) {
              State _trapState = automaton.getTrapState();
              it.setTo(_trapState);
            }
          };
          this.transitionsToTrapState.forEach(_function_6);
        };
        _states.forEach(_function_5);
      };
      _automata_1.forEach(_function_4);
      int id = 0;
      EList<Automaton> _automata_2 = retvalue.getAutomata();
      for (final Automaton automaton : _automata_2) {
        EList<State> _states = automaton.getStates();
        for (final State state : _states) {
          int _plusPlus = id++;
          state.setId(_plusPlus);
        }
      }
      InputOutput.<String>println("Compilation finished!");
      EList<Automaton> _automata_3 = retvalue.getAutomata();
      for (final Automaton automaton_1 : _automata_3) {
        String _automatonToYed = RegexCompiler.automatonToYed(automaton_1);
        InputOutput.<String>println(_automatonToYed);
      }
      _xblockexpression = retvalue;
    }
    return _xblockexpression;
  }
  
  public static String automatonToYed(final Automaton automaton) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Automaton ");
    String _name = automaton.getName();
    _builder.append(_name, "");
    _builder.newLineIfNotEmpty();
    _builder.append("=========================");
    _builder.newLine();
    _builder.newLine();
    {
      EList<State> _states = automaton.getStates();
      for(final State state : _states) {
        int _id = state.getId();
        _builder.append(_id, "");
        _builder.append(" ");
        int _id_1 = state.getId();
        _builder.append(_id_1, "");
        _builder.append(" ");
        {
          boolean _isAcceptor = state.isAcceptor();
          boolean _equals = (_isAcceptor == true);
          if (_equals) {
            _builder.append(" acceptor");
          } else {
            State _trapState = automaton.getTrapState();
            boolean _equals_1 = Objects.equal(_trapState, state);
            if (_equals_1) {
              _builder.append(" trap");
            } else {
              State _initialState = automaton.getInitialState();
              boolean _equals_2 = Objects.equal(_initialState, state);
              if (_equals_2) {
                _builder.append(" initial");
              }
            }
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("#");
    _builder.newLine();
    {
      EList<State> _states_1 = automaton.getStates();
      for(final State state_1 : _states_1) {
        {
          EList<AbstractTransition> _outgoingTransitions = state_1.getOutgoingTransitions();
          for(final AbstractTransition transition : _outgoingTransitions) {
            State _from = transition.getFrom();
            int _id_2 = _from.getId();
            _builder.append(_id_2, "");
            _builder.append(" ");
            State _to = transition.getTo();
            int _id_3 = _to.getId();
            _builder.append(_id_3, "");
            {
              if ((transition instanceof EpsilonTransition)) {
                _builder.append(" ε ");
              }
            }
            {
              if ((transition instanceof Transition)) {
                {
                  EventGuard _eventguard = ((Transition)transition).getEventguard();
                  SymbolicEvent _type = _eventguard.getType();
                  if ((_type instanceof SymbolicInputEvent)) {
                    _builder.append(" ");
                    EventGuard _eventguard_1 = ((Transition)transition).getEventguard();
                    SymbolicEvent _type_1 = _eventguard_1.getType();
                    String _name_1 = ((SymbolicInputEvent) _type_1).getName();
                    _builder.append(_name_1, "");
                  }
                }
                {
                  EventGuard _eventguard_2 = ((Transition)transition).getEventguard();
                  SymbolicEvent _type_2 = _eventguard_2.getType();
                  if ((_type_2 instanceof SymbolicTimeoutEvent)) {
                    _builder.append(" ");
                    EventGuard _eventguard_3 = ((Transition)transition).getEventguard();
                    SymbolicEvent _type_3 = _eventguard_3.getType();
                    SymbolicTimer _timer = ((SymbolicTimeoutEvent) _type_3).getTimer();
                    String _name_2 = _timer.getName();
                    _builder.append(_name_2, "");
                    _builder.append(" timeout");
                  }
                }
              }
            }
            _builder.append(" ");
            {
              EList<Action> _actions = transition.getActions();
              boolean _hasElements = false;
              for(final Action action : _actions) {
                if (!_hasElements) {
                  _hasElements = true;
                  _builder.append(" actions = [ ", "");
                } else {
                  _builder.appendImmediate(", ", "");
                }
                _builder.append(" ");
                {
                  if ((action instanceof SetTimerAction)) {
                    _builder.append(" set ");
                    SymbolicTimer _timer_1 = ((SetTimerAction)action).getTimer();
                    String _name_3 = _timer_1.getName();
                    _builder.append(_name_3, "");
                  }
                }
                {
                  if ((action instanceof ResetTimerAction)) {
                    _builder.append(" reset ");
                    SymbolicTimer _timer_2 = ((ResetTimerAction)action).getTimer();
                    String _name_4 = _timer_2.getName();
                    _builder.append(_name_4, "");
                  }
                }
              }
              if (_hasElements) {
                _builder.append(" ]", "");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("=========================");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected void symbolicEventsFromAlphabet(final Alphabet alphabet) {
    EList<Functor> _functors = alphabet.getFunctors();
    for (final Functor letter : _functors) {
      {
        SymbolicInputEvent newSymbolicEvent = RegexCompiler.factory.createSymbolicInputEvent();
        String _name = letter.getName();
        newSymbolicEvent.setName(_name);
        this.symbolicEvents.add(newSymbolicEvent);
        this.symbolicEventMapping.put(letter, newSymbolicEvent);
      }
    }
  }
  
  protected PartialAutomaton _recursiveCompile(final ExpressionDeclaration declaration) {
    PartialAutomaton _xblockexpression = null;
    {
      String _name = declaration.getName();
      String _plus = ("compiling " + _name);
      InputOutput.<String>println(_plus);
      Expression _body = declaration.getBody();
      PartialAutomaton compiled = this.recursiveCompile(_body);
      String _name_1 = declaration.getName();
      compiled.a.setName(_name_1);
      String _name_2 = declaration.getName();
      String _plus_1 = (_name_2 + " compiled");
      InputOutput.<String>println(_plus_1);
      _xblockexpression = compiled;
    }
    return _xblockexpression;
  }
  
  protected PartialAutomaton _recursiveCompile(final TimedExpression expression) {
    PartialAutomaton _xblockexpression = null;
    {
      Expression _body = expression.getBody();
      final PartialAutomaton compiled = this.recursiveCompile(_body);
      final SymbolicTimer timer = RegexCompiler.factory.createSymbolicTimer();
      int _plusPlus = this.timerCnt++;
      String _plus = ("t" + Integer.valueOf(_plusPlus));
      timer.setName(_plus);
      final SymbolicTimeoutEvent timeoutEvent = RegexCompiler.factory.createSymbolicTimeoutEvent();
      timer.setTimeoutEvent(timeoutEvent);
      EList<AbstractTransition> _outgoingTransitions = compiled.first.getOutgoingTransitions();
      final Consumer<AbstractTransition> _function = (AbstractTransition it) -> {
        SetTimerAction newAction = RegexCompiler.factory.createSetTimerAction();
        newAction.setTimer(timer);
        int _timeout = expression.getTimeout();
        newAction.setToValue(_timeout);
        EList<Action> _actions = it.getActions();
        _actions.add(newAction);
      };
      _outgoingTransitions.forEach(_function);
      EList<AbstractTransition> _incomingTransitions = compiled.last.getIncomingTransitions();
      final Consumer<AbstractTransition> _function_1 = (AbstractTransition it) -> {
        ResetTimerAction newAction = RegexCompiler.factory.createResetTimerAction();
        newAction.setTimer(timer);
        EList<Action> _actions = it.getActions();
        _actions.add(newAction);
      };
      _incomingTransitions.forEach(_function_1);
      EList<State> _states = compiled.a.getStates();
      final Function1<State, Boolean> _function_2 = (State it) -> {
        boolean _and = false;
        boolean _notEquals = (!Objects.equal(it, compiled.first));
        if (!_notEquals) {
          _and = false;
        } else {
          boolean _notEquals_1 = (!Objects.equal(it, compiled.last));
          _and = _notEquals_1;
        }
        return Boolean.valueOf(_and);
      };
      Iterable<State> _filter = IterableExtensions.<State>filter(_states, _function_2);
      final Consumer<State> _function_3 = (State it) -> {
        final Transition newTrans = RegexCompiler.factory.createTransition();
        newTrans.setFrom(it);
        newTrans.setTo(compiled.first);
        this.transitionsToTrapState.add(newTrans);
        final EventGuard newEventGuard = RegexCompiler.factory.createEventGuard();
        newEventGuard.setType(timeoutEvent);
        newTrans.setEventguard(newEventGuard);
      };
      _filter.forEach(_function_3);
      _xblockexpression = compiled;
    }
    return _xblockexpression;
  }
  
  protected PartialAutomaton _recursiveCompile(final Any expression) {
    PartialAutomaton _xblockexpression = null;
    {
      PartialAutomaton retvalue = new PartialAutomaton();
      State _createState = RegexCompiler.factory.createState();
      retvalue.first = _createState;
      State _createState_1 = RegexCompiler.factory.createState();
      retvalue.last = _createState_1;
      EList<State> _states = retvalue.a.getStates();
      _states.add(retvalue.first);
      EList<State> _states_1 = retvalue.a.getStates();
      _states_1.add(retvalue.last);
      for (final SymbolicInputEvent symbol : this.symbolicEvents) {
        {
          Transition newTransition = RegexCompiler.factory.createTransition();
          EventGuard _createEventGuard = RegexCompiler.factory.createEventGuard();
          newTransition.setEventguard(_createEventGuard);
          EventGuard _eventguard = newTransition.getEventguard();
          _eventguard.setType(symbol);
          newTransition.setFrom(retvalue.first);
          newTransition.setTo(retvalue.last);
        }
      }
      _xblockexpression = retvalue;
    }
    return _xblockexpression;
  }
  
  protected PartialAutomaton _recursiveCompile(final Inverse expression) {
    PartialAutomaton _xblockexpression = null;
    {
      PartialAutomaton retvalue = new PartialAutomaton();
      State _createState = RegexCompiler.factory.createState();
      retvalue.first = _createState;
      State _createState_1 = RegexCompiler.factory.createState();
      retvalue.last = _createState_1;
      EList<State> _states = retvalue.a.getStates();
      _states.add(retvalue.first);
      EList<State> _states_1 = retvalue.a.getStates();
      _states_1.add(retvalue.last);
      EList<Event> _excludes = expression.getExcludes();
      final Function1<Event, Functor> _function = (Event it) -> {
        return it.getFunctor();
      };
      final List<Functor> excludedLetters = ListExtensions.<Event, Functor>map(_excludes, _function);
      ArrayList<Functor> includedLetters = new ArrayList<Functor>();
      Set<Functor> _keySet = this.symbolicEventMapping.keySet();
      for (final Functor possibleLetter : _keySet) {
        boolean _contains = excludedLetters.contains(possibleLetter);
        boolean _not = (!_contains);
        if (_not) {
          includedLetters.add(possibleLetter);
        }
      }
      ArrayList<SymbolicEvent> includedSymbols = new ArrayList<SymbolicEvent>();
      for (final Functor letter : includedLetters) {
        SymbolicEvent _get = this.symbolicEventMapping.get(letter);
        includedSymbols.add(_get);
      }
      for (final SymbolicEvent symbol : includedSymbols) {
        {
          Transition newTransition = RegexCompiler.factory.createTransition();
          EventGuard _createEventGuard = RegexCompiler.factory.createEventGuard();
          newTransition.setEventguard(_createEventGuard);
          EventGuard _eventguard = newTransition.getEventguard();
          _eventguard.setType(symbol);
          newTransition.setFrom(retvalue.first);
          newTransition.setTo(retvalue.last);
        }
      }
      _xblockexpression = retvalue;
    }
    return _xblockexpression;
  }
  
  protected PartialAutomaton _recursiveCompile(final Event expression) {
    PartialAutomaton _xblockexpression = null;
    {
      PartialAutomaton retvalue = new PartialAutomaton();
      State _createState = RegexCompiler.factory.createState();
      retvalue.first = _createState;
      State _createState_1 = RegexCompiler.factory.createState();
      retvalue.last = _createState_1;
      EList<State> _states = retvalue.a.getStates();
      _states.add(retvalue.first);
      EList<State> _states_1 = retvalue.a.getStates();
      _states_1.add(retvalue.last);
      Transition transition = RegexCompiler.factory.createTransition();
      transition.setFrom(retvalue.first);
      transition.setTo(retvalue.last);
      EventGuard _createEventGuard = RegexCompiler.factory.createEventGuard();
      transition.setEventguard(_createEventGuard);
      EventGuard _eventguard = transition.getEventguard();
      Functor _functor = expression.getFunctor();
      SymbolicEvent _get = this.symbolicEventMapping.get(_functor);
      _eventguard.setType(_get);
      _xblockexpression = retvalue;
    }
    return _xblockexpression;
  }
  
  protected PartialAutomaton _recursiveCompile(final Sequence expression) {
    PartialAutomaton _xblockexpression = null;
    {
      EList<Expression> _elements = expression.getElements();
      final Function1<Expression, PartialAutomaton> _function = (Expression it) -> {
        return this.recursiveCompile(it);
      };
      List<PartialAutomaton> compiledExpressions = ListExtensions.<Expression, PartialAutomaton>map(_elements, _function);
      Iterable<PartialAutomaton> _tail = IterableExtensions.<PartialAutomaton>tail(compiledExpressions);
      PartialAutomaton _head = IterableExtensions.<PartialAutomaton>head(compiledExpressions);
      final Function2<PartialAutomaton, PartialAutomaton, PartialAutomaton> _function_1 = (PartialAutomaton i, PartialAutomaton j) -> {
        return this.merge(i, j);
      };
      _xblockexpression = IterableExtensions.<PartialAutomaton, PartialAutomaton>fold(_tail, _head, _function_1);
    }
    return _xblockexpression;
  }
  
  protected PartialAutomaton merge(final PartialAutomaton firstAutomaton, final PartialAutomaton secondAutomaton) {
    EList<AbstractTransition> _outgoingTransitions = secondAutomaton.first.getOutgoingTransitions();
    List<AbstractTransition> outgoingFirst = (List<AbstractTransition>)Conversions.doWrapArray(((AbstractTransition[])Conversions.unwrapArray(_outgoingTransitions, AbstractTransition.class)).clone());
    EList<AbstractTransition> _incomingTransitions = secondAutomaton.first.getIncomingTransitions();
    List<AbstractTransition> incomingFirst = (List<AbstractTransition>)Conversions.doWrapArray(((AbstractTransition[])Conversions.unwrapArray(_incomingTransitions, AbstractTransition.class)).clone());
    EList<State> _states = secondAutomaton.a.getStates();
    List<State> secondStates = (List<State>)Conversions.doWrapArray(((State[])Conversions.unwrapArray(_states, State.class)).clone());
    for (final State state : secondStates) {
      {
        EList<State> _states_1 = firstAutomaton.a.getStates();
        _states_1.add(state);
        EList<State> _states_2 = secondAutomaton.a.getStates();
        _states_2.remove(state);
      }
    }
    for (final AbstractTransition transition : outgoingFirst) {
      EList<AbstractTransition> _outgoingTransitions_1 = firstAutomaton.last.getOutgoingTransitions();
      _outgoingTransitions_1.add(transition);
    }
    for (final AbstractTransition transition_1 : incomingFirst) {
      EList<AbstractTransition> _incomingTransitions_1 = firstAutomaton.last.getIncomingTransitions();
      _incomingTransitions_1.add(transition_1);
    }
    EList<State> _states_1 = firstAutomaton.a.getStates();
    _states_1.remove(secondAutomaton.first);
    firstAutomaton.last = secondAutomaton.last;
    return firstAutomaton;
  }
  
  protected PartialAutomaton _recursiveCompile(final Choice expression) {
    EList<Expression> _elements = expression.getElements();
    Expression _head = IterableExtensions.<Expression>head(_elements);
    PartialAutomaton first = this.recursiveCompile(_head);
    State newFirst = RegexCompiler.factory.createState();
    State newLast = RegexCompiler.factory.createState();
    EList<State> _states = first.a.getStates();
    _states.add(newFirst);
    EList<State> _states_1 = first.a.getStates();
    _states_1.add(newLast);
    EpsilonTransition newTransBegin = RegexCompiler.factory.createEpsilonTransition();
    EpsilonTransition newTransEnd = RegexCompiler.factory.createEpsilonTransition();
    newTransBegin.setFrom(newFirst);
    newTransBegin.setTo(first.first);
    newTransEnd.setFrom(first.last);
    newTransEnd.setTo(newLast);
    first.first = newFirst;
    first.last = newLast;
    EList<Expression> _elements_1 = expression.getElements();
    Iterable<Expression> _tail = IterableExtensions.<Expression>tail(_elements_1);
    for (final Expression expr : _tail) {
      {
        PartialAutomaton compiled = this.recursiveCompile(expr);
        EpsilonTransition beginTrans = RegexCompiler.factory.createEpsilonTransition();
        EpsilonTransition endTrans = RegexCompiler.factory.createEpsilonTransition();
        EList<State> _states_2 = compiled.a.getStates();
        State[] states = ((State[])Conversions.unwrapArray(_states_2, State.class)).clone();
        for (final State state : states) {
          {
            EList<State> _states_3 = first.a.getStates();
            _states_3.add(state);
            EList<State> _states_4 = compiled.a.getStates();
            _states_4.remove(state);
          }
        }
        beginTrans.setFrom(first.first);
        beginTrans.setTo(compiled.first);
        endTrans.setFrom(compiled.last);
        endTrans.setTo(first.last);
      }
    }
    return first;
  }
  
  protected PartialAutomaton _recursiveCompile(final Star expression) {
    PartialAutomaton _xblockexpression = null;
    {
      Expression _body = expression.getBody();
      PartialAutomaton compiledAutomaton = this.recursiveCompile(_body);
      State first = RegexCompiler.factory.createState();
      State last = RegexCompiler.factory.createState();
      EList<State> _states = compiledAutomaton.a.getStates();
      _states.add(first);
      EList<State> _states_1 = compiledAutomaton.a.getStates();
      _states_1.add(last);
      EpsilonTransition beginEpsilon = RegexCompiler.factory.createEpsilonTransition();
      EpsilonTransition endEpsilon = RegexCompiler.factory.createEpsilonTransition();
      EpsilonTransition returnEpsilon = RegexCompiler.factory.createEpsilonTransition();
      EpsilonTransition skipEpsilon = RegexCompiler.factory.createEpsilonTransition();
      beginEpsilon.setFrom(first);
      beginEpsilon.setTo(compiledAutomaton.first);
      returnEpsilon.setFrom(compiledAutomaton.last);
      returnEpsilon.setTo(compiledAutomaton.first);
      endEpsilon.setFrom(compiledAutomaton.last);
      endEpsilon.setTo(last);
      skipEpsilon.setFrom(first);
      skipEpsilon.setTo(last);
      compiledAutomaton.first = first;
      compiledAutomaton.last = last;
      _xblockexpression = compiledAutomaton;
    }
    return _xblockexpression;
  }
  
  protected PartialAutomaton _recursiveCompile(final And expression) {
    PartialAutomaton _xblockexpression = null;
    {
      EList<Expression> _elements = expression.getElements();
      final Function1<Expression, PartialAutomaton> _function = (Expression it) -> {
        return this.recursiveCompile(it);
      };
      List<PartialAutomaton> compiledExpressions = ListExtensions.<Expression, PartialAutomaton>map(_elements, _function);
      Iterable<PartialAutomaton> _tail = IterableExtensions.<PartialAutomaton>tail(compiledExpressions);
      PartialAutomaton _head = IterableExtensions.<PartialAutomaton>head(compiledExpressions);
      final Function2<PartialAutomaton, PartialAutomaton, PartialAutomaton> _function_1 = (PartialAutomaton i, PartialAutomaton j) -> {
        return this.product(i, j);
      };
      _xblockexpression = IterableExtensions.<PartialAutomaton, PartialAutomaton>fold(_tail, _head, _function_1);
    }
    return _xblockexpression;
  }
  
  protected PartialAutomaton product(final PartialAutomaton left, final PartialAutomaton right) {
    final PartialAutomaton retvalue = new PartialAutomaton();
    final HashMap<State, HashSet<State>> leftTrace = new HashMap<State, HashSet<State>>();
    final HashMap<State, HashSet<State>> rightTrace = new HashMap<State, HashSet<State>>();
    EList<State> _states = left.a.getStates();
    for (final State leftState : _states) {
      EList<State> _states_1 = right.a.getStates();
      for (final State rightState : _states_1) {
        {
          State newState = RegexCompiler.factory.createState();
          boolean _containsKey = leftTrace.containsKey(leftState);
          boolean _not = (!_containsKey);
          if (_not) {
            HashSet<State> _hashSet = new HashSet<State>();
            leftTrace.put(leftState, _hashSet);
          }
          boolean _containsKey_1 = rightTrace.containsKey(rightState);
          boolean _not_1 = (!_containsKey_1);
          if (_not_1) {
            HashSet<State> _hashSet_1 = new HashSet<State>();
            rightTrace.put(rightState, _hashSet_1);
          }
          EList<State> _states_2 = retvalue.a.getStates();
          _states_2.add(newState);
          HashSet<State> _get = leftTrace.get(leftState);
          _get.add(newState);
          HashSet<State> _get_1 = rightTrace.get(rightState);
          _get_1.add(newState);
        }
      }
    }
    EList<State> _states_2 = retvalue.a.getStates();
    for (final State state : _states_2) {
      {
        final Function2<State, HashSet<State>, Boolean> _function = (State oldState, HashSet<State> newStates) -> {
          return Boolean.valueOf(newStates.contains(state));
        };
        Map<State, HashSet<State>> _filter = MapExtensions.<State, HashSet<State>>filter(leftTrace, _function);
        Set<State> _keySet = _filter.keySet();
        final State leftOriginal = IterableExtensions.<State>head(_keySet);
        final Function2<State, HashSet<State>, Boolean> _function_1 = (State oldState, HashSet<State> newStates) -> {
          return Boolean.valueOf(newStates.contains(state));
        };
        Map<State, HashSet<State>> _filter_1 = MapExtensions.<State, HashSet<State>>filter(rightTrace, _function_1);
        Set<State> _keySet_1 = _filter_1.keySet();
        final State rightOriginal = IterableExtensions.<State>head(_keySet_1);
        EList<AbstractTransition> _outgoingTransitions = rightOriginal.getOutgoingTransitions();
        final Consumer<AbstractTransition> _function_2 = (AbstractTransition transition) -> {
          AbstractTransition cloneTransition = EcoreUtil.<AbstractTransition>copy(transition);
          cloneTransition.setFrom(state);
          HashSet<State> _get = leftTrace.get(leftOriginal);
          final Function1<State, Boolean> _function_3 = (State it) -> {
            State _to = transition.getTo();
            HashSet<State> _get_1 = rightTrace.get(_to);
            return Boolean.valueOf(_get_1.contains(it));
          };
          Iterable<State> _filter_2 = IterableExtensions.<State>filter(_get, _function_3);
          State _head = IterableExtensions.<State>head(_filter_2);
          cloneTransition.setTo(_head);
        };
        _outgoingTransitions.forEach(_function_2);
        EList<AbstractTransition> _outgoingTransitions_1 = leftOriginal.getOutgoingTransitions();
        final Consumer<AbstractTransition> _function_3 = (AbstractTransition transition) -> {
          AbstractTransition cloneTransition = EcoreUtil.<AbstractTransition>copy(transition);
          cloneTransition.setFrom(state);
          HashSet<State> _get = rightTrace.get(rightOriginal);
          final Function1<State, Boolean> _function_4 = (State it) -> {
            State _to = transition.getTo();
            HashSet<State> _get_1 = leftTrace.get(_to);
            return Boolean.valueOf(_get_1.contains(it));
          };
          Iterable<State> _filter_2 = IterableExtensions.<State>filter(_get, _function_4);
          State _head = IterableExtensions.<State>head(_filter_2);
          cloneTransition.setTo(_head);
        };
        _outgoingTransitions_1.forEach(_function_3);
      }
    }
    EList<State> _states_3 = retvalue.a.getStates();
    final Function1<State, Boolean> _function = (State it) -> {
      boolean _and = false;
      HashSet<State> _get = leftTrace.get(left.first);
      boolean _contains = _get.contains(it);
      if (!_contains) {
        _and = false;
      } else {
        HashSet<State> _get_1 = rightTrace.get(right.first);
        boolean _contains_1 = _get_1.contains(it);
        _and = _contains_1;
      }
      return Boolean.valueOf(_and);
    };
    Iterable<State> _filter = IterableExtensions.<State>filter(_states_3, _function);
    State _head = IterableExtensions.<State>head(_filter);
    retvalue.first = _head;
    EList<State> _states_4 = retvalue.a.getStates();
    final Function1<State, Boolean> _function_1 = (State it) -> {
      boolean _and = false;
      HashSet<State> _get = leftTrace.get(left.last);
      boolean _contains = _get.contains(it);
      if (!_contains) {
        _and = false;
      } else {
        HashSet<State> _get_1 = rightTrace.get(right.last);
        boolean _contains_1 = _get_1.contains(it);
        _and = _contains_1;
      }
      return Boolean.valueOf(_and);
    };
    Iterable<State> _filter_1 = IterableExtensions.<State>filter(_states_4, _function_1);
    State _head_1 = IterableExtensions.<State>head(_filter_1);
    retvalue.last = _head_1;
    return retvalue;
  }
  
  public static HashSet<State> epsilonClosure(final State s) {
    HashSet<State> _xblockexpression = null;
    {
      ArrayList<State> list = new ArrayList<State>();
      list.add(s);
      _xblockexpression = RegexCompiler.epsilonClosure(list);
    }
    return _xblockexpression;
  }
  
  public static HashSet<State> epsilonClosure(final Iterable<State> input) {
    Stack<State> stack = new Stack<State>();
    HashSet<State> res = new HashSet<State>();
    for (final State state : input) {
      {
        stack.push(state);
        res.add(state);
      }
    }
    while ((!stack.isEmpty())) {
      {
        State t = stack.pop();
        EList<AbstractTransition> _outgoingTransitions = t.getOutgoingTransitions();
        final Function1<AbstractTransition, Boolean> _function = (AbstractTransition it) -> {
          return Boolean.valueOf((it instanceof EpsilonTransition));
        };
        Iterable<AbstractTransition> _filter = IterableExtensions.<AbstractTransition>filter(_outgoingTransitions, _function);
        final Function1<AbstractTransition, State> _function_1 = (AbstractTransition it) -> {
          return it.getTo();
        };
        Iterable<State> _map = IterableExtensions.<AbstractTransition, State>map(_filter, _function_1);
        for (final State u : _map) {
          boolean _contains = res.contains(u);
          boolean _not = (!_contains);
          if (_not) {
            res.add(u);
            stack.push(u);
          }
        }
      }
    }
    return res;
  }
  
  protected HashSet<State> move(final Iterable<State> T, final SymbolicEvent a) {
    HashSet<State> res = new HashSet<State>();
    for (final State state : T) {
      {
        EList<AbstractTransition> _outgoingTransitions = state.getOutgoingTransitions();
        final Function1<AbstractTransition, Boolean> _function = (AbstractTransition it) -> {
          return Boolean.valueOf((!(it instanceof EpsilonTransition)));
        };
        Iterable<AbstractTransition> _filter = IterableExtensions.<AbstractTransition>filter(_outgoingTransitions, _function);
        final Function1<AbstractTransition, Boolean> _function_1 = (AbstractTransition it) -> {
          EventGuard _eventguard = ((Transition) it).getEventguard();
          SymbolicEvent _type = _eventguard.getType();
          return Boolean.valueOf(Objects.equal(_type, a));
        };
        Iterable<AbstractTransition> _filter_1 = IterableExtensions.<AbstractTransition>filter(_filter, _function_1);
        AbstractTransition outGoingOnA = IterableExtensions.<AbstractTransition>head(_filter_1);
        boolean _notEquals = (!Objects.equal(outGoingOnA, null));
        if (_notEquals) {
          State _to = outGoingOnA.getTo();
          res.add(_to);
        }
      }
    }
    return res;
  }
  
  protected boolean sameDFAState(final Set<State> state1, final Set<State> state2) {
    for (final State state : state1) {
      boolean _contains = state2.contains(state);
      boolean _not = (!_contains);
      if (_not) {
        return false;
      }
    }
    for (final State state_1 : state2) {
      boolean _contains_1 = state1.contains(state_1);
      boolean _not_1 = (!_contains_1);
      if (_not_1) {
        return false;
      }
    }
    return true;
  }
  
  protected Automaton determinizeNFA(final Automaton NFA) {
    final Automaton DFA = RegexCompiler.factory.createAutomaton();
    String _name = NFA.getName();
    DFA.setName(_name);
    final HashSet<HashSet<State>> Dstates = new HashSet<HashSet<State>>();
    final HashMap<HashSet<State>, HashMap<SymbolicEvent, HashSet<State>>> Dtrans = new HashMap<HashSet<State>, HashMap<SymbolicEvent, HashSet<State>>>();
    final HashSet<HashSet<State>> marked = new HashSet<HashSet<State>>();
    State _initialState = NFA.getInitialState();
    HashSet<State> initialState = RegexCompiler.epsilonClosure(_initialState);
    Dstates.add(initialState);
    while ((!(IterableExtensions.<Boolean, Boolean>fold(IterableExtensions.<HashSet<State>, Boolean>map(Dstates, ((Function1<HashSet<State>, Boolean>) (HashSet<State> it) -> {
      return Boolean.valueOf(marked.contains(it));
    })), Boolean.valueOf(true), ((Function2<Boolean, Boolean, Boolean>) (Boolean i, Boolean j) -> {
      boolean _and = false;
      if (!(i).booleanValue()) {
        _and = false;
      } else {
        _and = (j).booleanValue();
      }
      return Boolean.valueOf(_and);
    }))).booleanValue())) {
      {
        final Function1<HashSet<State>, Boolean> _function = (HashSet<State> it) -> {
          boolean _contains = marked.contains(it);
          return Boolean.valueOf((!_contains));
        };
        Iterable<HashSet<State>> _filter = IterableExtensions.<HashSet<State>>filter(Dstates, _function);
        HashSet<State> T = IterableExtensions.<HashSet<State>>head(_filter);
        marked.add(T);
        for (final SymbolicInputEvent symbol : this.symbolicEvents) {
          {
            HashSet<State> _move = this.move(T, symbol);
            final HashSet<State> U = RegexCompiler.epsilonClosure(_move);
            final Function1<HashSet<State>, Boolean> _function_1 = (HashSet<State> it) -> {
              return Boolean.valueOf(this.sameDFAState(it, U));
            };
            Iterable<HashSet<State>> _filter_1 = IterableExtensions.<HashSet<State>>filter(Dstates, _function_1);
            HashSet<State> sameU = IterableExtensions.<HashSet<State>>head(_filter_1);
            boolean _equals = Objects.equal(sameU, null);
            if (_equals) {
              Dstates.add(U);
              sameU = U;
            }
            HashMap<SymbolicEvent, HashSet<State>> _get = Dtrans.get(T);
            boolean _equals_1 = Objects.equal(_get, null);
            if (_equals_1) {
              HashMap<SymbolicEvent, HashSet<State>> _hashMap = new HashMap<SymbolicEvent, HashSet<State>>();
              Dtrans.put(T, _hashMap);
            }
            HashMap<SymbolicEvent, HashSet<State>> _get_1 = Dtrans.get(T);
            _get_1.put(symbol, sameU);
          }
        }
      }
    }
    final HashMap<HashSet<State>, State> Dstates2DFAStates = new HashMap<HashSet<State>, State>();
    for (final HashSet<State> state : Dstates) {
      {
        State newState = RegexCompiler.factory.createState();
        EList<State> _states = DFA.getStates();
        _states.add(newState);
        Dstates2DFAStates.put(state, newState);
      }
    }
    final BiConsumer<HashSet<State>, HashMap<SymbolicEvent, HashSet<State>>> _function = (HashSet<State> p1, HashMap<SymbolicEvent, HashSet<State>> p2) -> {
      final BiConsumer<SymbolicEvent, HashSet<State>> _function_1 = (SymbolicEvent p3, HashSet<State> p4) -> {
        Transition newTrans = RegexCompiler.factory.createTransition();
        State _get = Dstates2DFAStates.get(p1);
        newTrans.setFrom(_get);
        State _get_1 = Dstates2DFAStates.get(p4);
        newTrans.setTo(_get_1);
        EventGuard _createEventGuard = RegexCompiler.factory.createEventGuard();
        newTrans.setEventguard(_createEventGuard);
        EventGuard _eventguard = newTrans.getEventguard();
        _eventguard.setType(p3);
      };
      p2.forEach(_function_1);
    };
    Dtrans.forEach(_function);
    State _get = Dstates2DFAStates.get(initialState);
    DFA.setInitialState(_get);
    EList<State> _states = DFA.getStates();
    for (final State state_1 : _states) {
      final Function2<HashSet<State>, State, Boolean> _function_1 = (HashSet<State> i, State j) -> {
        return Boolean.valueOf(Objects.equal(j, state_1));
      };
      Map<HashSet<State>, State> _filter = MapExtensions.<HashSet<State>, State>filter(Dstates2DFAStates, _function_1);
      Set<HashSet<State>> _keySet = _filter.keySet();
      HashSet<State> _head = IterableExtensions.<HashSet<State>>head(_keySet);
      final Function1<State, Boolean> _function_2 = (State it) -> {
        boolean _isAcceptor = it.isAcceptor();
        return Boolean.valueOf((_isAcceptor == true));
      };
      Iterable<State> _filter_1 = IterableExtensions.<State>filter(_head, _function_2);
      int _length = ((Object[])Conversions.unwrapArray(_filter_1, Object.class)).length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        state_1.setAcceptor(true);
      }
    }
    return DFA;
  }
  
  public static List<List<Expression>> generatePerm(final List<Expression> left, final List<Expression> right) {
    final LinkedList<List<Expression>> result = new LinkedList<List<Expression>>();
    Expression _head = IterableExtensions.<Expression>head(left);
    boolean _notEquals = (!Objects.equal(_head, null));
    if (_notEquals) {
      Iterable<Expression> _tail = IterableExtensions.<Expression>tail(left);
      List<Expression> _list = IterableExtensions.<Expression>toList(_tail);
      List<List<Expression>> _generatePerm = RegexCompiler.generatePerm(_list, right);
      final Consumer<List<Expression>> _function = (List<Expression> it) -> {
        final LinkedList<Expression> newRes = new LinkedList<Expression>();
        Expression _head_1 = IterableExtensions.<Expression>head(left);
        newRes.add(_head_1);
        final Consumer<Expression> _function_1 = (Expression it_1) -> {
          newRes.add(it_1);
        };
        it.forEach(_function_1);
        result.add(newRes);
      };
      _generatePerm.forEach(_function);
    }
    Expression _head_1 = IterableExtensions.<Expression>head(right);
    boolean _notEquals_1 = (!Objects.equal(_head_1, null));
    if (_notEquals_1) {
      Iterable<Expression> _tail_1 = IterableExtensions.<Expression>tail(right);
      List<Expression> _list_1 = IterableExtensions.<Expression>toList(_tail_1);
      List<List<Expression>> _generatePerm_1 = RegexCompiler.generatePerm(left, _list_1);
      final Consumer<List<Expression>> _function_1 = (List<Expression> it) -> {
        final LinkedList<Expression> newRes = new LinkedList<Expression>();
        Expression _head_2 = IterableExtensions.<Expression>head(right);
        newRes.add(_head_2);
        final Consumer<Expression> _function_2 = (Expression it_1) -> {
          newRes.add(it_1);
        };
        it.forEach(_function_2);
        result.add(newRes);
      };
      _generatePerm_1.forEach(_function_1);
    }
    boolean _and = false;
    Expression _head_2 = IterableExtensions.<Expression>head(right);
    boolean _equals = Objects.equal(_head_2, null);
    if (!_equals) {
      _and = false;
    } else {
      Expression _head_3 = IterableExtensions.<Expression>head(left);
      boolean _equals_1 = Objects.equal(_head_3, null);
      _and = _equals_1;
    }
    if (_and) {
      LinkedList<Expression> _linkedList = new LinkedList<Expression>();
      result.add(_linkedList);
    }
    return result;
  }
  
  protected PartialAutomaton recursiveCompile(final EObject expression) {
    if (expression instanceof And) {
      return _recursiveCompile((And)expression);
    } else if (expression instanceof Any) {
      return _recursiveCompile((Any)expression);
    } else if (expression instanceof Choice) {
      return _recursiveCompile((Choice)expression);
    } else if (expression instanceof Event) {
      return _recursiveCompile((Event)expression);
    } else if (expression instanceof Inverse) {
      return _recursiveCompile((Inverse)expression);
    } else if (expression instanceof Sequence) {
      return _recursiveCompile((Sequence)expression);
    } else if (expression instanceof Star) {
      return _recursiveCompile((Star)expression);
    } else if (expression instanceof TimedExpression) {
      return _recursiveCompile((TimedExpression)expression);
    } else if (expression instanceof ExpressionDeclaration) {
      return _recursiveCompile((ExpressionDeclaration)expression);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression).toString());
    }
  }
}
