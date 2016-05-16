package hu.bme.mit.inf.master.bbb.conf;

import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.Turnout;

/**
 * Interface for common methods of the embedded controllers.
 *
 * @author hegyibalint, benedekh
 */
public interface IControllerConfiguration {

    /**
     * Tells whether the respective embedded controller manages the referred
     * turnout.
     *
     * @param turnout which shall be checked whether it is managed by the
     * embedded controller
     * @return true, if the respective embedded controller manages the turnout
     */
    public boolean controllerManagesTurnout(Turnout turnout);

    /**
     * Tells whether the respective embedded controller manages the referred
     * section.
     *
     * @param section which shall be checked whether it is managed by the
     * embedded controller
     * @return true, if the respective embedded controller manages the section
     */
    public boolean controllerManagesSection(Section section);
}
