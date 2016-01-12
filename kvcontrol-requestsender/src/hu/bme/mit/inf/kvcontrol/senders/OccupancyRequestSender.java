package hu.bme.mit.inf.kvcontrol.senders;

import org.json.JSONObject;

/**
 *
 * @author benedekh
 */
public class OccupancyRequestSender extends AbstractRequestSender {

    private static final String URL_EXTENSION = "occupancy/";
    private static final String OCCUPIED = "occupied";

    public boolean isSectionOccupied(int sectionId) {
        JSONObject response = super.getGetResponse(URL_EXTENSION + String.valueOf(sectionId));
        return OCCUPIED.equals(response.getString(RESULT_TAG).toLowerCase());
    }

    public int getOccupancyVector() {
        JSONObject response = super.getGetResponse(URL_EXTENSION);
        return response.getInt(RESULT_TAG);
    }
    
}
