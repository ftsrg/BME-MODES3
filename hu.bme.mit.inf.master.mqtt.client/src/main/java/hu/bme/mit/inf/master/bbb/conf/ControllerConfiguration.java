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
        SectionArray sections = new SectionArray(
                (Section[]) managedSections.toArray());
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
            try {
                int id = Integer.parseInt(turnoutID);
                return new Turnout(id);
            } catch (NumberFormatException ex) {
                throw new NumberFormatException(
                        "TURNOUT_ID " + turnoutID + " cannot be converted to integer");
            }
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
                try {
                    int id = Integer.parseInt(sectionID);
                    sections.add(new Section(id));
                } catch (NumberFormatException ex) {
                    throw new NumberFormatException(
                            "SECTION_ID " + sectionID + " cannot be converted to integer");
                }
            }

            return sections;
        }
    }
}
