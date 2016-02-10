package hu.bme.mit.inf.kvcontrol.bpextension.senders;

import java.io.IOException;
import java.io.PrintStream;
import hu.bme.mit.inf.kvcontrol.bpextension.requests.PutRequest;
import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Allowance;
import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction;

/**
 *
 * @author benedekh
 */
public class PassageResponseSender extends AbstractRequestSender {

    private static final String URL_EXTENSION = "passage_response/";

    public void sendPassageResponse(Direction direction, Allowance allowance, int receiverId, PrintStream logger) {
        StringBuilder sb = new StringBuilder();
        sb.append(URL_EXTENSION);
        sb.append(direction.toString().toLowerCase()).append("/");
        sb.append(allowance.toString().toLowerCase()).append("/");
        sb.append(String.valueOf(receiverId));

        try {
            PutRequest request = new PutRequest();
            super.sendRequest(request.createPut(sb.toString()));
        } catch (IOException ex) {
            logger.println("[PASSAGE RESPONSE SENDER EXCEPTION] " + ex.getMessage());
        }
    }

}
