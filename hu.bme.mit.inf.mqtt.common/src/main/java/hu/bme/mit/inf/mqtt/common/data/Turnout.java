package hu.bme.mit.inf.mqtt.common.data;

import com.google.gson.Gson;

/**
 *
 * @author benedekh
 */
public class Turnout {

    private final int id;
    private final TurnoutStatus status;

    public Turnout(int id) {
        this(id, null);
    }

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

    public String toJson() {
        return new Gson().toJson(this);
    }

}
