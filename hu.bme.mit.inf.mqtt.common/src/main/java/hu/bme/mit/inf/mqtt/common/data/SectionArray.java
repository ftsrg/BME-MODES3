package hu.bme.mit.inf.mqtt.common.data;

import com.google.gson.Gson;

/**
 * An array of Sections.
 * 
 * @author benedekh
 */
public class SectionArray implements JsonConvertible {

    // the array of Sections
    private final Section[] sections;

    /**
     * @param sections array of sections
     */
    public SectionArray(Section[] sections) {
        this.sections = sections;
    }

    /**
     * @return the array of Sections
     */
    public Section[] getSectionArray() {
        return sections;
    }

    @Override
    public String toJson() {
        return new Gson().toJson(this);
    }
}
