package hu.bme.mit.inf.mqtt.common.data;

/**
 *
 * @author benedekh
 */
public class OccupancyPayload {

    private final Command command;
    private final byte[] content;

    public OccupancyPayload(Command command, byte[] content) {
        this.command = command;
        this.content = content;
    }

    public Command getCommand() {
        return command;
    }

    public byte[] getContent() {
        return content;
    }

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
