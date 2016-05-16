package hu.bme.mit.inf.yakindu.mqtt.client.data;

import com.google.gson.Gson;
import hu.bme.mit.inf.mqtt.common.data.JsonConvertible;

/**
 * An object that is sent between the turnouts statecharts and which stores an
 * answer (passsage allowed or denied) for a former (passage) request.
 *
 * @author benedekh
 */
public class StatemachineCommandMessage implements JsonConvertible {

    // the recipient turnout's (switch) ID
    private final int recipientID;

    // denotes whether the passage is allowed
    private Allowance allowance = null;

    /**
     * @param recipientID the recipient turnout's (switch) ID
     */
    public StatemachineCommandMessage(int recipientID) {
        this.recipientID = recipientID;
    }

    /**
     * @param recipientID the recipient turnout's (switch) ID
     * @param allowance denotes whether the passage is allowed
     */
    public StatemachineCommandMessage(int recipientID, Allowance allowance) {
        this.recipientID = recipientID;
        this.allowance = allowance;
    }

    /**
     * @return the recipient turnout's (switch) ID
     */
    public int getRecipientID() {
        return recipientID;
    }

    /**
     * @return denotes whether the passage is allowed
     */
    public Allowance getAllowance() {
        return this.allowance;
    }

    @Override
    public String toJson() {
        return new Gson().toJson(this);
    }
}
