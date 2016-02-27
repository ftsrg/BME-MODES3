package hu.bme.mit.inf.piclient.util;

import hu.bme.mit.inf.piclient.ui.RailwayWindow;
import hu.bme.mit.inf.piclient.ui.SettingsWindow;
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
        if (SettingsWindow.sectionControllerProxy.isSectionEnabled(sectionID)) {
            RailwayWindow.log(String.format(
                    "trying to disable section #%02X", this.sectionID));
            SettingsWindow.sectionControllerProxy.setSectionDisabled(sectionID);
        } else {
            RailwayWindow.log(
                    String.format("trying to enable section #%02X",
                            this.sectionID));
            SettingsWindow.sectionControllerProxy.setSectionEnabled(sectionID);
        }
    }

}
