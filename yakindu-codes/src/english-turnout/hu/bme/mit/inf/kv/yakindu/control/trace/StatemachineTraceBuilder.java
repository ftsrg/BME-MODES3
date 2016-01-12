package hu.bme.mit.inf.kv.yakindu.control.trace;

import hu.bme.mit.inf.kv.yakindu.control.helper.SimpleLogger;
import hu.bme.mit.inf.kv.yakindu.control.sm.ITraceableStatemachine;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.yakindu.scr.kv.KvStatemachine;
import org.yakindu.scr.kv.KvStatemachine.State;

/**
 *
 * @author benedekh
 */
public class StatemachineTraceBuilder {

    private StatemachineType type;
    private final StatemachineTraceNode startNode;
    private String traceSavePath;

    public StatemachineTraceBuilder() {
        this.startNode = createTraceNode();
    }

    public StatemachineTraceBuilder(StatemachineType type, String traceSavePath) {
        this.type = type;
        this.startNode = createTraceNode();
        this.traceSavePath = traceSavePath;
    }

    public void saveToXML() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder;

            docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("trace");
            rootElement.setAttribute("type", type.name());
            doc.appendChild(rootElement);

            startNode.saveToXML(doc, rootElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(
                    traceSavePath + File.separator + type.name() + ".xml"));
            transformer.transform(source, result);

        } catch (ParserConfigurationException e) {
            SimpleLogger.printErrorMessage(
                    StatemachineTraceBuilder.class.getName(), e.getMessage());
        } catch (TransformerConfigurationException e) {
            SimpleLogger.printErrorMessage(
                    StatemachineTraceBuilder.class.getName(), e.getMessage());
        } catch (TransformerException e) {
            SimpleLogger.printErrorMessage(
                    StatemachineTraceBuilder.class.getName(), e.getMessage());
        }
    }

    public boolean updateActiveStates(ITraceableStatemachine statemachine) {
        boolean hasChanged = false;

        StatemachineTraceNode lastNode = getLastNode();
        List<KvStatemachine.State> lastActiveStates = lastNode.getActiveStates();
        List<KvStatemachine.State> latestActiveStates = statemachine.getActiveStates(
                type);

        if (!lastActiveStates.equals(latestActiveStates)) {
            addNextNode(latestActiveStates, lastNode);
            hasChanged = true;
        }

        return hasChanged;
    }

    protected StatemachineTraceNode createNextNode(List<State> activeStates) {
        StatemachineTraceNode nextNode = createTraceNode();
        for (State state : activeStates) {
            nextNode.addState(state);
        }
        return nextNode;
    }

    protected StatemachineTraceNode createTraceNode() {
        return new StatemachineTraceNode();
    }

    protected StatemachineTraceNode getLastNode() {
        StatemachineTraceNode lastState = startNode;
        while (lastState.getNextNode() != null) {
            lastState = lastState.getNextNode();
        }
        return lastState;
    }

    private void addNextNode(List<State> activeStates,
            StatemachineTraceNode lastNode) {
        StatemachineTraceNode nextNode = createNextNode(activeStates);
        lastNode.setNextNode(nextNode);
    }

}
