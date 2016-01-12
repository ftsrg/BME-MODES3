package hu.bme.mit.inf.kvcontrol.bpextension.communication;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.ini4j.Profile;
import org.ini4j.Wini;

/**
 *
 * @author benedekh
 */
public class CommandServer {

    private final PrintStream logger = System.out;
    private PacketSender sender;

    private int port;

    public CommandServer(int port, String iniPath) {
        this.port = port;
        try {
            Wini ini = new Wini();
            ini.getConfig().setMultiOption(true);
            ini.load(new File(iniPath));
            Profile.Section turnoutSection = ini.get("turnouts");
            List<String> turnouts = turnoutSection.getAll("turnout");

            this.sender = new PacketSender(turnouts, logger);
        } catch (IOException ex) {
            logger.println("[COMMAND SERVER EXCEPTION] " + ex.getMessage());
        }
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.println("[Server] socket created");
            ExecutorService threadPool = Executors.newCachedThreadPool();

            while (true) {
                // accept connections from the clients
                try {
                    Socket socket = serverSocket.accept();
                    logger.println("[Server] client connected");

                    threadPool.execute(new RequestHandler(socket, sender, logger));

                } catch (IOException e) {
                    logger.println("[Server - exception]"
                            + "Unexpected exception occured when creating"
                            + " a socket, details:" + e.getMessage());
                }
            }
        } catch (IOException e) {
            logger.println("[Server - exception]"
                    + "Unexpected exception occured when creating"
                    + " a socket, details:" + e.getMessage());
        }

    }

}
