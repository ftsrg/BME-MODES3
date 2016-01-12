/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.kvcontrol;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

/**
 *
 * @author zsoltmazlo
 */
public class KVControl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            OptionParser parser = new OptionParser();
            ArgumentAcceptingOptionSpec<Integer> portArg = parser
                    .accepts("p", "port number [mandatory]").withRequiredArg()
                    .ofType(Integer.class);
            ArgumentAcceptingOptionSpec<Integer> timeoutArg = parser.
                    accepts("t", "timeout [mandatory]").withRequiredArg()
                    .ofType(Integer.class);

            OptionSet parsed = parser.parse(args);

            if (!parsed.has(portArg) || !parsed.has(timeoutArg)) {
                parser.printHelpOn(System.out);
                return;
            }

            int port = parsed.valueOf(portArg);
            int timeout = parsed.valueOf(timeoutArg);

            // kvcontrol-t futtatva egyből indul a szerver
            new CommandServer(port, timeout).start();

        } catch (IOException ex) {
            Logger.getLogger(KVControl.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

}
