/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.piclient.util;

import hu.bme.mit.inf.piclient.ui.SettingsWindow;
import hu.bme.mit.inf.piclient.ui.RailwayWindow;
import java.util.logging.Level;
import java.util.logging.Logger;
import hu.bme.mit.inf.kvcontrol.exceptions.NotFoundException;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;

/**
 *
 * @author zsoltmazlo
 */
public class SectionClickAction implements EventListener {

    protected int sectionID;

    public SectionClickAction(int sectionID) {
        this.sectionID = sectionID;
    }

    @Override
    public void handleEvent(Event event) {

//        synchronized (sectionController) {
            try {
                if (SettingsWindow.sectionController.isSectionEnabled(sectionID)) {
                    RailwayWindow.log(String.format("trying to set section #%02X to disable", this.sectionID));
                    SettingsWindow.sectionController.setSectionDisabled(sectionID);
                } else {
                    RailwayWindow.log(String.format("trying to set section #%02X to enable", this.sectionID));
                    SettingsWindow.sectionController.setSectionEnabled(sectionID);
                }
            } catch (NotFoundException ex) {
                Logger.getLogger(SectionClickAction.class.getName()).log(Level.SEVERE, null, ex);
            }
//        }

    }

}
