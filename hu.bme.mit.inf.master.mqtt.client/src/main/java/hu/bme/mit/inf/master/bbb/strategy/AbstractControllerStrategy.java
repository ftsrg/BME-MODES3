package hu.bme.mit.inf.master.bbb.strategy;

import static io.silverspoon.bulldog.core.platform.Platform.createBoard;
import static io.silverspoon.bulldog.core.util.BulldogUtil.sleepMs;

import hu.bme.mit.inf.mqtt.common.data.SectionStatus;
import hu.bme.mit.inf.mqtt.common.data.TurnoutStatus;
import io.silverspoon.bulldog.core.Signal;
import io.silverspoon.bulldog.core.gpio.DigitalInput;
import io.silverspoon.bulldog.core.gpio.DigitalOutput;
import io.silverspoon.bulldog.core.platform.Board;

public abstract class AbstractControllerStrategy {

    // Detect the board we are running on
    protected static final Board board = createBoard();

    protected static long SLEEP_MS_AFTER_SETTING_PIN = 0;

    public synchronized void enableSection(int sectionId) {
        onEnableSection(sectionId);
    }

    public synchronized void disableSection(int sectionId) {
        onDisableSection(sectionId);
    }

    public synchronized SectionStatus getSectionStatus(int sectionId) {
        return onGetSectionStatus(sectionId);
    }

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

    protected abstract TurnoutStatus onGetTurnoutStatus(int turnoutId);

    protected abstract SectionStatus onGetSectionStatus(int sectionId);

    protected abstract void onEnableSection(int sectionId);

    protected abstract void onDisableSection(int sectionId);

}
