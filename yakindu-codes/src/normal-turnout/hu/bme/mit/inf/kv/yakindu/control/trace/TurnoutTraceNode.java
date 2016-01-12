package hu.bme.mit.inf.kv.yakindu.control.trace;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.yakindu.scr.kv.KvStatemachine.State;

/**
 *
 * @author benedekh
 */
public class TurnoutTraceNode extends StatemachineTraceNode {

    private boolean isOccupied = false;

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    @Override
    public void saveToXML(Document doc, Element rootElement) {
        Element child = null;
        if (time != null) {
            child = doc.createElement("node");
            for (State state : activeStates) {
                child.setAttribute("state" + activeStates.indexOf(state),
                        state.name());
            }
            child.setAttribute("isOccupied", String.valueOf(isOccupied));
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

    public boolean isOccupied() {
        return isOccupied;
    }

}
