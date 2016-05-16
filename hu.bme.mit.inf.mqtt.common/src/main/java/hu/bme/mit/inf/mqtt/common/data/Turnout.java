package hu.bme.mit.inf.mqtt.common.data;

import com.google.gson.Gson;

/**
 * A turnout (switch) status (straight / divergent).
 *
 * Straight means the switch connects the straight and the top sections.
 * Divergent means the switch connects the divergent and the top sections.
 *
 * @author benedekh
 */
public class Turnout implements JsonConvertible {

    // the ID of the referred switch
    private final int id;

    // the status of the referred switch
    private TurnoutStatus status;

    /**
     * @param id of the referred switch
     */
    public Turnout(int id) {
        this(id, null);
    }

    /**
     * @param id of the referred switch
     * @param status of the referred switch
     */
    public Turnout(int id, TurnoutStatus status) {
        this.id = id;
        this.status = status;
    }

    /**
     * @return the ID of the referred switch
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return the status of the referred switch
     */
    public TurnoutStatus getStatus() {
        return this.status;
    }

    /**
     * @param status new status (straight / divergent) of the referred switch
     */
    public void setStatus(TurnoutStatus status) {
        this.status = status;
    }

    @Override
    public String toJson() {
        return new Gson().toJson(this);
    }

}
