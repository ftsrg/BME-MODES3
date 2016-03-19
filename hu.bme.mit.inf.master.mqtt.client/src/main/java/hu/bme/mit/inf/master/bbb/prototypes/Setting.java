package hu.bme.mit.inf.master.bbb.prototypes;

import java.io.InputStreamReader;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import hu.bme.mit.inf.master.bbb.utils.HexConversionUtil;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.Turnout;

public class Setting {

    public Map<String, Integer> turnouts;
    public Map<String, Integer> sections;

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

    public boolean containsTurnout(Turnout turnout) {
        return turnouts.containsKey(
                HexConversionUtil.fromNumber(turnout.getId()));
    }

    public boolean containsSection(Section section) {
        return sections.containsKey(
                HexConversionUtil.fromNumber(section.getId()));
    }
}
