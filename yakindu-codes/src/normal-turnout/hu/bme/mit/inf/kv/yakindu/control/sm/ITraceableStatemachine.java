package hu.bme.mit.inf.kv.yakindu.control.sm;

import hu.bme.mit.inf.kv.yakindu.control.trace.StatemachineType;

import java.util.List;

import org.yakindu.scr.kv.IKvStatemachine;
import org.yakindu.scr.kv.KvStatemachine.State;

/**
 *
 * @author benedekh
 */
public interface ITraceableStatemachine extends IKvStatemachine {

    public List<State> getActiveStates(StatemachineType statemachineType);
}
