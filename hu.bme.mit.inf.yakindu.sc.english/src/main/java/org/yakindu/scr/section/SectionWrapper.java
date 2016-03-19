package org.yakindu.scr.section;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import java.util.List;

/**
 * Runnable wrapper of SectionStatemachine. This wrapper provides a thread safe,
 * runnable instance of the statemachine. The wrapper implements the
 * {@link Runnable} interface and can be started in a thread by the client code.
 * The run method then starts the main event processing loop for this
 * statemachine.
 *
 * This feature is in beta state. Currently not supported are - interface
 * observer - operation callbacks
 *
 * Please report bugs and issues...
 */
public class SectionWrapper implements ISectionStatemachine, Runnable {

    /**
     * The events are queued using a blocking queue without capacity
     * restriction. This queue holds Runnable instances that process the events.
     */
    protected BlockingQueue<Runnable> eventQueue = new LinkedBlockingQueue<>();

    /**
     * The core statemachine is simply wrapped and the event processing will be
     * delegated to that statemachine instance. This instance will be created
     * implicitly.
     */
    protected final SectionStatemachine statemachine = new SectionStatemachine();

    /**
     * Interface object for SCISection
     */
    protected SCISection sCISection = new SCISection() {
        @Override
        public void raiseRevokeLock() {
            eventQueue.add(new Runnable() {

                @Override
                public void run() {
                    synchronized (statemachine) {
                        statemachine.getSCISection().raiseRevokeLock();
                        statemachine.runCycle();
                    }
                }
            });
        }

        @Override
        public void raiseLockRequestTo(final long value) {

            eventQueue.add(new Runnable() {

                @Override
                public void run() {
                    synchronized (statemachine) {
                        statemachine.getSCISection().raiseLockRequestTo(value);
                        statemachine.runCycle();
                    }
                }
            });
        }

        @Override
        public void raiseSectionLockedWithReplyTo(final long value) {

            eventQueue.add(new Runnable() {

                @Override
                public void run() {
                    synchronized (statemachine) {
                        statemachine.getSCISection().raiseSectionLockedWithReplyTo(
                                value);
                        statemachine.runCycle();
                    }
                }
            });
        }

        @Override
        public void raiseSectionLockedTo(final long value) {

            eventQueue.add(new Runnable() {

                @Override
                public void run() {
                    synchronized (statemachine) {
                        statemachine.getSCISection().raiseSectionLockedTo(value);
                        statemachine.runCycle();
                    }
                }
            });
        }

        @Override
        public void raiseSectionAllowedTo(final long value) {

            eventQueue.add(new Runnable() {

                @Override
                public void run() {
                    synchronized (statemachine) {
                        statemachine.getSCISection().raiseSectionAllowedTo(value);
                        statemachine.runCycle();
                    }
                }
            });
        }

        @Override
        public void raiseSectionOccupied() {
            eventQueue.add(new Runnable() {

                @Override
                public void run() {
                    synchronized (statemachine) {
                        statemachine.getSCISection().raiseSectionOccupied();
                        statemachine.runCycle();
                    }
                }
            });
        }

        @Override
        public void raiseSectionFree() {
            eventQueue.add(new Runnable() {

                @Override
                public void run() {
                    synchronized (statemachine) {
                        statemachine.getSCISection().raiseSectionFree();
                        statemachine.runCycle();
                    }
                }
            });
        }

        @Override
        public boolean isRaisedEnableSection() {
            synchronized (statemachine) {
                return statemachine.getSCISection().isRaisedEnableSection();
            }
        }

        @Override
        public long getEnableSectionValue() {
            synchronized (statemachine) {
                return statemachine.getSCISection().getEnableSectionValue();
            }
        }

        @Override
        public boolean isRaisedDisableSection() {
            synchronized (statemachine) {
                return statemachine.getSCISection().isRaisedDisableSection();
            }
        }

        @Override
        public long getDisableSectionValue() {
            synchronized (statemachine) {
                return statemachine.getSCISection().getDisableSectionValue();
            }
        }

        @Override
        public boolean isRaisedPassingAllowedFrom() {
            synchronized (statemachine) {
                return statemachine.getSCISection().isRaisedPassingAllowedFrom();
            }
        }

        @Override
        public long getPassingAllowedFromValue() {
            synchronized (statemachine) {
                return statemachine.getSCISection().getPassingAllowedFromValue();
            }
        }

        @Override
        public boolean isRaisedPassingDeniedFrom() {
            synchronized (statemachine) {
                return statemachine.getSCISection().isRaisedPassingDeniedFrom();
            }
        }

        @Override
        public long getPassingDeniedFromValue() {
            synchronized (statemachine) {
                return statemachine.getSCISection().getPassingDeniedFromValue();
            }
        }

        @Override
        public boolean isRaisedSectionLockFrom() {
            synchronized (statemachine) {
                return statemachine.getSCISection().isRaisedSectionLockFrom();
            }
        }

        @Override
        public long getSectionLockFromValue() {
            synchronized (statemachine) {
                return statemachine.getSCISection().getSectionLockFromValue();
            }
        }

        @Override
        public long getSTRAIGHT() {
            synchronized (statemachine) {
                return statemachine.getSCISection().getSTRAIGHT();
            }
        }

        @Override
        public long getDIVERGENT() {
            synchronized (statemachine) {
                return statemachine.getSCISection().getDIVERGENT();
            }
        }

        @Override
        public long getTOP() {
            synchronized (statemachine) {
                return statemachine.getSCISection().getTOP();
            }
        }

        @Override
        public long getId() {
            synchronized (statemachine) {
                return statemachine.getSCISection().getId();
            }
        }

        @Override
        public void setId(final long value) {
            synchronized (statemachine) {
                statemachine.getSCISection().setId(value);
            }
        }

        @Override
        public long getDirection() {
            synchronized (statemachine) {
                return statemachine.getSCISection().getDirection();
            }
        }

        @Override
        public void setDirection(final long value) {
            synchronized (statemachine) {
                statemachine.getSCISection().setDirection(value);
            }
        }

        @Override
        public List<SCISectionListener> getListeners() {
            synchronized (statemachine) {
                return statemachine.getSCISection().getListeners();
            }
        }

    };

