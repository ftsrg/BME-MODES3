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
    
    public void setId(int id) {
    	this.id = id;
    }

    public SectionStatus getStatus() {
        return this.status;
    }
    
    public void setStatus(SectionStatus status) {
        this.status = status;
    }
    
}
