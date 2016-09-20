package hu.bme.mit.inf.modes3.components.safetylogic.sc.factory;

import java.util.List;
import java.util.Map;

import org.yakindu.scr.section.ISectionStatemachine;
import org.yakindu.scr.turnout.ITurnoutStatemachine;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson.ConnectingTrackElementConfiguration;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson.SectionConfiguration;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage.INextTrackElement;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage.LinkedSectionStatemachine;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage.LinkedTurnoutStatemachine;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage.NextTrackElementWrapper;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage.NullableNextTrackElement;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage.RemoteTrackElement;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduHandlerHolder;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirection;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirectionHolder;

class SectionStatechartConfigurationInitializer {

	private Map<Integer, ITurnoutStatemachine> localTurnouts;
	private Map<Integer, ISectionStatemachine> localSections;

	private List<SectionConfiguration> sectionConfigurations;

	private YakinduHandlerHolder remoteTrackElementHandlers;

	SectionStatechartConfigurationInitializer(Map<Integer, ITurnoutStatemachine> localTurnouts, Map<Integer, ISectionStatemachine> localSections,
			List<SectionConfiguration> sectionConfigurations, YakinduHandlerHolder remoteTrackElementHandlers) {
		this.localTurnouts = localTurnouts;
		this.localSections = localSections;
		this.sectionConfigurations = sectionConfigurations;
		this.remoteTrackElementHandlers = remoteTrackElementHandlers;
	}

	/**
	 * connect local sections to each other and to turnouts and remote track elements according to the section configuration
	 */
	void connectSectionsToNeighbours() {
		if (sectionConfigurations != null) {
			sectionConfigurations.stream().forEach(sectionConfiguration -> {
				ISectionStatemachine localSection = localSections.get(sectionConfiguration.getOccupancyId());

				ConnectingTrackElementConfiguration connectsFromCw = sectionConfiguration.getCw();
				if (connectsFromCw != null) {
					int targetId = connectsFromCw.getId();
					ConnectionDirection weSeeItFrom = ConnectionDirection.CW;
					ConnectionDirection targetReceivesFrom = connectsFromCw.getItReceivesOurMessagesFrom();
					ConnectionDirectionHolder directions = new ConnectionDirectionHolder(weSeeItFrom, targetReceivesFrom);

					connectSectionToTrackElementConnectingFromDirection(localSection, targetId, directions);
				}

				ConnectingTrackElementConfiguration connectsFromCcw = sectionConfiguration.getCcw();
				if (connectsFromCcw != null) {
					int targetId = connectsFromCcw.getId();
					ConnectionDirection weSeeItFrom = ConnectionDirection.CCW;
					ConnectionDirection targetReceivesFrom = connectsFromCcw.getItReceivesOurMessagesFrom();
					ConnectionDirectionHolder directions = new ConnectionDirectionHolder(weSeeItFrom, targetReceivesFrom);

					connectSectionToTrackElementConnectingFromDirection(localSection, targetId, directions);
				}
			});
		}
	}

	/**
	 * connect the specific section to target denoted by target id.
	 */
	private void connectSectionToTrackElementConnectingFromDirection(ISectionStatemachine localSection, int targetId, ConnectionDirectionHolder directions) {
		if (localSections.containsKey(targetId)) {
			ISectionStatemachine targetSection = localSections.get(targetId);
			connectLocalSectionToLocalSection(localSection, targetSection, directions);
		} else if (localTurnouts.containsKey(targetId)) {
			ITurnoutStatemachine targetTurnout = localTurnouts.get(targetId);
			connectLocalSectionToLocalTurnout(localSection, targetTurnout, directions);
		} else {
			connectLocalSectionToRemoteTrackElement(localSection, targetId, directions, remoteTrackElementHandlers);
		}
	}

	/**
	 * both sections are in the same component so that we connect them 'directly'
	 */
	private void connectLocalSectionToLocalSection(ISectionStatemachine localSection, ISectionStatemachine targetSection,
			ConnectionDirectionHolder directions) {
		INextTrackElement nextStatemachine = new LinkedSectionStatemachine(targetSection, new NullableNextTrackElement());
		connectNextTrackElementViaWrapperToLocalSection(localSection, nextStatemachine, directions);
	}

	/**
	 * both section and turnout are in the same component so that we connect them 'directly'
	 */
	private void connectLocalSectionToLocalTurnout(ISectionStatemachine localSection, ITurnoutStatemachine targetTurnout,
			ConnectionDirectionHolder directions) {
		INextTrackElement nextStatemachine = new LinkedTurnoutStatemachine(targetTurnout, new NullableNextTrackElement());
		connectNextTrackElementViaWrapperToLocalSection(localSection, nextStatemachine, directions);
	}

	/**
	 * track element denoted by targetId is not in the same component as localSection so that we connect them using the Yakindu message handler interfaces (for
	 * network messaging)
	 */
	private void connectLocalSectionToRemoteTrackElement(ISectionStatemachine localSection, int targetId, ConnectionDirectionHolder directions,
			YakinduHandlerHolder handlersForRemoteTrackElements) {
		INextTrackElement nextStatemachine = new RemoteTrackElement(targetId, handlersForRemoteTrackElements.getReleaseToSender(),
				handlersForRemoteTrackElements.getReserveToSender(), handlersForRemoteTrackElements.getCanGoToSender(),
				handlersForRemoteTrackElements.getCannotGoToSender());

		connectNextTrackElementViaWrapperToLocalSection(localSection, nextStatemachine, directions);
	}

	/**
	 * put next track element in a wrapper that stores from which direction local section see it, and connect this next track element to local section
	 */
	private void connectNextTrackElementViaWrapperToLocalSection(ISectionStatemachine localSection, INextTrackElement nextTrackElement,
			ConnectionDirectionHolder directions) {
		NextTrackElementWrapper nextStatemachineWrapper = new NextTrackElementWrapper(nextTrackElement, directions);
		new LinkedSectionStatemachine(localSection, nextStatemachineWrapper);
	}
}