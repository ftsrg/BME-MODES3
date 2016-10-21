package hu.bme.mit.inf.modes3.components.dashboard.service;

import javax.inject.Inject;
import javax.swing.SwingWorker.StateValue;

import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.PathParam;
import org.atmosphere.cpr.MetaBroadcaster;
import org.slf4j.Logger;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import hu.bme.mit.inf.modes3.components.dashboard.main.DashboardManager;
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy;
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState;
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState;
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentOccupancyChangeListener;
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentStateChangeListener;
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITurnoutStateChangeListener;
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentOccupancyValue;
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue;

import static hu.bme.mit.inf.modes3.components.dashboard.utils.ResourceUtils.*;

@ManagedService(path = "/ws/state/{source}")
public class StateChangeService implements ISegmentOccupancyChangeListener, ITurnoutStateChangeListener, ISegmentStateChangeListener {
	
	Logger logger = DashboardManager.INSTANCE.getLoggerFactory().getLogger(StateChangeService.class.getName());
	
	@Inject
	protected MetaBroadcaster metaBroadcaster;
	
	@PathParam("source")
	protected String source;
	
	hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentOccupancy.Builder segmentOccBuilder;
	hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentState.Builder segmentStateBuilder;
	hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutState.Builder turnoutStateBuilder;
	
	public StateChangeService() {
		DashboardManager.INSTANCE.getLocator().getTrackElementStateRegistry().setSegmentOccupancyChangeListener(this);
		DashboardManager.INSTANCE.getLocator().getTrackElementStateRegistry().setSegmentStateChangeListener(this);
		DashboardManager.INSTANCE.getLocator().getTrackElementStateRegistry().setTurnoutStateChangeListener(this);
		segmentOccBuilder = hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentOccupancy.newBuilder();
		segmentStateBuilder = hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentState.newBuilder();
		turnoutStateBuilder = hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutState.newBuilder();
	}
	
	@Override
	public void onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
		String occupancyAsJson;
		try {
			occupancyAsJson = JsonFormat.printer().print(segmentOccBuilder.clear()
					.setSegmentID(id)
					.setState(SegmentOccupancyValue.valueOf(newValue.name())));
					metaBroadcaster.broadcastTo("/ws/state/" + SEGMENT_OCCUPACY, occupancyAsJson);
		} catch (InvalidProtocolBufferException e) {
			logger.error("Unable to convert & push segment occupancy message " + e.getMessage());
		}
	}

	@Override
	public void onSegmentStateChange(int id, SegmentState oldValue, SegmentState newValue ) {
		String stateAsJson;
		try {
			stateAsJson = JsonFormat.printer().print(segmentStateBuilder.clear()
					.setSegmentID(id)
					.setState(SegmentStateValue.valueOf(newValue.name())).build());
					metaBroadcaster.broadcastTo("/ws/state/" + SEGMENT_STATE, stateAsJson);
			logger.info("segment old state: "+oldValue.toString()+", new state: "+newValue.toString());
		} catch (InvalidProtocolBufferException e) {
			logger.error("Unable to convert & push turnout state message " + e.getMessage());
		}
	}

	@Override
	public void onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
		String stateAsJson;
		try {
			stateAsJson = JsonFormat.printer().print(turnoutStateBuilder.clear()
					.setTurnoutID(id)
					.setState(TurnoutStateValue.valueOf(newValue.name())));
					metaBroadcaster.broadcastTo("/ws/state/" + TURNOUT_STATE, stateAsJson);
		} catch (InvalidProtocolBufferException e) {
			logger.error("Unable to convert & push turnout state message " + e.getMessage());
		}
	}
	
}
