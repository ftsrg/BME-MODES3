package hu.bme.mit.inf.master.bbb.prototypes;

import java.io.InputStreamReader;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class Pinout {

    public Map<String, String[]> headers;

    public static Pinout loadPinoutConfig() throws Exception {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(
                Pinout.class.getClassLoader().getResourceAsStream(
                        "conf/pinouts.json")));
        JsonObject pinout = gson.fromJson(reader, JsonObject.class);

        return gson.fromJson(pinout, Pinout.class);
    }
}
