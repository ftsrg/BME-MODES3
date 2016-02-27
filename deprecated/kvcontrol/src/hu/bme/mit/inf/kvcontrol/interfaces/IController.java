package hu.bme.mit.inf.kvcontrol.interfaces;

import java.io.IOException;

/**
 * A general interface for controllers
 * <p>
 *
 * @author zsoltmazlo, benedekh
 */
public interface IController {

    /**
     * Send a TCP packet to the destination.
     *
     * @param responsibleControllerID Destination device's ID
     * @param message byte array of the message
     * <p>
     * @throws java.io.IOException if socket failed
     */
    public void sendTCPPacket(int responsibleControllerID, byte[] message)
            throws IOException;

    /**
     * all the requester threads are designed not to ruin the network, so every
     * thread got an 'heartbeat' which could handled by outside the class.
     *
     * Because of that, if you want one measuring only, then you should call
     * this method once, but if you want trigger the system periodically, then
     * you are able to create a thread which call this method a sleep time on
     * your own.
     */
    public void sendHeartBeat();

    /**
     * starts the receiver and requester thread inside the object. The receiver
     * thread is running continuously while the requester thread needs a
     * 'heartbeat'
     *
     * @see sendHeartBeat method for more details
     */
    public void startThreads();

    /**
     * A Runnable class stub which handling the heartbeat pattern.
     */
    public abstract class RunnableStub implements Runnable {

        protected final Object heartBeat;

        protected RunnableStub(Object syncObject) {
            this.heartBeat = syncObject;
        }
    }

}
