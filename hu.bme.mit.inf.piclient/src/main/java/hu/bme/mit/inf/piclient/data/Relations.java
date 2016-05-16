package hu.bme.mit.inf.piclient.data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.Turnout;

/**
 * A data class for storing sections and turnouts of the layout
 *
 * @author zsoltmazlo, benedekh
 */
public class Relations {

    /**
     * All sections' ID and the responsible controller they belong are storedW
     * here.
     */
    private static final ConcurrentMap<String, Section> sections = new ConcurrentHashMap<>();

    /**
     * All turnouts' ID and the responsible controller they belong are stored
     * here.
     */
    private static final ConcurrentMap<String, Turnout> turnouts = new ConcurrentHashMap<>();

    /**
     * Get Map of turnout and the responsible controller they belong to.
     *
     * @return a Map of turnouts
     */
    public static synchronized ConcurrentMap<String, Turnout> getTurnouts() {
        if (turnouts.isEmpty()) {
            int[][] turnoutRaw = {
                {0x81, 0x81},
                {0x82, 0x82},
                {0x83, 0x83},
                {0x84, 0x84},
                {0x85, 0x85},
                {0x86, 0x86},
                {0x87, 0x86}
            };
            for (int i = 0; i < turnoutRaw.length; ++i) {
                turnouts.put(getKey(turnoutRaw[i][0]),
                        new Turnout(turnoutRaw[i][0]));
            }
        }
        return turnouts;
    }

    /**
     * Get Map of sections and the responsible controller they belong to.
     *
     * @return a Map of sections
     */
    public static synchronized ConcurrentMap<String, Section> getSections() {
        if (sections.isEmpty()) {
            int[][] sectionsRaw = {
                {0x01, 0x81},
                {0x02, 0x82},
                {0x03, 0x83},
                {0x04, 0x86},
                {0x05, 0x84},
                {0x06, 0x85},
                {0x08, 0x83},
                {0x09, 0x81},
                {0x0A, 0x84},
                {0x0B, 0x83},
                {0x0C, 0x82},
                {0x0D, 0x81},
                {0x0E, 0x86},
                {0x0F, 0x82},
                {0x10, 0x86},
                {0x11, 0x84},
                {0x13, 0x85},
                {0x14, 0x85},
                {0x15, 0x86},
                {0x16, 0x86},
                {0x17, 0x83}
            };
            for (int i = 0; i < sectionsRaw.length; ++i) {
                sections.put(getKey(sectionsRaw[i][0]),
                        new Section(sectionsRaw[i][0]));
            }
        }
        return sections;
    }

    /**
     * create a usable key for Map classes from byte ID.
     *
     * @param ID hashable ID
     * @return String hash
     */
    public static String getKey(int ID) {
        return String.format("0x%02X", ID);
    }
}
