package hu.bme.mit.inf.modes3.components.safetylogic.sc.transmitter;

import java.util.Map;
import java.util.TreeMap;

import org.yakindu.scr.section.ISectionStatemachine;

public class ProtocolPeriodicRestarterRunnable implements Runnable {

	protected final Map<Integer, ISectionStatemachine> localSections = new TreeMap<>();

	protected final int sleepTime = 50;

	public void registerSectionStatemachine(int id, ISectionStatemachine statemachine) {
		localSections.put(id, statemachine);
	}

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			try {
				for (Map.Entry<Integer, ISectionStatemachine> sectionEntry : localSections.entrySet()) {
					sectionEntry.getValue().getSCIProtocol().raiseRestartProtocol();
				}
				Thread.sleep(sleepTime);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}

	}

}
