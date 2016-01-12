package hu.bme.mit.inf.kv.yakindu.control.trace;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.yakindu.scr.kv.KvStatemachine.State;

/**
 *
 * @author benedekh
 */
public class StatemachineTraceNode {

    protected StatemachineTraceNode nextNode = null;

    protected Calendar time = null;
    protected List<State> activeStates = new ArrayList<>();

    public void saveToXML(Document doc, Element rootElement) {
        Element child = null;
        if (time != null) {
            child = doc.createElement("node");
            for (State state : activeStates) {
                child.setAttribute("state" + activeStates.indexOf(state),
                        state.name());
            }
            child.setAttribute("time", time.getTime().toString());
            rootElement.appendChild(child);
        }

        if (nextNode != null) {
            if (child != null) {
                nextNode.saveToXML(doc, child);
            } else {
                nextNode.saveToXML(doc, rootElement);
            }
        }
    }

    public void addState(State state) {
        activeStates.add(state);
        time = Calendar.getInstance();
    }

    public void setNextNode(StatemachineTraceNode next) {
        nextNode = next;
    }

    public StatemachineTraceNode getNextNode() {
        return nextNode;
    }

    public List<State> getActiveStates() {
        return activeStates;
    }

}
