package hu.bme.mit.inf.kvcontrol.mqtt.client.data;

import com.google.gson.Gson;

/**
 *
 * @author benedekh
 */
public class Section {

    private final int id;
    private SectionStatus status = null;
    private SectionOccupancyStatus occupancyStatus = null;

    public Section(int id) {
        this.id = id;
    }

    public Section(int id, SectionStatus status) {
        this.id = id;
        this.status = status;
    }

    public Section(int id, SectionOccupancyStatus occupancyStatus) {
        this.id = id;
        this.occupancyStatus = occupancyStatus;
    }

    public int getId() {
        return this.id;
    }

    public SectionStatus getStatus() {
        return this.status;
    }

    public SectionOccupancyStatus getOccupancyStatus() {
        return this.occupancyStatus;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
