package hu.bme.mit.inf.kvcontrol.entities;

import hu.bme.mit.inf.kvcontrol.data.AddressTranslator;

/**
 * Section Entity class
 * <p>
 * @author zsoltmazlo, benedekh
 */
public class Section {

    /**
     * the section's ID
     */
    private final int ID;

    /**
     * The controller's address which is responsible for every communication
     * with the section.
     */
    private final AddressTranslator responsibleControllerAddress;

    /**
     * Indicates, whether the section is occupied.
     */
    private boolean isOccupied;

    /**
     * Indicates, whether the section is enabled.
     */
    private boolean isEnabled;

    public Section(int ID, int logicalAddress, int physicalAddress) {
        this.ID = ID;
        this.responsibleControllerAddress = new AddressTranslator(logicalAddress,
                physicalAddress);
        this.isOccupied = false;
        this.isEnabled = true;
    }

    /**
     * send the section's ID
     * <p>
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param isOccupied is occupied the section or not
     */
    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    /**
     * @param isEnabled is enabled the section or not
     */
    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * @return the responsibleControllerID
     */
    public int getPhysicalAddress() {
        return this.responsibleControllerAddress.getPhysicalAddress();
    }

    /**
     * @return the isOccupied
     */
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * @return the isEnabled
     */
    public boolean isEnabled() {
        return isEnabled;
    }

}
