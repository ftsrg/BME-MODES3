package hu.bme.mit.inf.eda.util;

import hu.bme.mit.inf.eda.main.Application;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author benedekh
 */
public class PathValidator {

    public static boolean isPathValid(String path) {
        try {
            new File(path).createNewFile();
        } catch (IOException ex) {
            logException(Application.class.getName(), ex);
            return false;
        }

        return true;
    }
}
