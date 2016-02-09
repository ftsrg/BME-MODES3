package hu.bme.mit.inf.qea;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public enum AutomatonTimerScheduler {
	INSTANCE;
	
	private ScheduledExecutorService instance;
	
	public ScheduledExecutorService getInstance(){
		return instance;
	}
	
	public void schedule(Runnable r, int timeout, TimeUnit tu){
		instance.schedule(r, timeout, tu);
	}
	
	private AutomatonTimerScheduler(){
		instance = Executors.newScheduledThreadPool(1);
	}
};
