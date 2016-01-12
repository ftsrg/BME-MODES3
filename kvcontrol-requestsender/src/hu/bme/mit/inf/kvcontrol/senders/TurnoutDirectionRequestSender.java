package hu.bme.mit.inf.kvcontrol.senders;

import org.json.JSONObject;

/**
 *
 * @author benedekh
 */
public class TurnoutDirectionRequestSender extends AbstractRequestSender {

    private static final String URL_EXTENSION = "turnout/";
    private static final String DIVERGENT = "divergent";
    private static final String STRAIGHT = "straight";

    public boolean isTurnoutDivergent(int turnoutId) {
        JSONObject response = super.getGetResponse(URL_EXTENSION + String.valueOf(turnoutId));
        return DIVERGENT.equals(response.getString(RESULT_TAG).toLowerCase());
    }

    public boolean isTurnoutStraight(int turnoutId) {
        JSONObject response = super.getGetResponse(URL_EXTENSION + String.valueOf(turnoutId));
        return STRAIGHT.equals(response.getString(RESULT_TAG).toLowerCase());
    }

}
