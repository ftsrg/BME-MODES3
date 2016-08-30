package hu.bme.mit.inf.modes3.components.bbb.handlers;

import hu.bme.mit.inf.modes3.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.bbb.utils.TurnoutStatus
import java.util.Map.Entry
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * The message handler of turnout related commands received on the subscribed
 * topic. This class transmits the received turnout commands to the actual
 * actuators, so the respective turnouts statuses can be queried.
 *
 * It is a proxy between the MQTT communication and the embedded controller.
 *
 * @author benedekh, hegyibalint
 */
class TurnoutMessageHandler {

    // the actuator that can access the referred turnout
    @Accessors(PRIVATE_GETTER, PRIVATE_SETTER) final ExpanderTurnoutController turnoutController

    new() {
        turnoutController = new ExpanderTurnoutController    
    }

    /**
     * Handles the identity queries. It means the managed turnouts statuses
     * should be transmitted to the subscribed topic.
     *
     * @throws InterruptedException if the thread has been interrupted
     */
    private def handleIdentify(){
        val turnouts = turnoutController.getTurnoutsWithStatus
        for (Entry<String, TurnoutStatus> turnout : turnouts) {
      		// TODO publish status messages
			// sender.publishMessage(payload, topic);
        }
    }

    /**
     * If the embedded controller manages the referred turnout (that is received
     * in the Payload), then its status will be queried and sent back on the
     * subscribed topic.
     *
     * @param receivedPayload the payload that stores the turnout's ID whose
     * status should be queried
     */
    private def handleGetTurnoutStatus() {
        /*Turnout turnout = receivedPayload.getContentAs(Turnout.class);
        if (turnoutController.controllerManagesTurnout(turnout)) {
            logInfoMessage(CLASS_NAME,
                    "turnout status query received");

            TurnoutStatus status = turnoutController.getTurnoutStatus(
                    turnout.getId());
            turnout.setStatus(status);
            Payload payload = createCommandWithContent(SEND_TURNOUT_STATUS,
                    turnout);
            sender.publishMessage(payload, topic);
        }*/
    }

}
