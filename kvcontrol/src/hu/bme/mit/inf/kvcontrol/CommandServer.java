/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.kvcontrol;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import hu.bme.mit.inf.kvcontrol.commands.ICommand;
import hu.bme.mit.inf.kvcontrol.commands.OccupancyCommand;
import hu.bme.mit.inf.kvcontrol.commands.SectionStateCommand;
import hu.bme.mit.inf.kvcontrol.commands.TurnoutStateCommand;
import hu.bme.mit.inf.kvcontrol.controllers.OccupancyController;
import hu.bme.mit.inf.kvcontrol.controllers.SectionController;
import hu.bme.mit.inf.kvcontrol.controllers.TurnoutController;
import hu.bme.mit.inf.kvcontrol.interfaces.IController;
import org.json.JSONObject;

/**
 *
 * @author zsoltmazlo
 */
public class CommandServer {

    public final OccupancyController occupancyController = new OccupancyController();
    public final SectionController sectionController = new SectionController();
    public final TurnoutController turnoutController = new TurnoutController();

    private final int port;
    
    public static final PrintStream logger = System.out;

    private volatile boolean doOrDoNotThereIsNoTry;

    private final int heartbeatTimeout;
    
    private volatile long occupancyLastHeartbeat;

    private volatile long sectionLastHeartbeat;
    
    private volatile long turnoutLastHeartbeat;

    public CommandServer(int port, int heartbeatTimeout) {
        this.port = port;
        this.doOrDoNotThereIsNoTry = true;
        this.heartbeatTimeout = heartbeatTimeout;
    }

    public void stop() {
        this.doOrDoNotThereIsNoTry = false;
    }

