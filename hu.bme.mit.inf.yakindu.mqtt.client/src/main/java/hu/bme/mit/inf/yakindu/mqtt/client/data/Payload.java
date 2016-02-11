package hu.bme.mit.inf.yakindu.mqtt.client.data;

import com.google.gson.Gson;

/**
 *
 * @author benedekh
 */
public class Payload {

    private final StatemachineCommand command;
    private final String content;

    public Payload(StatemachineCommand command, String content) {
        this.command = command;
        this.content = content;
    }

    public StatemachineCommand getCommand() {
        return command;
    }

    public String getContent() {
        return content;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
