package hu.bme.mit.inf.yakindu.sc.normal.control.trace;

import java.util.Calendar;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author benedekh
 * @param <T> enum of State type.
 */
public class StatemachineTraceNode<T extends Enum<T>> {

    private final Calendar time;
    private final List<T> activeStates;
    private final boolean isOccupied;

    public StatemachineTraceNode(List<T> activeStates, boolean isOccupied) {
        this.activeStates = activeStates;
        this.time = Calendar.getInstance();
        this.isOccupied = isOccupied;
    }

    public void saveToXML(Document doc, Element rootElement) {
        Element child = doc.createElement("node");
        for (T state : activeStates) {
            child.setAttribute("state" + activeStates.indexOf(state),
                    state.name());

            child.setAttribute("isOccupied", String.valueOf(isOccupied));
            child.setAttribute("time", time.getTime().toString());
            rootElement.appendChild(child);

            rootElement = child;
            child = doc.createElement("node");
        }
    }

    public boolean isSameActiveStates(List<T> activeStates) {
        return this.activeStates.equals(activeStates);
    }

    public boolean isOccupied() {
        return isOccupied;
    }

}
