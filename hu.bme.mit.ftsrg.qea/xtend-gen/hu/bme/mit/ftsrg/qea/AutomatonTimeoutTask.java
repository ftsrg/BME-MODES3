package hu.bme.mit.ftsrg.qea;

import com.google.common.base.Objects;
import hu.bme.mit.ftsrg.qea.AutomatonTimerScheduler;
import hu.bme.mit.ftsrg.qea.model.AbstractTransition;
import hu.bme.mit.ftsrg.qea.model.EventGuard;
import hu.bme.mit.ftsrg.qea.model.State;
import hu.bme.mit.ftsrg.qea.model.SymbolicEvent;
import hu.bme.mit.ftsrg.qea.model.SymbolicTimeoutEvent;
import hu.bme.mit.ftsrg.qea.model.SymbolicTimer;
import hu.bme.mit.ftsrg.qea.model.Token;
import hu.bme.mit.ftsrg.qea.model.Transition;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class AutomatonTimeoutTask implements Runnable {
  private Set<Token> subscribedTokens;
  
  private Object lock;
  
  private SymbolicTimer timer;
  
  private Set<AutomatonTimeoutTask> registry;
  
  public AutomatonTimeoutTask(final Token t, final SymbolicTimer timer, final int timeoutValue, final Set<AutomatonTimeoutTask> registry, final Object lock) {
    AutomatonTimerScheduler.INSTANCE.schedule(this, timeoutValue, TimeUnit.MILLISECONDS);
    this.registry = registry;
    registry.add(this);
    HashSet<Token> _hashSet = new HashSet<Token>();
    this.subscribedTokens = _hashSet;
    this.subscribedTokens.add(t);
    this.timer = timer;
    this.lock = lock;
  }
  
  public boolean subscribe(final Token t) {
    return this.subscribedTokens.add(t);
  }
  
  public boolean unsubscribe(final Token t) {
    return this.subscribedTokens.remove(t);
  }
  
  public Set<Token> getSubscribed() {
    return this.subscribedTokens;
  }
  
  public SymbolicTimer getSymbolicTimer() {
    return this.timer;
  }
  
  @Override
  public void run() {
    InputOutput.<String>println("Egy idozito lejart!!");
    synchronized (this.lock) {
      boolean _isEmpty = this.subscribedTokens.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        InputOutput.<String>println("Volt subscribed token");
        for (final Token token : this.subscribedTokens) {
          {
            State _on = token.getOn();
            EList<AbstractTransition> _outgoingTransitions = _on.getOutgoingTransitions();
            final Function1<AbstractTransition, Boolean> _function = (AbstractTransition it) -> {
              return Boolean.valueOf((it instanceof Transition));
            };
            Iterable<AbstractTransition> _filter = IterableExtensions.<AbstractTransition>filter(_outgoingTransitions, _function);
            final Function1<AbstractTransition, Boolean> _function_1 = (AbstractTransition it) -> {
              EventGuard _eventguard = ((Transition) it).getEventguard();
              SymbolicEvent _type = _eventguard.getType();
              SymbolicTimeoutEvent _timeoutEvent = this.timer.getTimeoutEvent();
              return Boolean.valueOf(Objects.equal(_type, _timeoutEvent));
            };
            Iterable<AbstractTransition> _filter_1 = IterableExtensions.<AbstractTransition>filter(_filter, _function_1);
            AbstractTransition activeEdge = IterableExtensions.<AbstractTransition>head(_filter_1);
            boolean _notEquals = (!Objects.equal(activeEdge, null));
            if (_notEquals) {
              InputOutput.<String>println("A timer activated and throwing the token away :)");
              State _to = activeEdge.getTo();
              token.setOn(_to);
            }
          }
        }
      }
      this.registry.remove(this);
    }
  }
}
