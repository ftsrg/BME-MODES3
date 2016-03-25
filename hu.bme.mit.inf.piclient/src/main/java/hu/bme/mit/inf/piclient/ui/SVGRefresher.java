package hu.bme.mit.inf.piclient.ui;

import hu.bme.mit.inf.piclient.util.TurnoutCache;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import hu.bme.mit.inf.mqtt.common.data.Section;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import org.apache.batik.swing.JSVGCanvas;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.svg.SVGDocument;
import hu.bme.mit.inf.piclient.Application;
import static hu.bme.mit.inf.piclient.Application.findStrokePattern;
import static hu.bme.mit.inf.piclient.Application.sections;
import static hu.bme.mit.inf.piclient.ui.SettingsWindow.occupancyControllerProxy;
import static hu.bme.mit.inf.piclient.ui.SettingsWindow.sectionControllerProxy;
import static hu.bme.mit.inf.piclient.ui.SettingsWindow.turnoutControllerProxy;
import hu.bme.mit.inf.piclient.data.Relations;

/**
 *
 * @author zsoltmazlo
 */
public class SVGRefresher implements Runnable {

    private final JSVGCanvas canvas;

    private SVGDocument svgDocument;

    private final String[] occupancyVector = {
        "NOP", "0x81L", "0x82L", "0x83L",
        "0x86L", "0x84L", "0x85L", "NOP",
        "0x08L", "0x09L", "0x0AL", "0x0BL",
        "0x0CL", "0x0DL", "0x0EL", "0x0FL",
        "0x10L", "0x11L", "NOP", "0x13L",
        "0x14L", "0x15L", "0x16L", "0x17L"
    };

    private final HashMap<Integer, TurnoutCache> turnouts;

    public SVGRefresher(JSVGCanvas canvas) {
        this.canvas = canvas;

        this.turnouts = new HashMap<>();

        // setting up cache map
        Set<String> turnoutKeys = Relations.getTurnouts().keySet();
        for (String turnout : turnoutKeys) {
            int turnoutID = Integer.parseInt(turnout.substring(2), 16);
            this.turnouts.put(turnoutID, TurnoutCache.NOT_CONFIGURED);
        }
    }

    @Override
    public void run() {

        synchronized (this.canvas) {
            try {
                this.canvas.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(SVGRefresher.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }
        svgDocument = canvas.getSVGDocument();

        RailwayWindow.log(
                "Thread@" + Thread.currentThread().getName() + " started(svg turnout refresher)");

        final int sleepConstant = 50;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(sleepConstant);
                if (sectionControllerProxy != null) {
                    refreshSections();
                }
                Thread.sleep(sleepConstant);
                if (occupancyControllerProxy != null) {
                    refreshOccupancy();
                }
                Thread.sleep(sleepConstant);
                if (turnoutControllerProxy != null) {
                    refreshTurnouts();
                }
                Thread.sleep(sleepConstant);

                refreshSVG();

                if (SettingsWindow.Configuration.heartbeatTimeout >= 4 * sleepConstant) {
                    Thread.sleep(
                            SettingsWindow.Configuration.heartbeatTimeout - 4 * sleepConstant);
                }
            } catch (InterruptedException ex) {
                logException(getClass().getName(), ex);
                Thread.currentThread().interrupt();
            }
        }
    }

    private void refreshSVG() {
        // need one mouse event to refresh svg
        MouseEvent me = new MouseEvent(canvas, MouseEvent.MOUSE_MOVED, 0,
                0, 100, 100, 1, false);
        canvas.getMouseListeners()[0].mouseEntered(me);
    }

    private void refreshSections() throws InterruptedException {
        for (Section section : sections.values()) {
            boolean isEnabled = SettingsWindow.sectionControllerProxy.isSectionEnabled(
                    section.getId());
            // 10 ms wait, otherwise mqtt will be throottled
            Thread.sleep(10);

            String color = isEnabled ? SettingsWindow.SECTION_ENABLED_COLOR : SettingsWindow.SECTION_DISABLED_COLOR;
            Element elem = svgDocument.getElementById(Relations.getKey(
                    section.getId()));
            this.changeElementColor(elem, "stroke", color, false);
        }
    }

    private void refreshOccupancy() throws DOMException, InterruptedException {

        // refresh occupancy display
        for (int i = 0; i < occupancyVector.length; i++) {
            String locoObjectID = occupancyVector[i];

            if (!locoObjectID.equals("NOP")) {
                boolean sectionOccupied = occupancyControllerProxy.isSectionOccupied(
                        i);
                // 10 ms wait, otherwise mqtt will be throottled
                Thread.sleep(10);

                Element elem = svgDocument.getElementById(locoObjectID);
                this.changeElementColor(elem, "fill",
                        sectionOccupied ? SettingsWindow.OCCUPANCY_BACKGROUND : "FFFFFF",
                        false);
            }
        }
    }

    private void changeElementColor(Element elem, String attr, String color,
            boolean bringToFront) {
        if (elem != null) {

            Matcher m = null;
            switch (attr) {
                case "stroke":
                    m = findStrokePattern.matcher(elem.getAttribute("style"));
                    break;
                case "fill":
                    m = Application.findFillPattern.matcher(elem.getAttribute(
                            "style"));
                    break;
            }

            if (m != null && m.find()) {
                String newStyle = m.replaceAll(attr + ":#" + color + ";");
                elem.setAttributeNS(null, "style", newStyle);
                if (bringToFront) {
                    Node parentNode = elem.getParentNode();
                    parentNode.removeChild(elem);
                    parentNode.appendChild(elem);
                }
            }
        }
    }

