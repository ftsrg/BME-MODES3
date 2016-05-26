package hu.bme.mit.inf.eda.util;

import java.io.File;
import java.io.IOException;

import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;

/**
 * Validates a path.
 *
 * @author benedekh
 */
public final class PathValidator {

    /**
     * Validates the referred path. The path is valid, if (1) it exists, (2) a
     * file can be created there.
     *
     * @param path to be validated
     * @return true if the referred path is valid, false otherwise
     */
    public static boolean isPathValid(String path) {
        try {
            new File(path).createNewFile();
        } catch (IOException ex) {
            logException(PathValidator.class.getName(), ex);
            return false;
        }

        return true;
    }
}
