package hu.bme.mit.inf.kv.yakindu.control.sm;

import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction;

/**
 *
 * @author benedekh
 */
public class Section {

    private final Direction direction;
    private final int sectionId;

    public Section(Direction direction, int sectionId) {
        this.direction = direction;
        this.sectionId = sectionId;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public int getSectionId() {
        return this.sectionId;
    }
}
