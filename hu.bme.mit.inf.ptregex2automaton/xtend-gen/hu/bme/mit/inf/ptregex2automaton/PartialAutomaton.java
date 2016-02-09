package hu.bme.mit.inf.ptregex2automaton;

import EventAutomatonModel.Automaton;
import EventAutomatonModel.EventAutomatonModelFactory;
import EventAutomatonModel.State;

@SuppressWarnings("all")
public class PartialAutomaton {
  public State first;
  
  public State last;
  
  public Automaton a;
  
  public PartialAutomaton() {
    Automaton _createAutomaton = EventAutomatonModelFactory.eINSTANCE.createAutomaton();
    this.a = _createAutomaton;
  }
  
  public Automaton toAutomaton() {
    Automaton _xblockexpression = null;
    {
      this.a.setInitialState(this.first);
      this.last.setAcceptor(true);
      _xblockexpression = this.a;
    }
    return _xblockexpression;
  }
}
