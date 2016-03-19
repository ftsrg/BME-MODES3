/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.kvcontrol.commands;

import static hu.bme.mit.inf.kvcontrol.commands.ICommand.RESULT_TAG;
import hu.bme.mit.inf.kvcontrol.controllers.SectionController;
import hu.bme.mit.inf.kvcontrol.exceptions.NotFoundException;
import org.json.JSONObject;

/**
 *
 * @author zsoltmazlo
 */
public class SectionStateCommand implements ICommand {

    public static final String COMMAND = "section";
    private static final String SECTION_TAG = "section";
    private static final String STATE_TAG = "state";

    private final SectionController controller;

    private int sectionId;

    private boolean isSectionEnabled;

    private boolean found;

    private Boolean setState;

    public enum State {
        Disabled,
        Enabled,
        NotFound
    }

    public SectionStateCommand(SectionController controller, int sectionId, Boolean setState) {
        this.controller = controller;
        this.sectionId = sectionId;
        this.setState = setState;

        // ha nincs controller, akkor nem is kell továbbmenni
        if (this.controller == null) {
            return;
        }

        try {
            if (this.setState == null) {
                isSectionEnabled = this.controller.isSectionEnabled(this.sectionId);
            } else if (this.setState) {
                this.controller.setSectionEnabled(this.sectionId);
            } else {
                this.controller.setSectionDisabled(this.sectionId);
            }
            isSectionEnabled = this.controller.isSectionEnabled(this.sectionId);
            found = true;
        } catch (NotFoundException ex) {
            found = false;
        }
    }

    @Override
    public String jsonify() {
        JSONObject object = new JSONObject();
        if (controller != null) {
            // van controller, a lekért adatot be kell tölteni
            object.put(ICommand.COMMAND_TAG, COMMAND);
            if (found) {
                // talált section státusza
                object.put(RESULT_TAG, isSectionEnabled ? State.Enabled : State.Disabled);
            } else {
                // nincs ezzel az id-val section
                object.put(RESULT_TAG, State.NotFound);
            }
        }
        return object.toString();
    }

}
