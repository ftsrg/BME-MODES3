package hu.bme.mit.inf.yakindu.sc.english.control.trace;

import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * A trace builder for the statemachine. It can be registered in the
 * event-handling loop, see
 * {@link org.yakindu.scr.turnout.TurnoutWrapperWithListeners}, and it stores
 * the active states of the statechart in any give moment.
 *
 * The events (edges) that caused the state changes are not logged yet.
 *
 * @author benedekh
 * @param <T> enum of State type.
 */
public class StatemachineTraceBuilder<T extends Enum<T>> {

    // the default path for the log
    private static String SAVE_PATH_DEFAULT;

    // the first node in the trace
    private final StatemachineTraceNode<T> startNode;
    // the latest node in the trace
    private StatemachineTraceNode<T> lastNode;

    // the name of the statechart
    private final String statemachineName;
    // the file that is going to store the trace as serialized
    private final File file;

    public static void setDefaultSavePath(String path) {
        SAVE_PATH_DEFAULT = path;
    }

    /**
     * Create a trace builder with the referred statechart name.
     *
     * @param name the name of the statechart.
     */
    public StatemachineTraceBuilder(String name) {
        this.startNode = new StatemachineTraceNode(Collections.EMPTY_LIST, false);
        this.lastNode = startNode;
        this.statemachineName = name;
        this.file = new File(
                SAVE_PATH_DEFAULT + File.separator + statemachineName + ".xml");
    }

    /**
     * Save the trace to XML.
     */
    public void saveToXML() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = null;
            Element rootElement = null;

            if (!Files.exists(file.toPath()) || (Files.exists(file.toPath()) && startNode == lastNode)) {
                if (startNode == lastNode) {
                    Files.delete(file.toPath());
                }

                doc = docBuilder.newDocument();
                rootElement = doc.createElement("trace");
                rootElement.setAttribute("type", statemachineName);
                doc.appendChild(rootElement);
            } else {
                doc = docBuilder.parse(file);
                rootElement = (Element) doc.getDocumentElement().getLastChild();
            }

            lastNode.saveToXML(doc, rootElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(
                    SAVE_PATH_DEFAULT + File.separator + statemachineName + ".xml"));
            transformer.transform(source, result);

        } catch (SAXException | IOException | TransformerException | ParserConfigurationException e) {
            logException(getClass().getName(), e);
        }
    }

    /**
     * Create a new node in the trace, if the active states and the section's
     * occupancy was changed since last time. (Note: turnout is a section from
     * the occupancy view)
     *
     * @param latestActiveStates the latest active states of the statechart
     * @param isOccupied if the section is occupied
     * @return if the trace has changed (a new trace node was appended)
     */
    public boolean updateActiveStates(List<T> latestActiveStates,
            boolean isOccupied) {

        boolean hasChanged = false;
        boolean wasOccupied = lastNode.isOccupied();

        if (!lastNode.isSameActiveStates(latestActiveStates) || wasOccupied != isOccupied) {
            StatemachineTraceNode<T> nextNode = new StatemachineTraceNode<>(
                    latestActiveStates, isOccupied);
            this.lastNode = nextNode;

            hasChanged = true;
        }

        return hasChanged;
    }

}
