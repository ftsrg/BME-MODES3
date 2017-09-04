package hu.bme.mit.inf.modes3.components.dashboard.service;

import java.util.List;

import javax.inject.Inject;

import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Message;
import org.atmosphere.config.service.Singleton;
import org.atmosphere.cpr.MetaBroadcaster;

import hu.bme.mit.inf.modes3.components.dashboard.main.DashboardManager;
import hu.bme.mit.inf.modes3.components.dashboard.utils.Utils;
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateRegistry;
import hu.bme.mit.inf.modes3.messaging.communication.trainreferencespeed.TrainReferenceSpeedState;
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy;
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState;
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection;
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState;;

@Singleton
@ManagedService(path = "/ws/allstate")
public class AllStateHandlerService {

	@Inject
	protected MetaBroadcaster metaBroadcaster;

	@Message
	public void onMessage(String message) {
		System.out.println("State change service: " + message);

		System.out.println("Requesting all state information...");

		// sending information about segments
		ITrackElementStateRegistry registry = DashboardManager.INSTANCE.getLocator().getTrackElementStateRegistry();
		List<Integer> segments = registry.getSegments();
		for (Integer s : segments) {
			SegmentState state = registry.getSegmentState(s);
			Utils.sendSegmentStateChange(metaBroadcaster, s, state);
		}

		// sending information about occupancy
		for (Integer s : segments) {
			SegmentOccupancy occupancy = registry.getSegmentOccupancy(s);
			Utils.sendSegmentOccupancyStateChange(metaBroadcaster, s, occupancy);
		}

		// sending information about turnout positions
		List<Integer> turnouts = registry.getTurnouts();
		for (Integer t : turnouts) {
			TurnoutState state = registry.getTurnoutState(t);
			Utils.sendTurnutStateChange(metaBroadcaster, t, state);
		}

		// sending information about train speeds
		TrainReferenceSpeedState referenceSpeedState = DashboardManager.INSTANCE.getLocator()
				.getTrainReferenceSpeedState();
		List<Integer> addresses = referenceSpeedState.getTrainAddresses();
		for (Integer id : addresses) {
			TrainDirection direction = referenceSpeedState.getDirection(id);
			Integer speed = referenceSpeedState.getSpeed(id);
			Utils.sendTrainReferenceSpeedChange(metaBroadcaster, id, speed, direction);
		}
	}

}
