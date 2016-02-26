package hu.bme.mit.inf.mqtt.common.data;

import com.google.gson.Gson;

/**
 *
 * @author benedekh
 */
public class OccupancyVector implements JsonConvertible {

    private final byte[] occupancyVector;

    public OccupancyVector(byte[] vector) {
        this.occupancyVector = vector;
    }

    /**
     * byte[] in raw Arduino representation.
     */
    public byte[] getOccupancyVectorRaw() {
        return occupancyVector;
    }

    /**
     * Arduino byte[] converted to int[] with correct Java representation.
     */
    public int getOccupancyVector() {
        int[] receivedInt = new int[4];

        for (int i = 0; i < 4; i++) {
            receivedInt[i] = ((int) occupancyVector[i] & 0xFF);
        }

        int occupancy = (receivedInt[3] << 24) | (receivedInt[2] << 16)
                | (receivedInt[1] << 8) | (receivedInt[0]);

        return occupancy;
    }

    @Override
    public String toJson() {
        return new Gson().toJson(this);
    }
}
