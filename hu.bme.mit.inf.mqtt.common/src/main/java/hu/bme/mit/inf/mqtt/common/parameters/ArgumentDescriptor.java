package hu.bme.mit.inf.mqtt.common.parameters;

/**
 * A descriptor class which stores the (command-line) argument's name,
 * description, and type (e.g. String.class, Integer.class).
 *
 * @author benedekh
 */
public class ArgumentDescriptor<T> {

    // the name of the argument
    private final String name;

    // a description for the argument
    private final String description;

    // type of the argument (e.g. String.class, Integer.class)
    private Class<T> type;

    /**
     * @param name name of the argument
     * @param description description for the argument
     */
    public ArgumentDescriptor(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * @param name name of the argument
     * @param description description for the argument
     * @param type type of the argument
     */
    public ArgumentDescriptor(String name, String description,
            Class<T> type) {
        this(name, description);
        this.type = type;
    }

    /**
     * @return the name of the argument
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description of the argument
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the type of the argument
     */
    public Class<T> getType() {
        return type;
    }

}
