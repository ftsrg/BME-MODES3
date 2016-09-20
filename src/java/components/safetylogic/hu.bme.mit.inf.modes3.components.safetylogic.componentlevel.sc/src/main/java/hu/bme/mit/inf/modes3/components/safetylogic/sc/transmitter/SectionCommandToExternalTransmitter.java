package hu.bme.mit.inf.modes3.components.safetylogic.sc.transmitter;

import org.yakindu.scr.section.ISectionStatemachine;
import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;

import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander;
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState;

public class SectionCommandToExternalTransmitter implements SCISectionListener {

	protected final ISectionStatemachine statemachine;

	protected final ITrackElementCommander commander;

	public SectionCommandToExternalTransmitter(ISectionStatemachine statemachine, ITrackElementCommander commander) {
		this.statemachine = statemachine;
		this.commander = commander;

		statemachine.getSCISection().getListeners().add(this);
	}

	@Override
	public void onEnableSectionRaised(int value) {
		commander.sendSegmentCommand(value, SegmentState.ENABLED);
	}

	@Override
	public void onDisableSectionRaised(int value) {
		commander.sendSegmentCommand(value, SegmentState.DISABLED);
	}

}
