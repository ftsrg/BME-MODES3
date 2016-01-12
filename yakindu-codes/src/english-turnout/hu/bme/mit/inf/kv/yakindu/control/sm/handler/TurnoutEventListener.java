package hu.bme.mit.inf.kv.yakindu.control.sm.handler;

import hu.bme.mit.inf.kv.yakindu.control.controller.IYakinduKVController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.yakindu.scr.kv.IKvStatemachine.SCITurnoutListener;

public class TurnoutEventListener implements SCITurnoutListener {

    private final IYakinduKVController otherHalfOfTurnout;
    private final ExecutorService threadPool;

    public TurnoutEventListener(IYakinduKVController otherController) {
        this.otherHalfOfTurnout = otherController;
        this.threadPool = Executors.newCachedThreadPool();
    }

    @Override
    public void onRemSectionLockFromOtherHalfOUTRaised() {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                otherHalfOfTurnout.remSectionLockFromOtherHalf();
            }
        });
    }

    @Override
    public void onSectionLockFromOtherHalfOUTRaised() {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                otherHalfOfTurnout.sectionLockFromOtherHalf();
            }
        });
    }

    @Override
    public void onPassingAllowedFromOtherHalfOUTRaised() {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                otherHalfOfTurnout.passingAllowedFromOtherHalf();
            }
        });
    }

    @Override
    public void onPassingDeniedFromOtherHalfOUTRaised() {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                otherHalfOfTurnout.passingDeniedFromOtherHalf();
            }
        });
    }

}