    public void start() {
        occupancyController.startThreads();
        sectionController.startThreads();
        turnoutController.startThreads();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.println("[Server] socket created");
            ExecutorService threadPool = Executors.newCachedThreadPool();

            while (doOrDoNotThereIsNoTry) {
                // accept connections from the clients
                try {
                    Socket socket = serverSocket.accept();
                    logger.println("[Server] client connected");

                    threadPool.execute(new RequestHandler(socket));

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
    
    public static void handleConnectionError(Exception e) {
//            logger.println("[Server - exception] No connection with the table!");
//            StackTraceElement last = e.getStackTrace()[e.getStackTrace().length-2];
//            logger.println("Details: "+ last.getClassName() +":"+last.getMethodName()+", line "+last.getLineNumber());
////            e.printStackTrace();
    }

    /**
     *
     * @author zsoltmazlo
     */
    private class RequestHandler implements Runnable {

        private final PrintStream socketOut;
        private final BufferedReader socketIn;
        private final Socket socket;

        public RequestHandler(Socket socket) throws IOException {
            socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketOut = new PrintStream(socket.getOutputStream(), true);
            this.socket = socket;

        }

        @Override
        public void run() {

            try {
                // get headers
                Map<String, String> headers = readHttpHeaders();

                if (headers == null) {
                    return;
                }

                System.out.println(headers.get(null));

                // parse request
                String[] requestParts = headers.get(null).split("\\s+", 3);
                String method = requestParts[0];
                String resource = requestParts[1];
                String protocol = requestParts[2];
                String payload = getRequestPayload(headers);

                if (!protocol.equals("HTTP/1.1")) {
                    socketOut.println(new HttpResponse(HttpStatusCodes.HTTP_VERSION_NOT_SUPPORTED).toString());
                    return;
                }

                logger.println("[Server] method.....: " + method);
                logger.println("[Server] resource...: " + resource);
                logger.println("[Server] payload....: " + payload);

                socketOut.println(serveRequest(method, resource, payload).toString());
            } catch (Exception e) {
                // exception when accessing the socket
                String error = "Unexpected exception occured when accessing the client: "
                        + socket.getInetAddress() + ":" + socket.getPort();
                logger.println("[Server - exception] " + error);
                logger.println("[Server - exception] " + e.getMessage());
                socketOut.println(new HttpResponse(HttpStatusCodes.INTERNAL_SERVER_ERROR));

            } finally {
                // close socket
                try {
                    socket.close();
                    String info = "Client disconnected: "
                            + socket.getInetAddress() + ":" + socket.getPort();
                    logger.println("[Server] " + info);

                } catch (Exception e) {
                    String error = "Unexpected exception occured when closing the socket: "
                            + socket.getInetAddress()
                            + ":"
                            + socket.getPort();
                    logger.println("[Server - exception] " + error);
                    socketOut.println(new HttpResponse(HttpStatusCodes.INTERNAL_SERVER_ERROR));
                }
            }

        }

        private HttpResponse serveRequest(String method, String resource, String payload) {
            String content = null;
            ICommand command = null;

            String[] uriParts = resource.split("/");
            String action = uriParts[1];
            int id = (uriParts.length < 3) ? 0 : Integer.parseInt(uriParts[2]);

            switch (method) {
                case "GET":
                    switch (action) {
                        case OccupancyCommand.COMMAND:
                            sendHeartBeat(occupancyController);
                            command = new OccupancyCommand(
                                    occupancyController, id);
                            content = command.jsonify();
                            break;

                        case SectionStateCommand.COMMAND:
                            sendHeartBeat(sectionController);
                            command = new SectionStateCommand(
                                    sectionController, id, null);
                            content = command.jsonify();
                            break;

                        case TurnoutStateCommand.COMMAND:
                            sendHeartBeat(turnoutController);
                            command = new TurnoutStateCommand(
                                    turnoutController, id);
                            content = command.jsonify();
                            break;

                        default:
                            return new HttpResponse(HttpStatusCodes.BAD_REQUEST);
                    }
                    break;

                case "PUT":
                    // processing payload
                    JSONObject _payload = new JSONObject(payload);

                    switch (action) {
                        case SectionStateCommand.COMMAND:
                            sendHeartBeat(sectionController);
                            command = new SectionStateCommand(
                                    sectionController, id, _payload.getBoolean("state"));
                            content = command.jsonify();
                            break;

                        default:
                            return new HttpResponse(HttpStatusCodes.BAD_REQUEST);
                    }

                    break;

                default:
                    // egyébként minden más kérést visszautasítunk
                    return new HttpResponse(HttpStatusCodes.BAD_REQUEST);

            }

            return new HttpResponse(HttpStatusCodes.OK, "application/json", content);
        }

        private void sendHeartBeat(IController controller) {
            if (controller == occupancyController) {
                if (System.currentTimeMillis() < occupancyLastHeartbeat + heartbeatTimeout) {
                    return;
                }
                occupancyLastHeartbeat = System.currentTimeMillis();
                logger.println("[Server] sending heartbeat occupancy controller");
                occupancyController.sendHeartBeat();
            } else if (controller == sectionController) {
                if (System.currentTimeMillis() < sectionLastHeartbeat + heartbeatTimeout) {
                    return;
                }
                sectionLastHeartbeat = System.currentTimeMillis();
                logger.println("[Server] sending heartbeat section controller");
                sectionController.sendHeartBeat();
            } else if (controller == turnoutController) {
                if (System.currentTimeMillis() < turnoutLastHeartbeat + heartbeatTimeout) {
                    return;
                }
                turnoutLastHeartbeat = System.currentTimeMillis();
                logger.println("[Server] sending heartbeat turnout controller");
                turnoutController.sendHeartBeat();
            }

        }

        private Map<String, String> readHttpHeaders() throws IOException, EOFException {
            Map<String, String> headers = new HashMap<>();
            while (true) {
                String line = socketIn.readLine();
                if (line == null) {
                    // no good headers
                    return null;
                } else if (line.trim().isEmpty()) {
                    // headers end
                    break;
                }

                String[] parts = line.split(":", 2);
                if (parts.length == 1) {
                    headers.put(null, parts[0].trim());
                } else {
                    headers.put(parts[0].trim(), parts[1].trim());
                }
            }
            return headers;
        }

        private String getRequestPayload(Map<String, String> headers) throws IOException {
            // get request payload length
            int contentLength;
            if (headers.get("Content-Length") != null) {
                contentLength = Integer.parseInt(headers.get("Content-Length"));
            } else {
                contentLength = 0;
            }

            String payload = null;
            if (contentLength > 0) {
                // only get request payload if it is not empty
                payload = "";
                char[] buf = new char[1024];
                while (payload.getBytes().length < contentLength) {
                    int count = socketIn.read(buf);

                    // we are reading chars, but length is in
                    // bytes!!!
                    payload = payload.concat(new String(buf, 0, count));
                }
            }
            return payload;
        }
    }

}
