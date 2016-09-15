package hu.bme.mit.inf.modes3.components.occupancyquery

import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import java.util.HashMap
import java.util.Map

class SectionOccupancyQueryComponent extends AbstractRailRoadCommunicationComponent {

	S88CommunicationReader reader

	new(CommunicationStack stack, S88CommunicationReader reader) {
		super(stack)
		this.reader = reader
	}

	override run() {
		while(!Thread.interrupted) {
			process()
		}
	}

	def process() {
		val recievedMsg = readMsg() // blocking wait so we won't burn the CPU
		val msgToSend = parseMsg(recievedMsg)
		sendMessage(msgToSend)
	}

	private def sendMessage(Map<Integer, SegmentOccupancy> states) {
		states.forEach [ id, state |
			locator.trackElementStateSender.sendSegmentOccupation(id, state)
		]
	}

	/**
	 * Converts the occupancy vector byte array to a Java map.
	 * 
	 * @return the occupancy vector as a Map<Integer, SegmentOccupancy>
	 */
	private def parseMsg(byte[] byteVector) {
		val int occupancy = (byteVector.get(3).bitwiseAnd(0xff) << 24).bitwiseOr(byteVector.get(2).bitwiseAnd(0xff) << 16).bitwiseOr(byteVector.get(1).bitwiseAnd(0xff) << 8).bitwiseOr(byteVector.get(0).bitwiseAnd(0xff))
		val map = new HashMap<Integer, SegmentOccupancy>
		for (i : 0 ..< 31) {
			val mask = ( 1 << i )
			val bit = (occupancy.bitwiseAnd(mask) >> i)
			map.put(i, if(bit == 1) SegmentOccupancy.OCCUPIED else SegmentOccupancy.FREE)
		}
		return reshuffle(map)
	}

	private def HashMap<Integer, SegmentOccupancy> reshuffle(HashMap<Integer, SegmentOccupancy> map) {
		val transitionTable = #{1 -> 2, 2 -> 1}
		val ignoredBits = #[0]
		val newMap = new HashMap<Integer, SegmentOccupancy>
		map.filter [ id, state |
			!ignoredBits.contains(id)
		].forEach [ id, state |
			if(transitionTable.keySet.contains(id)) {
				newMap.put(transitionTable.get(id), state)
			} else {
				newMap.put(id, state)
			}
		]
		return newMap
	}

	private def readMsg() {
		reader.read
	}
}
