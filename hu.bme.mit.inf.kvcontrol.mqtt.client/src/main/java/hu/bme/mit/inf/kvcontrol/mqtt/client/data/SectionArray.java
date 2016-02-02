package hu.bme.mit.inf.kvcontrol.mqtt.client.data;

import com.google.gson.Gson;

/**
 *
 * @author benedekh
 */
public class SectionArray {

    private final Section[] sections;

    public SectionArray(Section[] sections) {
        this.sections = sections;
    }

    public Section[] getSectionArray() {
        return sections;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
