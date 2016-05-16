package hu.bme.mit.inf.master.bbb.prototypes;

import java.io.InputStreamReader;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import hu.bme.mit.inf.master.bbb.utils.HexConversionUtil;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.Turnout;

/**
 * Stores the actual pinout header configuration of the respective
 * BeagleBoneBlack embedded controller, based on the turnout ID.
 *
 * The actual configuration file is located at
 * src/main/resources/conf/settings.json
 *
 * @author hegyibalint
 */
public class Setting {

    /**
     * Stores the managed turnouts ID [key], and the pinout header value through
     * that turnout's status (divergent/straight) is measurable.
     */
    public Map<String, Integer> turnouts;

    /**
     * Stores the managed sections ID [key], and the pinout header value through
     * that sections are controllable.
     */
    public Map<String, Integer> sections;

    /**
     * The deserialized configuration of the pinout headers, based on the
     * turnout ID. In this way the managed turnout's and sections pinout header
     * values are deserialized so the respective actuators can be addressed.
     *
     * @param id the ID of the respective turnout (switch)
     * @return the pinout configuration
     * @throws Exception
     */
    public static Setting loadPinoutConfig(int id) throws Exception {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(
                Pinout.class.getClassLoader().getResourceAsStream(
                        "conf/settings.json")));
        JsonObject settings = gson.fromJson(reader, JsonObject.class);
        settings = settings.get("settings").getAsJsonObject();

        return gson.fromJson(settings.get(HexConversionUtil.fromNumber(id)),
                Setting.class);
    }

    /**
     * Tells whether this embedded controller manages the referred turnout.
     *
     * @param turnout that should be examined if it is managed
     * @return true if the respective turnout is managed by this embedded
     * controller
     */
    public boolean containsTurnout(Turnout turnout) {
        return turnouts.containsKey(
                HexConversionUtil.fromNumber(turnout.getId()));
    }

    /**
     * Tells whether this embedded controller manages the referred section.
     *
     * @param section that should be examined if it is managed
     * @return true if the respective section is managed by this embedded
     * controller
     */
    public boolean containsSection(Section section) {
        return sections.containsKey(
                HexConversionUtil.fromNumber(section.getId()));
    }
}
