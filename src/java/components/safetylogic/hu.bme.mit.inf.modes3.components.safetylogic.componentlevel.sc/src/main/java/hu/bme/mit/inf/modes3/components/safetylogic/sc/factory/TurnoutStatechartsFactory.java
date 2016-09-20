package hu.bme.mit.inf.modes3.components.safetylogic.sc.factory;

import java.util.List;
import java.util.Map;

import org.yakindu.scr.section.ISectionStatemachine;
import org.yakindu.scr.turnout.ITurnoutStatemachine;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson.ConnectingTrackElementConfiguration;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson.TurnoutConfiguration;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage.INextTrackElement;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage.LinkedSectionStatemachine;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage.LinkedTurnoutStatemachine;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage.NextTrackElementWrapper;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage.NullableNextTrackElement;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage.RemoteTrackElement;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduHandlerHolder;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirection;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirectionHolder;

class TurnoutStatechartsFactory {

	private Map<Integer, ITurnoutStatemachine> localTurnouts;
	private Map<Integer, ISectionStatemachine> localSections;

	private List<TurnoutConfiguration> turnoutConfigurations;

	private YakinduHandlerHolder remoteTrackElementHandlers;

	TurnoutStatechartsFactory(Map<Integer, ITurnoutStatemachine> localTurnouts, Map<Integer, ISectionStatemachine> localSections,
			List<TurnoutConfiguration> turnoutConfigurations, YakinduHandlerHolder remoteTrackElementHandlers) {
		this.localTurnouts = localTurnouts;
		this.localSections = localSections;
		this.turnoutConfigurations = turnoutConfigurations;
		this.remoteTrackElementHandlers = remoteTrackElementHandlers;
	}

	/**
	 * connect local turnouts to each other and to sections and remote track elements according to the section configuration
	 */
	void connectTurnoutsToNeighbours() {
		if (turnoutConfigurations != null) {
			turnoutConfigurations.stream().forEach(turnoutConfiguration -> {
				ITurnoutStatemachine localTurnout = localTurnouts.get(turnoutConfiguration.getOccupancyId());

				ConnectingTrackElementConfiguration connectsFromDivergent = turnoutConfiguration.getDivergent();
				if (connectsFromDivergent != null) {
					int targetId = connectsFromDivergent.getId();
					ConnectionDirection weSeeItFrom = ConnectionDirection.DIVERGENT;
					ConnectionDirection targetReceivesFrom = connectsFromDivergent.getItReceivesOurMessagesFrom();
					ConnectionDirectionHolder directions = new ConnectionDirectionHolder(weSeeItFrom, targetReceivesFrom);

					connectTurnoutToTrackElementConnectingFromDirection(localTurnout, targetId, directions);
				}

				ConnectingTrackElementConfiguration connectsFromStraight = turnoutConfiguration.getStraight();
				if (connectsFromStraight != null) {
					int targetId = connectsFromStraight.getId();
					ConnectionDirection weSeeItFrom = ConnectionDirection.STRAIGHT;
					ConnectionDirection targetReceivesFrom = connectsFromStraight.getItReceivesOurMessagesFrom();
					ConnectionDirectionHolder directions = new ConnectionDirectionHolder(weSeeItFrom, targetReceivesFrom);

					connectTurnoutToTrackElementConnectingFromDirection(localTurnout, targetId, directions);
				}

				ConnectingTrackElementConfiguration connectsFromTop = turnoutConfiguration.getTop();
				if (connectsFromTop != null) {
					int targetId = connectsFromTop.getId();
					ConnectionDirection weSeeItFrom = ConnectionDirection.TOP;
					ConnectionDirection targetReceivesFrom = connectsFromTop.getItReceivesOurMessagesFrom();
					ConnectionDirectionHolder directions = new ConnectionDirectionHolder(weSeeItFrom, targetReceivesFrom);

					connectTurnoutToTrackElementConnectingFromDirection(localTurnout, targetId, directions);
				}
			});
		}
	}

	/**
	 * connect the specific turnout to target denoted by target id.
	 */
	private void connectTurnoutToTrackElementConnectingFromDirection(ITurnoutStatemachine localTurnout, int targetId, ConnectionDirectionHolder directions) {
		if (localTurnouts.containsKey(targetId)) {
			ITurnoutStatemachine targetTurnout = localTurnouts.get(targetId);
			connectLocalTurnoutToLocalTurnout(localTurnout, targetTurnout, directions);
		} else if (localSections.containsKey(targetId)) {
			ISectionStatemachine targetSection = localSections.get(targetId);
			connectLocalTurnoutToLocalSection(localTurnout, targetSection, directions);
		} else {
			connectLocalTurnoutToRemoteTrackElement(localTurnout, targetId, directions, remoteTrackElementHandlers);
		}
	}

	/**
	 * both turnouts are in the same component so that we connect them 'directly'
	 */
	private void connectLocalTurnoutToLocalTurnout(ITurnoutStatemachine localTurnout, ITurnoutStatemachine targetTurnout,
			ConnectionDirectionHolder directions) {
		INextTrackElement nextStatemachine = new LinkedTurnoutStatemachine(targetTurnout, new NullableNextTrackElement());
		connectNextTrackElementViaWrapperToLocalTurnout(localTurnout, nextStatemachine, directions);
	}

	/**
	 * both turnouts and section are in the same component so that we connect them 'directly'
	 */
	private void connectLocalTurnoutToLocalSection(ITurnoutStatemachine localTurnout, ISectionStatemachine targetSection,
			ConnectionDirectionHolder directions) {
		INextTrackElement nextStatemachine = new LinkedSectionStatemachine(targetSection, new NullableNextTrackElement());
		connectNextTrackElementViaWrapperToLocalTurnout(localTurnout, nextStatemachine, directions);
	}

	/**
	 * track element denoted by targetId is not in the same component as localTurnout so that we connect them using the Yakindu message handler interfaces (for
	 * network messaging)
	 */
	private void connectLocalTurnoutToRemoteTrackElement(ITurnoutStatemachine localTurnout, int targetId, ConnectionDirectionHolder directions,
			YakinduHandlerHolder handlersForRemoteTrackElements) {
		INextTrackElement nextStatemachine = new RemoteTrackElement(targetId, handlersForRemoteTrackElements.getReleaseToSender(),
				handlersForRemoteTrackElements.getReserveToSender(), handlersForRemoteTrackElements.getCanGoToSender(),
				handlersForRemoteTrackElements.getCannotGoToSender());

		connectNextTrackElementViaWrapperToLocalTurnout(localTurnout, nextStatemachine, directions);
	}

	/**
	 * put next track element in a wrapper that stores from which direction local section see it, and connect this next track element to local turnout
	 */
	private void connectNextTrackElementViaWrapperToLocalTurnout(ITurnoutStatemachine localTurnout, INextTrackElement nextTrackElement,
			ConnectionDirectionHolder directions) {
		NextTrackElementWrapper nextStatemachineWrapper = new NextTrackElementWrapper(nextTrackElement, directions);
		new LinkedTurnoutStatemachine(localTurnout, nextStatemachineWrapper);
	}
}