package hu.bme.mit.inf.kvcontrol.data;

/**
 *
 * @author benedekh
 */
public class AddressTranslator {

    private final int logicalAddress;
    private final int physicalAddress;

    public AddressTranslator(int logicalAddress, int physicalAddress) {
        this.logicalAddress = logicalAddress;
        this.physicalAddress = physicalAddress;
    }

    public int getPhysicalAddress() {
        return this.physicalAddress;
    }

    public int getLogicalAddress() {
        return this.logicalAddress;
    }

}
