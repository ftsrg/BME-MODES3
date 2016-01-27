package hu.bme.mit.ftsrg.ptregex;

import hu.bme.mit.ftsrg.qea.model.Automaton;
import hu.bme.mit.ftsrg.qea.model.ModelFactory;
import hu.bme.mit.ftsrg.qea.model.State;

@SuppressWarnings("all")
public class PartialAutomaton {
  public State first;
  
  public State last;
  
  public Automaton a;
  
  public PartialAutomaton() {
    Automaton _createAutomaton = ModelFactory.eINSTANCE.createAutomaton();
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
