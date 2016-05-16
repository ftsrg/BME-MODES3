package hu.bme.mit.inf.mqtt.common.data;

import com.google.gson.Gson;

/**
 * An identify object.
 *
 * @author benedekh
 */
public class Identity implements JsonConvertible {

    // referred turnout (switch)
    private final Turnout turnout;

    // referred sections array
    private final SectionArray sections;

    /**
     * @param turnout referred turnout (switch)
     * @param sections referred sections array
     */
    public Identity(Turnout turnout, SectionArray sections) {
        this.turnout = turnout;
        this.sections = sections;
    }

    /**
     * @return the referred turnout (switch)
     */
    public Turnout getTurnout() {
        return this.turnout;
    }

    /**
     * @return referred sections array
     */
    public SectionArray getSections() {
        return this.sections;
    }

    @Override
    public String toJson() {
        return new Gson().toJson(this);
    }
}
