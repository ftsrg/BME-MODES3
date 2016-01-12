package hu.bme.mit.inf.kvcontrol.bpextension.senders;

import java.io.IOException;
import java.io.PrintStream;
import hu.bme.mit.inf.kvcontrol.bpextension.requests.GetRequest;
import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction;

/**
 *
 * @author benedekh
 */
public class PassageRequestSender extends AbstractRequestSender {
    
    private static final String URL_EXTENSION = "passage_request/";
    
    public void sendPassageRequest(Direction direction, int receiverId, PrintStream logger) {
        this.sendPassageRequest(direction, receiverId, logger, URL_EXTENSION);
    }
    
    protected void sendPassageRequest(Direction direction, int receiverId, PrintStream logger, String urlExtension) {
        StringBuilder sb = new StringBuilder();
        sb.append(urlExtension);
        sb.append(direction.toString().toLowerCase()).append("/");
        sb.append(String.valueOf(receiverId));
        
        try {
            GetRequest request = new GetRequest();
            super.sendRequest(request.createGet(sb.toString()));
        } catch (IOException ex) {
            logger.println("[PASSAGE REQUEST SENDER EXCEPTION] " + ex.getMessage());
        }
    }
    
}
