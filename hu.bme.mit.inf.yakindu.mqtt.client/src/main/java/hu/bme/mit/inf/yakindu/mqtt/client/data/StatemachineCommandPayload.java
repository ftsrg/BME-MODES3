package hu.bme.mit.inf.yakindu.mqtt.client.data;

import com.google.gson.Gson;

/**
 *
 * @author benedekh
 */
public class StatemachineCommandPayload {

    private final int recipientID;
    private Allowance allowance = null;

    public StatemachineCommandPayload(int recipientID) {
        this.recipientID = recipientID;
    }

    public StatemachineCommandPayload(int recipientID, Allowance allowance) {
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
