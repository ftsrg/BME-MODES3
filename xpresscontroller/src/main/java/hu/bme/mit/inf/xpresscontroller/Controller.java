package hu.bme.mit.inf.xpresscontroller;

import java.util.HashMap;

import jmri.DccLocoAddress;
import jmri.DccThrottle;
import jmri.Throttle;
import jmri.ThrottleListener;
import jmri.jmrix.lenz.LenzCommandStation;
import jmri.jmrix.lenz.XNetSystemConnectionMemo;
import jmri.jmrix.lenz.XNetThrottleManager;
import jmri.jmrix.lenz.XNetTurnoutManager;
import jmri.jmrix.lenz.li100.LI100XNetPacketizer;
import jmri.jmrix.lenz.li100f.LI100Adapter;

public class Controller implements ThrottleListener {
	HashMap<Train, DccThrottle> trainThrottles = new HashMap<Train, DccThrottle>();
	HashMap<Turnout, jmri.Turnout> turnoutCommander = new HashMap<Turnout, jmri.Turnout>();

	public void init() throws InterruptedException {
		LenzCommandStation commandStation = new LenzCommandStation();
		LI100XNetPacketizer packetizer = new LI100XNetPacketizer(commandStation);

		LI100Adapter adapter = new LI100Adapter();
		adapter.configureBaudRate("9600");
		adapter.setOptionState("FlowControl", "true");
		adapter.openPort("/dev/tty.usbmodemFD131", "MODES3");

		packetizer.connectPort(adapter);

		XNetThrottleManager throttleManager = new XNetThrottleManager(new XNetSystemConnectionMemo(packetizer));
		XNetTurnoutManager turnoutManager = new XNetTurnoutManager(packetizer, "");

		for (Train t : Train.values()) {
			throttleManager.requestThrottle(new DccLocoAddress(t.getAddress(), false), this);
		}

		for (Turnout t : Turnout.values()) {
			String name = t.getAddress();
			jmri.Turnout turnout = turnoutManager.newTurnout(name, name);
			turnoutCommander.put(t, turnout);
		}
	}

	public void setSpeed(Train train, float speed) {
		Throttle throttle = trainThrottles.get(train);

		if (speed > 0.0) {
			throttle.setIsForward(true);
		} else {
			throttle.setIsForward(false);
		}
		throttle.setSpeedSetting(speed);
	}
	
	public void setTurnout(String id, boolean straight) {
		jmri.Turnout turnout = turnoutCommander.get(id);
		
		int command = straight ? jmri.Turnout.CLOSED : jmri.Turnout.THROWN;
		turnout.setCommandedState(command);
	}

	public void notifyThrottleFound(DccThrottle throttle) {
		for (Train train : Train.values()) {
			if (train.getAddress() == throttle.getLocoAddress().getNumber()) {
				trainThrottles.put(train, throttle);
			}
		}
	}

	public void notifyFailedThrottleRequest(DccLocoAddress address, String reason) {
		for (Train train : Train.values()) {
			if (train.getAddress() == address.getNumber()) {
				trainThrottles.put(train, null);
			}
		}
	}

}
