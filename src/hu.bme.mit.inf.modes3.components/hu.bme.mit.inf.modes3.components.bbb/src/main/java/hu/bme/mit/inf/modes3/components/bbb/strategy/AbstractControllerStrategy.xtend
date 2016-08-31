package hu.bme.mit.inf.modes3.components.bbb.strategy;

import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState
import io.silverspoon.bulldog.core.Signal
import io.silverspoon.bulldog.core.gpio.DigitalInput
import io.silverspoon.bulldog.core.gpio.DigitalOutput
import io.silverspoon.bulldog.core.platform.Board
import org.eclipse.xtend.lib.annotations.Accessors

import static io.silverspoon.bulldog.core.platform.Platform.createBoard
import static io.silverspoon.bulldog.core.util.BulldogUtil.sleepMs

/**
 * Common ancestor of the embedded controllers. High-level methods
 * (enable/disable section, get turnout/section status, set/get pin level) are
 * declared here.
 * 
 * @author benedekh
 */
abstract class AbstractControllerStrategy {

	// Detect the board we are running on
	@Accessors(#[PROTECTED_GETTER, PROTECTED_SETTER]) static val Board board = createBoard

	// sleep time after setting the pin value
	@Accessors(#[PROTECTED_GETTER, PROTECTED_SETTER]) static val SLEEP_MS_AFTER_SETTING_PIN = 0

	/**
	 * Enables the referred section, so trains can move on.
	 * 
	 * @param sectionId the ID of the section to be enabled
	 */
	synchronized def enableSection(int sectionId) {
		onEnableSection(sectionId)
	}

	/**
	 * Disables the referred section, so no train can move on.
	 * 
	 * @param sectionId the ID of the section to be disabled
	 */
	synchronized def disableSection(int sectionId) {
		onDisableSection(sectionId)
	}

	/**
	 * Tells the status (enabled / disabled) of the respective section ID.
	 * 
	 * @param sectionId the ID of the referred section
	 * @return the status of the referred section
	 */
	synchronized def getSectionStatus(int sectionId) {
		onGetSectionStatus(sectionId)
	}

	/**
	 * Tells the status (straight / divergent) of the respective turnout ID.
	 * 
	 * @param turnoutId the ID of the referred turnout (switch)
	 * @return the status of the referred turnout (switch)
	 */
	synchronized def getTurnoutStatus(int turnoutId) {
		onGetTurnoutStatus(turnoutId)
	}

	/**
	 * Sets the referred turnout straight.
	 * 
	 * @param turnoutId the ID of the turnout that shall be set straight
	 */
	synchronized def setTurnoutStraight(int turnoutId) {
		onSetTurnoutStraight(turnoutId)
	}

	/**
	 * Sets the referred turnout divergent.
	 * 
	 * @param turnoutId the ID of the turnout that shall be set divergent
	 */
	synchronized def setTurnoutDivergent(int turnoutId) {
		onSetTurnoutDivergent(turnoutId)
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
	protected def setPinLevel(String pin, Signal level) {
		synchronized (board) {
			val output = board.getPin(pin).^as(DigitalOutput)
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
	protected def getPinLevel(String pin) {
		var Signal value;
		synchronized (board) {
			val input = board.getPin(pin).^as(DigitalInput);
			value = input.read();
		}
		value
	}

	/**
	 * The platform specific implementation of querying turnout status (straight
	 * / divergent).
	 * 
	 * @param turnoutId the ID of the turnout whose status should be queried
	 * @return the status (straight / divergent) of the respective turnout
	 */
	protected def TurnoutState onGetTurnoutStatus(int turnoutId)

	/**
	 * The platform specific implementation of querying section status (enabled
	 * / disabled).
	 * 
	 * @param sectionId the ID of the section whose status should be queried
	 * @return the status (enabled / disabled) of the respective section
	 */
	protected def SegmentState onGetSectionStatus(int sectionId)

	/**
	 * The platform specific implementation of enabling the section.
	 * 
	 * Enabled means any train can move on that section.
	 * 
	 * @param sectionId the ID of the section that should be enabled
	 */
	protected def void onEnableSection(int sectionId)

	/**
	 * The platform specific implementation of disabling the section.
	 * 
	 * Enabled means no train can move on that section.
	 * 
	 * @param sectionId the ID of the section that should be disabled
	 */
	protected def void onDisableSection(int sectionId)

	/**
	 * The platform specific implementation of setting a turnout straight.
	 * 
	 * @param turnoutId the ID of the turnout that shall be set straight
	 */
	protected def void onSetTurnoutStraight(int turnoutId)

	/**
	 * The platform specific implementation of setting a turnout divergent.
	 * 
	 * @param turnoutId the ID of the turnout that shall be set divergent
	 */
	protected def void onSetTurnoutDivergent(int turnoutId)
}
