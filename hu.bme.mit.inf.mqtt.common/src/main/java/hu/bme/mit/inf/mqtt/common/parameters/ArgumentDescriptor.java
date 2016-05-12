package hu.bme.mit.inf.mqtt.common.parameters;

/**
 *
 * @author benedekh
 */
public class ArgumentDescriptor<T>{

    private final String name;
    private final String description;
    private Class<T> type;

    public ArgumentDescriptor(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ArgumentDescriptor(String name, String description,
            Class<T> type) {
        this(name, description);
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Class<T> getType() {
        return type;
    }

}
