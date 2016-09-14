package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.IYakinduMessageHandler;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public abstract class AbstractYakinduStatechartComponent implements IYakinduMessageHandler {

	private static final Logger logger = LoggerFactory.getLogger(AbstractYakinduStatechartComponent.class);

	protected Map<Integer, Object> ids = new TreeMap<>();
	
	public Set<Integer> getLocalSegmentIDs(){
		return ids.keySet();
	}
	
	public void setTrainDirection(int targetID, TrainDirection direction){
		Object target = ids.get(targetID);
		if (target instanceof SectionComponent) {
			SectionComponent section = (SectionComponent) target;
			section.setTrainDirection(direction);
		} else if (target instanceof TurnoutComponent) {
			logger.error("Train direction is not meaningful for turnout " + targetID + ".");
		} else {
			logger.error("No such id in this component: " + targetID + ".");
		}
	}

	public void raiseOccupy(int targetID) {
		Object target = ids.get(targetID);
		if (target instanceof SectionComponent) {
			SectionComponent section = (SectionComponent) target;
			section.raiseOccupy();
		} else if (target instanceof TurnoutComponent) {
			logger.error("Occupy is not meaningful for turnout " + targetID + ".");
		} else {
			logger.error("No such id in this component: " + targetID + ".");
		}
	}

	public void raiseUnoccupy(int targetID) {
		Object target = ids.get(targetID);
		if (target instanceof SectionComponent) {
			SectionComponent section = (SectionComponent) target;
			section.raiseOccupy();
		} else if (target instanceof TurnoutComponent) {
			logger.error("Unoccupy is not meaningful for turnout " + targetID + ".");
		} else {
			logger.error("No such id in this component: " + targetID + ".");
		}
	}

	public void raiseReset(int targetID) {
		Object target = ids.get(targetID);
		if (target instanceof SectionComponent) {
			SectionComponent section = (SectionComponent) target;
			section.raiseReset();
		} else if (target instanceof TurnoutComponent) {
			logger.error("Reset is not meaningful for turnout " + targetID + ".");
		} else {
			logger.error("No such id in this component: " + targetID + ".");
		}
	}

	public void raiseSwitch(int targetID) {
		Object target = ids.get(targetID);
		if (target instanceof SectionComponent) {
			logger.error("Switch is not meaningful for section " + targetID + ".");
		} else if (target instanceof TurnoutComponent) {
			TurnoutComponent turnout = (TurnoutComponent) target;
			turnout.raiseSwitch();
		} else {
			logger.error("No such id in this component: " + targetID + ".");
		}
	}

	@Override
	public void reserveTo(int targetID, ConnectionDirection direction) {
		Object target = ids.get(targetID);
		if (target instanceof SectionComponent) {
			SectionComponent section = (SectionComponent) target;
			switch (direction) {
			case RIGHT:
				section.raiseReserveFromRight();
				break;
			case LEFT:
				section.raiseReserveFromLeft();
				break;
			default:
				logger.error("This section cannot be reserved from " + direction + ": " + targetID + ".");
			}
		} else if (target instanceof TurnoutComponent) {
			TurnoutComponent turnout = (TurnoutComponent) target;
			switch (direction) {
			case BOTTOM:
				turnout.raiseReserveFromBottom();
				break;
			default:
				logger.error("This turnout cannot be reserved from " + direction + ": " + targetID + ".");
			}
		} else {
			logger.error("No such id in this component: " + targetID + ".");
		}
	}

	@Override
	public void releaseTo(int targetID, ConnectionDirection direction) {
		Object target = ids.get(targetID);
		if (target instanceof SectionComponent) {
			SectionComponent section = (SectionComponent) target;
			switch (direction) {
			case RIGHT:
			case LEFT:
				section.raiseRelease();
				break;
			default:
				logger.error("This section cannot be released from " + direction + ": " + targetID + ".");
			}
		} else if (target instanceof TurnoutComponent) {
			TurnoutComponent turnout = (TurnoutComponent) target;
			switch (direction) {
			case BOTTOM:
				turnout.raiseReleaseFromBottom();
				break;
			default:
				logger.error("This turnout cannot be released from " + direction + ": " + targetID + ".");
			}
		} else {
			logger.error("No such id in this component: " + targetID + ".");
		}
	}

	@Override
	public void reserveResultTo(int targetID, ConnectionDirection direction, boolean result) {
		Object target = ids.get(targetID);
		if (target instanceof SectionComponent) {
			SectionComponent section = (SectionComponent) target;
			switch (direction) {
			case RIGHT:
			case LEFT:
				section.raiseReserveResult(result);
				break;
			default:
				logger.error("This section cannot get a reserve result from " + direction + ": " + targetID + ".");
			}
		} else if (target instanceof TurnoutComponent) {
			TurnoutComponent turnout = (TurnoutComponent) target;
			switch (direction) {
			case BOTTOM:
				turnout.raiseReserveResultFromBottom(result);
				break;
			default:
				logger.error("This turnout cannot get a reserve result from " + direction + ": " + targetID + ".");
			}
		} else {
			logger.error("No such id in this component: " + targetID + ".");
		}
	}

	protected abstract void setupIds();

}
