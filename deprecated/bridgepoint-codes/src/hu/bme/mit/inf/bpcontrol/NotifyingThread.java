package hu.bme.mit.inf.bpcontrol;

import interfaces.ThreadCompletedListener;
import java.util.HashSet;

import java.util.Set;

public abstract class NotifyingThread extends Thread {

    private final Set<ThreadCompletedListener> listeners = new HashSet<>();

    public abstract void doRun();

    @Override
    public final void run() {
        try {
            doRun();
        } finally {
            notifyListeners();
        }
    }

    public void addListener(ThreadCompletedListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners() {
        for (ThreadCompletedListener listener : listeners) {
            listener.notifyThreadCompleted(this);
        }
    }
}
