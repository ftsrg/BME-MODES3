/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.kvcontrol.commands;

import static hu.bme.mit.inf.kvcontrol.commands.ICommand.RESULT_TAG;
import hu.bme.mit.inf.kvcontrol.controllers.TurnoutController;
import hu.bme.mit.inf.kvcontrol.exceptions.NotFoundException;
import org.json.JSONObject;

/**
 *
 * @author zsoltmazlo
 */
public class TurnoutStateCommand implements ICommand {

    public static final String COMMAND = "turnout";

    private final TurnoutController controller;

    private int sectionId;

    private boolean isTurnoutDivergent;

    private boolean found;

    public enum State {
        Divergent,
        Straight,
        NotFound
    }

    public TurnoutStateCommand(TurnoutController controller, int sectionId) {
        this.controller = controller;
        this.sectionId = sectionId;

        // ha nincs controller, akkor nem is kell továbbmenni
        if (this.controller == null) {
            return;
        }

        try {
            // megcseréljük a kettőt, hogy konzisztens legyen a multimaussal
            if (this.sectionId == 0x86){
                this.sectionId = 0x87;
            } else if(this.sectionId == 0x87){
                this.sectionId = 0x86;
            }
            
            isTurnoutDivergent = this.controller.isTurnoutDivergent(this.sectionId);
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
                object.put(RESULT_TAG, isTurnoutDivergent ? State.Divergent : State.Straight);
            } else {
                // nincs ezzel az id-val section
                object.put(RESULT_TAG, State.NotFound);
            }
        }
        return object.toString();
    }

}
