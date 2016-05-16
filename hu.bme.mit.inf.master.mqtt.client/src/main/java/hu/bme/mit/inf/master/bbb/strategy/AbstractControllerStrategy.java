package hu.bme.mit.inf.master.bbb.strategy;

import static io.silverspoon.bulldog.core.platform.Platform.createBoard;
import static io.silverspoon.bulldog.core.util.BulldogUtil.sleepMs;

import hu.bme.mit.inf.mqtt.common.data.SectionStatus;
import hu.bme.mit.inf.mqtt.common.data.TurnoutStatus;
import io.silverspoon.bulldog.core.Signal;
import io.silverspoon.bulldog.core.gpio.DigitalInput;
import io.silverspoon.bulldog.core.gpio.DigitalOutput;
import io.silverspoon.bulldog.core.platform.Board;

/**
 * Common ancestor of the embedded controllers. High-level methods
 * (enable/disable section, get turnout/section status, set/get pin level) are
 * declared here.
 *
 * @author benedekh
 */
public abstract class AbstractControllerStrategy {

    // Detect the board we are running on
    protected static final Board board = createBoard();

    // sleep time after setting the pin value
    protected static long SLEEP_MS_AFTER_SETTING_PIN = 0;

    /**
     * Enables the referred section, so trains can move on.
     *
     * @param sectionId the ID of the section to be enabled
     */
    public synchronized void enableSection(int sectionId) {
        onEnableSection(sectionId);
    }

    /**
     * Disables the referred section, so no train can move on.
     *
     * @param sectionId the ID of the section to be disabled
     */
    public synchronized void disableSection(int sectionId) {
        onDisableSection(sectionId);
    }

    /**
     * Tells the status (enabled / disabled) of the respective section ID.
     *
     * @param sectionId the ID of the referred section
     * @return the status of the referred section
     */
    public synchronized SectionStatus getSectionStatus(int sectionId) {
        return onGetSectionStatus(sectionId);
    }

    /**
     * Tells the status (straight / divergent) of the respective turnout ID.
     *
     * @param turnoutId the ID of the referred turnout (switch)
     * @return the status of the referred turnout (switch)
     */
    public synchronized TurnoutStatus getTurnoutStatus(int turnoutId) {
        return onGetTurnoutStatus(turnoutId);
    }

    /**
     * pin is the name of the pin on the sheet:
     * https://insigntech.files.wordpress.com/2013/09/bbb_pinouts.jpg
     *
     * e.g. pin == "P8_7", then it is GPIO_22;
     *
     * Otherwise look in the io.silverspoon.bulldog.beagleboneblack.BBBNames
     * class for possible names.
     *
     * @param pin
     * @param level HIGH or LOW
     */
    protected void setPinLevel(final String pin, Signal level) {
        synchronized (board) {
            DigitalOutput output = board.getPin(pin).as(DigitalOutput.class);
            output.applySignal(level);
        }
        sleepMs(SLEEP_MS_AFTER_SETTING_PIN);
    }

    /**
     * pin is the name of the pin on the sheet:
     * https://insigntech.files.wordpress.com/2013/09/bbb_pinouts.jpg
     *
     * e.g. pin == "P8_7", then it is GPIO_22;
     *
     * Otherwise look in the io.silverspoon.bulldog.beagleboneblack.BBBNames
     * class for possible names.
     *
     * @param pin
     * @return level of the pin: HIGH or LOW
     */
    protected Signal getPinLevel(final String pin) {
        Signal value;
        synchronized (board) {
            DigitalInput input = board.getPin(pin).as(DigitalInput.class);
            value = input.read();
        }
        return value;
    }

    /**
     * The platform specific implementation of querying turnout status (straight
     * / divergent).
     *
     * @param turnoutId the ID of the turnout whose status should be queried
     * @return the status (straight / divergent) of the respective turnout
     */
    protected abstract TurnoutStatus onGetTurnoutStatus(int turnoutId);

    /**
     * The platform specific implementation of querying section status (enabled
     * / disabled).
     *
     * @param sectionId the ID of the section whose status should be queried
     * @return the status (enabled / disabled) of the respective section
     */
    protected abstract SectionStatus onGetSectionStatus(int sectionId);

    /**
     * The platform specific implementation of enabling the section.
     *
     * Enabled means any train can move on that section.
     *
     * @param sectionId the ID of the section that should be enabled
     */
    protected abstract void onEnableSection(int sectionId);

    /**
     * The platform specific implementation of disabling the section.
     *
     * Enabled means no train can move on that section.
     *
     * @param sectionId the ID of the section that should be disabled
     */
    protected abstract void onDisableSection(int sectionId);

}
