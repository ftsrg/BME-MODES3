package hu.bme.mit.inf.kvcontrol.mqtt.client.data;

/**
 *
 * @author benedekh
 */
public class Turnout {

    private int id;
    private TurnoutStatus status;

    public Turnout(int id, TurnoutStatus status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public TurnoutStatus getStatus() {
        return this.status;
    }

}
