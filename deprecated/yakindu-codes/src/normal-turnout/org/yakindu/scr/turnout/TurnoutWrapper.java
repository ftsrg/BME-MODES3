package org.yakindu.scr.turnout;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Runnable wrapper of TurnoutStatemachine. This wrapper provides a thread safe,
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
public class TurnoutWrapper implements ITurnoutStatemachine, Runnable {

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
    protected final TurnoutStatemachine statemachine = new TurnoutStatemachine();

    /**
     * Interface object for SCISections
     */
    protected SCISections sCISections = new SCISections() {
        @Override
        public boolean isRaisedRemPassageDeniedToAll() {
            synchronized (statemachine) {
                return statemachine.getSCISections().isRaisedRemPassageDeniedToAll();
            }
        }

        @Override
        public long getSTRAIGHT() {
            synchronized (statemachine) {
                return statemachine.getSCISections().getSTRAIGHT();
            }
        }

        @Override
        public long getDIVERGENT() {
            synchronized (statemachine) {
                return statemachine.getSCISections().getDIVERGENT();
            }
        }

        @Override
        public long getTOP() {
            synchronized (statemachine) {
                return statemachine.getSCISections().getTOP();
            }
        }

        @Override
        public List<SCISectionsListener> getListeners() {
            synchronized (statemachine) {
                return statemachine.getSCISections().getListeners();
            }
        }

    };