    @Override
    public SCISection getSCISection() {
        return sCISection;
    }

    /**
     * init() will be delegated thread safe to the wrapped statemachine.
     */
    @Override
    public void init() {
        synchronized (statemachine) {
            statemachine.init();
        }
    }

    /**
     * enter() will be delegated thread safe to the wrapped statemachine.
     */
    @Override
    public void enter() {
        synchronized (statemachine) {
            statemachine.enter();
        }
    }

    /**
     * exit() will be delegated thread safe to the wrapped statemachine.
     */
    @Override
    public void exit() {
        synchronized (statemachine) {
            statemachine.exit();
        }
    }

    /**
     * isActive() will be delegated thread safe to the wrapped statemachine.
     */
    @Override
    public boolean isActive() {
        synchronized (statemachine) {
            return statemachine.isActive();
        }
    }

    /**
     * isFinal() will be delegated thread safe to the wrapped statemachine.
     */
    @Override
    public boolean isFinal() {
        synchronized (statemachine) {
            return statemachine.isFinal();
        }
    }

    /**
     * runCycle() will be delegated thread safe to the wrapped statemachine.
     */
    @Override
    public void runCycle() {
        synchronized (statemachine) {
            statemachine.runCycle();
        }
    }

    /**
     * This method will start the main execution loop for the statemachine.
     * First it will init and enter the statemachine implicitly and then will
     * start processing events from the event queue until the thread is
     * interrupted.
     */
    @Override
    public void run() {

        boolean terminate = false;

        while (!(terminate || Thread.currentThread().isInterrupted())) {

            try {

                Runnable eventProcessor = eventQueue.take();
                eventProcessor.run();

            } catch (InterruptedException e) {
                terminate = true;
            }
        }
    }

}
