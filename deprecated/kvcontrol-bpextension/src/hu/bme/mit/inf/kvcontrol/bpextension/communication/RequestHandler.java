package hu.bme.mit.inf.kvcontrol.bpextension.communication;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import hu.bme.mit.inf.kvcontrol.bpextension.commands.Allowance;
import hu.bme.mit.inf.kvcontrol.bpextension.commands.Commands;
import hu.bme.mit.inf.kvcontrol.bpextension.commands.Direction;
import hu.bme.mit.inf.kvcontrol.bpextension.communication.http.HttpResponse;
import hu.bme.mit.inf.kvcontrol.bpextension.communication.http.HttpStatusCodes;

/**
 *
 * @author benedekh
 */
public class RequestHandler implements Runnable {

    private final PrintStream socketOut;
    private final BufferedReader socketIn;
    private final Socket socket;

    private final PrintStream logger;
    private final PacketSender sender;

    public RequestHandler(Socket socket, PacketSender sender, PrintStream logger) throws IOException {
        socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        socketOut = new PrintStream(socket.getOutputStream(), true);
        this.socket = socket;
        this.sender = sender;
        this.logger = logger;
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

            if (!protocol.equals("HTTP/1.1")) {
                socketOut.println(new HttpResponse(HttpStatusCodes.HTTP_VERSION_NOT_SUPPORTED).toString());
                return;
            }

            logger.println("[Server] method.....: " + method);
            logger.println("[Server] resource...: " + resource);

            socketOut.println(serveRequest(method, resource).toString());
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

    private HttpResponse serveRequest(String method, String resource) {
        try {
            String[] uriParts = resource.split("/");
            String action = uriParts[1].toUpperCase();
            String direction = uriParts[2].toUpperCase();

            int turnoutID;
            byte[] message;

            switch (method) {
                case "GET":
                    turnoutID = Integer.parseInt(uriParts[3]);

                    switch (action) {
                        case Commands.PASSAGE_REQUEST:
                            switch (direction) {
                                case Direction.TOP:
                                    message = new byte[]{Commands.DISTRIBUTED_PASSAGE_REQUEST_TOP, (byte) turnoutID};
                                    break;
                                case Direction.STRAIGHT:
                                    message = new byte[]{Commands.DISTRIBUTED_PASSAGE_REQUEST_STRAIGHT, (byte) turnoutID};
                                    break;
                                case Direction.DIVERGENT:
                                    message = new byte[]{Commands.DISTRIBUTED_PASSAGE_REQUEST_DIVERGENT, (byte) turnoutID};
                                    break;
                                default:
                                    return new HttpResponse(HttpStatusCodes.BAD_REQUEST);
                            }
                            break;
                        case Commands.SHORT_PASSAGE_REQUEST:
                            switch (direction) {
                                case Direction.TOP:
                                    message = new byte[]{Commands.DISTRIBUTED_SHORT_PASSAGE_REQUEST_TOP, (byte) turnoutID};
                                    break;
                                case Direction.STRAIGHT:
                                    message = new byte[]{Commands.DISTRIBUTED_SHORT_PASSAGE_REQUEST_STRAIGHT, (byte) turnoutID};
                                    break;
                                case Direction.DIVERGENT:
                                    message = new byte[]{Commands.DISTRIBUTED_SHORT_PASSAGE_REQUEST_DIVERGENT, (byte) turnoutID};
                                    break;
                                default:
                                    return new HttpResponse(HttpStatusCodes.BAD_REQUEST);
                            }
                            break;
                        default:
                            return new HttpResponse(HttpStatusCodes.BAD_REQUEST);
                    }
                    break;
                case "PUT":
                    switch (action) {
                        case Commands.PASSAGE_RESPONSE:
                            String allowance = uriParts[3].toUpperCase();
                            turnoutID = Integer.parseInt(uriParts[4]);

                            byte command;
                            byte allowanceCode;

                            switch (direction) {
                                case Direction.TOP:
                                    command = Commands.DISTRIBUTED_PASSAGE_RESPONSE_TOP;
                                    break;
                                case Direction.STRAIGHT:
                                    command = Commands.DISTRIBUTED_PASSAGE_RESPONSE_STRAIGHT;
                                    break;
                                case Direction.DIVERGENT:
                                    command = Commands.DISTRIBUTED_PASSAGE_RESPONSE_DIVERGENT;
                                    break;
                                default:
                                    return new HttpResponse(HttpStatusCodes.BAD_REQUEST);
                            }
                            switch (allowance) {
                                case Allowance.ALLOWED:
                                    allowanceCode = Commands.DISTRIBUTED_PASSAGE_ALLOWED;
                                    break;
                                case Allowance.DENIED:
                                    allowanceCode = Commands.DISTRIBUTED_PASSAGE_DENIED;
                                    break;
                                default:
                                    return new HttpResponse(HttpStatusCodes.BAD_REQUEST);
                            }

                            message = new byte[]{command, allowanceCode, (byte) turnoutID};
                            break;
                        default:
                            return new HttpResponse(HttpStatusCodes.BAD_REQUEST);
                    }
                    break;
                default:
                    return new HttpResponse(HttpStatusCodes.BAD_REQUEST);
            }
            
            sender.sendTCPPacket(turnoutID, message);

        } catch (Exception ex) {
            return new HttpResponse(HttpStatusCodes.BAD_REQUEST);
        }

        return new HttpResponse(HttpStatusCodes.OK);
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

}
