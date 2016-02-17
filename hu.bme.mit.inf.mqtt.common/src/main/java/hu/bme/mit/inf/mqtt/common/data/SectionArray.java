package hu.bme.mit.inf.mqtt.common.data;

import com.google.gson.Gson;

/**
 *
 * @author benedekh
 */
public class SectionArray implements JsonConvertible {

    private final Section[] sections;

    public SectionArray(Section[] sections) {
        this.sections = sections;
    }

    public Section[] getSectionArray() {
        return sections;
    }

    @Override
    public String toJson() {
        return new Gson().toJson(this);
    }
}
