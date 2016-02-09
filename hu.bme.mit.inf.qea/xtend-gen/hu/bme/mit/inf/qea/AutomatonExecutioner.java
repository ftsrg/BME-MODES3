package hu.bme.mit.inf.qea;

import EventAutomatonModel.AbstractTransition;
import EventAutomatonModel.Action;
import EventAutomatonModel.Automaton;
import EventAutomatonModel.Binding;
import EventAutomatonModel.ConstantBinding;
import EventAutomatonModel.EpsilonTransition;
import EventAutomatonModel.Event;
import EventAutomatonModel.EventAutomatonModelFactory;
import EventAutomatonModel.EventGuard;
import EventAutomatonModel.FixParameter;
import EventAutomatonModel.FreeParameter;
import EventAutomatonModel.Parameter;
import EventAutomatonModel.ResetTimerAction;
import EventAutomatonModel.SetTimerAction;
import EventAutomatonModel.State;
import EventAutomatonModel.SymbolicEvent;
import EventAutomatonModel.SymbolicEventParameter;
import EventAutomatonModel.SymbolicParameter;
import EventAutomatonModel.SymbolicTimer;
import EventAutomatonModel.TimerAction;
import EventAutomatonModel.Token;
import EventAutomatonModel.Transition;
import com.google.common.base.Objects;
import hu.bme.mit.inf.qea.AutomatonTimeoutTask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class AutomatonExecutioner {
  @Extension
  private static EventAutomatonModelFactory factory = EventAutomatonModelFactory.eINSTANCE;
  
  private Automaton a;
  
  private Object lock;
  
  private Set<AutomatonTimeoutTask> runningTimers;
  
  public AutomatonExecutioner(final Automaton a) {
    Object _object = new Object();
    this.lock = _object;
    this.a = a;
    HashSet<AutomatonTimeoutTask> _hashSet = new HashSet<AutomatonTimeoutTask>();
    this.runningTimers = _hashSet;
    State _initialState = a.getInitialState();
    HashSet<State> _epsilonClosure = AutomatonExecutioner.epsilonClosure(_initialState);
    final Consumer<State> _function = (State it) -> {
      EList<Token> _tokens = it.getTokens();
      Token _createToken = AutomatonExecutioner.factory.createToken();
      _tokens.add(_createToken);
    };
    _epsilonClosure.forEach(_function);
  }
  
  public void pushEvent(final Event event) {
    synchronized (this.lock) {
      final HashMap<Token, HashSet<AbstractTransition>> copyTo = new HashMap<Token, HashSet<AbstractTransition>>();
      final HashSet<Token> oldTokens = new HashSet<Token>();
      EList<State> _states = this.a.getStates();
      final Consumer<State> _function = (State it) -> {
        EList<Token> _tokens = it.getTokens();
        final Consumer<Token> _function_1 = (Token it_1) -> {
          oldTokens.add(it_1);
        };
        _tokens.forEach(_function_1);
      };
      _states.forEach(_function);
      EList<State> _states_1 = this.a.getStates();
      for (final State state : _states_1) {
        EList<AbstractTransition> _outgoingTransitions = state.getOutgoingTransitions();
        final Function1<AbstractTransition, Boolean> _function_1 = (AbstractTransition it) -> {
          return Boolean.valueOf((it instanceof Transition));
        };
        Iterable<AbstractTransition> _filter = IterableExtensions.<AbstractTransition>filter(_outgoingTransitions, _function_1);
        for (final AbstractTransition trans : _filter) {
          boolean _transitionEnabled = this.transitionEnabled(trans, event);
          if (_transitionEnabled) {
            State _from = trans.getFrom();
            EList<Token> _tokens = _from.getTokens();
            for (final Token token : _tokens) {
              {
                HashSet<AbstractTransition> _get = copyTo.get(token);
                boolean _equals = Objects.equal(_get, null);
                if (_equals) {
                  HashSet<AbstractTransition> _hashSet = new HashSet<AbstractTransition>();
                  copyTo.put(token, _hashSet);
                }
                HashSet<AbstractTransition> _get_1 = copyTo.get(token);
                _get_1.add(trans);
              }
            }
          }
        }
      }
      final BiConsumer<Token, HashSet<AbstractTransition>> _function_2 = (Token token_1, HashSet<AbstractTransition> transitions) -> {
        final Consumer<AbstractTransition> _function_3 = (AbstractTransition it) -> {
          final Token newToken = this.copyToken(token_1);
          EList<Action> _actions = it.getActions();
          final Consumer<Action> _function_4 = (Action it_1) -> {
            this.executeOn(it_1, newToken);
          };
          _actions.forEach(_function_4);
          State _to = it.getTo();
          EList<Token> _tokens_1 = _to.getTokens();
          _tokens_1.add(newToken);
          Stack<Token> stack = new Stack<Token>();
          HashSet<Token> eclosure = new HashSet<Token>();
          stack.push(newToken);
          while ((!stack.isEmpty())) {
            {
              Token t = stack.pop();
              State _on = t.getOn();
              EList<AbstractTransition> _outgoingTransitions_1 = _on.getOutgoingTransitions();
              final Function1<AbstractTransition, Boolean> _function_5 = (AbstractTransition it_1) -> {
                return Boolean.valueOf((it_1 instanceof EpsilonTransition));
              };
              Iterable<AbstractTransition> _filter_1 = IterableExtensions.<AbstractTransition>filter(_outgoingTransitions_1, _function_5);
              for (final AbstractTransition outGoingEpsilonTransition : _filter_1) {
                {
                  final State u = outGoingEpsilonTransition.getTo();
                  final Function1<Token, State> _function_6 = (Token it_1) -> {
                    return it_1.getOn();
                  };
                  Iterable<State> _map = IterableExtensions.<Token, State>map(eclosure, _function_6);
                  final Function1<State, Boolean> _function_7 = (State it_1) -> {
                    return Boolean.valueOf(Objects.equal(it_1, u));
                  };
                  State _findFirst = IterableExtensions.<State>findFirst(_map, _function_7);
                  boolean _equals = Objects.equal(_findFirst, null);
                  if (_equals) {
                    final Token newToken2 = this.copyToken(t);
                    newToken2.setOn(u);
                    EList<Action> _actions_1 = outGoingEpsilonTransition.getActions();
                    final Consumer<Action> _function_8 = (Action it_1) -> {
                      this.executeOn(it_1, newToken2);
                      InputOutput.<String>println("Action executed");
                    };
                    _actions_1.forEach(_function_8);
                    eclosure.add(newToken2);
                    stack.push(newToken2);
                  }
                }
              }
            }
          }
        };
        transitions.forEach(_function_3);
      };
      copyTo.forEach(_function_2);
      final Consumer<Token> _function_3 = (Token it) -> {
        it.setOn(null);
      };
      oldTokens.forEach(_function_3);
      String _name = this.a.getName();
      String _plus = ("Automaton " + _name);
      String _plus_1 = (_plus + "s state:");
      InputOutput.<String>println(_plus_1);
      EList<State> _states_2 = this.a.getStates();
      final Consumer<State> _function_4 = (State state_1) -> {
        EList<Token> _tokens_1 = state_1.getTokens();
        int _length = ((Object[])Conversions.unwrapArray(_tokens_1, Object.class)).length;
        boolean _notEquals = (_length != 0);
        if (_notEquals) {
          int _id = state_1.getId();
          String _plus_2 = ("\tToken on " + Integer.valueOf(_id));
          InputOutput.<String>println(_plus_2);
        }
      };
      _states_2.forEach(_function_4);
      EList<State> _states_3 = this.a.getStates();
      final Function1<State, Boolean> _function_5 = (State it) -> {
        return Boolean.valueOf(it.isAcceptor());
      };
      Iterable<State> _filter_1 = IterableExtensions.<State>filter(_states_3, _function_5);
      final Consumer<State> _function_6 = (State it) -> {
        EList<Token> _tokens_1 = it.getTokens();
        int _length = ((Object[])Conversions.unwrapArray(_tokens_1, Object.class)).length;
        boolean _notEquals = (_length != 0);
        if (_notEquals) {
          InputOutput.<String>println("\tA token has been accepted");
        }
      };
      _filter_1.forEach(_function_6);
    }
  }
  
  public void reduceTokens() {
    final HashSet<Token> tokens = new HashSet<Token>();
    EList<State> _states = this.a.getStates();
    final Consumer<State> _function = (State it) -> {
      EList<Token> _tokens = it.getTokens();
      final Consumer<Token> _function_1 = (Token it_1) -> {
        tokens.add(it_1);
      };
      _tokens.forEach(_function_1);
    };
    _states.forEach(_function);
    final HashSet<HashSet<Token>> equivalents = new HashSet<HashSet<Token>>();
    final Consumer<Token> _function_1 = (Token token1) -> {
      final Consumer<Token> _function_2 = (Token token2) -> {
        State _on = token1.getOn();
        State _on_1 = token2.getOn();
        boolean _equals = Objects.equal(_on, _on_1);
        if (_equals) {
          boolean _or = false;
          boolean _and = false;
          final Function1<AutomatonTimeoutTask, Boolean> _function_3 = (AutomatonTimeoutTask it) -> {
            Set<Token> _subscribed = it.getSubscribed();
            return Boolean.valueOf(_subscribed.contains(token1));
          };
          AutomatonTimeoutTask _findFirst = IterableExtensions.<AutomatonTimeoutTask>findFirst(this.runningTimers, _function_3);
          boolean _equals_1 = Objects.equal(_findFirst, null);
          if (!_equals_1) {
            _and = false;
          } else {
            final Function1<AutomatonTimeoutTask, Boolean> _function_4 = (AutomatonTimeoutTask it) -> {
              Set<Token> _subscribed = it.getSubscribed();
              return Boolean.valueOf(_subscribed.contains(token2));
            };
            AutomatonTimeoutTask _findFirst_1 = IterableExtensions.<AutomatonTimeoutTask>findFirst(this.runningTimers, _function_4);
            boolean _equals_2 = Objects.equal(_findFirst_1, null);
            _and = _equals_2;
          }
          if (_and) {
            _or = true;
          } else {
            boolean _hasSameRunningTimers = this.hasSameRunningTimers(token1, token2);
            _or = _hasSameRunningTimers;
          }
          if (_or) {
            final Function1<HashSet<Token>, Boolean> _function_5 = (HashSet<Token> it) -> {
              return Boolean.valueOf(it.contains(token1));
            };
            HashSet<Token> equivalent1 = IterableExtensions.<HashSet<Token>>findFirst(equivalents, _function_5);
            final Function1<HashSet<Token>, Boolean> _function_6 = (HashSet<Token> it) -> {
              return Boolean.valueOf(it.contains(token2));
            };
            HashSet<Token> equivalent2 = IterableExtensions.<HashSet<Token>>findFirst(equivalents, _function_6);
            boolean _and_1 = false;
            boolean _equals_3 = Objects.equal(equivalent1, null);
            if (!_equals_3) {
              _and_1 = false;
            } else {
              boolean _equals_4 = Objects.equal(equivalent2, null);
              _and_1 = _equals_4;
            }
            if (_and_1) {
              HashSet<Token> equivalent = new HashSet<Token>();
              equivalent.add(token1);
              equivalent.add(token2);
              equivalents.add(equivalent);
            } else {
              boolean _and_2 = false;
              boolean _notEquals = (!Objects.equal(equivalent1, null));
              if (!_notEquals) {
                _and_2 = false;
              } else {
                boolean _equals_5 = Objects.equal(equivalent2, null);
                _and_2 = _equals_5;
              }
              if (_and_2) {
                equivalent1.add(token2);
              } else {
                boolean _and_3 = false;
                boolean _equals_6 = Objects.equal(equivalent1, null);
                if (!_equals_6) {
                  _and_3 = false;
                } else {
                  boolean _notEquals_1 = (!Objects.equal(equivalent2, null));
                  _and_3 = _notEquals_1;
                }
                if (_and_3) {
                  equivalent1.add(token2);
                } else {
                  throw new AssertionError("This shouldn\'t happen");
                }
              }
            }
          }
        }
      };
      tokens.forEach(_function_2);
    };
    tokens.forEach(_function_1);
    final Consumer<HashSet<Token>> _function_2 = (HashSet<Token> it) -> {
      Iterable<Token> _tail = IterableExtensions.<Token>tail(it);
      final Consumer<Token> _function_3 = (Token token) -> {
        token.setOn(null);
        final Function1<AutomatonTimeoutTask, Boolean> _function_4 = (AutomatonTimeoutTask it_1) -> {
          Set<Token> _subscribed = it_1.getSubscribed();
          return Boolean.valueOf(_subscribed.contains(token));
        };
        Iterable<AutomatonTimeoutTask> _filter = IterableExtensions.<AutomatonTimeoutTask>filter(this.runningTimers, _function_4);
        final Consumer<AutomatonTimeoutTask> _function_5 = (AutomatonTimeoutTask it_1) -> {
          it_1.unsubscribe(token);
        };
        _filter.forEach(_function_5);
      };
      _tail.forEach(_function_3);
    };
    equivalents.forEach(_function_2);
  }
  
  public boolean hasSameRunningTimers(final Token token1, final Token token2) {
    boolean _xblockexpression = false;
    {
      final Function1<AutomatonTimeoutTask, Boolean> _function = (AutomatonTimeoutTask it) -> {
        Set<Token> _subscribed = it.getSubscribed();
        return Boolean.valueOf(_subscribed.contains(token1));
      };
      Iterable<AutomatonTimeoutTask> runningTimers1 = IterableExtensions.<AutomatonTimeoutTask>filter(this.runningTimers, _function);
      final Function1<AutomatonTimeoutTask, Boolean> _function_1 = (AutomatonTimeoutTask it) -> {
        Set<Token> _subscribed = it.getSubscribed();
        return Boolean.valueOf(_subscribed.contains(token2));
      };
      Iterable<AutomatonTimeoutTask> runningTimers2 = IterableExtensions.<AutomatonTimeoutTask>filter(this.runningTimers, _function_1);
      for (final AutomatonTimeoutTask timer1 : runningTimers1) {
        final Function1<AutomatonTimeoutTask, Boolean> _function_2 = (AutomatonTimeoutTask it) -> {
          return Boolean.valueOf(Objects.equal(it, timer1));
        };
        AutomatonTimeoutTask _findFirst = IterableExtensions.<AutomatonTimeoutTask>findFirst(runningTimers2, _function_2);
        boolean _equals = Objects.equal(_findFirst, null);
        if (_equals) {
          return false;
        }
      }
      for (final AutomatonTimeoutTask timer2 : runningTimers2) {
        final Function1<AutomatonTimeoutTask, Boolean> _function_3 = (AutomatonTimeoutTask it) -> {
          return Boolean.valueOf(Objects.equal(it, timer2));
        };
        AutomatonTimeoutTask _findFirst_1 = IterableExtensions.<AutomatonTimeoutTask>findFirst(runningTimers1, _function_3);
        boolean _equals_1 = Objects.equal(_findFirst_1, null);
        if (_equals_1) {
          return false;
        }
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  protected void _executeOn(final Action action, final Token token) {
    throw new UnsupportedOperationException();
  }
  
  protected void _executeOn(final TimerAction action, final Token token) {
    throw new UnsupportedOperationException();
  }
  
  protected void _executeOn(final ResetTimerAction action, final Token token) {
    final Function1<AutomatonTimeoutTask, Boolean> _function = (AutomatonTimeoutTask it) -> {
      boolean _and = false;
      SymbolicTimer _symbolicTimer = it.getSymbolicTimer();
      SymbolicTimer _timer = action.getTimer();
      boolean _equals = Objects.equal(_symbolicTimer, _timer);
      if (!_equals) {
        _and = false;
      } else {
        Set<Token> _subscribed = it.getSubscribed();
        boolean _contains = _subscribed.contains(token);
        _and = _contains;
      }
      return Boolean.valueOf(_and);
    };
    Iterable<AutomatonTimeoutTask> _filter = IterableExtensions.<AutomatonTimeoutTask>filter(this.runningTimers, _function);
    final Consumer<AutomatonTimeoutTask> _function_1 = (AutomatonTimeoutTask it) -> {
      it.unsubscribe(token);
    };
    _filter.forEach(_function_1);
  }
  
  protected void _executeOn(final SetTimerAction action, final Token token) {
    SymbolicTimer _timer = action.getTimer();
    int _toValue = action.getToValue();
    new AutomatonTimeoutTask(token, _timer, _toValue, this.runningTimers, this.lock);
  }
  
  protected Token copyToken(final Token t) {
    Token _xblockexpression = null;
    {
      final Token token = AutomatonExecutioner.factory.createToken();
      final Function1<AutomatonTimeoutTask, Boolean> _function = (AutomatonTimeoutTask it) -> {
        Set<Token> _subscribed = it.getSubscribed();
        return Boolean.valueOf(_subscribed.contains(t));
      };
      Iterable<AutomatonTimeoutTask> _filter = IterableExtensions.<AutomatonTimeoutTask>filter(this.runningTimers, _function);
      final Consumer<AutomatonTimeoutTask> _function_1 = (AutomatonTimeoutTask it) -> {
        it.subscribe(token);
      };
      _filter.forEach(_function_1);
      _xblockexpression = token;
    }
    return _xblockexpression;
  }
  
  public boolean tokenParametersMatchesEvent(final Token token, final Event event) {
    boolean _xblockexpression = false;
    {
      EList<Parameter> _parameters = token.getParameters();
      for (final Parameter param : _parameters) {
        if ((param instanceof FixParameter)) {
          EList<FixParameter> _parameters_1 = event.getParameters();
          final Function1<FixParameter, Boolean> _function = (FixParameter it) -> {
            SymbolicParameter _type = it.getType();
            SymbolicParameter _type_1 = ((FixParameter)param).getType();
            return Boolean.valueOf(Objects.equal(_type, _type_1));
          };
          FixParameter _findFirst = IterableExtensions.<FixParameter>findFirst(_parameters_1, _function);
          boolean _equals = _findFirst.equals(param);
          boolean _not = (!_equals);
          if (_not) {
            return false;
          }
        } else {
          if ((param instanceof FreeParameter)) {
            EList<Object> _excludedValues = ((FreeParameter)param).getExcludedValues();
            EList<FixParameter> _parameters_2 = event.getParameters();
            final Function1<FixParameter, Boolean> _function_1 = (FixParameter it) -> {
              SymbolicParameter _type = it.getType();
              SymbolicParameter _type_1 = ((FreeParameter)param).getType();
              return Boolean.valueOf(Objects.equal(_type, _type_1));
            };
            FixParameter _findFirst_1 = IterableExtensions.<FixParameter>findFirst(_parameters_2, _function_1);
            Object _value = ((FixParameter) _findFirst_1).getValue();
            boolean _contains = _excludedValues.contains(_value);
            if (_contains) {
              return false;
            }
          }
        }
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public boolean transitionEnabled(final AbstractTransition trans, final Event event) {
    boolean _xblockexpression = false;
    {
      if ((trans instanceof EpsilonTransition)) {
        return false;
      }
      Transition transition = ((Transition) trans);
      EventGuard _eventguard = transition.getEventguard();
      SymbolicEvent _type = _eventguard.getType();
      SymbolicEvent _type_1 = event.getType();
      boolean _notEquals = (!Objects.equal(_type, _type_1));
      if (_notEquals) {
        return false;
      }
      EventGuard _eventguard_1 = transition.getEventguard();
      EList<Binding> _bindings = _eventguard_1.getBindings();
      final Function1<Binding, Boolean> _function = (Binding it) -> {
        return Boolean.valueOf((it instanceof ConstantBinding));
      };
      Iterable<Binding> _filter = IterableExtensions.<Binding>filter(_bindings, _function);
      final Function1<Binding, Boolean> _function_1 = (Binding binding) -> {
        boolean _xblockexpression_1 = false;
        {
          final ConstantBinding constBinding = ((ConstantBinding) binding);
          FixParameter _boundTo = constBinding.getBoundTo();
          Object _value = _boundTo.getValue();
          EList<FixParameter> _parameters = event.getParameters();
          final Function1<FixParameter, Boolean> _function_2 = (FixParameter it) -> {
            SymbolicParameter _type_2 = it.getType();
            SymbolicEventParameter _binds = constBinding.getBinds();
            return Boolean.valueOf(Objects.equal(_type_2, _binds));
          };
          FixParameter _findFirst = IterableExtensions.<FixParameter>findFirst(_parameters, _function_2);
          _xblockexpression_1 = _value.equals(_findFirst);
        }
        return Boolean.valueOf(_xblockexpression_1);
      };
      _xblockexpression = IterableExtensions.<Binding>forall(_filter, _function_1);
    }
    return _xblockexpression;
  }
  
  protected String _printParameter(final FixParameter param) {
    Object _value = param.getValue();
    String _plus = ("FIX = " + _value);
    return InputOutput.<String>println(_plus);
  }
  
  protected String _printParameter(final FreeParameter param) {
    String _xblockexpression = null;
    {
      InputOutput.<String>print("FREE = {");
      EList<Object> _excludedValues = param.getExcludedValues();
      for (final Object value : _excludedValues) {
        String _string = value.toString();
        String _plus = (_string + ", ");
        InputOutput.<String>print(_plus);
      }
      _xblockexpression = InputOutput.<String>println("}");
    }
    return _xblockexpression;
  }
  
  public static HashSet<State> epsilonClosure(final State s) {
    HashSet<State> _xblockexpression = null;
    {
      ArrayList<State> list = new ArrayList<State>();
      list.add(s);
      _xblockexpression = AutomatonExecutioner.epsilonClosure(list);
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
  
  public void executeOn(final Action action, final Token token) {
    if (action instanceof ResetTimerAction) {
      _executeOn((ResetTimerAction)action, token);
      return;
    } else if (action instanceof SetTimerAction) {
      _executeOn((SetTimerAction)action, token);
      return;
    } else if (action instanceof TimerAction) {
      _executeOn((TimerAction)action, token);
      return;
    } else if (action != null) {
      _executeOn(action, token);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(action, token).toString());
    }
  }
  
  public String printParameter(final Parameter param) {
    if (param instanceof FixParameter) {
      return _printParameter((FixParameter)param);
    } else if (param instanceof FreeParameter) {
      return _printParameter((FreeParameter)param);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(param).toString());
    }
  }
}
