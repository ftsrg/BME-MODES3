package hu.bme.mit.inf.mqtt.common.data;

/**
 * Denotes a turnout (switch) status.
 *
 * Straight means the switch connects the straight and the top sections.
 * Divergent means the switch connects the divergent and the top sections.
 *
 * @author benedekh
 */
public enum TurnoutStatus {

    DIVERGENT, STRAIGHT;
}
