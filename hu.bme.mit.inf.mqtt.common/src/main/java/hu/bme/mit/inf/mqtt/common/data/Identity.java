package hu.bme.mit.inf.mqtt.common.data;

import com.google.gson.Gson;

/**
 *
 * @author benedekh
 */
public class Identity implements JsonConvertible {

    private final Turnout turnout;
    private final SectionArray sections;

    public Identity(Turnout turnout, SectionArray sections) {
        this.turnout = turnout;
        this.sections = sections;
    }

    public Turnout getTurnout() {
        return this.turnout;
    }

    public SectionArray getSections() {
        return this.sections;
    }

    @Override
    public String toJson() {
        return new Gson().toJson(this);
    }
}
