package hu.bme.mit.inf.yakindu.mqtt.client.data;

import com.google.gson.Gson;
import hu.bme.mit.inf.mqtt.common.data.JsonConvertible;

/**
 *
 * @author benedekh
 */
public class StatemachineCommandMessage implements JsonConvertible{

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

    @Override
    public String toJson() {
        return new Gson().toJson(this);
    }
}
