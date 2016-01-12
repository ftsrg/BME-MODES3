package hu.bme.mit.inf.kvcontrol.senders;

import org.json.JSONObject;

/**
 *
 * @author benedekh
 */
public class SectionStateRequestSender extends AbstractRequestSender {

    private static final String URL_EXTENSION = "section/";
    private static final String ENABLED = "enabled";

    public boolean isSectionEnabled(int sectionId) {
        JSONObject result = super.getGetResponse(URL_EXTENSION + String.valueOf(sectionId));
        return ENABLED.equals(result.getString(RESULT_TAG).toLowerCase());
    }

    public void enableSection(int sectionId) {
        JSONObject payload = new JSONObject().put("state", true);
        super.getPutResponse(URL_EXTENSION + String.valueOf(sectionId), payload);
    }

    public void disableSection(int sectionId) {
        JSONObject payload = new JSONObject().put("state", false);
        super.getPutResponse(URL_EXTENSION + String.valueOf(sectionId), payload);
    }

}
