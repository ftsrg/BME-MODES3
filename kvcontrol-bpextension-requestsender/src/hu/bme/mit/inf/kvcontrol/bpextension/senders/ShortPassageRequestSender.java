package hu.bme.mit.inf.kvcontrol.bpextension.senders;

import java.io.PrintStream;
import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction;

/**
 *
 * @author benedekh
 */
public class ShortPassageRequestSender extends PassageRequestSender {

    private static final String URL_EXTENSION = "short_passage_request/";

    public void sendShortPassageRequest(Direction direction, int receiverId, PrintStream logger) {
        super.sendPassageRequest(direction, receiverId, logger, URL_EXTENSION);
    }
}
