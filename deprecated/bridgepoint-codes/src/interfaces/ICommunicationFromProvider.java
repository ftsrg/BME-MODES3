package interfaces;

import org.xtuml.bp.core.ComponentInstance_c;

import types.Direction;

public interface ICommunicationFromProvider {

    public void receiveOccupancy(ComponentInstance_c senderReceiver, 
            int occupancy);

    public void turnoutDirection(ComponentInstance_c senderReceiver, 
            int turnoutId, Boolean isDivergent);

    public void triggerUnlock(ComponentInstance_c senderReceiver);

    public void receivePassageRequest(ComponentInstance_c senderReceiver,
            int receiverId, Direction direction);

    public void receivePassageResponse(ComponentInstance_c senderReceiver,
            int receiverId, Boolean isAllowed, Direction direction);

    public void resetSm(ComponentInstance_c senderReceiver);

}