    private void refreshTurnouts() throws InterruptedException {

        for (Map.Entry<Integer, TurnoutCache> turnout : turnouts.entrySet()) {
            Integer turnoutID = turnout.getKey();
            TurnoutCache turnoutCache = turnout.getValue();

            if (turnoutID == 0x87 || turnoutID == 0x86) {
                this.changeXTurnout();
                continue;
            }

            // normal turnouts
            boolean isDivergent = turnoutControllerProxy.isTurnoutDivergent(
                    turnoutID);
            // 10 ms wait, otherwise mqtt will be throottled
            Thread.sleep(10);

            this.changeTurnout(turnoutID, turnoutCache, isDivergent);
        }
    }

    private void changeXTurnout() throws InterruptedException {
        String[] elements = {"0x86E", "0x86K", "0x87E", "0x87K"};
        Element elem;
        String change = "NOP";
        String route = "";

        TurnoutCache c86 = turnouts.get(0x86);
        TurnoutCache c87 = turnouts.get(0x87);

        boolean div86 = turnoutControllerProxy.isTurnoutDivergent(0x86);
        // 10 ms wait, otherwise mqtt will be throottled
        Thread.sleep(10);
        boolean div87 = turnoutControllerProxy.isTurnoutDivergent(0x87);
        // 10 ms wait, otherwise mqtt will be throottled
        Thread.sleep(10);

        if (div86 && div87 && (!c86.isDivergent() || !c87.isDivergent())) {
            change = "0x87E";
            route = "0x10&lt;&#8212;&gt;0x0E";
            c86 = TurnoutCache.DIVERGENT;
            c87 = TurnoutCache.DIVERGENT;
        } else if (!div86 && !div87 && (!c86.isStraight() || !c87.isStraight())) {
            change = "0x86E";
            route = "0x15&lt;&#8212;&gt;0x16";
            c86 = TurnoutCache.STRAIGHT;
            c87 = TurnoutCache.STRAIGHT;
        } else if (div86 && !div87 && (!c86.isDivergent() || !c87.isStraight())) {
            change = "0x86K";
            route = "0x15&lt;&#8212;&gt;0x0E";
            c86 = TurnoutCache.DIVERGENT;
            c87 = TurnoutCache.STRAIGHT;
        } else if (!div86 && div87 && (!c86.isStraight() || !c87.isDivergent())) {
            change = "0x87K";
            route = "0x10&lt;&#8212;&gt;0x16";
            c86 = TurnoutCache.STRAIGHT;
            c87 = TurnoutCache.DIVERGENT;
        }

        // refresh cache
        turnouts.put(0x86, c86);
        turnouts.put(0x87, c87);

        if (!change.equals("NOP")) {
            // all element to inactive
            for (String elemID : elements) {
                elem = this.svgDocument.getElementById(elemID);
                this.changeElementColor(elem, "stroke",
                        SettingsWindow.TURNOUT_DEACTIVE_BRANCH_COLOR, false);
            }
            RailwayWindow.log("X turnout changed to <br>route " + route);
            elem = this.svgDocument.getElementById(change);
            this.changeElementColor(elem, "stroke",
                    SettingsWindow.TURNOUT_ACTIVE_BRANCH_COLOR, true);
        }
    }

    private void changeTurnout(int turnoutID, TurnoutCache cache,
            boolean isDivergent) {
        Element elem;

        if (isDivergent && !cache.isDivergent()) {
            RailwayWindow.log("changing turnout #" + turnoutID + " to divergent");

            elem = this.svgDocument.getElementById(String.format("0x%02XK",
                    turnoutID));
            this.changeElementColor(elem, "stroke",
                    SettingsWindow.TURNOUT_DEACTIVE_BRANCH_COLOR, false);

            elem = this.svgDocument.getElementById(String.format("0x%02XE",
                    turnoutID));
            this.changeElementColor(elem, "stroke",
                    SettingsWindow.TURNOUT_ACTIVE_BRANCH_COLOR, true);

            // refresh cache by overwriting the previous cache value
            cache = TurnoutCache.DIVERGENT;
            turnouts.put(turnoutID, cache);
        } else if (!isDivergent && !cache.isStraight()) {
            RailwayWindow.log("changing turnout #" + turnoutID + " to straight");

            elem = this.svgDocument.getElementById(String.format("0x%02XE",
                    turnoutID));
            this.changeElementColor(elem, "stroke",
                    SettingsWindow.TURNOUT_DEACTIVE_BRANCH_COLOR, false);

            elem = this.svgDocument.getElementById(String.format("0x%02XK",
                    turnoutID));
            this.changeElementColor(elem, "stroke",
                    SettingsWindow.TURNOUT_ACTIVE_BRANCH_COLOR, true);

            // refresh cache by overwriting the previous cache value
            cache = TurnoutCache.STRAIGHT;
            turnouts.put(turnoutID, cache);
        }
    }
}
