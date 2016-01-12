package hu.bme.mit.inf.kv.yakindu.control.transmitter;

import hu.bme.mit.inf.kv.yakindu.control.controller.IYakinduKVController;
import hu.bme.mit.inf.kv.yakindu.control.helper.LoggingThread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author benedekh
 */
public class SmEventDispatcher extends LoggingThread {

    private final IYakinduKVController statemachineController;
    private final BlockingQueue<Thread> events = new LinkedBlockingQueue<>();

    public SmEventDispatcher(IYakinduKVController statemachineController) {
        this.statemachineController = statemachineController;
    }

    public void addEvent(Thread event) {
        events.add(event);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Thread event = events.take();
                event.start();
                event.join();
                statemachineController.simulateStatemachine();
            } catch (InterruptedException ex) {
                logErrorMessage(ex.getMessage());
            }
        }
    }

}