    /**
     * Interface object for SCITurnout
     */
    protected SCITurnout sCITurnout = new SCITurnout() {
        @Override
        public void raiseTurnoutStraight() {
            eventQueue.add(new Runnable() {

                @Override
                public void run() {
                    synchronized (statemachine) {
                        statemachine.getSCITurnout().raiseTurnoutStraight();
                        statemachine.runCycle();
                    }
                }
            });
        }

        @Override
        public void raiseTurnoutDivergent() {
            eventQueue.add(new Runnable() {

                @Override
                public void run() {
                    synchronized (statemachine) {
                        statemachine.getSCITurnout().raiseTurnoutDivergent();
                        statemachine.runCycle();
                    }
                }
            });
        }

        @Override
        public void raisePassingAllowedFrom(final long value) {

            eventQueue.add(new Runnable() {

                @Override
                public void run() {
                    synchronized (statemachine) {
                        statemachine.getSCITurnout().raisePassingAllowedFrom(
                                value);
                        statemachine.runCycle();
                    }
                }
            });
        }

        @Override
        public void raisePassingDeniedFrom(final long value) {

            eventQueue.add(new Runnable() {

                @Override
                public void run() {
                    synchronized (statemachine) {
                        statemachine.getSCITurnout().raisePassingDeniedFrom(
                                value);
                        statemachine.runCycle();
                    }
                }
            });
        }

        @Override
        public void raiseRemPassageAllowedFrom(final long value) {

            eventQueue.add(new Runnable() {

                @Override
                public void run() {
                    synchronized (statemachine) {
                        statemachine.getSCITurnout().raiseRemPassageAllowedFrom(
                                value);
                        statemachine.runCycle();
                    }
                }
            });
        }

        @Override
        public void raiseRemPassageDeniedFrom(final long value) {

            eventQueue.add(new Runnable() {

                @Override
                public void run() {
                    synchronized (statemachine) {
                        statemachine.getSCITurnout().raiseRemPassageDeniedFrom(
                                value);
                        statemachine.runCycle();
                    }
                }
            });
        }

        @Override
        public void raiseSectionLockFrom(final long value) {

            eventQueue.add(new Runnable() {

                @Override
                public void run() {
                    synchronized (statemachine) {
                        statemachine.getSCITurnout().raiseSectionLockFrom(value);
                        statemachine.runCycle();
                    }
                }
            });
        }

        @Override
        public void raiseRemSectionLockFrom(final long value) {

            eventQueue.add(new Runnable() {

                @Override
                public void run() {
                    synchronized (statemachine) {
                        statemachine.getSCITurnout().raiseRemSectionLockFrom(
                                value);
                        statemachine.runCycle();
                    }
                }
            });
        }

        @Override
        public boolean isRaisedSectionAllowedTo() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().isRaisedSectionAllowedTo();
            }
        }

        @Override
        public long getSectionAllowedToValue() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().getSectionAllowedToValue();
            }
        }

        @Override
        public boolean isRaisedSectionLockedTo() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().isRaisedSectionLockedTo();
            }
        }

        @Override
        public long getSectionLockedToValue() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().getSectionLockedToValue();
            }
        }

        @Override
        public boolean isRaisedSectionLockedWithReplyTo() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().isRaisedSectionLockedWithReplyTo();
            }
        }

        @Override
        public long getSectionLockedWithReplyToValue() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().getSectionLockedWithReplyToValue();
            }
        }

        @Override
        public boolean isRaisedLockRequestTo() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().isRaisedLockRequestTo();
            }
        }

        @Override
        public long getLockRequestToValue() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().getLockRequestToValue();
            }
        }

        @Override
        public boolean isRaisedRemShortPassageRequestTo() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().isRaisedRemShortPassageRequestTo();
            }
        }

        @Override
        public long getRemShortPassageRequestToValue() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().getRemShortPassageRequestToValue();
            }
        }

        @Override
        public boolean isRaisedRemPassageAllowedTo() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().isRaisedRemPassageAllowedTo();
            }
        }

        @Override
        public long getRemPassageAllowedToValue() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().getRemPassageAllowedToValue();
            }
        }

        @Override
        public boolean isRaisedRemPassageDeniedTo() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().isRaisedRemPassageDeniedTo();
            }
        }

        @Override
        public long getRemPassageDeniedToValue() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().getRemPassageDeniedToValue();
            }
        }

        @Override
        public boolean isRaisedRemPassageRequestTo() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().isRaisedRemPassageRequestTo();
            }
        }

        @Override
        public long getRemPassageRequestToValue() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().getRemPassageRequestToValue();
            }
        }

        @Override
        public long getId() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().getId();
            }
        }

        @Override
        public void setId(final long value) {
            synchronized (statemachine) {
                statemachine.getSCITurnout().setId(value);
            }
        }

        @Override
        public boolean getIsOccupied() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().getIsOccupied();
            }
        }

        @Override
        public void setIsOccupied(final boolean value) {
            synchronized (statemachine) {
                statemachine.getSCITurnout().setIsOccupied(value);
            }
        }

        @Override
        public boolean getTopExists() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().getTopExists();
            }
        }

        @Override
        public void setTopExists(final boolean value) {
            synchronized (statemachine) {
                statemachine.getSCITurnout().setTopExists(value);
            }
        }

        @Override
        public boolean getDivergentExists() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().getDivergentExists();
            }
        }

        @Override
        public void setDivergentExists(final boolean value) {
            synchronized (statemachine) {
                statemachine.getSCITurnout().setDivergentExists(value);
            }
        }

        @Override
        public boolean getStraightExists() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().getStraightExists();
            }
        }

        @Override
        public void setStraightExists(final boolean value) {
            synchronized (statemachine) {
                statemachine.getSCITurnout().setStraightExists(value);
            }
        }

        @Override
        public boolean getRemDivergentIsPrior() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().getRemDivergentIsPrior();
            }
        }

        @Override
        public void setRemDivergentIsPrior(final boolean value) {
            synchronized (statemachine) {
                statemachine.getSCITurnout().setRemDivergentIsPrior(value);
            }
        }

        @Override
        public boolean getRemStraightIsPrior() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().getRemStraightIsPrior();
            }
        }

        @Override
        public void setRemStraightIsPrior(final boolean value) {
            synchronized (statemachine) {
                statemachine.getSCITurnout().setRemStraightIsPrior(value);
            }
        }

        @Override
        public boolean getRemTopIsPrior() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().getRemTopIsPrior();
            }
        }

        @Override
        public void setRemTopIsPrior(final boolean value) {
            synchronized (statemachine) {
                statemachine.getSCITurnout().setRemTopIsPrior(value);
            }
        }

        @Override
        public List<SCITurnoutListener> getListeners() {
            synchronized (statemachine) {
                return statemachine.getSCITurnout().getListeners();
            }
        }

    };

    @Override
    public SCISections getSCISections() {
        return sCISections;
    }

    @Override
    public SCITurnout getSCITurnout() {
        return sCITurnout;
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
