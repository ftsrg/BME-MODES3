package hu.bme.mit.inf.modes3.components.safetylogic.sc.transmitter;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.yakindu.scr.section.ISectionStatemachine;
import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;

import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander;
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState;

public class SectionCommandToExternalTransmitter implements SCISectionListener {

	protected final Logger logger;

	protected final ISectionStatemachine statemachine;

	protected final ITrackElementCommander commander;

	public SectionCommandToExternalTransmitter(ISectionStatemachine statemachine, ITrackElementCommander commander, ILoggerFactory factory) {
		this.statemachine = statemachine;
		this.commander = commander;
		this.logger = factory.getLogger(this.getClass().getName());

		statemachine.getSCISection().getListeners().add(this);
	}

	@Override
	public void onEnableSectionRaised(int value) {
		logger.debug("EnableSection command forwarded to commander for section " + value);
		commander.sendSegmentCommand(value, SegmentState.ENABLED);
	}

	@Override
	public void onDisableSectionRaised(int value) {
		logger.debug("DisableSection command forwarded to commander for section " + value);
		commander.sendSegmentCommand(value, SegmentState.DISABLED);
	}

}
