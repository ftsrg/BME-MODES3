package hu.bme.mit.inf.master.bbb.conf;

import java.util.Map;
import java.util.Set;

import hu.bme.mit.inf.master.bbb.prototypes.Pinout;
import hu.bme.mit.inf.master.bbb.prototypes.Setting;
import hu.bme.mit.inf.master.bbb.utils.HexConversionUtil;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.Turnout;

public class ExpanderControllerConfiguration implements IControllerConfiguration {

    Pinout pinout;
    Setting setting;

    public ExpanderControllerConfiguration() throws Exception {
        Map<String, String> env = System.getenv();
        if (!env.containsKey("TURNOUT_ID")) {
            throw new RuntimeException(
                    "There is no TURNOUT_ID environmental variable defined");
        }
        int controllerID = HexConversionUtil.fromString(env.get("TURNOUT_ID"));

        pinout = Pinout.loadPinoutConfig();
        setting = Setting.loadPinoutConfig(controllerID);
    }

    @Override
    public boolean controllerManagesTurnout(Turnout turnout) {
        return setting.containsTurnout(turnout);
    }

    @Override
    public boolean controllerManagesSection(Section section) {
        return setting.containsSection(section);
    }

    public Set<String> getAllTurnout() {
        return setting.turnouts.keySet();
    }

    public Set<String> getAllSection() {
        return setting.sections.keySet();
    }

    public String[] getSectionExpander(int sectionId) {
        int expander = setting.sections.get(HexConversionUtil.fromNumber(
                sectionId));
        String[] ret = pinout.headers.get(String.valueOf(expander));
        return ret;
    }

    public String[] getTurnoutExpander(String turnoutId) {
        int expander = setting.turnouts.get(turnoutId);
        String[] ret = pinout.headers.get(String.valueOf(expander));
        return ret;
    }

}
