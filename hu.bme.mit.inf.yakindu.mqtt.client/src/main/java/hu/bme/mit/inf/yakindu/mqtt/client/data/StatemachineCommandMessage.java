package hu.bme.mit.inf.yakindu.mqtt.client.data;

import com.google.gson.Gson;

/**
 *
 * @author benedekh
 */
public class StatemachineCommandMessage {

    private final int recipientID;
    private Allowance allowance = null;

    public StatemachineCommandMessage(int recipientID) {
        this.recipientID = recipientID;
    }

    public StatemachineCommandMessage(int recipientID, Allowance allowance) {
        this.recipientID = recipientID;
        this.allowance = allowance;
    }

    public int getRecipientID() {
        return recipientID;
    }

    public Allowance getAllowance() {
        return this.allowance;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
