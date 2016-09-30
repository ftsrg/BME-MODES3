package hu.bme.mit.inf.modes3.components.occupancyquery

import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import java.util.Collections
import java.util.HashMap
import java.util.Map
import java.util.TreeMap
import org.slf4j.ILoggerFactory

class SectionOccupancyQueryComponent extends AbstractRailRoadCommunicationComponent {

	Map<Integer, SegmentOccupancy> stateCache = new TreeMap
	IUARTReader reader

	new(CommunicationStack stack, IUARTReader reader, ILoggerFactory factory) {
		super(stack, factory)
		this.reader = reader
	}

	override run() {
		while(!Thread.interrupted) {
			process
		}
	}

	def process() {
		val recievedMsg = readMsg // blocking wait so we won't burn the CPU
		val msgToSend = parseMsg(recievedMsg)
		sendMessage(msgToSend)
	}

	private def sendMessage(Map<Integer, SegmentOccupancy> states) {
		states.forEach [ id, state |
			if(!stateCache.containsKey(id)) {
				stateCache.put(id, state)
				logger.info('''«id» «state»''')
				locator.trackElementStateSender.sendSegmentOccupation(id, state)
			} else if(!stateCache.get(id).equals(state)) {
				stateCache.put(id, state)
				logger.info('''«id» «state»''')
				locator.trackElementStateSender.sendSegmentOccupation(id, state)
			}
		]
	}

	/**
	 * Converts the occupancy vector byte array to a Java map.
	 * 
	 * @return the occupancy vector as a Map<Integer, SegmentOccupancy>
	 */
	private def parseMsg(byte[] byteVector) {
		// That masking with 0xff is necessary because java doesn't have unsigned chars (so the sign bits messes up shifting)
		val int occupancy = (byteVector.get(0).bitwiseAnd(0xff) << 24)
				.bitwiseOr(byteVector.get(1).bitwiseAnd(0xff) << 16)
				.bitwiseOr(byteVector.get(2).bitwiseAnd(0xff) << 8)
				.bitwiseOr(byteVector.get(3).bitwiseAnd(0xff))
		val map = new HashMap<Integer, SegmentOccupancy>
		for (i : 0 ..< 32) {
			val mask = ( 1 << i )
			val bit = (occupancy.bitwiseAnd(mask) >> i)
			// i+1 is the section ID, because we start number from 1
			map.put(i + 1, if(bit.bitwiseAnd(1) == 1) SegmentOccupancy.OCCUPIED else SegmentOccupancy.FREE)
		}
		return reshuffle(map)
	}

	private def HashMap<Integer, SegmentOccupancy> reshuffle(HashMap<Integer, SegmentOccupancy> map) {
		// val transitionTable = #{1 -> 2, 2 -> 1}
		// val ignoredBits = #[0]
		val transitionTable = Collections.emptyMap
		val ignoredBits = Collections.emptyList
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
