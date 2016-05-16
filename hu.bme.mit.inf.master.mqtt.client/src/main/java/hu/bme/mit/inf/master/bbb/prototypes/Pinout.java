package hu.bme.mit.inf.master.bbb.prototypes;

import java.io.InputStreamReader;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

/**
 * Stores the pinout header addresses of the BeagleBone Black embedded
 * controller.
 *
 * The actual configuration file is located at
 * src/main/resources/conf/pinouts.json
 *
 * @author hegyibalint
 */
public class Pinout {

    // the pinout header addresses of the BeagleBone Black embedded controller.
    public Map<String, String[]> headers;

    /**
     * @return the pinout header configuration
     * @throws Exception if an error happens
     */
    public static Pinout loadPinoutConfig() throws Exception {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(
                Pinout.class.getClassLoader().getResourceAsStream(
                        "conf/pinouts.json")));
        JsonObject pinout = gson.fromJson(reader, JsonObject.class);

        return gson.fromJson(pinout, Pinout.class);
    }
}
