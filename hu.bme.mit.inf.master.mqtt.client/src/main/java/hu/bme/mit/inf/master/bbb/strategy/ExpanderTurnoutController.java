package hu.bme.mit.inf.master.bbb.strategy;

import hu.bme.mit.inf.master.bbb.conf.ExpanderControllerConfiguration;
import hu.bme.mit.inf.master.bbb.conf.IControllerConfiguration;
import hu.bme.mit.inf.master.bbb.utils.HexConversionUtil;
import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_TURNOUT_STATUS;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.SectionStatus;
import hu.bme.mit.inf.mqtt.common.data.Turnout;
import hu.bme.mit.inf.mqtt.common.data.TurnoutStatus;
import static hu.bme.mit.inf.mqtt.common.data.TurnoutStatus.STRAIGHT;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.createCommandWithContent;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import io.silverspoon.bulldog.core.Signal;
import io.silverspoon.bulldog.core.gpio.DigitalInput;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author benedekh
 */
public class ExpanderTurnoutController extends AbstractControllerStrategy implements IControllerConfiguration {

    protected Thread turnoutDirectionUpdater;
    protected ExpanderControllerConfiguration controllerConf;
    protected String subscribedTopic;

    protected Map<String, TurnoutStatus> latestTurnoutStatus;
    protected Map<String, TurnoutStatus> formerTurnoutStatus;

    public ExpanderTurnoutController(final MQTTPublishSubscribeDispatcher mqttPublisher,
            String topic) {
        try {
            controllerConf = new ExpanderControllerConfiguration();
        } catch (Exception ex) {
            logException(getClass().getName(), ex);
        }

        subscribedTopic = topic;

        latestTurnoutStatus = new ConcurrentHashMap<>();
        formerTurnoutStatus = new ConcurrentHashMap<>();

        for (String to : controllerConf.getAllTurnout()) {
            TurnoutStatus defaultDirection = STRAIGHT;
            latestTurnoutStatus.put(to, defaultDirection);
            formerTurnoutStatus.put(to, defaultDirection);
            publishTurnoutStatus(to, defaultDirection, mqttPublisher);
        }

        // turnout direction updater
        turnoutDirectionUpdater = new Thread(new Runnable() {
            @Override
            public void run() {
                updateTurnoutDirection(mqttPublisher);
            }
        });

        turnoutDirectionUpdater.start();
    }

    @Override
    protected TurnoutStatus onGetTurnoutStatus(int turnoutId) {
        return latestTurnoutStatus.get(HexConversionUtil.fromNumber(turnoutId));
    }

    @Override
    public boolean controllerManagesTurnout(Turnout turnout) {
        return controllerConf.controllerManagesTurnout(turnout);
    }

    @Override
    protected SectionStatus onGetSectionStatus(int sectionId) {
        throw new UnsupportedOperationException(
                "ExpanderTurnoutController does not support section operations");
    }

    @Override
    protected void onEnableSection(int sectionId) {
        throw new UnsupportedOperationException(
                "ExpanderTurnoutController does not support section operations");
    }

    @Override
    protected void onDisableSection(int sectionId) {
        throw new UnsupportedOperationException(
                "ExpanderTurnoutController does not support section operations");
    }

    @Override
    public boolean controllerManagesSection(Section section) {
        throw new UnsupportedOperationException(
                "ExpanderTurnoutController does not support section operations");
    }

    public List<Turnout> getTurnoutsWithStatus() {
        List<Turnout> results = new ArrayList<>();
        for (String turnoutId : latestTurnoutStatus.keySet()) {
            Turnout turnout = new Turnout(
                    HexConversionUtil.fromString(turnoutId));
            turnout.setStatus(latestTurnoutStatus.get(turnoutId));
            results.add(turnout);
        }
        return results;
    }

    private void updateTurnoutDirection(MQTTPublishSubscribeDispatcher mqttPublisher) {
        HashMap<String, DigitalInput> ioMap = new HashMap<>(4);

        for (String to : controllerConf.getAllTurnout()) {
            String[] pins = controllerConf.getTurnoutExpander(to);
            ioMap.put(pins[0], board.getPin(pins[0]).as(DigitalInput.class));
            ioMap.put(pins[1], board.getPin(pins[1]).as(DigitalInput.class));
        }

        while (!Thread.interrupted()) {
            for (String to : controllerConf.getAllTurnout()) {
                String[] pins = controllerConf.getTurnoutExpander(to);

                if (ioMap.get(pins[0]).read() == Signal.High) {
                    latestTurnoutStatus.put(to, TurnoutStatus.STRAIGHT);
                }
                if (ioMap.get(pins[1]).read() == Signal.High) {
                    latestTurnoutStatus.put(to, TurnoutStatus.DIVERGENT);
                }

                TurnoutStatus latest = latestTurnoutStatus.get(to);
                TurnoutStatus former = formerTurnoutStatus.get(to);

                if (latest != former) {
                    formerTurnoutStatus.put(to, latest);
                    publishTurnoutStatus(to, latest, mqttPublisher);
                }
            }

            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                logException(getClass().getName(), e);
                Thread.currentThread().interrupt();
            }
        }
    }

    private void publishTurnoutStatus(String id, TurnoutStatus status,
            MQTTPublishSubscribeDispatcher mqttPublisher) {
        Turnout turnout = new Turnout(HexConversionUtil.fromString(id));
        turnout.setStatus(status);
        Payload payload = createCommandWithContent(SEND_TURNOUT_STATUS, turnout);
        mqttPublisher.publishMessage(payload, subscribedTopic);
    }

}
