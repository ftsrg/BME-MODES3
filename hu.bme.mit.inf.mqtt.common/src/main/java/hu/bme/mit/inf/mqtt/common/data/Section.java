package hu.bme.mit.inf.mqtt.common.data;

import com.google.gson.Gson;

/**
 * A section whose occupancy status (occupied / free) and (normal) status
 * (disabled / enabled) is stored.
 *
 * Disabled means no train can move on that section. Enabled means anyone can go
 * on that section.
 *
 * @author benedekh
 */
public class Section implements JsonConvertible {

    // the ID of the referred section
    private final int id;

    // the status (disabled / enabled) of the section
    private SectionStatus status = null;

    // the occupancy status (occupied / free) of the section
    private SectionOccupancyStatus occupancyStatus = null;

    /**
     * @param id of the section
     */
    public Section(int id) {
        this.id = id;
    }

    /**
     * @param id of the section
     * @param status the status (disabled / enabled) of the section
     */
    public Section(int id, SectionStatus status) {
        this.id = id;
        this.status = status;
    }

    /**
     * @param id of the section
     * @param occupancyStatus the occupancy status (occupied / free) of the
     * section
     */
    public Section(int id, SectionOccupancyStatus occupancyStatus) {
        this.id = id;
        this.occupancyStatus = occupancyStatus;
    }

    /**
     * @return the ID of the referred section
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return the status (disabled / enabled) of the referred section
     */
    public SectionStatus getStatus() {
        return this.status;
    }

    /**
     * @return the occupancy status (occupied / free) of the referred section
     */
    public SectionOccupancyStatus getOccupancyStatus() {
        return this.occupancyStatus;
    }

    /**
     * @param status the new status (disabled / enabled) of the referred
     * section.
     */
    public void setStatus(SectionStatus status) {
        this.status = status;
    }

    @Override
    public String toJson() {
        return new Gson().toJson(this);
    }
}
