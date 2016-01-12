package hu.bme.mit.inf.kv.yakindu.control.sm;

import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction;

/**
 *
 * @author benedekh
 */
public class RemoteTurnout {

    // the LOCAL turnout can reach the REMOTE turnout from this direction
    private final Direction remoteDirection;

    // the REMOTE turnout can reach the LOCAL turnout from this direction
    private final Direction localDirection;

    private final int turnoutId;

    public RemoteTurnout(Direction remoteDirection, Direction localDirection,
            int turnoutId) {
        this.remoteDirection = remoteDirection;
        this.localDirection = localDirection;
        this.turnoutId = turnoutId;
    }

    public Direction getRemoteDirection() {
        return this.remoteDirection;
    }

    public Direction getLocalDirection() {
        return this.localDirection;
    }

    public int getTurnoutId() {
        return this.turnoutId;
    }

}
