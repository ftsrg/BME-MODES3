package hu.bme.mit.inf.kvcontrol.entities;

import hu.bme.mit.inf.kvcontrol.data.AddressTranslator;

/**
 * Turnout Entity class
 * <p>
 * @author zsoltmazlo
 */
public class Turnout {

    /**
     * The turnout's ID
     */
    private final int ID;

    /**
     * The controller's address which is responsible for every communication
     * with the turnout.
     */
    private final AddressTranslator responsibleControllerAddress;

    /**
     * measured value on the divergent branch
     */
    private int onDivergentBranch;

    /**
     * measured value on the straight branch
     */
    private int onStraightBranch;

    /**
     *
     * @param ID turnout's ID
     * @param logicalAddress the turnout's logical address
     * @param physicalAddress the last octet of the turnout's physical address
     */
    public Turnout(int ID, int logicalAddress, int physicalAddress) {
        this.ID = ID;
        this.responsibleControllerAddress = new AddressTranslator(logicalAddress,
                physicalAddress);
    }

    /**
     * set the measured values on both branches
     * <p>
     * @param onDivergentBranch measured value on divergent branch
     * @param onStraightBranch measured value on divergent branch
     */
    public void setMeasuredValues(int onDivergentBranch, int onStraightBranch) {
        this.onDivergentBranch = onDivergentBranch;
        this.onStraightBranch = onStraightBranch;
    }

    /**
     *
     * @return true if the turnout is setted to divergent branch
     */
    public boolean isDivergent() {
        return this.onDivergentBranch > this.onStraightBranch;
    }

    /**
     *
     * @return true if the turnout is setted to straight branch
     */
    public boolean isStraight() {
        return !this.isDivergent();
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @return the physical address of the responsible turnout
     */
    public int getPhysicalAddress() {
        return this.responsibleControllerAddress.getPhysicalAddress();
    }

}
