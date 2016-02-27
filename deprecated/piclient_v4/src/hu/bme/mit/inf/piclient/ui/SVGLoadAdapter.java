/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.piclient.ui;

import hu.bme.mit.inf.piclient.util.SectionClickAction;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JFrame;
import hu.bme.mit.inf.kvcontrol.data.Relations;
import hu.bme.mit.inf.kvcontrol.entities.Section;
import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.svg.SVGLoadEventDispatcherAdapter;
import org.apache.batik.swing.svg.SVGLoadEventDispatcherEvent;
import org.w3c.dom.Element;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGSVGElement;
import static hu.bme.mit.inf.piclient.Application.sections;

/**
 *
 * @author zsoltmazlo
 */
public class SVGLoadAdapter extends SVGLoadEventDispatcherAdapter {

    private final JSVGCanvas canvas;

    private final JFrame frame;

    public SVGLoadAdapter(JSVGCanvas canvas, JFrame frame) {
        this.canvas = canvas;
        this.frame = frame;
    }

    @Override
    public void svgLoadEventDispatchCompleted(SVGLoadEventDispatcherEvent e) {

        SVGDocument svgDocument = canvas.getSVGDocument();
        SVGSVGElement root = svgDocument.getRootElement();

        // elements to find, because we using them to activate-deactive 
        for (Section section : sections.values()) {
            Element elem = svgDocument.getElementById(Relations.getKey(section.getID()));
            EventTarget targ = (EventTarget) elem;

            if (elem != null) {
                targ.addEventListener("click", new SectionClickAction(section.getID()), false);
            } else {
                System.out.println("section not found! " + section.getID());
            }
        }

        this.frame.pack();
        this.frame.setSize(new Dimension(900, 500));

        Rectangle renderRect = canvas.getRenderRect();
        root.setAttribute("width", String.valueOf(renderRect.width));
        root.setAttribute("height", String.valueOf(renderRect.height));
        root.setAttribute("viewBox", "0 0 2200 1500");

        System.out.println("svg loaded");
        synchronized (this.canvas) {
            this.canvas.notify();
        }

    }
}
