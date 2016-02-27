/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.kvcontrol.commands;

import hu.bme.mit.inf.kvcontrol.controllers.OccupancyController;
import hu.bme.mit.inf.kvcontrol.exceptions.NotFoundException;
import org.json.JSONObject;

/**
 *
 * @author zsoltmazlo
 */
public class OccupancyCommand implements ICommand {

    public static final String COMMAND = "occupancy";
    private static final String SECTION_TAG = "section";

    private OccupancyController controller;

    private int sectionId;

    private int vector;

    private boolean isSectionOccupied;

    private boolean found;
    
    public enum State {
        Occupied,
        Free,
        NotFound
    }

    public OccupancyCommand(OccupancyController controller, int sectionId) {
        this.controller = controller;
        this.sectionId = sectionId;

        if (sectionId == 0) {
            vector = controller.getOccupancyVector();
        } else {
            try {
                isSectionOccupied = controller.isSectionOccupied(this.sectionId);
                found = true;
            } catch (NotFoundException ex) {
                found = false;
            }
        }
    }

    @Override
    public String jsonify() {
        JSONObject object = new JSONObject();
        if (controller != null) {
            // van controller, a lekért adatot be kell tölteni
            object.put(ICommand.COMMAND_TAG, COMMAND);
            if( sectionId == 0 ) {
                // ekkor a vektort kértük el
                object.put(RESULT_TAG, vector);
            } else if( found ) {
                // talált section státusza
                object.put(RESULT_TAG, isSectionOccupied?State.Occupied:State.Free);
            } else {
                // nincs ezzel az id-val section
                object.put(RESULT_TAG, State.NotFound);
            }
        }
        return object.toString();
    }

}
