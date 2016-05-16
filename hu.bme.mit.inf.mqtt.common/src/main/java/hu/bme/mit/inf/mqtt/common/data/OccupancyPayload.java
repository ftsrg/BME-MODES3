package hu.bme.mit.inf.mqtt.common.data;

/**
 * Stores an occupancy vector in a byte array.
 *
 * @author benedekh
 */
public class OccupancyPayload {

    // SEND_OCCUPANCY, or GET_OCCUPANCY usually
    private final Command command;

    // the occupancy vector in a byte array
    private final byte[] content;

    /**
     * @param command SEND_OCCUPANCY, or GET_OCCUPANCY usually
     * @param content the occupancy vector in a byte array
     */
    public OccupancyPayload(Command command, byte[] content) {
        this.command = command;
        this.content = content;
    }

    /**
     * @return SEND_OCCUPANCY, or GET_OCCUPANCY usually
     */
    public Command getCommand() {
        return command;
    }

    /**
     * @return the occupancy vector in a byte array
     */
    public byte[] getContent() {
        return content;
    }

    /**
     * Converts the occupancy vector byte array to a Java int.
     *
     * @return the occupancy vector as an int number
     */
    public int getOccupancyVector() {
        int[] receivedInt = new int[4];

        for (int i = 0; i < 4; i++) {
            receivedInt[i] = ((int) content[i] & 0xFF);
        }

        int occupancy = (receivedInt[3] << 24) | (receivedInt[2] << 16)
                | (receivedInt[1] << 8) | (receivedInt[0]);

        return occupancy;
    }
}
