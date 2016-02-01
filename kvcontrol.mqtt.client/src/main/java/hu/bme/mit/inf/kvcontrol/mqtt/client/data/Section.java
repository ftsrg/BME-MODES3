package hu.bme.mit.inf.kvcontrol.mqtt.client.data;

/**
 *
 * @author benedekh
 */
public class Section {

    private int id;
    private SectionStatus status;

    public Section(int id, SectionStatus status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public SectionStatus getStatus() {
        return this.status;
    }
}
