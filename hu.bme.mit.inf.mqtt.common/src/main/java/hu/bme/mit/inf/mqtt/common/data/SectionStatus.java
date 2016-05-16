package hu.bme.mit.inf.mqtt.common.data;

/**
 * Denotes the section's status. 
 * 
 * Disabled means no train can move on that section. Enabled means anyone can go
 * on that section.
 * 
 * @author benedekh
 */
public enum SectionStatus {

    ENABLED, DISABLED;
}
