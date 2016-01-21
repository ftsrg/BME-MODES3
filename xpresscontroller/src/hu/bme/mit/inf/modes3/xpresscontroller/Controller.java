package hu.bme.mit.inf.modes3.xpresscontroller;

import jmri.DccLocoAddress;
import jmri.DccThrottle;
import jmri.LocoAddress;
import jmri.ThrottleListener;
import jmri.jmrix.lenz.LenzCommandStation;
import jmri.jmrix.lenz.XNetSystemConnectionMemo;
import jmri.jmrix.lenz.XNetThrottleManager;
import jmri.jmrix.lenz.li100.LI100XNetPacketizer;
import jmri.jmrix.lenz.li100f.LI100Adapter;

public class Controller implements ThrottleListener {
	public DccThrottle taurusThrottle;
	public DccThrottle sncfThrottle;
	public DccThrottle dbagThrottle;

	public void init() {
		LenzCommandStation commandStation = new LenzCommandStation();
		LI100XNetPacketizer packetizer = new LI100XNetPacketizer(commandStation);		
		
		LI100Adapter adapter = new LI100Adapter();
		adapter.configureBaudRate("9600");
		adapter.setOptionState("FlowControl", "true");
		adapter.openPort("/dev/tty.usbmodemFD131", "MODES3");
		
		packetizer.connectPort(adapter);
		
		XNetThrottleManager throttleManager = new XNetThrottleManager(new XNetSystemConnectionMemo(packetizer));
		throttleManager.requestThrottle(new DccLocoAddress(8, false), this);
		throttleManager.requestThrottle(new DccLocoAddress(9, false), this);
		throttleManager.requestThrottle(new DccLocoAddress(10, false), this);
	}
	
	void setThrottle(LocoAddress address, DccThrottle throttle) {
		if (address.getNumber() == 8)
			sncfThrottle = throttle;
		else if (address.getNumber() == 9)
			taurusThrottle = throttle;
		else if (address.getNumber() == 10)
			dbagThrottle= throttle;
	}
	
	void setSpeed(Train train, float speed) {
		DccThrottle throttle = null;
		
		switch (train) {
		case TAURUS:
			throttle = taurusThrottle;
			break;
		case SNCF:
			throttle = sncfThrottle;
			break;
		case DBAG:
			throttle = dbagThrottle;
			break;
		default:
			break;
		}
		
		if (speed > 0.0) {
			throttle.setIsForward(true);
		} else {
			throttle.setIsForward(false);
		}
		throttle.setSpeedSetting(speed);
	}

	@Override
	public void notifyThrottleFound(DccThrottle t) {
		setThrottle(t.getLocoAddress(), t);
	}

	@Override
	public void notifyFailedThrottleRequest(DccLocoAddress address, String reason) {
		setThrottle(address, null);
	}

}
