package hu.bme.mit.inf.yakindu.sc.normal.control.trace;

import java.util.Calendar;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * A node in the trace that stores a timestamp, the latest active states of the
 * statechart, and whether the referred section was occupied. (Note: a turnout
 * is a section from the occupancy view.)
 *
 * @author benedekh
 * @param <T> enum of State type.
 */
public class StatemachineTraceNode<T extends Enum<T>> {

    // the timestamp of the trace node
    private final Calendar time;
    // the latest active states of the statechart
    private final List<T> activeStates;
    // true if the respective section was occupied
    private final boolean isOccupied;

    public StatemachineTraceNode(List<T> activeStates, boolean isOccupied) {
        this.activeStates = activeStates;
        this.time = Calendar.getInstance();
        this.isOccupied = isOccupied;
    }

    /**
     * Store the node to the referred document. The node's parent is the
     * rootElement.
     *
     * @param doc the document which stores the XML
     * @param rootElement the node's parent
     */
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

    /**
     * True if the active states are the same in both cases.
     *
     * @param activeStates the latest active states
     * @return
     */
    public boolean isSameActiveStates(List<T> activeStates) {
        return this.activeStates.equals(activeStates);
    }

    /**
     * @return if the referred section was occupied when the node was created
     */
    public boolean isOccupied() {
        return isOccupied;
    }

}
