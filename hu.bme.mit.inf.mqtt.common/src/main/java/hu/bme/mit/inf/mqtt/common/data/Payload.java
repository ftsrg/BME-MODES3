package hu.bme.mit.inf.mqtt.common.data;

import com.google.gson.Gson;

/**
 *
 * @author benedekh
 */
public class Payload {

    private final Command command;
    private final String content;

    public Payload(Command command, String content) {
        this.command = command;
        this.content = content;
    }

    public Command getCommand() {
        return command;
    }

    public String getContent() {
        return content;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
