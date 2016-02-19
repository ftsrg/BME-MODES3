package hu.bme.mit.inf.master.bbb.conf;

import hu.bme.mit.inf.mqtt.common.data.Identity;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.SectionArray;
import hu.bme.mit.inf.mqtt.common.data.Turnout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benedekh
 */
public class ControllerConfiguration {

    private final Turnout managedTurnout;
    private final List<Section> managedSections;

    public ControllerConfiguration() {
        this.managedTurnout = createTurnout();
        this.managedSections = createSections();
    }

    public Identity createIdentity() {
        SectionArray sections = new SectionArray(managedSections.toArray(
                new Section[managedSections.size()]));
        return new Identity(managedTurnout, sections);
    }

    public boolean controllerManagesTurnout(Turnout turnout) {
        return managedTurnout.getId() == turnout.getId();
    }

    public boolean controllerManagesSection(Section section) {
        for (Section managedSection : managedSections) {
            if (managedSection.getId() == section.getId()) {
                return true;
            }
        }
        return false;
    }

    private Turnout createTurnout() {
        String turnoutKey = "TURNOUT_ID";
        Map<String, String> env = System.getenv();

        if (!env.containsKey(turnoutKey)) {
            throw new RuntimeException(
                    "No " + turnoutKey + " environmental variable is set.");
        } else {
            String turnoutID = env.get(turnoutKey);
            int id = convertStringToInt(turnoutID);
            return new Turnout(id);
        }
    }

    private List<Section> createSections() {
        String sectionsKey = "SECTIONS";
        Map<String, String> env = System.getenv();

        if (!env.containsKey(sectionsKey)) {
            throw new RuntimeException(
                    "No " + sectionsKey + " environmental variable is set.");
        } else {
            List<Section> sections = new ArrayList<>();

            String[] sectionIDs = env.get(sectionsKey).split(";");
            for (String sectionID : sectionIDs) {
                int id = convertStringToInt(sectionID);
                sections.add(new Section(id));
            }

            return sections;
        }
    }

    /**
     * Supports both hexadecimal and decimal string representation of integers
     * to be converted to int.
     *
     * First it tries to convert as decimal representation, then as hexadecimal
     * one.
     *
     * @param number string representation of the number to be converted. (E.g.
     * 0x81 or 129)
     * @return
     */
    private int convertStringToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            try {
                return Integer.parseInt(number.substring(2), 16);
            } catch (NumberFormatException ee) {
                throw new NumberFormatException(
                        number + " cannot be converted to integer");
            }
        }
    }
}
