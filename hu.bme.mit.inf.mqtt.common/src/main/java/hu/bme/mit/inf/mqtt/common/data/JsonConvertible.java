package hu.bme.mit.inf.mqtt.common.data;

/**
 * Convert the referred object to Json String format.
 *
 * @author benedekh
 */
public interface JsonConvertible {

    /**
     * Convert the referred object to Json String format.
     *
     * @return the json string serialized version of the object
     */
    public String toJson();
}
