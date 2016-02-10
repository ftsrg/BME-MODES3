package hu.bme.mit.inf.kvcontrol.bpextension;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import hu.bme.mit.inf.kvcontrol.bpextension.communication.CommandServer;

/**
 *
 * @author benedekh
 */
public class Main {

    public static void main(String[] args) {

        try {
            OptionParser parser = new OptionParser();
            ArgumentAcceptingOptionSpec<Integer> portArg = parser
                    .accepts("p", "port number [mandatory]").withRequiredArg()
                    .ofType(Integer.class);
            ArgumentAcceptingOptionSpec<String> pathArg = parser
                    .accepts("ini",
                            "ini configuration file path (servers IP:port) [mandatory]")
                    .withRequiredArg().ofType(String.class);

            OptionSet parsed = parser.parse(args);

            if (!parsed.has(portArg) || !parsed.has(pathArg)) {
                parser.printHelpOn(System.out);
                return;
            }

            int port = parsed.valueOf(portArg);
            String path = parsed.valueOf(pathArg);

            if (!new File(path).isFile()) {
                throw new IOException("[file does not exist] " + path);
            }

            // kvcontrol-t futtatva egyből indul a szerver
            new CommandServer(port, path).start();

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
