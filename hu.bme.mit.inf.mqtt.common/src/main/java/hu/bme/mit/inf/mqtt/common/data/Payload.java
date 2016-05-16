package hu.bme.mit.inf.mqtt.common.data;

import com.google.gson.Gson;

/**
 * Stores a command, and the content of the payload.
 *
 * The content is usually a json object serialized as a string.
 *
 * @author benedekh
 */
public class Payload implements JsonConvertible {

    // a command that refers to the content
    private final Command command;

    // a json object serialized as a string
    private final String content;

    /**
     * @param command that refers to the content
     * @param content a json object serialized as a string
     */
    public Payload(Command command, String content) {
        this.command = command;
        this.content = content;
    }

    /**
     * @return a json object serialized as a string
     */
    public Command getCommand() {
        return command;
    }

    /**
     * Converts the json serialized content to a Java object (@see objects that
     * are transferred through the network as string serialized json objects).
     *
     * @param <T> {@link hu.bme.mit.inf.mqtt.common.data}
     * @param cls class that denotes a class and the json serialized content
     * conforms it
     * @return the json serialized content as a Java object
     */
    public <T> T getContentAs(Class<T> cls) {
        return new Gson().fromJson(content, cls);
    }

    @Override
    public String toJson() {
        return new Gson().toJson(this);
    }
}
